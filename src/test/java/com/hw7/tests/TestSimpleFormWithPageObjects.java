package com.hw7.tests;
import com.hw7.pages.SimpleFormWithPageObjects;
import org.junit.jupiter.api.Test;

public class TestSimpleFormWithPageObjects extends TestBase {
    SimpleFormWithPageObjects simpleFormWithPageObjects = new SimpleFormWithPageObjects();
    @Test
    void successfulRegistrationTest() {
        //Проверка заполения формы
        simpleFormWithPageObjects.openPage()
                .removeBanner()
                .setFirstName("TestFirstName")
                .setLastName("TestLastN")
                .setUserEmailName("test@test.test")
                .setGender("Other")
                .setUserNumber("1111111111")
                .setBirthDay("30", "October", "2008")
                .setCurrentAddress("TestCurrentAddress")
                .setHobby("Sports")
                .setSubjects("Maths")
                .setCity("NCR","Delhi")
                .uploadPicture("src/test/resources/1.png")
                .clickSubmit();

        //Проверка данных попапа
        simpleFormWithPageObjects.checkResult("Student Name", "TestFirstName")
                .checkResult("Student Email", "test@test.test")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1111111111")
                .checkResult("Date of Birth", "30 October,2008")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1.png")
                .checkResult("Address", "TestCurrentAddress")
                .checkResult("State and City", "NCR Delhi");
    }
}