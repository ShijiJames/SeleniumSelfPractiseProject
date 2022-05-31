package basiccmds;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentOnWaits {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));

		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		// System.out.println("doneeeeeeeeeeeeeeeee");
		WebElement userType = driver.findElement(By.xpath("//select[@class='form-control']"));
		userType.click();
		Select userOp = new Select(userType);
		userOp.selectByVisibleText("Consultant");
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
		// <title>ProtoCommerce</title>
		// driver.findElements(By.xpath("//button[text()='Add ']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Add ']")));
		List<WebElement> products = driver.findElements(By.xpath("//h4//a"));
		for (int i = 0; i <= products.size() - 1; i++) {

			String names = products.get(i).getText();
			// System.out.println(names);
			driver.findElements(By.xpath("//button[text()='Add ']")).get(i).click();
		}
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Checkout ')]")).click();
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("Ch");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='suggestions']//a")));
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='suggestions']//a"));
		/*
		 * for(WebElement option : options) { //System.out.println(option.getText());
		 * 
		 * if(option.getText().equals("China")) { option.click(); break; } }
		 */

		for (int i = 0; i <= options.size() - 1; i++) {

			// System.out.println(options.get(i).getText());

			if (options.get(i).getText().equals("China")) {
				options.get(i).click();
				break;
			}

		}
		/* checkbox for terms is not able to click, I tried but couldn't */

		// wait.until(ExpectedConditions.e(By.xpath("//input[@id='checkbox2']")));
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.findElement(By.xpath("//div[@class='checkbox
		// checkbox-primary']//input[@id='checkbox2']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
