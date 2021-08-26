package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.SendKeysAction;

public class GooglePage extends BasePage{

	//page actions:
	public void googleSearchTest() {
		
		driver.findElement(By.xpath("//input[@name='q']")).clear();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("automation labs");
		driver.findElement(By.xpath("//input[@name='q']")).submit(); //press enter
		
	//collect all <h3> tags from results and add it to a WebElements collection
	//stream(): Collection class to capture WebElements
		driver.findElements(By.xpath("//h3")).stream().forEach(ele->System.out.println(ele.getText()));
	}

}
	

