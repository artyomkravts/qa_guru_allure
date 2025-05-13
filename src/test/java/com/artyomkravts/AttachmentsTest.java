package com.artyomkravts;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.artyomkravts.SelenideHelper.GITHUBLINK;
import static com.artyomkravts.SelenideHelper.REPOSITORY;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {

    @Test
    @Feature("Issue in repo")
    @Story("Creating Issue")
    @Owner("artyomkravts")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Search for issue 80 in repository")
    public void testWithLambdaStepsAndAttachment() {
        step("Open " + GITHUBLINK + " and take screenshot", () -> {
            open(GITHUBLINK);
            attachment("Source", webdriver().driver().source()); // прикрепить web страничку в репорт
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

    @Test
    public void testWithAnnotationStepsAndAttachment() {

        SelenideHelper.openGitHub();
        SelenideHelper.takeScreenshot();

        SelenideHelper.insertQueryAndPressEnter(REPOSITORY);

        SelenideHelper.clickLink(REPOSITORY);

        SelenideHelper.clickOnIssuesTabAndCheckText80();

    }
}
