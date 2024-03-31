package com.api.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature", glue = { "com.api.stepdefinition" },

		monochrome = true, plugin = {

				"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/HtmlReport/htmlreport.html" }

)

public class TestRunner {

}
