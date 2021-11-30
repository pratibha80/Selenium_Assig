package WalmartAssigmnet;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AviatorPage {
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
		Thread.sleep(5000);
		 driver.findElement(By.xpath("//span[text()='Aviator']")).click();
		 
		 
		 
		 
		 
	}

}
