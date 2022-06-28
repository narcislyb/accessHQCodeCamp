package com.accessHQ.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestAPISuite {

    @Test
    public void Verify_Status_200() {
        given().
            header("auth-key", "0312d6cd-75cb-4051-9395-0b70ddd076d5").
            param("q", "Tascott").
            param("state", "NSW").
        when().get("https://digitalapi.auspost.com.au/postcode/search.json").
        then().assertThat().statusCode(200);
    }

    @Test
    public void Verify_Postcode2250() {
        given().
            header("auth-key", "0312d6cd-75cb-4051-9395-0b70ddd076d5").
            param("q", "Tascott").
            param("state", "NSW").
        when().get("https://digitalapi.auspost.com.au/postcode/search.json").
        then().
            assertThat().body("localities.locality.postcode", equalTo(2250));
    }
}
