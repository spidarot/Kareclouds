package objectFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class FloorPage extends ObjectParentClass {

	WebDriver driver;

	public FloorPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Title Text
	@FindBy(xpath = "//h3[@class='box-title titlefix']")
	WebElement titleTextElement;
	// add Floor button
	@FindBy(xpath = "//a[@data-target='#myModal']")
	WebElement addFloorButtonElement;
	// close Button in add Floor window
	@FindBy(xpath = "//div[@id='myModal']//button[@class='close']")
	WebElement closeAddFloorWindowButtonElement;
	// name field in add Floor Window
	@FindBy(xpath = "//div[@id='myModal']//input[@name='name']")
	WebElement nameInAddFloorWindowElement;
	// description in add Floor window
	@FindBy(xpath = "//div[@id='myModal']//textarea[@name='description']")
	WebElement descriptionInAddFloorWindowElement;
	// save button in add Floor window
	@FindBy(css = "button#addfloorbtn")
	WebElement saveButtonInAddFloorWindowElement;
	// toast Message Element
	@FindBy(xpath = "//body//div[@id='toast-container']//div[@class='toast-message']")
	WebElement toastMessageElement;
	// edit Floor button list
	@FindBy(xpath = "//a[@data-target='#myModaledit']")
	List<WebElement> editFloorButtonList;
	// delete Floor button list
	@FindBy(xpath = "//a[contains(@onclick,'delete_recordById')]//i")
	List<WebElement> deleteFloorButtonList;
	// name in edit Floor window
	@FindBy(xpath = "//div[@id='myModaledit']//input[@name='name']")
	WebElement nameInEditFloorWindowElement;
	// description in Edit Floor window
	@FindBy(xpath = "//div[@id='myModaledit']//textarea[@name='description']")
	WebElement descriptionInEditFloorWindowElement;
	// close button in edit Floor window
	@FindBy(xpath = "//div[@id='myModaledit']//button[@class='close']")
	WebElement closeButtonInEditFloorWindowElement;
	// save Button in edit Floor Window
	@FindBy(xpath = "//div[@id='myModaledit']//button[@id='editfloor_databtn']")
	WebElement saveButtonInEditFloorWindowElement;
	

	public String titleTextGetText() {
		waitByElement(titleTextElement);
		String TitleText = titleTextElement.getText();
		return TitleText;
	}

	public void addFloorButtonClick() {
		waitByElement(titleTextElement);
		addFloorButtonElement.click();
		waitByElement(closeAddFloorWindowButtonElement);
	}

	public String enterNameInAddFloorWindow(String enterName) {
		nameInAddFloorWindowElement.sendKeys(enterName);
		return enterName;
	}
	
	public String enterdescriptionInAddFloorWindow(String enterdescription) {
		descriptionInAddFloorWindowElement.sendKeys(enterdescription);
		return enterdescription;
	}

	public void saveButtonInAddFloorClick() {
		saveButtonInAddFloorWindowElement.click();
		waitByElement(titleTextElement);
	}

	public void closeAddFloorWindowButtonClick() {
		closeAddFloorWindowButtonElement.click();
	}

	public String toastMessageGetText() {
		waitByElement(toastMessageElement);
		String toastMessage = toastMessageElement.getText();
		return toastMessage;
	}

	public void editFloorButtonClick(int ElementNumberToBeSelected) {
		int i = ElementNumberToBeSelected - 1;
		actions(editFloorButtonList.get(i));
		editFloorButtonList.get(i).click();
		waitByElement(closeButtonInEditFloorWindowElement);
	}

	public void deleteFloorButtonClick(int ElementNumberToBeSelected) {
		int i = ElementNumberToBeSelected - 1;
		actions(deleteFloorButtonList.get(i));
		deleteFloorButtonList.get(i).click();
	}

	public String enterNameInEditFloorWindow(String enterName) {
		nameInEditFloorWindowElement.sendKeys(enterName);
		return enterName;
	}

	public String enterdescriptionInEditFloorWindow(String enterdescription) {
		descriptionInEditFloorWindowElement.sendKeys(enterdescription);
		return enterdescription;
	}

	public void closeButtonInEditFloorWindowClick() {
		closeButtonInEditFloorWindowElement.click();
	}

	public void saveButtonInEditFloorWindowClick() {
		saveButtonInEditFloorWindowElement.click();
		waitByElement(titleTextElement);
	}
	public void alertHandlingPositive() {
		driver.switchTo().alert().accept();
	}

	public void alertHandlingNegative() {
		driver.switchTo().alert().dismiss();
	}
}
