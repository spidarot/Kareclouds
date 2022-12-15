package objectFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class AppointmentPriorityPage extends ObjectParentClass{

	WebDriver driver;
	
	public AppointmentPriorityPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Title Text
	@FindBy(xpath = "//h3[@class='box-title titlefix']")
	WebElement titleTextElement;
	//add Priority
	@FindBy(xpath = "//a[@data-target='#myModal']")
	WebElement addPriorityElement;
	//close add Priority button
	@FindBy(xpath="//div[@id='myModal']//button[@class='close']")
	WebElement closeAddPriorityButtonElement;
	//Priority in add Priority window
	@FindBy(xpath="//div[@id='myModal']//input[@id='appoint_priority']")
	WebElement PriorityInAddPriorityWindowElement;
	//save Button in add Priority window
	@FindBy(xpath="//div[@id='myModal']//button[@id='formaddbtn']")
	WebElement saveButtonInAddPriorityWindowElement;		
	//edit Priority Button List
	@FindBy(xpath="//table[@id='DataTables_Table_0']//a[@data-target='#editmyModal']")
	List<WebElement> editPriorityButtonList;		
	//delete Priority Button List
	@FindBy(xpath="//table[@id='DataTables_Table_0']//a[contains(@onclick,'delete_recordById')]")
	List<WebElement> deletePriorityButtonList;		
	//close Edit Priority Window Button
	@FindBy(xpath="//div[@id='editmyModal']//button[@class='close']")
	WebElement closeEditPriorityWindowButtonElement;
	//save Edit Priority Window Button
	@FindBy(xpath="//div[@id='editmyModal']//button[@id='editformaddbtn']")
	WebElement saveEditPriorityWindowButtonElement;
	//Priority in Edit Priority window
	@FindBy(xpath="//div[@id='editmyModal']//input[@id='appoint_priority_edit']")
	WebElement PriorityInEditPriorityWindowElement;
	// toast Message Element
	@FindBy(xpath = "//body//div[@id='toast-container']//div[@class='toast-message']")
	WebElement toastMessageElement;
		
		
		
	public String titleTextGetText() {
		 waitByElement(titleTextElement);
		 String TitleText = titleTextElement.getText();
		 return TitleText;
	}
	public void addPriorityButtonClick() {
		waitByElement(titleTextElement);
		addPriorityElement.click();
		waitByElement(closeAddPriorityButtonElement);
	}
	public String enterPriorityInAddPriorityWindow(String enterPriority) {
		PriorityInAddPriorityWindowElement.sendKeys(enterPriority);
		return enterPriority;
	}
	public void saveButtonInAddPriorityWindowClick() {
		saveButtonInAddPriorityWindowElement.click();
	}
	public void editPriorityButtonClick(int ElementNumberToBeSelected) {
		waitByElement(editPriorityButtonList.get(0));
		int i = ElementNumberToBeSelected - 1;
		actionScroll(editPriorityButtonList.get(i));
		editPriorityButtonList.get(i).click();
		waitByElement(closeEditPriorityWindowButtonElement);
	}
	public void deletePriorityButtonClick(int ElementNumberToBeSelected) {
		int i = ElementNumberToBeSelected - 1;
		actions(deletePriorityButtonList.get(i));
		deletePriorityButtonList.get(i).click();
	}
	public void closeEditPriorityWindowButtonClick() {
		closeEditPriorityWindowButtonElement.click();
	}
	public void saveEditPriorityWindowButtonClick() {
		saveEditPriorityWindowButtonElement.click();
	}
	public String enterPriorityInEditPriorityWindow(String enterPriority) {
		PriorityInEditPriorityWindowElement.sendKeys(enterPriority);
		return enterPriority;
	}
	public String toastMessageGetText() {
		waitByElement(toastMessageElement);
		String toastMessage = toastMessageElement.getText();
		return toastMessage;
	}
	
}