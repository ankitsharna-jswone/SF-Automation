package Utils;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class k6Runner {

    @Test
    public void runK6Test() throws IOException, InterruptedException {

        ProcessBuilder processBuilder = new ProcessBuilder("k6", "run", "src/test/java/ApiFramwork/K6/ZohoApprovedCredit.js");

        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        int exitCode = process.waitFor();
        System.out.println("K6 process exited with code: " + exitCode);
    }
}
