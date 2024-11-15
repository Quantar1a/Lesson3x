package org.emample.tests;

import io.restassured.RestAssured;
import org.example.Data;
import org.example.Pet;
import org.example.pojoComponents.Category;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTest
{
    Pet pet;

    @BeforeEach
    public void beforeEachTest()
    {
        RestAssured.baseURI = Data.serverURI;

        pet  = new Pet(
                Data.petID,
                new Category(0, "string"),
                Data.petName,
                Data.getPhotoUrlsList(),
                Data.getTagList(),
                Data.petStatus);
    }
}