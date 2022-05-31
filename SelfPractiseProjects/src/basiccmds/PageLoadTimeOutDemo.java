package basiccmds;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.netty.handler.timeout.TimeoutException;

public class PageLoadTimeOutDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		// Define the timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		// Use the timeout when navigating to a webpage
		try {
			driver.get("https://demoqa.com/frames");
			WebElement frame = driver.findElement(By.xpath("//iframe[@id='frame1']"));
			driver.switchTo().frame(frame);// 3rd method of switching to iframe using webelement
			WebElement frameText = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
			System.out.println(frameText.getText());
			driver.switchTo().parentFrame();// to switch back to parent frame
			driver.close();
		} catch (TimeoutException e) {
			System.out.println("Page:  did not load within 40 seconds!");
			// treat the timeout as needed
		}

	}

}
