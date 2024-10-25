package ApiFramwork.RestAssured;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApprovedCreditInfo {

    @Test
    public static void ApprovedCreditCall() {
        RestAssured.baseURI = "https://qa-oms.msme.jswone.in";

        Response response = given()
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8")
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYWxsZXBhbGx5LnZhcm1hQGpzdy5pbiIsImF1dGgiOiJST0xFX1VTRVIiLCJpYXQiOjE2OTk0MzkyODUsImV4cCI6MTczMDk3NTI4NX0.5maAURb63toVEFeN0v42kjjZtbDhGsrKkT47rGMUR3kIp3XVDo0v9NsN2CDrU7RVE1mBiaWQ4GMiiIcP9gOBfw")
                .header("Connection", "keep-alive")
                .header("Origin", "https://qa-oms.msme.jswone.in")
                .header("Referer", "https://qa-oms.msme.jswone.in/order-list/JOO-S4782PFB?tab=shipments")
                .header("Content-Type", "application/json")
                .when()
                .get("/joms/api/credit/internal/v1/getCreditInfoByPan?pan=BNEPR4751B")
                .then()
                .statusCode(200)
                .extract().response();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<ApprovedCreditInfo> creditInfoList = objectMapper.readValue(
                    response.asString(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, ApprovedCreditInfo.class)
            );


            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("creditInfo.json"), creditInfoList);
            System.out.println("JSON file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Response: " + response.asString());
    }
}
