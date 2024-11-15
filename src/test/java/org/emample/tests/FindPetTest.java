package org.emample.tests;

import io.restassured.http.ContentType;
import org.example.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FindPetTest extends AbstractTest
{
    String endpoint = "pet/" + Data.petID;

    @BeforeEach
    public void createPet()
    {
        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post("pet");
    }

    @Test
    public void findPetTest() {

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("id", equalTo(Data.petID))
                .body("name", equalTo(Data.petName))
                .body("status", equalTo(Data.petStatus));
    }

    @Test
    public void findPetWithInvalidID()
    {
        given()
                .when()
                .get(endpoint + "1")
                .then()
                .statusCode(404);
    }
}
