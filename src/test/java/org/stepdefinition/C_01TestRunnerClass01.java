package org.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", 
glue = "org.stepdefinition", 
monochrome = true, 
dryRun = false, 
snippets = SnippetType.UNDERSCORE, 
tags = "@feature06", 
plugin = {"html:target/reports/index.html", 
		"junit:target/reports/Xmlreport.xml",
		"json:target/reports/Jsonreports.json" })
public class C_01TestRunnerClass01 {

}