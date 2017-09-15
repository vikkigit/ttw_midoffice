package com.test.mo.automation.login;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.mo.automation.testbase.Testbase;
import com.test.mo.automation.uiaction.test;

public class logintest extends Testbase{
	
	test test1;
	
	
	@BeforeClass
	public void startBrowser() throws IOException{
		init();
	}
	
	
	@Test
	public void login() throws InterruptedException{
		test1=new test(driver);
		test1.login();
	}

}
