package objectFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class BedPage extends ObjectParentClass {

	WebDriver driver;
	
	public BedPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
