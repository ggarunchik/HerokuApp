package utils;

import io.restassured.RestAssured;

public class HttpResponseValidator {

    public static int httpResponseCodeViaGet(String url) {
        return RestAssured.get(url).statusCode();
    }

    public static int httpResponseCodeViaPost(String url) {
        return RestAssured.post(url).statusCode();
    }
}
