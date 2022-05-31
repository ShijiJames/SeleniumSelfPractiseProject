package basiccmds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxs {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Check the first Checkbox and verify if it is successfully checked and
		// Uncheck it again to verify if it is successfully Unchecked

		WebElement checkbx = driver.findElement(By.id("checkBoxOption1"));
		checkbx.click();
		System.out.println(checkbx.isSelected());
		checkbx.click();
		System.out.println(checkbx.isSelected());

		// How to get the Count of number of check boxes present in the page

		int totalcheckbx = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		System.out.println(totalcheckbx);
	}

}
