package objectFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractParentFiles.ObjectParentClass;

public class SetupPage extends ObjectParentClass {

	WebDriver driver;

	public SetupPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="//*[text()='Setup']")
	// WebElement setupElement;

	@FindBy(xpath = "//li[@class='treeview '][18]")
	WebElement setupElement;
	// patient dropdown
	@FindBy(xpath = "//ul[@class='treeview-menu menu-open']//li[1]")
	WebElement patientElement;

	By patientElementBy = By.xpath("//ul[@class='treeview-menu menu-open']//li[1]");

	public void setupClick() {
		actions(setupElement);
		setupElement.click();
	}

	public PatientPage LoadpatientPage() {
		actions(patientElement);
		waits(patientElementBy);
		patientElement.click();
		PatientPage patient = new PatientPage(driver);
		return patient;
	}

}
