package com.artyomkravts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class SelenideHelper {

    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final String GITHUBLINK = "https://github.com";

    @Step("Click on issues-tab and check #80")
    public static void clickOnIssuesTabAndCheckText80() {
        Selenide.$("#issues-tab").click();
        Selenide.$(Selectors.withText("#80")).should(Condition.exist);
    }

    @Step("Click {repo}")
    public static void clickLink(String repo) {
        Selenide.$(By.linkText(repo)).click();
    }

    @Step("Click search bar, insert {repo} and press ENTER")
    public static void insertQueryAndPressEnter(String repo) {
        Selenide.$("[data-target='qbsearch-input.inputButtonText']").click();
        Selenide.$("#query-builder-test").sendKeys(repo);
        Selenide.$("#query-builder-test").pressEnter();
    }

    @Step("Open https://github.com")
    public static void openGitHub() {
        Selenide.open("https://github.com");
    }

    @Step("Take a screenshot")
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
