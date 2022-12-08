package objectFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class DisabledPatientPage extends ObjectParentClass {
	WebDriver driver;
	

	public DisabledPatientPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Patient List
	@FindBy(xpath="//a[text()=' Patient List']")
	WebElement patientListButtonElement;
	
	
	public void patientListButtonClick() {
		patientListButtonElement.click();
	}
	
}
