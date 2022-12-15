package objectFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class ComplainTypePage extends ObjectParentClass {

	WebDriver driver;
	public ComplainTypePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Title Text
	@FindBy(xpath = "//h3[@class='box-title titlefix']")
	WebElement titleTextElement;
	//add Complain Type
	@FindBy(xpath = "//a[@data-target='#myModal']")
	WebElement addComplainTypeElement;
	//close add Complain Type button
	@FindBy(xpath="//div[@id='myModal']//button[@class='close']")
	WebElement closeAddComplainTypeButtonElement;
	//complain Type in add Complain Type window
	@FindBy(xpath="//div[@id='myModal']//input[@id='description']")
	WebElement complainTypeInAddComplainTypeWindowElement;
	//description in add Complain Type window
	@FindBy(xpath="//div[@id='myModal']//textarea[@id='description']")
	WebElement descriptionInAddComplainTypeWindowElement;
	//save Button in add Complain Type window
	@FindBy(xpath="//div[@id='myModal']//button[@id='formaddbtn']")
	WebElement saveButtonInAddComplainTypeWindowElement;		
	//edit Complain Type Button List
	@FindBy(xpath="//table[@id='DataTables_Table_0']//a[@data-target='#editmyModal']")
	List<WebElement> editComplainTypeButtonList;		
	//delete ComplainType Button List
	@FindBy(xpath="//table[@id='DataTables_Table_0']//a[contains(@onclick,'delete_recordById')]")
	List<WebElement> deleteComplainTypeButtonList;		
	//close Edit Complain Type Window Button
	@FindBy(xpath="//div[@id='editmyModal']//button[@class='close']")
	WebElement closeEditComplainTypeWindowButtonElement;
	//save Edit ComplainType Window Button
	@FindBy(xpath="//div[@id='editmyModal']//button[@id='editformaddbtn']")
	WebElement saveEditComplainTypeWindowButtonElement;
	//ComplainType in Edit ComplainType window
	@FindBy(xpath="//div[@id='editmyModal']//input[@id='complaint_type']")
	WebElement complainTypeInEditComplainTypeWindowElement;
	//description in Edit ComplainType window
	@FindBy(xpath="//div[@id='editmyModal']//textarea[@id='description1']")
	WebElement descriptionInEditComplainTypeWindowElement;
	// toast Message Element
	@FindBy(xpath = "//body//div[@id='toast-container']//div[@class='toast-message']")
	WebElement toastMessageElement;
		
		
		
	public String titleTextGetText() {
		 waitByElement(titleTextElement);
		 String TitleText = titleTextElement.getText();
		 return TitleText;
		}
		public void addComplainTypeButtonClick() {
			waitByElement(titleTextElement);
			addComplainTypeElement.click();
			waitByElement(closeAddComplainTypeButtonElement);
		}
		public String enterComplainTypeInAddComplainTypeWindow(String enterComplainType) {
			complainTypeInAddComplainTypeWindowElement.sendKeys(enterComplainType);
			return enterComplainType;
		}
		public String enterDescriptionInAddComplainTypeWindow(String enterDescription) {
			descriptionInAddComplainTypeWindowElement.sendKeys(enterDescription);
			return enterDescription;
		}
		public void saveButtonInAddComplainTypeWindowClick() {
			saveButtonInAddComplainTypeWindowElement.click();
		}
		public void editComplainTypeButtonClick(int ElementNumberToBeSelected) {
			waitByElement(editComplainTypeButtonList.get(0));
			int i = ElementNumberToBeSelected - 1;
			actionScroll(editComplainTypeButtonList.get(i));
			editComplainTypeButtonList.get(i).click();
			waitByElement(closeEditComplainTypeWindowButtonElement);
		}
		public void deleteComplainTypeButtonClick(int ElementNumberToBeSelected) {
			int i = ElementNumberToBeSelected - 1;
			actions(deleteComplainTypeButtonList.get(i));
			deleteComplainTypeButtonList.get(i).click();
		}
		public void closeEditComplainTypeWindowButtonClick() {
			closeEditComplainTypeWindowButtonElement.click();
		}
		public void saveEditComplainTypeWindowButtonClick() {
			saveEditComplainTypeWindowButtonElement.click();
		}
		public String enterComplainTypeInEditComplainTypeWindow(String enterComplainType) {
			complainTypeInEditComplainTypeWindowElement.sendKeys(enterComplainType);
			return enterComplainType;
		}
		public String enterDescriptionInEditComplainTypeWindow(String enterDescription) {
			descriptionInEditComplainTypeWindowElement.sendKeys(enterDescription);
			return enterDescription;
		}
		public String toastMessageGetText() {
			waitByElement(toastMessageElement);
			String toastMessage = toastMessageElement.getText();
			return toastMessage;
		}
		
}
