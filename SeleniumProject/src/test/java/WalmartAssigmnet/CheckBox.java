package WalmartAssigmnet;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckBox {
	public static void main(String[] args) throws IOException, Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.lenskart.com/");

		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./photo/lenkart.png");
		FileUtils.copyFile(src, dest);
		WebElement ele = driver.findElement(By.xpath("//a[text()='SUNGLASSES']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		Thread.sleep(3000);
		 driver.findElement(By.xpath("//span[text()='Aviator']")).click();


		 driver.findElement(By.xpath("//span[text()='Black(8)']")).click();
			driver.findElement(By.xpath("//img[@class='img-responsive']")).click();
			Set<String> set = driver.getWindowHandles();
			for(String id:set) {
				
				driver.switchTo().window(id);
			}
			driver.findElement(By.xpath("//button[@class='ok-btn padding-5 fs14 letter-spacing-1 bg-white text-topaz text-uppercase']")).click();
			driver.findElement(By.xpath("//div[text()='Black']")).click();
}
}