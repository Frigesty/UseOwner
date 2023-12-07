package ru.frigesty.tests;

import com.github.javafaker.Faker;

import static ru.frigesty.tests.TestData.*;
import static ru.frigesty.utils.RandomUtils.*;

public class GenerationData {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = faker.options().option(gender),
            userNumber = 89 + faker.phoneNumber().subscriberNumber(8),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
            monthOfBirth = faker.options().option(months),
            yearOfBirth = String.format("%d", faker.number().numberBetween(1901,2023)),
            subject = faker.options().option(subjects),
            hobbies = faker.options().option(hobbiess),
            pictures = faker.options().option(morePictures),
            currentAddress = faker.address().streetAddress(),
            randomState = faker.options().option(states),
            randomCity = getRandomCity(randomState);
}