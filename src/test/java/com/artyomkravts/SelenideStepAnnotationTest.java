package com.artyomkravts;

import org.junit.jupiter.api.Test;

import static com.artyomkravts.SelenideHelper.REPOSITORY;

public class SelenideStepAnnotationTest {

    @Test
    public void testWithAnnotationSteps() {

        SelenideHelper.openGitHub();

        SelenideHelper.insertQueryAndPressEnter(REPOSITORY);

        SelenideHelper.clickLink(REPOSITORY);

        SelenideHelper.clickOnIssuesTabAndCheckText80();
    }
}
