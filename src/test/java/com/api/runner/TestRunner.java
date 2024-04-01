package com.api.runner;

import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/03_BatchController_Positive.feature",
                  glue = { "com.api.stepdefinition" }
                 // tags=  "@GetBatchByBatchId"
                 
 
//monochrome = true, 
//plugin = {
//		
//"html:target/HtmlReport/htmlreport.html" }

)
 


public class TestRunner  {

}
