package pages;

import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Открываем страницу регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#close-fixedban').remove()");
        executeJavaScript("$('#adplus-anchor').remove()");

        return this;
    }

    @Step("Вводим имя")
    public RegistrationPage setFirstName(String value) {
        $("#firstName").setValue(value);

        return this;
    }

    @Step("Вводим фамилию")
    public RegistrationPage setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }

    @Step("Вводим Email")
    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    @Step("Выбираем пол")
    public RegistrationPage setGender(String value) {
        $$(".custom-radio").findBy(text(value)).click();

        return this;
    }

    @Step("Вводим номер телефона")
    public RegistrationPage setMobile(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    @Step("Выбираем дату рождения")
    public RegistrationPage setDateOfBirth(String year, String month, String day) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(year, month, day);

        return this;
    }

    @Step("Выбираем предметы")
    public RegistrationPage setSubject(String value) {
        $("#subjectsContainer input").setValue(value);
        $(".subjects-auto-complete__menu-list").$(byText(value)).click();

        return this;
    }

    @Step("Выбираем хобби")
    public RegistrationPage setHobby(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    @Step("Выбираем файл")
    public RegistrationPage setFile(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    @Step("Вводим адрес")
    public RegistrationPage setAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    @Step("Выбираем штат")
    public RegistrationPage setState(String value) {
        $("#state").click();
        $("#state").$(byText(value)).click();

        return this;
    }

    @Step("Выбираем город")
    public RegistrationPage setCity(String value) {
        $("#city").click();
        $("#city").$(byText(value)).click();

        return this;
    }

    @Step("Утверждаем введенные данные")
    public RegistrationPage submit() {
        $("#submit").click();

        return this;
    }

    @Step("Проверяем появление модального окна")
    public RegistrationPage verifyModalWindowAppears() {
        $("#example-modal-sizes-title-lg").shouldHave(exactTextCaseSensitive("Thanks for submitting the form"));

        return this;
    }

    @Step("Проверяем, что в Label {label} указано значение {value}")
    public RegistrationPage verifyModalWindowResult(String label, String value) {
        $$(".table tr").findBy(textCaseSensitive(value)).shouldBe(visible);

        return this;
    }
}
