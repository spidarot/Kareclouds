package objectFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class BedGroupPage extends ObjectParentClass {

	WebDriver driver;

	public BedGroupPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Title Text
	@FindBy(xpath = "//h3[@class='box-title titlefix']")
	WebElement titleTextElement;
	// add button
	@FindBy(xpath = "//a[@data-target='#myModal']")
	WebElement addBedGroupButtonElement;
	// close Button in add Bed Group window
	@FindBy(xpath = "//div[@id='myModal']//button[@class='close']")
	WebElement closeAddBedGroupWindowButtonElement;
	// name field in add Bed Group Window
	@FindBy(xpath = "//div[@id='myModal']//input[@name='name']")
	WebElement nameInAddBedGroupWindowElement;
	// Select Floor in add Bed Group window
	@FindBy(xpath = "//div[@id='myModal']//select[@name='floor']")
	WebElement selectFloorOptionInAddBedGroupWindowElement;
	// description in add Bed Group window
	@FindBy(xpath = "//div[@id='myModal']//textarea[@name='description']")
	WebElement descriptionInAddBedGroupWindowElement;
	// save button in add Bed Group window
	@FindBy(css = "button#addwardbtn")
	WebElement saveButtonInAddBedGroupWindowElement;
	// toast Message Element
	@FindBy(xpath = "//body//div[@id='toast-container']//div[@class='toast-message']")
	WebElement toastMessageElement;
	// edit Bed Group button list
	@FindBy(xpath = "//a[@data-target='#myeditModal']")
	List<WebElement> editBedGroupButtonList;
	// delete Bed Group button list
	@FindBy(xpath = "//a[contains(@onclick,'delete_recordById')]")
	List<WebElement> deleteBedGroupButtonList;
	// name in edit Bed Group window
	@FindBy(xpath = "//div[@id='myeditModal']//input[@name='name']")
	WebElement nameInEditBedGroupWindowElement;
	// close button in edit Bed Group window
	@FindBy(xpath = "//div[@id='myeditModal']//button[@class='close']")
	WebElement closeButtonInEditBedGroupWindowElement;
	// save Button in edit Bed Group Window
	@FindBy(xpath = "//div[@id='myeditModal']//button[@id='editbedgroupbtn']")
	WebElement saveButtonInEditBedGroupWindowElement;
	// Select Floor in Edit Bed Group window
	@FindBy(xpath = "//form[@id='editbedgroup']//select[@name='floor']")
	WebElement selectFloorOptionInEditBedGroupWindowElement;
	// description in Edit window
	@FindBy(xpath = "//form[@id='editbedgroup']//textarea[@name='description']")
	WebElement descriptionInEditBedGroupWindowElement;

	public String titleTextGetText() {
		waitByElement(titleTextElement);
		String TitleText = titleTextElement.getText();
		return TitleText;
	}

	public void addBedGroupButtonClick() {
		waitByElement(titleTextElement);
		addBedGroupButtonElement.click();
		waitByElement(closeAddBedGroupWindowButtonElement);
	}

	public String enterNameInAddBedGroupWindow(String enterName) {
		nameInAddBedGroupWindowElement.sendKeys(enterName);
		return enterName;
	}

	public void selectFloorOptionInAddBedGroupWindow(String selectByText) {
		selectOptionByText(selectFloorOptionInAddBedGroupWindowElement, selectByText);
	}

	public String enterdescriptionInAddBedGroupWindow(String enterdescription) {
		descriptionInAddBedGroupWindowElement.sendKeys(enterdescription);
		return enterdescription;
	}

	public void saveButtonInAddBedGroupClick() {
		saveButtonInAddBedGroupWindowElement.click();
		waitByElement(titleTextElement);
	}

	public void closeAddBedGroupWindowButtonClick() {
		closeAddBedGroupWindowButtonElement.click();
	}

	public String toastMessageGetText() {
		waitByElement(toastMessageElement);
		String toastMessage = toastMessageElement.getText();
		return toastMessage;
	}

	public void editBedGroupButtonClick(int ElementNumberToBeSelected) {
		int i = ElementNumberToBeSelected - 1;
		actions(editBedGroupButtonList.get(i));
		editBedGroupButtonList.get(i).click();
		waitByElement(closeButtonInEditBedGroupWindowElement);
	}

	public void deleteBedGroupButtonClick(int ElementNumberToBeSelected) {
		int i = ElementNumberToBeSelected - 1;
		actions(deleteBedGroupButtonList.get(i));
		deleteBedGroupButtonList.get(i).click();
		
	}

	public String enterNameInEditBedGroupWindow(String enterName) {
		nameInEditBedGroupWindowElement.sendKeys(enterName);
		return enterName;
	}

	public void selectFloorOptionInEditBedGroupWindow(String selectByText) {
		selectOptionByText(selectFloorOptionInEditBedGroupWindowElement, selectByText);
	}

	public String enterdescriptionInEditBedGroupWindow(String enterdescription) {
		descriptionInEditBedGroupWindowElement.sendKeys(enterdescription);
		return enterdescription;
	}

	public void closeButtonInEditBedGroupWindowClick() {
		closeButtonInEditBedGroupWindowElement.click();
	}

	public void saveButtonInEditBedGroupWindowClick() {
		saveButtonInEditBedGroupWindowElement.click();
	}

}
