package org.emample.tests;

import io.restassured.http.ContentType;
import org.example.pojoComponents.Category;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddPetTest extends AbstractTest
{
    String endpoint = "pet";

    @Test
    public void createPetSuccessfully()
    {
        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(endpoint);
    }

    //Create pet without name
    @Test
    public void createPetSuccessfullyWithEmptyName()
    {
        pet.setName("");

        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(endpoint)
                .then()
                .statusCode(200)
                .body("name", equalTo(""));
    }

    //Create pet without status
    @Test
    public void createPetSuccessfullyWithEmptyStatus()
    {
        pet.setStatus("");

        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(endpoint)
                .then()
                .statusCode(200)
                .body("status", equalTo(""));
    }

    //Case if category is empty
    @Test
    public void createPetWIthEmptyCategory()
    {
        pet.setCategory(new Category());

        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(endpoint)
                .then()
                .statusCode(200)
                .body("category.id", equalTo(0));
    }
}
