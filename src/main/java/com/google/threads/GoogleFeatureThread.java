package com.google.threads;

import com.pages.GooglePage;

//Class to implement multi-threading concept
public class GoogleFeatureThread extends Thread{
	
	public String browser;
	GooglePage googlePage;
	
//constructor
	public GoogleFeatureThread(String threadName, String browserName) {
		
		super(threadName); //call Thread class constructor to print the thead name
		this.browser = browserName;
		googlePage = new GooglePage(); //initiating instance of GooglePage class (when this constructor is called)
	}

//Override run() method from Thread class	
	@Override
	public void run() {
		
		System.out.println("Thread started: "+Thread.currentThread().getName());
		
		try {
			Thread.sleep(1000);
			googlePage.setUp(this.browser); //call setUp() method to launch browser and return driver object for next step
			googlePage.googleSearchTest(); //call method to perform google search
			
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
	//finally - executed irrespective of an exception or not
		finally {
			googlePage.tearDown();
		}
		
		System.out.println("Thread ended: "+Thread.currentThread().getName());
	}
	
}
