package com.artyomkravts;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static com.artyomkravts.SelenideHelper.*;

public class SelenideLambdaTest {

    @Test
    public void testWithLambdaSteps() {
        step("Open " + GITHUBLINK, () -> {
            open(GITHUBLINK);
        });

        step("Search for repository: " + REPOSITORY, () -> {
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").pressEnter();
        });

        step("Click " + REPOSITORY, () -> {
            $(By.linkText("/eroshenkoam/allure-example")).click();
        });

        step("Click issues tab and look for #80", () -> {
            $("#issues-tab").click();
            $(withText("#80")).should(Condition.exist);
        });
    }
}
