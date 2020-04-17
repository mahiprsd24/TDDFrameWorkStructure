package pageFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testBase.TestBaseDemo;
import util.TestUtilDemo;

public class LoginPageDemo extends TestBaseDemo{

		
	public LoginPageDemo() throws IOException, FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
		}
	
	//Logos and Headers
		@FindBy(xpath = "//*[@id='ci_espot__HeaderStoreLogo_Content']/div/a/img")
		WebElement BassProLogo;
		
		//Links and Buttons
		@FindBy(xpath = "//*[@id='Header_GlobalLogin_signInQuickLink']/div")
		WebElement SignInLink;
		
		@FindBy(xpath = "//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']")
		WebElement SignInButton;
		
		@FindBy(xpath = "//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_3']")
		WebElement CreateAnAccountButton;
		
		//Forms and Windows 
		@FindBy(xpath = "//*[@id='Header_GlobalLogin_signInDropdown']/div")
		WebElement SignInBox;
		
		//TextBoxes
		@FindBy(xpath = "//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']")
		WebElement EmailTextBox;
		
		@FindBy(xpath = "//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']")
		WebElement PasswordTextBox;
		
		//Additional pop-ups		
		@FindBy(xpath = "//*[@id='justuno_form']/div/div[2]")
		WebElement AdventurePopUp;
		
		@FindBy(xpath = "//*[@id='justuno_form']/div/div[2]/div[9]/div/div/div/span/strong/span")
		WebElement CloseAdventurePopUp;
		
		//Method to validate successful login
		public HomePage ValidLogin() throws IOException, InterruptedException {
			
			XSSFRow loginDertails = TestUtilDemo.getTestData("loginDetails", "ValidLogin");
			String userName = loginDertails.getCell(1).getStringCellValue();
			String password = loginDertails.getCell(2).getStringCellValue();
			System.out.println("Username : " + userName + " Password : " + password);
			
			//CloseAdventurePopUp.click();
			
			/*try {
			wait.until(ExpectedConditions.visibilityOf(AdventurePopUp));
			CloseAdventurePopUp.click();
			} catch (NoSuchElementException e) {
				System.out.println("Element not displayed");
			}*/
			
			/*List<WebElement> dynamicElement = driver.findElements(By.xpath("//*[@id='justuno_form']/div/div[2]"));
			if(dynamicElement.size() != 0) {
			 System.out.println("Element present");
			driver.findElement(By.xpath("//*[@id='justuno_form']/div/div[2]/div[9]/div/div/div/span/strong/span")).click();
			}
			else {
			 System.out.println("Element not present");
			}*/
			
			//wait.until(ExpectedConditions.visibilityOf(BassProLogo));
			System.out.println("Basspro home page being displayed");
			SignInLink.click();
			Thread.sleep(3000);
			//wait.until(ExpectedConditions.elementToBeClickable(SignInButton));
			
			EmailTextBox.click();
			EmailTextBox.sendKeys(userName);
			
			PasswordTextBox.click();
			PasswordTextBox.sendKeys(password);
			
			SignInBox.click();
			System.out.println("Action perfomed to login to site");
			
			return new HomePage();
			
//			try {
//				AdventurePopUp.isDisplayed();
//				CloseAdventurePopUp.click();
//				
//				System.out.println("Operation performd to close pop-up");
//				
//				wait.until(ExpectedConditions.visibilityOf(BassProLogo));
//				System.out.println("Basspro home page being displayed");
//				SignInLink.click();
//				wait.until(ExpectedConditions.elementToBeClickable(SignInButton));
//				
//				EmailTextBox.click();
//				EmailTextBox.sendKeys(userName);
//				
//				PasswordTextBox.click();
//				PasswordTextBox.sendKeys(password);
//				
//				SignInBox.click();
//				System.out.println("Action perfomed to login to site");
//				
//			} catch (NoSuchElementException e) {
//				System.out.println("Element not present");
//				
//				wait.until(ExpectedConditions.visibilityOf(BassProLogo));
//				System.out.println("Basspro home page being displayed");
//				SignInLink.click();
//				wait.until(ExpectedConditions.elementToBeClickable(SignInButton));
//				
//				EmailTextBox.click();
//				EmailTextBox.sendKeys(userName);
//				
//				PasswordTextBox.click();
//				PasswordTextBox.sendKeys(password);
//				
//				SignInBox.click();
//				System.out.println("Action perfomed to login to site");
//				
//			}
						
			/*if(!AdventurePopUp.isDisplayed()) {
				System.out.println("Next Adventure pop up not displayed");
			}
				else {
					System.out.println("Closing Next Adventure pop-up");
					//driver.findElement(By.xpath("//*[@id='justuno_form']/div/div[2]/div[9]/div/div/div/span/strong/span")).click();
					CloseAdventurePopUp.click();
			}*/			
			
		}
		//Methods to navigate to user registration page
		public void NavigateToRegisterNewUser() throws IOException {
		
			wait.until(ExpectedConditions.visibilityOf(BassProLogo));
			SignInLink.click();
			wait.until(ExpectedConditions.elementToBeClickable(SignInButton));
			CreateAnAccountButton.click();
			
			
		}
		
		
}
