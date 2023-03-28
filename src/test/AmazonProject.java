package test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProject {

	public static void main(String[] args) throws IOException { 
		// TODO Auto-generated method stub
		int i=0;
		System.setProperty("webdriver.chrome.driver","chromedriver.exe" );
		WebDriver driver =new ChromeDriver();
		driver.get ("http://www.Amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement SearchBox = driver.findElement(By.xpath("//input[@id ='twotabsearchtextbox']"));
		SearchBox.sendKeys("Samsung mobile");
		WebElement SearchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		SearchButton.click();
		List<WebElement> Prodname = driver.findElements(By.xpath("//div[@class = 'a-section']//h2//span"));
		List<WebElement> Prodprice = driver.findElements(By.xpath("//div[@class = 'a-section']//a//span[@class = 'a-price-whole']"));
		List<WebElement> rupees = driver.findElements(By.xpath("//div[@class ='sg-row']//span[@class= 'a-price-symbol']"));
		for (i=0; i <Prodname.size(); i++ ) {
			System.out.println("product name:" + Prodname.get(i).getText());
			System.out.println("product price:" + rupees.get(i).getText() + " " + Prodprice.get(i).getText());
		
			
		    TakesScreenshot tsObj = (TakesScreenshot) driver;
			File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
			File screenshotObj = new File("image.png");
			
			FileUtils.copyFile(fileObj,screenshotObj);
		}
			driver.close();
			
			
			
		
		}
			
			
			
			}

	

			
		
		
		
		





