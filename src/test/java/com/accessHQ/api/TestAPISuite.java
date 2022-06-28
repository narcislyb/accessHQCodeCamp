package com.accessHQ.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class verify_test {

    @Test
    public void verify_status_200() {
        given().
            header("auth-key", "0312d6cd-75cb-4051-9395-0b70ddd076d5").
            param("q", "Tascott").
            param("state", "NSW").
        when().get("https://digitalapi.auspost.com.au/postcode/search.json").
        then().assertThat().statusCode(201);
    }
}
