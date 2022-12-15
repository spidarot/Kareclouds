package objectFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class BedTypePage extends ObjectParentClass {
	WebDriver driver;

	public BedTypePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Title Text
	@FindBy(xpath = "//h3[@class='box-title titlefix']")
	WebElement titleTextElement;
	// add button
	@FindBy(xpath = "//a[@data-target='#myModal']")
	WebElement addButtonElement;
	// close Button in add window
	@FindBy(xpath = "//div[@id='myModal']//button[@class='close']")
	WebElement closeAddWindowButtonElement;
	// name field in add Window
	@FindBy(css = "input#invoice_no")
	WebElement nameInAddWindowElement;
	// save button in add window
	@FindBy(css = "button#addbedtypebtn")
	WebElement saveInAddWindowButtonElement;
	// toast Message Element
	@FindBy(xpath = "//body//div[@id='toast-container']//div[@class='toast-message']")
	WebElement toastMessageElement;
	// edit button list
	@FindBy(xpath = "//a[@data-target='#editmyModal']")
	List<WebElement> editButtonList;
	// delete button list
	@FindBy(xpath = "//a[contains(@onclick,'delete_recordById')]")
	List<WebElement> deleteButtonList;
	// name in edit Bed Type window
	@FindBy(xpath = "//div[@id='edit_bedtypedata']//input[@name='name']")
	WebElement nameInEditBedTypeWindowElement;
	// close button in edit bed type window
	@FindBy(xpath = "//div[@id='editmyModal']//button[@class='close']")
	WebElement closeButtonInEditBedTypeWindowElement;
	// save Button in edit bed Type Window
	@FindBy(xpath = "//div[@id='editmyModal']//button[@id='editbedtypebtn']")
	WebElement saveButtonInEditBedTypeWindowElement;

	public String titleTextGetText() {
		waitByElement(titleTextElement);
		String TitleText = titleTextElement.getText();
		return TitleText;
	}

	public void addButtonClick() {
		waitByElement(titleTextElement);
		addButtonElement.click();
		waitByElement(closeAddWindowButtonElement);
	}

	public String enterNameInAddWindow(String enterName) {
		nameInAddWindowElement.sendKeys(enterName);
		return enterName;
	}

	public void saveInAddButtonClick() {
		saveInAddWindowButtonElement.click();
		waitByElement(titleTextElement);
	}

	public void closeAddWindowButtonClick() {
		closeAddWindowButtonElement.click();
	}

	public String toastMessageGetText() {
		waitByElement(toastMessageElement);
		String toastMessage = toastMessageElement.getText();
		return toastMessage;
	}

	public void editButtonClick(int ElementNumberToBeSelected) {
		int i = ElementNumberToBeSelected - 1;
		actions(editButtonList.get(i));
		editButtonList.get(i).click();
		waitByElement(closeButtonInEditBedTypeWindowElement);
	}

	public void deleteButtonClick(int ElementNumberToBeSelected) {
		int i = ElementNumberToBeSelected - 1;
		actions(deleteButtonList.get(i));
		deleteButtonList.get(i).click();
	}

	public String enterNameInEditBedTypeWindow(String enterName) {
		nameInEditBedTypeWindowElement.sendKeys(enterName);
		return enterName;
	}

	public void closeButtonInEditBedTypeWindowClick() {
		closeButtonInEditBedTypeWindowElement.click();
	}

	public void saveButtonInEditBedTypeWindowClick() {
		saveButtonInEditBedTypeWindowElement.click();
	}

}
