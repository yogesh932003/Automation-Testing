package org.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class C_01HooksClass extends C_00Base {

	@Before (order = 1)
	private void preCondition() {
		launchBrowser();
		windowMaximize();
	}
	
	@Before (order = 2)
	private void preCondition1() {
		System.out.println("Browser launched and window maximized successfully!!!");
	}
	
	@After (order = 2)
	private void postCondition() {
		closeEntireBrowser();
	}
	
	@After (order = 1)
	private void postCondition1() {
		System.out.println("Browser closed successfully!!!");
	}
	
}
