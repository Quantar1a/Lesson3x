package org.emample.tests;

import io.restassured.http.ContentType;
import org.example.Data;
import org.example.pojoComponents.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePetTest extends AbstractTest
{
    String endpoint = "pet";

    @BeforeEach
    public void createPet()
    {
        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(endpoint);
    }

    // Update pet record with valid data
    @Test
    public void updatePetTest()
    {
        pet.setName("Robert");
        pet.setStatus("unavailable");

        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(endpoint)
                .then()
                .statusCode(200)
                .body("id", equalTo(Data.petID))
                .body("name", equalTo("Robert"))
                .body("status", equalTo("unavailable"));
    }

    //Check case when pet name is empty
    @Test()
    public void updatePetWithEmptyPetsName()
    {
        pet.setName("");

        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(endpoint)
                .then()
                .statusCode(200)
                .body("id", equalTo(Data.petID))
                .body("name", equalTo(""));
    }

    //Check case when status is empty
    @Test
    public void updatePetWithEmptyStatus()
    {
        pet.setStatus("");

        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(endpoint)
                .then()
                .statusCode(200)
                .body("id", equalTo(Data.petID))
                .body("status", equalTo(""));
    }

    //Check case when the pet is deleted
    @Test
    public void updateDeletedPet()
    {
        //Request for deleting
        given()
                .when()
                .delete(endpoint + "/" + Data.petID);


        //Request for updating
        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(endpoint)
                .then()
                .statusCode(404);
    }

    //Case if category is empty
    @Test
    public void updatePetWIthEmptyCategory()
    {
        pet.setCategory(new Category());

        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(endpoint)
                .then()
                .statusCode(200)
                .body("category.id", equalTo(0));
    }
}
