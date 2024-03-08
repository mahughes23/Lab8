package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @Before
    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity() {
        list = MockCityList();
        City testCity = new City("Regina", "SK");
        list.addCity(testCity); // Add city to make sure the hasCity works after adding.
        assertEquals(true, list.hasCity(testCity));
        assertEquals(false, list.hasCity(new City("Nonexistent", "City")));
    }

    @Test
    public void testDeleteCity() {
        list = MockCityList();
        City testCity = new City("Saskatoon", "SK");
        list.addCity(testCity);
        assertEquals(true, list.hasCity(testCity)); // Check that the city is added.
        list.deleteCity(testCity);
        assertEquals(false, list.hasCity(testCity)); // Check that the city is removed.
    }

    @Test
    public void testCountCities() {
        list = MockCityList();
        assertEquals(0, list.countCities()); // Initially, there should be no cities.
        list.addCity(new City("Moose Jaw", "SK"));
        assertEquals(1, list.countCities()); // Now there should be one city.
    }

}
