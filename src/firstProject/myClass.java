package firstProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myClass {
	
	// driver it is the object that i can use the Chrome browser 
	WebDriver driver = new ChromeDriver();

	@BeforeTest()
	public void beforeTest() {
		// store user name and password in variables to use it later in login process
		String userName = "standard_user";
		String password = "secret_sauce";
		
		// visit sauce demo web site
		String url = "https://www.saucedemo.com/";	
		driver.get(url);
		
		// login process
		// we can get the element By id , className , name ,....,etc
		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
		// add all products to cart 
		List <WebElement> allProducts = driver.findElements(By.className("btn"));
		
		for(int i = 0; i < allProducts.size(); i++) {
			allProducts.get(i).click();
		}
		
	}

	@Test()
	public void test() throws InterruptedException {
		
		String myUrl = driver.getCurrentUrl();
		
		Thread.sleep(2000);
		
		// remove all products from cart 
		List <WebElement> allProducts = driver.findElements(By.className("btn"));
		
		for(int i = 0; i < allProducts.size(); i++) {
			allProducts.get(i).click();
		}
		
		Thread.sleep(1000);
		
		// driver.close();
	}

	@AfterTest()
	public void afterTest() throws InterruptedException {
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.close();
	}

}

/*
 
xpath: is the worst way to select element
className
id
name

*/
