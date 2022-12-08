package objectFiles;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractParentFiles.ObjectParentClass;

public class LoginPage extends ObjectParentClass {

	public WebDriver driver;

	public LoginPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement Username=driver.findElement(By.xpath(null));
	@FindBy(css = "input#email")
	WebElement UsernameElement;

	@FindBy(css = "input#password")
	WebElement PasswordElement;

	@FindBy(xpath = "//button[@class='btn']")
	WebElement Submit;

	public void goTo(String Url) throws InterruptedException, IOException {
		driver.get(Url);
	}

	public SetupPage loginApplicatio(String Username, String Password) {
		UsernameElement.sendKeys(Username);
		PasswordElement.sendKeys(Password);
		Submit.click();

		SetupPage setup = new SetupPage(driver);
		return setup;
	}

}
