package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class AutomationPracticeForm extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();

    @Owner("I AM")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("blocker")
    @DisplayName("Проверка заполнения и утверждения формы Student Registration Form")
    @Test
    void practiceFillFormTest() {
        registrationPage.openPage();

        step("Заполняем форму", () -> {
            registrationPage
                    .setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.email)
                    .setGender(data.gender)
                    .setMobile(data.phoneNumber)
                    .setDateOfBirth(data.yearOfBirth, data.monthOfBirth, data.dayOfBirth)
                    .setSubject(data.subject_1)
                    .setHobby(data.hobby)
                    .setFile(data.picture)
                    .setAddress(data.address)
                    .setState(data.state)
                    .setCity(data.city)
                    .submit();
        });

        registrationPage.verifyModalWindowAppears();

        step("Проверяем, что форма была утверждена правильно", () -> {
            registrationPage
                    .verifyModalWindowResult("Student Name ", data.firstName + " " + data.lastName)
                    .verifyModalWindowResult("Student Email ", data.email)
                    .verifyModalWindowResult("Gender ", data.gender)
                    .verifyModalWindowResult("Mobile ", data.phoneNumber)
                    .verifyModalWindowResult("Date of Birth ", data.dayOfBirth + " " + data.monthOfBirth + "," + data.yearOfBirth)
                    .verifyModalWindowResult("Subjects ", data.subject_1)
                    .verifyModalWindowResult("Hobbies ", data.hobby)
                    .verifyModalWindowResult("Picture ", data.picture)
                    .verifyModalWindowResult("Address ", data.address)
                    .verifyModalWindowResult("State and City ", data.state + " " + data.city);
        });
    }
}
