package org.example;

import org.example.pojoComponents.Tag;

import java.util.ArrayList;
import java.util.List;

public class Data
{
    public static String serverURI = "https://petstore.swagger.io/v2/";

    //Info about pet
    public static int petID = 1425545;
    public static String petName = "Adolf";
    public static String petStatus = "available";

    public static List<Tag> getTagList()
    {
        List<Tag> tagList = new ArrayList<>();
        tagList.add(new Tag(0, "string"));
        return tagList;
    }

    public static List<String> getPhotoUrlsList()
    {
        List<String> photoUrlsList = new ArrayList<>();
        photoUrlsList.add("string");
        return photoUrlsList;
    }
}
