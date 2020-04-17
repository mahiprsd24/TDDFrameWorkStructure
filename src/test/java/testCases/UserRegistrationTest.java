package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageFactory.LoginPageDemo;
import testBase.TestBaseDemo;
import util.TestUtilDemo;

public class UserRegistrationTest extends TestBaseDemo{

	TestBaseDemo obj = new TestBaseDemo();
	TestUtilDemo TestUtil = new TestUtilDemo();
	LoginPageDemo LoginPage = new LoginPageDemo();
	
	public UserRegistrationTest() throws IOException, FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
		
	@SuppressWarnings("static-access")
	@BeforeMethod
	public void RegistrationTest() throws IOException {
		System.out.println("Print for before method");
		Instantiate();
							
	}
	
	@Test(priority = 1)
	public void NewUserRegistrationValidation() throws IOException, InterruptedException {		
		System.out.println("Test method");
		LoginPage.ValidLogin();
	}
	
	@Test(priority = 2)
	public void Demotest() throws IOException, InterruptedException {		
		System.out.println("Test method 2");
		//LoginPage.ValidLogin();
	}
	
	@AfterMethod
	public void TearDown() {
		System.out.println("Print for after method");
		driver.close();
	}	

}
