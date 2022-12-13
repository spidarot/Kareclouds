package objectFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class FrontOfficePage extends ObjectParentClass {

	WebDriver driver;
	
	public FrontOfficePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
