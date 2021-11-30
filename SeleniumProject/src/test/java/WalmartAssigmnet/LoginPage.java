package WalmartAssigmnet;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.walmart.com/");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./photo/walmart.png");
		FileUtils.copyFile(src, dest);
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Electronics");
		driver.findElement(By.xpath("//button[@class='absolute bn br-100 bg-gold h3 w3']")).click();
		Thread.sleep(5000);
		
		Set<String> set = driver.getWindowHandles();
		for(String id:set) {
			
			driver.switchTo().window(id);
		}
		driver.findElement(By.xpath("//button[@class='w_Gp']/descendant::i[@class='ld ld-Close']")).click();
		
//		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Electronics");
//		driver.findElement(By.xpath("//button[@class='absolute bn br-100 bg-gold h3 w3']")).click();
        
		driver.findElement(By.xpath("//button[text()='tv']")).click();
		String exptitle="electronics - Walmart.com";
		String actTitle=driver.getTitle();
		assertEquals(exptitle, actTitle);
		
	}

}
