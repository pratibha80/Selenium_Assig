package WalmartAssigmnet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//a[@class='gb_C']")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//span[text()='YouTube']")).click();
        driver.findElement(By.id("search"));

	}

}
