package abstractParentFiles;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectParentClass {

	WebDriver driver;
	public ObjectParentClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void waits(By FindBy){
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	public void waitByElement(WebElement webElment){
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(webElment));
	}
	public void waitsFluent(WebElement webElment) {
	
	Wait<WebDriver> w=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(10)).ignoring(NoSuchElementException.class);
	WebElement obj=w.until(new Function<WebDriver,WebElement>(){
	public WebElement apply(WebDriver driver) {
	if(webElment.isDisplayed()) {
	return webElment;	
	}
	else return null;
	}
	});
	}
	public  void screenshot(String FileName) throws IOException 
	{
		String FName=FileName;
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("D:\\Testing Sadup\\KCScreenshots\\"+FName+".png"));
		
	}
	public void actions(WebElement findbyElement) 
	{
		Actions a = new Actions(driver);
		a.moveToElement(findbyElement).build().perform();
	}
	public void actionScroll(WebElement findbyElement) 
	{
		Actions a = new Actions(driver);
		a.scrollToElement(findbyElement).build().perform();
	}
	public void selectOption(WebElement findbyElement,String selectByValue) {
		Select s = new Select(findbyElement);
		s.selectByValue(selectByValue);
	}
	public void selectOptionByText(WebElement findbyElement,String selectByText) {
		Select s = new Select(findbyElement);
		s.selectByVisibleText(selectByText);
	}
}
