package basiccmds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentAngularPractice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//form//input[@name='name']")).sendKeys("Shiji");
		driver.findElement(By.xpath("//form//input[@name='email']")).sendKeys("shiji@gmail.com");
		driver.findElement(By.xpath("//form//input[@placeholder='Password']")).sendKeys("q1w2e3r4t5");
		driver.findElement(By.xpath("//form//input[@id='exampleCheck1']")).click();
		WebElement gender=driver.findElement(By.xpath("//form//select[@id='exampleFormControlSelect1']"));
		//gender.click();
		Select options=new Select(gender);
		options.selectByIndex(1);
		driver.findElement(By.xpath("//form//input[@id='inlineRadio1']")).click();
		driver.findElement(By.xpath("//form//input[@name='bday']")).sendKeys("1998-01-01");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//System.out.println(driver.findElement(By.xpath("//strong[text()]")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		driver.close();
	}

}
