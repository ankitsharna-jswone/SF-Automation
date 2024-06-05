package Listner;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class CustomCucumberListener implements EventListener {

    private int totalFeatures = 0;
    private int totalScenarios = 0;
    private int totalSteps = 0;

    private int passedFeatures = 0;
    private int passedScenarios = 0;
    private int passedSteps = 0;

    private int failedFeatures = 0;
    private int failedScenarios = 0;
    private int failedSteps = 0;

    private int skippedSteps = 0;
    private int warningSteps = 0;
    private int infoSteps = 0;

    private String featureName = null;

    public Map<Object,Object> map = new HashMap<>();

    private Map<String, Boolean> scenarioStatuses = new HashMap<>();
    private Map<String, Boolean> featureStatuses = new HashMap<>();
    private Map<String, Integer> featureStepCounts = new HashMap<>();
    private Map<String, Boolean> featurePassStatuses = new HashMap<>();

    private Map<String, Instant> scenarioStartTimes = new HashMap<>();
    private Map<String, Long> scenarioDurations = new HashMap<>();

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, this::handleTestRunStarted);
        publisher.registerHandlerFor(TestRunFinished.class, this::handleTestRunFinished);
        publisher.registerHandlerFor(TestSourceRead.class, this::handleTestSourceRead);
        publisher.registerHandlerFor(TestCaseStarted.class, this::handleTestCaseStarted);
        publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
    }

    private void handleTestRunStarted(TestRunStarted event) {
        System.out.println("Test run started.");
    }

    private void handleTestRunFinished(TestRunFinished event) {
        System.out.println("Test run finished.");
        printSummary();
    }

    private void handleTestSourceRead(TestSourceRead event) {
        totalFeatures++;
        featureStepCounts.put(event.getUri().toString(), 0);
        featurePassStatuses.put(event.getUri().toString(), true);
    }

    private void handleTestCaseStarted(TestCaseStarted event) {
        String scenarioName = event.getTestCase().getName();
        scenarioStartTimes.put(scenarioName, Instant.now());
    }

    private void handleTestCaseFinished(TestCaseFinished event) {
        String scenarioName = event.getTestCase().getName();
        boolean scenarioPassed = event.getResult().getStatus().is(Status.PASSED);

        Instant startTime = scenarioStartTimes.get(scenarioName);
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        scenarioDurations.put(scenarioName, duration);

        if (scenarioPassed) {
            passedScenarios++;
        } else {
            failedScenarios++;
        }

        scenarioStatuses.put(scenarioName, scenarioPassed);
        featurePassStatuses.put(event.getTestCase().getUri().toString(),
                featurePassStatuses.get(event.getTestCase().getUri().toString()) && scenarioPassed);
        totalScenarios++;
    }

    private void handleTestStepFinished(TestStepFinished event) {
        Result result = event.getResult();
        Status status = result.getStatus();
        String scenarioName = event.getTestCase().getName();
        String featureUri = event.getTestCase().getUri().toString();

        featureStepCounts.put(featureUri, featureStepCounts.get(featureUri) + 1);
        totalSteps++;

        switch (status) {
            case PASSED:
                passedSteps++;
                break;
            case FAILED:
                failedSteps++;
                scenarioStatuses.put(scenarioName, false);
                break;
            case SKIPPED:
                skippedSteps++;
                break;
            case PENDING:
            case UNDEFINED:
                warningSteps++;
                break;
            case AMBIGUOUS:
                infoSteps++;
                break;
            default:
                break;
        }
    }

    private void printSummary() {
        for (Map.Entry<String, Boolean> entry : featurePassStatuses.entrySet()) {
            if (entry.getValue()) {
                passedFeatures++;
            } else {
                failedFeatures++;
            }
        }

        System.out.println("Total Features: " + totalFeatures);
        System.out.println("Total Scenarios: " + totalScenarios);
        System.out.println("Total Steps: " + totalSteps);

        System.out.println("Passed Features: " + passedFeatures);
        System.out.println("Failed Features: " + failedFeatures);

        System.out.println("Passed Scenarios: " + passedScenarios);
        System.out.println("Failed Scenarios: " + failedScenarios);

        System.out.println("Passed Steps: " + passedSteps);
        System.out.println("Failed Steps: " + failedSteps);
        System.out.println("Skipped Steps: " + skippedSteps);
        System.out.println("Warning Steps: " + warningSteps);
        System.out.println("Info Steps: " + infoSteps);

        map.put("totalFeatures", totalFeatures);
        map.put("totalScenarios", totalScenarios);
        map.put("totalSteps", totalSteps);
        map.put("passedFeatures", passedFeatures);
        map.put("failedFeatures", failedFeatures);
        map.put("passedScenarios", passedScenarios);
        map.put("failedScenarios", failedScenarios);
        map.put("passedSteps", passedSteps);
        map.put("failedSteps", failedSteps);
        map.put("skippedSteps", skippedSteps);
        map.put("warningSteps", warningSteps);
        map.put("infoSteps", infoSteps);
        map.put("scenarioDurations", scenarioDurations);

        mapToJson();
    }

    public void ObjectToJSON(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("output.json"), map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mapToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(map);

        String filePath = "test-output/html/reports/ERP.json"; 
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
            System.out.println("JSON file created: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
