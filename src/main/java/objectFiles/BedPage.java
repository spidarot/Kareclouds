package objectFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class BedPage extends ObjectParentClass {

	WebDriver driver;
	
	public BedPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Title Text
	@FindBy(xpath="//h3[@class='box-title titlefix']")
	WebElement titleTextElement;	
	//Bed List Page Link
	@FindBy(xpath="//div[@class='col-md-2'] //li//a[text()='Bed']")
	WebElement bedListPageLinkElement;
	//Bed Type Page Link
	@FindBy(xpath="//div[@class='col-md-2'] //li//a[text()='Bed Type']")
	WebElement bedTypePageLinkElement;
	//Bed Group Page Link
	@FindBy(xpath="//div[@class='col-md-2'] //li//a[text()='Bed Group']")
	WebElement bedGroupPageLinkElement;
	//Floor Page Link
	@FindBy(xpath="//div[@class='col-md-2'] //li//a[text()='Floor']")
	WebElement floorPageLinkElement;
	
	public String titleTextGetText() {
		waitByElement(titleTextElement);
	String TitleText=titleTextElement.getText();
		return TitleText;
	}
	
	public BedListPage loadbedListPage() {
		waitByElement(titleTextElement);
		bedListPageLinkElement.click();
		BedListPage bedList=new BedListPage(driver);
		return bedList;
	}
	public BedTypePage loadbedTypePage() {
		waitByElement(titleTextElement);
		bedTypePageLinkElement.click();
		BedTypePage bedType=new BedTypePage(driver);
		return bedType;
	}
	public BedGroupPage loadbedGroupPage() {
		waitByElement(titleTextElement);
		bedGroupPageLinkElement.click();
		BedGroupPage bedGroup=new BedGroupPage(driver);
		return bedGroup;
	}
	public FloorPage loadFloorPage() {
		waitByElement(titleTextElement);
		floorPageLinkElement.click();
		FloorPage floor=new FloorPage(driver);
		return floor;
	}
}
