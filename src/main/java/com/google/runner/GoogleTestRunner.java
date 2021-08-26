package com.google.runner;

import com.google.threads.GoogleFeatureThread;

public class GoogleTestRunner {

	public static void main(String[] args) {

//calling constructor of GoogleFeatureThread class
//pass thread name and browser
		Thread t1 = new GoogleFeatureThread("chrome Thread","chrome"); //top-casting (parent class reference variable references child class object)
		Thread t2 = new GoogleFeatureThread("firefox Thread","firefox"); 
		
		System.out.println("Starting both threads...");
	
//Multi-threading: both threads started simultaneously on Chrome and FF		
		t1.start(); //invokes overridden run() method in GoogleFeatureThread class
		t2.start(); //invokes overridden run() method in GoogleFeatureThread class
					
//run 5 threads each on Chrome & FF		
		for(int i=0; i<5; i++) {
			new GoogleFeatureThread("chrome thread", "chrome").start();
			new GoogleFeatureThread("firefox thread", "firefox").start();
		}
		
//get number of threads from command line
	    int chromeCount = Integer.parseInt(System.getProperty("chrome"));
		int firefoxCount = Integer.parseInt(System.getProperty("firefox"));		
		
		System.out.println("total chrome threads: "+chromeCount);
		System.out.println("total FF threads: "+firefoxCount);
		
		for(int x=0, y=0;x<chromeCount || y<firefoxCount; x++, y++) {
			
			new GoogleFeatureThread("chrome thread", "chrome").start();
			new GoogleFeatureThread("firefox thread", "firefox").start();
			
			System.out.println("thread ended..");
		}
		
	}

}
