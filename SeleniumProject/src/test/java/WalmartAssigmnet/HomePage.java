package WalmartAssigmnet;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
public static void main(String[] args) throws IOException, InterruptedException {
		
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
		driver.findElement(By.xpath("//span[text()='Black(8)']")).click();
		driver.findElement(By.xpath("//img[@class='img-responsive']")).click();
		Set<String> set = driver.getWindowHandles();
		for(String id:set) {
			
			driver.switchTo().window(id);
		}
		driver.findElement(By.xpath("//button[@class='ok-btn padding-5 fs14 letter-spacing-1 bg-white text-topaz text-uppercase']")).click();
		driver.findElement(By.xpath("//div[text()='Black']")).click();
		
		driver.findElement(By.xpath("//button[text()='BUY NOW']")).click();
		driver.findElement(By.xpath("(//i[@class='cart-item_remove-icon'])[2]")).click();
		driver.findElement(By.xpath("//i[@class='icon- plus']")).click();
		
		
		
		
		
		
		
		
		
		
	FileInputStream fis=new FileInputStream("C:\\Users\\tprat\\eclipse-workspace\\AmdocsAddign\\SeleniumProject\\Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
	    Row row = sh.getRow(1);	
	    Cell cel = row.createCell(1);
	    cel.setCellValue("Vincent Chase Polarized");
	    
	    FileOutputStream fos=new FileOutputStream("C:\\\\Users\\\\tprat\\\\eclipse-workspace\\\\AmdocsAddign\\\\SeleniumProject\\\\Data.xlsx");
	    wb.write(fos);
	    wb.close();
		
		driver.findElement(By.xpath("//div[text()='Vincent Chase Polarized']"));
		
		
		

}
}