package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.TestUtilDemo;

public class TestBaseDemo {

	public WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;
		
	public TestBaseDemo() throws IOException, FileNotFoundException {
		FileInputStream fp = new FileInputStream("C:\\Users\\mahi9\\eclipse-workspace\\com.basspro.demo\\Resources\\config.properties");
		prop = new Properties();
		prop.load(fp);
		}
	
	@SuppressWarnings("deprecation")
	public void Instantiate() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("test-type");
		options.addArguments("enable-strict-powerful-feature-restrictions");
		options.addArguments("disable-geolocation");
		/*cap.setCapability(ChromeOptions.CAPABILITY, options);
		cap = cap.merge(DesiredCapabilities.chrome());
		driver = new ChromeDriver(cap); */
		
	}
}
