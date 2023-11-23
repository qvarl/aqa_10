package tests;

import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();

    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 9)),
            yearOfBirth = faker.number().numberBetween(1900, 2100) + "",
            monthOfBirth = setMonth(Integer.parseInt(dayOfBirth), Integer.parseInt(yearOfBirth)),
            subject_1 = faker.options().option("Chemistry", "Computer Science", "Commerce", "Accounting", "Economics", "Social Studies",
                    "Civics", "English", "Arts", "History", "Maths", "Physics", "Biology", "Hindi"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            picture = "Foto.PNG",
            address = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setCity(state);

    private String setMonth(int day, int year) {
        if (day == 31) {

            return faker.options().option("January", "March", "May", "July", "August", "October", "December");

        } else if (day == 30 || (day == 29) && (year % 4 != 0)) {

            return faker.options().option("January", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        } else

            return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }

    private String setCity(String state) {
        String city = "";

        switch (state) {
            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
            default:
        }

        return city;
    }
}
