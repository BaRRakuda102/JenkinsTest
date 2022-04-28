package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class AutomationRegistrationFormTest {

    String email = "domesh.s@yandex.ru";

    @BeforeAll
    static void BeforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void succesfullTest () {
        Selenide.open("/automation-practice-form");
        $("#firstName").setValue("Vladislav");
        $("#lastName").setValue("Krasavchik");
        $("#userEmail").setValue(email);
        $(byText("Male")).click();
        $("#userNumber").setValue("89174358231");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1994");
        $("[aria-label$='November 30th, 1994']").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Slivovaya");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Vladislav Krasavchik"))
                .parent().shouldHave(text("Vladislav Krasavchik"));

        $(".table-responsive").$(byText("Slivovaya")).parent().shouldHave(text("Slivovaya"));
        $(".table-responsive").$(byText("domesh.s@yandex.ru"))
                .parent().shouldHave(text("domesh.s@yandex.ru"));


    }
}