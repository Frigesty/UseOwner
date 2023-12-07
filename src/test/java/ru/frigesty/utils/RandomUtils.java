package ru.frigesty.utils;

import com.github.javafaker.Faker;

import static ru.frigesty.tests.TestData.*;

public class RandomUtils {

    public static String getRandomCity(String state) {

        Faker faker = new Faker();

        String city;
        switch (state) {
            case "NCR" : {
                city = faker.options().option(stateNCR);
                return city;
            }
            case "Uttar Pradesh" : {
                city = faker.options().option(stateUttarPradesh);
                return city;
            }
            case "Haryana" : {
                city = faker.options().option(stateHaryana);
                return city;
            }
            case "Rajasthan" : {
                city = faker.options().option(stateRajasthan);
                return city;
            }
        }
        return null;
    }
}