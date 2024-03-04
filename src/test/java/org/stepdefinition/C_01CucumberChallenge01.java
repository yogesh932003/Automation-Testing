package org.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class C_01CucumberChallenge01 extends C_00Base {

	@Given("To launch the edge browser and maximize window")
	public void to_launch_the_edge_browser_and_maximize_window() {
	    launchBrowser();
	    windowMaximize();
	}

	@When("To launch the URL of the ICICI netbanking application")
	public void to_launch_the_url_of_the_icici_netbanking_application() {
	    launchUrl("https://secure.icicidirect.com/customer/login");
	}

	@When("To pass valid userId in input field")
	public void to_pass_valid_userId_in_input_field() {
	    WebElement userId = driver.findElement(By.xpath("//input[@id='txtu']"));
	    passText("2233445566", userId);
	}

	@When("To pass valid password in input field")
	public void to_pass_valid_password_in_input_field() {
		WebElement pass = driver.findElement(By.xpath("//input[@id='txtp']"));
		passText("12345", pass);
	}

	@When("To click login button")
	public void to_click_login_button() {
	    WebElement login = driver.findElement(By.xpath("//a[text()='Login ']"));
	    clickBtn(login);
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
		closeEntireBrowser();
	}

}
