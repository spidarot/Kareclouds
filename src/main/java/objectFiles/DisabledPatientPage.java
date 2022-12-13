package objectFiles;

import org.openqa.selenium.By;
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
	// Tabel patient Data Button
	@FindBy(xpath = "(//a[contains(@onclick,'getpatientData')])[1]")
	WebElement patientDataElement;
	//delete Patient Button
	@FindBy(xpath="(//a[contains(@onclick,'delete_record')])")
	WebElement deletePatientDataElement;
	// toast Message Element
	@FindBy(css = ".toast-message")
	WebElement toastMessageElement;
	//enable Patient Data Button
	@FindBy(xpath="//i[@class='fa fa-thumbs-o-up']")
	WebElement enablePatientDataButtonElement;
	//close Patient Data Button
	@FindBy(xpath="//button[@class='close pt4']")
	WebElement closePatientDataButtonElement;
	
	By toastMessageElementBY = By.xpath("//div[@class='toast-message']");
	
	public void patientListButtonClick() {
		patientListButtonElement.click();
	}
	
	public void patientDataElementClick() {
		patientDataElement.click();
	}
	public void deletePatientData() {
		deletePatientDataElement.click();
	}
	
	public void alertHandlingPositive() {
		driver.switchTo().alert().accept();
	}

	public void alertHandlingNegative() {
		driver.switchTo().alert().dismiss();
	}
	
	public String toastMessageGetText() {
		waitByElement(toastMessageElement);
		String toastMessage = toastMessageElement.getText();
		return toastMessage;
	}
	public void enablePatientDataButtonClick() {
		enablePatientDataButtonElement.click();
	}
	public void closePatientDataButtonclick() {
		actions(closePatientDataButtonElement);
		closePatientDataButtonElement.click();
	}
}
