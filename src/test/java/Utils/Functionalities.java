package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

import static Utils.BrowsserSetup.getDriver;

public class Functionalities {

    public static WebDriver driver  = getDriver();
    public static WebDriverWait wait;

    public Functionalities(WebDriver driver) {
        Functionalities.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private static final int DEFAULT_TIMEOUT = 10;
    private static final int POLLING_INTERVAL = 500;


    static DevTools devTools;

    public static void setConsoleReader(WebDriver driver) {
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Log.enable());

    }

    private static void highlightElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.border='3px solid red'", element);
    }


    public static void readConsole() {
        devTools.addListener(Log.entryAdded(), LogEntry -> {
            System.out.println("Log text:" + LogEntry.getText());
//            System.out.println("Log level:" + LogEntry.getLevel());
        });

    }

    public static void readLevel() {
        devTools.addListener(Log.entryAdded(), LogEntry -> {
            System.out.println("Log Args :" + LogEntry.getArgs());
            System.out.println("Log Source :" + LogEntry.getSource());
            System.out.println("Log Network:" + LogEntry.getNetworkRequestId());
            System.out.println("Log level:" + LogEntry.getLevel());
        });
    }


    public static void clickingTool(WebElement element) {
        boolean elementClickable = false;
        try {
            element.click();

            elementClickable = true;
        } catch (Exception e) {
            System.out.println("Normal click failed");
                try {
                    JavaScriptScroll(element);
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click();", element);
                    elementClickable = true;
                } catch (Exception jsException) {
                    System.out.println("JavaScript click failed");
                    try {
                        Actions actions = new Actions(driver);
                        actions.moveToElement(element).click().perform();
                        elementClickable = true;
                    } catch (Exception actionsException) {
                        System.out.println("Action class click failed");
                        try {
                            Thread.sleep(3000);
                            element.click();
                            elementClickable = true;
                        } catch (InterruptedException sleepException) {
                            System.out.println("Thread class click failed");
                            try {
                                driver.findElement(By.xpath("(" + element + ")[2]")).click();
                            } catch (Exception e1) {
                                System.out.println(e1.getMessage() + " After all Error handling i got this exception");
                            }
                        }

                    }
                }
            }

        if (!elementClickable) {
            System.out.println("Unable to click the element.");
        }
    }


    public static WebElement waitForElement(String path ) {
        By locator = By.xpath(path);
        WebElement element = null;
        try {

            element = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .pollingEvery(Duration.ofMillis(POLLING_INTERVAL))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.out.println("Standard wait failed, trying fallbacks...");


            try {
                element = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(StaleElementReferenceException.class)
                        .until(d -> {
                            highlightElement(driver, d.findElement(locator));
                            return d.findElement(locator);
                        });
            } catch (Exception ex1) {
                System.out.println("Fluent wait failed, trying JS...");

                try {
                    element = (WebElement) ((JavascriptExecutor) driver)
                            .executeScript("return document.querySelector(arguments[0]);",
                                    locator.toString().split(": ")[1]);
                } catch (Exception ex2) {
                    System.out.println("JS fallback failed, trying action move...");


                    try {
                        new Actions(driver)
                                .moveToElement(driver.findElement(locator))
                                .perform();
                        element = driver.findElement(locator);
                    } catch (Exception ex3) {
                        System.out.println("All fallbacks failed for locator: " + locator);
                    }
                }
            }
        }
        return element;
    }



    public static void MultipleTry(WebElement elem) {
        int maxAttempts = 3;

        int attempt = 1;
        boolean elementClickable = false;

        while (attempt <= maxAttempts) {
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));
                element.click();

                elementClickable = true;
                break;

            } catch (Exception e) {
                attempt++;

            }
        }
    }

    private static void sleep(int millis) {
        try { Thread.sleep(millis); }
        catch (InterruptedException e) {

        }
    }



    public static void ActionClass(WebElement element) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).build().perform();
        actions.moveToElement(element).click();

    }

    public static void JavaScriptClick(String Path) {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Path)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public static void JavaElemClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public static WebElement xpathELem(String path) {
        return driver.findElement(By.xpath(path));
    }

    public static List<WebElement> xpathELems(String path) {
        return driver.findElements(By.xpath(path));
    }


    public static void waitLocatedXpath(String path) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
    }

    public static void waitForPresence(String path){
        JavaScriptScroll(xpathELem(path));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
        JavaScriptScroll(xpathELem(path));
    }

    public static void waitLocatedXpaths(String path) {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(path)));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(path)));
        JavaScriptScroll(xpathELem(path));
    }

    public static void waitLocatedCss(String path) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(path)));
    }

    public static void ActionMoveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).build().perform();
        actions.moveToElement(element).build().perform();

    }

    public static void JavaScriptScroll(WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void JavaScriptEndScroll(WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("arguments[0].scrollTop += 250;", element);
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", element);

    }

    public static void windowScroll(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
    }


    public static void waitFor(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));


    }


}
