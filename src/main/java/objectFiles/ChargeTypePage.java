package objectFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class ChargeTypePage extends ObjectParentClass {

	WebDriver driver;
	
	public ChargeTypePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Title Text
	@FindBy(xpath="//h3[@class='box-title titlefix']")
	WebElement titleTextElement;
	//add Charge Type Button
	@FindBy(xpath="//a[contains(text(),' Add Charge Type')]")
	WebElement addChargeTypeButtonElement;
	//Charge Type Element
	@FindBy(xpath="//input[@id='type']")
	WebElement chargeTypeElement;
	//save add Charge Type Button
	@FindBy(xpath="//button[@id='formaddbtn']")
	WebElement saveAddChargeTypeButtonElement;
	//close add Charge Type Button
	@FindBy(xpath="//div[@id='myModal']//button[@class='close']")
	WebElement closeAddChargeTypeButtonElement;
	// toast Message Element
	@FindBy(xpath = "//body//div[@id='toast-container']//div[@class='toast-message']")
	WebElement toastMessageElement;
	//delete Charge Type Button
	@FindBy(xpath="//a[contains(@onclick,'deleteChargeType')]")
	List<WebElement> deleteChargeTypeButtonList;
	
	
	public String titleTextGetText() {
		waitByElement(titleTextElement);
		String TitleText=titleTextElement.getText();
		return TitleText;
	}
	public void addChargeTypeButtonClick() {
		waitByElement(addChargeTypeButtonElement);
		addChargeTypeButtonElement.click();
		waitByElement(closeAddChargeTypeButtonElement);
	}
	public void enterChargeType(String enterChargeType) {
		chargeTypeElement.sendKeys(enterChargeType);
	}
	public void saveAddChargeTypeButtonClick() {
		saveAddChargeTypeButtonElement.click();
	}
	public String toastMessageGetText() {
		waitByElement(toastMessageElement);
		String toastMessage = toastMessageElement.getText();
		return toastMessage;
	}
	public void deleteChargeTypeButtonClick(int ElementNumberToBeSelected) {
		waitByElement(deleteChargeTypeButtonList.get(0));
		int i=ElementNumberToBeSelected-1;
		actions(deleteChargeTypeButtonList.get(i));
		deleteChargeTypeButtonList.get(i).click();
	}
}
