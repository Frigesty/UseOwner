package ru.frigesty.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.frigesty.pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class HomeTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    GenerationData gD = new GenerationData();
    @Tag("simple")
    @Test
    @DisplayName("Проверка тестовой формы")
    void practiceFormTest() {

        step("Открываем страницу", () ->
            registrationPage.openPage()
        );
        step("Закрываем банер и футер", () ->
            registrationPage.removeFooter()
        );
        step("Вводим имя и фамилию", () -> {
            registrationPage.setFirstName(gD.firstName);
            registrationPage.setLastName(gD.lastName);
        });
        step("Вводим email", () ->
            registrationPage.userEmailName(gD.userEmail)
        );
        step("Выбираем гендер", () ->
            registrationPage.chooseGender(gD.userGender)
        );
        step("Вводим номер телефона", () ->
            registrationPage.userMobileNumber(gD.userNumber)
        );
        step("Вводим дату рождения", () ->
            registrationPage.chooseBirthDate(gD.dayOfBirth, gD.monthOfBirth, gD.yearOfBirth)
        );
        step("Выбираем предметы", () ->
            registrationPage.writeAndChooseSubject(gD.subject)
        );
        step("Выбираем хобби", () ->
            registrationPage.chooseHobbies(gD.hobbies)
        );
        step("Загружаем картинку", () ->
            registrationPage.uploadPicture(gD.pictures)
        );
        step("Вводим адрес", () ->
            registrationPage.setAddressName(gD.currentAddress)
        );
        step("Выбираем штат и город", () ->
            registrationPage.chooseStateAndCity(gD.randomState, gD.randomCity)
        );
        step("Кликаем на кнопку Submit", () ->
            registrationPage.clickSubmit()
        );
        step("Проверяем результат", () -> {
            registrationPage.verifyRegistrationResultsModalAppears()
                    .verifyResult("Student Name", gD.firstName + " " + gD.lastName)
                    .verifyResult("Student Email", gD.userEmail)
                    .verifyResult("Gender", gD.userGender)
                    .verifyResult("Mobile", gD.userNumber)
                    .verifyResult("Date of Birth", gD.dayOfBirth + " " + gD.monthOfBirth + "," + gD.yearOfBirth)
                    .verifyResult("Subjects", gD.subject)
                    .verifyResult("Hobbies", gD.hobbies)
                    .verifyResult("Picture", gD.pictures)
                    .verifyResult("Address", gD.currentAddress)
                    .verifyResult("State and City", gD.randomState + " " + gD.randomCity);
        });
    }
}