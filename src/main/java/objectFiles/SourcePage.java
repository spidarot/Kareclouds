package objectFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class SourcePage extends ObjectParentClass{

	WebDriver driver;
	
	public SourcePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Title Text
	@FindBy(xpath = "//h3[@class='box-title titlefix']")
	WebElement titleTextElement;
	//add Source
	@FindBy(xpath = "//a[@data-target='#myModal']")
	WebElement addSourceElement;
	//close add Source button
	@FindBy(xpath="//div[@id='myModal']//button[@class='close']")
	WebElement closeAddSourceButtonElement;
	//Source in add Source window
	@FindBy(xpath="//div[@id='myModal']//input[@id='description']")
	WebElement sourceInAddSourceWindowElement;
	//description in add Source window
	@FindBy(xpath="//div[@id='myModal']//textarea[@id='description']")
	WebElement descriptionInAddSourceWindowElement;
	//save Button in add Source window
	@FindBy(xpath="//div[@id='myModal']//button[@id='formaddbtn']")
	WebElement saveButtonInAddSourceWindowElement;		
	//edit Source Button List
	@FindBy(xpath="//table[@id='DataTables_Table_0']//a[@data-target='#editmyModal']")
	List<WebElement> editSourceButtonList;		
	//delete Source Button List
	@FindBy(xpath="//table[@id='DataTables_Table_0']//a[contains(@onclick,'delete_recordById')]")
	List<WebElement> deleteSourceButtonList;		
	//close Edit Source Window Button
	@FindBy(xpath="//div[@id='editmyModal']//button[@class='close']")
	WebElement closeEditSourceWindowButtonElement;
	//save Edit Source Window Button
	@FindBy(xpath="//div[@id='editmyModal']//button[@id='editformaddbtn']")
	WebElement saveEditSourceWindowButtonElement;
	//Source in Edit Source window
	@FindBy(xpath="//div[@id='editmyModal']//input[@id='source']")
	WebElement sourceInEditSourceWindowElement;
	//description in Edit Source window
	@FindBy(xpath="//div[@id='editmyModal']//textarea[@id='description1']")
	WebElement descriptionInEditSourceWindowElement;
	// toast Message Element
	@FindBy(xpath = "//body//div[@id='toast-container']//div[@class='toast-message']")
	WebElement toastMessageElement;
		
		
		
	public String titleTextGetText() {
		 waitByElement(titleTextElement);
		 String TitleText = titleTextElement.getText();
		 return TitleText;
	}
	public void addSourceButtonClick() {
		waitByElement(titleTextElement);
		addSourceElement.click();
		waitByElement(closeAddSourceButtonElement);
	}
	public String enterSourceInAddSourceWindow(String enterSource) {
		sourceInAddSourceWindowElement.sendKeys(enterSource);
		return enterSource;
	}
	public String enterDescriptionInAddSourceWindow(String enterDescription) {
		descriptionInAddSourceWindowElement.sendKeys(enterDescription);
		return enterDescription;
	}
	public void saveButtonInAddSourceWindowClick() {
		saveButtonInAddSourceWindowElement.click();
	}
	public void editSourceButtonClick(int ElementNumberToBeSelected) {
		waitByElement(editSourceButtonList.get(0));
		int i = ElementNumberToBeSelected - 1;
		actionScroll(editSourceButtonList.get(i));
		editSourceButtonList.get(i).click();
		waitByElement(closeEditSourceWindowButtonElement);
	}
	public void deleteSourceButtonClick(int ElementNumberToBeSelected) {
		int i = ElementNumberToBeSelected - 1;
		actions(deleteSourceButtonList.get(i));
		deleteSourceButtonList.get(i).click();
	}
	public void closeEditSourceWindowButtonClick() {
		closeEditSourceWindowButtonElement.click();
	}
	public void saveEditSourceWindowButtonClick() {
		saveEditSourceWindowButtonElement.click();
	}
	public String enterSourceInEditSourceWindow(String enterSource) {
		sourceInEditSourceWindowElement.sendKeys(enterSource);
		return enterSource;
	}
	public String enterDescriptionInEditSourceWindow(String enterDescription) {
		descriptionInEditSourceWindowElement.sendKeys(enterDescription);
		return enterDescription;
	}
	public String toastMessageGetText() {
		waitByElement(toastMessageElement);
		String toastMessage = toastMessageElement.getText();
		return toastMessage;
	}
	
}