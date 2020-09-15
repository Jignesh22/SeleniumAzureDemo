package testPackageLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;

	@Test
	public void test1_AdminLogin() throws InterruptedException {
		
/*		
		// Setup chromer driver
		WebDriverManager.chromedriver().version("2.46").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox"); // Bypass OS security model
		// Launch google chromer browser
		driver = new ChromeDriver(options);
*/		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		
		
		Thread.sleep(15000);
		
		
		
/*		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
*/		
		
		// Enter URL and open the site.
		driver.get("http://www.opsauto.radixdev68.com/admin/");
		// Maximize window of the browser window
		driver.manage().window().maximize();
		// Adding sleep wait
		Thread.sleep(5000);
		// Enter admin username
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("admin");
		// Enter admin password
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("admin");
		// Click on login button
		driver.findElement(By.xpath(".//*[@value='Login']")).click();
		// Adding sleep wait
		Thread.sleep(5000);
		// Print comment
		System.out.println("----------PASS: ADMIN LOGIN SUCCESSFULL----------");
	}

	@Test
	public void test2_CreateCustomer() throws InterruptedException {

		// Navigate to add customer form
		driver.navigate().to("http://www.opsauto.radixdev68.com/admin/user_action.php");
		// Adding sleep wait
		Thread.sleep(5000);
		// Fill customer details
		driver.findElement(By.xpath(".//*[@id='firstname']")).sendKeys("Jignesh");
		driver.findElement(By.xpath(".//*[@id='lastname']")).sendKeys("Patel FROM AZURE");
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("jignesh.patel@radixweb.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("admin");
		driver.findElement(By.xpath(".//*[@id='phone_number']")).sendKeys("8888899999");
		// Save&Back the customer
		driver.findElement(By.xpath(".//*[@id='btn-action-saveback']")).click();
		// Adding sleep wait
		Thread.sleep(5000);
		// Print comment
		System.out.println("----------PASS: CUSTOMER CREATION SUCCESSFULL----------");
	}

	@Test
	public void test3_AdminLogout() throws InterruptedException {

		// Click on admin logout dropdown
		driver.findElement(By.xpath(".//*[@class='user-info']")).click();
		// Adding sleep wait
		Thread.sleep(5000);
		// Click on admin logout
		driver.findElement(By.xpath(".//*[@class='ace-icon fa fa-power-off']/..")).click();
		// Print comment
		System.out.println("----------PASS: ADMIN LOGOUT SUCCESSFULL----------");
	}

}
