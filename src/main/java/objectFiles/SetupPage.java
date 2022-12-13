package objectFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractParentFiles.ObjectParentClass;

public class SetupPage extends ObjectParentClass {

	WebDriver driver;

	public SetupPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="//*[text()='Setup']")
	// WebElement setupElement;

	@FindBy(xpath = "//li[@class='treeview '][18]")
	WebElement setupElement;
	// patient dropdown
	@FindBy(xpath = "//ul[@class='treeview-menu menu-open']//li[1]")
	WebElement patientPageElement;
	//hospital Charges dropdown
	@FindBy(xpath="//a[contains(text(),' Hospital Charges')]")
	WebElement hospitalChargesPageElement;
	//Bed dropdown
	@FindBy(xpath="//a[contains(text(),' Bed')]")
	WebElement bedPageElement;
	//Front Office dropdown
	@FindBy(xpath="//a[contains(text(),' Front Office')]")
	WebElement frontOfficePageElement;
	
	By patientElementBy = By.xpath("//ul[@class='treeview-menu menu-open']//li[1]");

	public void setupClick() {
		actions(setupElement);
		setupElement.click();
	}

	public PatientPage loadPatientPage() {
		actions(patientPageElement);
		waits(patientElementBy);
		patientPageElement.click();
		PatientPage patient = new PatientPage(driver);
		return patient;
	}
	
	public HospitalChargesPage loadHospitalChargesPage() {
		actions(hospitalChargesPageElement);
		waitByElement(hospitalChargesPageElement);
		hospitalChargesPageElement.click();
		HospitalChargesPage hospitalCharges=new HospitalChargesPage(driver);
		return hospitalCharges;
	}
	
	public BedPage loadBedPage() {
		actions(bedPageElement);
		waitByElement(bedPageElement);
		bedPageElement.click();
		BedPage bed=new BedPage(driver);
		return bed;
	}

	public FrontOfficePage loadFrontOfficePage() {
		actions(frontOfficePageElement);
		waitByElement(frontOfficePageElement);
		frontOfficePageElement.click();
		FrontOfficePage frontOffice=new FrontOfficePage(driver);
		return frontOffice;
	}
}
