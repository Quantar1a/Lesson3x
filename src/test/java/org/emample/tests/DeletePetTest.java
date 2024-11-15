package org.emample.tests;

import io.restassured.http.ContentType;
import org.example.Data;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeletePetTest extends AbstractTest
{
    String endpoint = "pet/" + Data.petID;

    @Test
    public void createPet()
    {
        //Request for creating a pet
        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post("pet")
                .then()
                .statusCode(200);

        //Request for deleting
        given()
                .when()
                .delete(endpoint)
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteDeletedPet()
    {
        //Request for deleting
        given()
                .when()
                .delete(endpoint)
                .then()
                .statusCode(404);
    }
}
