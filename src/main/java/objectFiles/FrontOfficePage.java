package objectFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class FrontOfficePage extends ObjectParentClass {

	WebDriver driver;

	public FrontOfficePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Title Text
	@FindBy(xpath = "//h3[@class='box-title titlefix']")
	WebElement titleTextElement;
	// Add purpose
	//@FindBy(xpath = "//a[contains(text(),'  Add Purpose')]")
	@FindBy(xpath="//a[@data-target='#myModal']")
	WebElement addPurposeButtonElement;
	//close add Purpose button
	@FindBy(xpath="//div[@id='myModal']//button[@class='close']")
	WebElement closeAddPurposeButtonElement;
	//purpose in add Purpose window
	@FindBy(xpath="//div[@id='myModal']//input[@id='description']")
	WebElement purposeInAddPurposeWindowElement;
	//description in add Purpose window
	@FindBy(xpath="//div[@id='myModal']//textarea[@id='description']")
	WebElement descriptionInAddPurposeWindowElement;
	//save Button in add Purpose window
	@FindBy(xpath="//div[@id='myModal']//button[@id='formaddbtn']")
	WebElement saveButtonInAddPurposeWindowElement;
	//edit Purpose Button List
	@FindBy(xpath="//table[@id='DataTables_Table_0']//a[@data-target='#editmyModal']")
	List<WebElement> editPurposeButtonList;
	//delete Purpose Button List
	@FindBy(xpath="//table[@id='DataTables_Table_0']//a[contains(@onclick,'delete_recordById')]")
	List<WebElement> deletePurposeButtonList;
	//close Edit Purpose Window Button
	@FindBy(xpath="//div[@id='editmyModal']//button[@class='close']")
	WebElement closeEditPurposeWindowButtonElement;
	//save Edit Purpose Window Button
	@FindBy(xpath="//div[@id='editmyModal']//button[@id='editformaddbtn']")
	WebElement saveEditPurposeWindowButtonElement;
	//purpose in Edit Purpose window
	@FindBy(xpath="//div[@id='editmyModal']//input[@id='visitors_purpose']")
	WebElement purposeInEditPurposeWindowElement;
	//description in Edit Purpose window
	@FindBy(xpath="//div[@id='editmyModal']//textarea[@id='description1']")
	WebElement descriptionInEditPurposeWindowElement;
	// toast Message Element
	@FindBy(xpath = "//body//div[@id='toast-container']//div[@class='toast-message']")
	WebElement toastMessageElement;
	//Complain Type page link
	@FindBy(xpath="//ul[@class='tablists']//a[contains(text(),'Complain Type')]")
	WebElement complainTypePageLinkElement;
	//source Page Link
	@FindBy(xpath="//ul[@class='tablists']//a[contains(text(),'Source')]")
	WebElement sourcePageLinkElement;
	//appointment Priority Page Link
	@FindBy(xpath="//ul[@class='tablists']//a[contains(text(),'Appointment Priority')]")
	WebElement appointmentPriorityPageLinkElement;
	
	
	
	public String titleTextGetText() {
	 waitByElement(titleTextElement);
	 String TitleText = titleTextElement.getText();
	 return TitleText;
	}
	public void addPurposeButtonClick() {
		waitByElement(titleTextElement);
		addPurposeButtonElement.click();
		waitByElement(closeAddPurposeButtonElement);
	}
	public String enterPurposeInAddPurposeWindow(String enterPurpose) {
		purposeInAddPurposeWindowElement.sendKeys(enterPurpose);
		return enterPurpose;
	}
	public String enterDescriptionInAddPurposeWindow(String enterDescription) {
		descriptionInAddPurposeWindowElement.sendKeys(enterDescription);
		return enterDescription;
	}
	public void saveButtonInAddPurposeWindowClick() {
		saveButtonInAddPurposeWindowElement.click();
	}
	public void editPurposeButtonClick(int ElementNumberToBeSelected) {
		int i = ElementNumberToBeSelected - 1;
		actions(editPurposeButtonList.get(i));
		editPurposeButtonList.get(i).click();
		waitByElement(closeEditPurposeWindowButtonElement);
	}
	public void deletePurposeButtonClick(int ElementNumberToBeSelected) {
		int i = ElementNumberToBeSelected - 1;
		actions(deletePurposeButtonList.get(i));
		deletePurposeButtonList.get(i).click();
	}
	public void closeEditPurposeWindowButtonClick() {
		closeEditPurposeWindowButtonElement.click();
	}
	public void saveEditPurposeWindowButtonClick() {
		saveEditPurposeWindowButtonElement.click();
	}
	public String enterPurposeInEditPurposeWindow(String enterPurpose) {
		purposeInEditPurposeWindowElement.sendKeys(enterPurpose);
		return enterPurpose;
	}
	public String enterDescriptionInEditPurposeWindow(String enterDescription) {
		descriptionInEditPurposeWindowElement.sendKeys(enterDescription);
		return enterDescription;
	}
	public String toastMessageGetText() {
		waitByElement(toastMessageElement);
		String toastMessage = toastMessageElement.getText();
		return toastMessage;
	}
	
	public ComplainTypePage loadComplainTypePage() {
		waitByElement(titleTextElement);
		complainTypePageLinkElement.click();
		ComplainTypePage complainType=new ComplainTypePage(driver);
		return complainType;
	}
	public SourcePage loadSourcePage() {
		waitByElement(titleTextElement);
		sourcePageLinkElement.click();
		SourcePage source=new SourcePage(driver);
		return source;
	}
	public AppointmentPriorityPage loadAppointmentPriorityPage() {
		waitByElement(titleTextElement);
		appointmentPriorityPageLinkElement.click();
		AppointmentPriorityPage appointmentPriority=new AppointmentPriorityPage(driver);
		return appointmentPriority;
	}
	
	
}
