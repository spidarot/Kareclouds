package objectFiles;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractParentFiles.ObjectParentClass;

public class PatientPage extends ObjectParentClass {

	WebDriver driver;
	List<WebElement> columnElement;
	WebElement SortingButtonElement;

	public PatientPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// add Patient button
	@FindBy(id = "addp")
	WebElement addPatientElement;
	// Name
	@FindBy(xpath = "//input[@id='name']")
	WebElement nameElement;
	// Guardian Name
	@FindBy(xpath = "//div[@class='col-lg-6 col-md-6 col-sm-6'] //input[@name='guardian_name']")
	WebElement guardianNameElement;
	// Gender
	@FindBy(id = "addformgender")
	WebElement genderElement;
	// Date of Birth
	@FindBy(xpath = "//input[@id='birth_date']")
	WebElement dobElement;
	// Age
	@FindBy(xpath = "(//label[text()='Age'])[2]")
	WebElement ageElement;
	// Blood Group
	@FindBy(xpath = "(//select[@name='blood_group'])[2]")
	WebElement bloodGroupElement;
	// Marital Status
	@FindBy(xpath = "(//select[@name='marital_status'])[2]")
	WebElement mStatusElement;
	// Phone Number
	@FindBy(xpath = "//input[@id='number']")
	WebElement phNumberElement;
	// Email id
	@FindBy(xpath = "//input[@id='addformemail']")
	WebElement emailElement;
	// Address
	@FindBy(xpath = "(//input[@name='address'])[2]")
	WebElement addressElement;
	// Remarks
	@FindBy(xpath = "//textarea[@id='note']")
	WebElement remarksElement;
	// Known Allergies
	@FindBy(xpath = "(//textarea[@name='known_allergies'])[2]")
	WebElement allergiesElement;
	// Save button
	@FindBy(id = "formaddpabtn")
	WebElement saveElement;
	//edit save button
	@FindBy(id = "formeditpabtn")
	WebElement editSaveElement;
	// toast Message Element
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessageElement;
	//edit Patient Data Button
	@FindBy(xpath="//i[@class='fa fa-pencil']")
	WebElement editPatientDataButtonElement;
	// search
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchElement;
	// Tabel patient Id
	@FindBy(xpath = "//tr[@role='row']//td[1]")
	WebElement tabelpatientIdElement;
	// Tabel patient Name
	@FindBy(xpath = "//tr[@role='row']//td[2]")
	WebElement tabelPatientNameElement;
	// Tabel patient Age
	@FindBy(xpath = "//tr[@role='row']//td[3]")
	WebElement tabelAgeElement;
	// Tabel patient Gender
	@FindBy(xpath = "//tr[@role='row']//td[4]")
	WebElement tabelGenderElement;
	// Tabel patient Ph number
	@FindBy(xpath = "//tr[@role='row']//td[5]")
	WebElement tabelPhNumberElement;
	// Tabel patient Guardian Name
	@FindBy(xpath = "//tr[@role='row']//td[6]")
	WebElement tabelguardianNameElement;
	// Tabel patient Address
	@FindBy(xpath = "//tr[@role='row']//td[7]")
	WebElement tabelAddressElement;
	// Tabel patient Data Button
	@FindBy(xpath = "(//a[contains(@onclick,'getpatientData')])[1]")
	WebElement patientDataElement;
	// disable Patient button
	@FindBy(xpath = "//a[@data-original-title='Disable']")
	WebElement disablePatientElement;
	// close Patient Data button
	@FindBy(xpath = "//button[@class='close pt4']")
	WebElement closePatientDataElement;
	// show Patient Data Button right side corner
	@FindBy(xpath = "(//a[@title='Show'])[1]")
	WebElement showPatientDataButtonElement;
	//patient ID column element for sorting
	@FindBy(xpath = "//tr[@role='row']//td[1]")
	List<WebElement> patientIDColumnElement;
	//patient Name column element for sorting
	@FindBy(xpath = "//tr[@role='row']//td[2]")
	List<WebElement> patientNameColumnElement;
	//age column element for sorting
	@FindBy(xpath = "//tr[@role='row']//td[3]")
	List<WebElement> ageColumnElement;
	//gender column element for sorting
	@FindBy(xpath = "//tr[@role='row']//td[4]")
	List<WebElement> genderColumnElement;
	//phone column element for sorting
	@FindBy(xpath = "//tr[@role='row']//td[5]")
	List<WebElement> phoneColumnElement;
	//guardian Name column element for sorting
	@FindBy(xpath = "//tr[@role='row']//td[6]")
	List<WebElement> guardianNameColumnElement;
	//address column element for sorting
	@FindBy(xpath = "//tr[@role='row']//td[7]")
	List<WebElement> addressColumnElement;
	// patientID Sorting button
	@FindBy(xpath = "//th[contains(@aria-label,'Patient Id')]")
	WebElement patientIDSortingButtonElement;
	// Patient Name Sorting button
	@FindBy(xpath = "//th[contains(@aria-label,'Patient Name')]")
	WebElement patientNameSortingButtonElement;
	// Age Sorting button
	@FindBy(xpath = "//th[contains(@aria-label,'Age')]")
	WebElement ageSortingButtonElement;
	// Gender Sorting button
	@FindBy(xpath = "//th[contains(@aria-label,'Gender')]")
	WebElement genderSortingButtonElement;
	// Phone Sorting button
	@FindBy(xpath = "//th[contains(@aria-label,'Phone')]")
	WebElement phoneSortingButtonElement;
	// Guardian Name Sorting button
	@FindBy(xpath = "//th[contains(@aria-label,'Guardian Name')]")
	WebElement guardianNameSortingButtonElement;
	// Address Sorting button
	@FindBy(xpath = "//th[contains(@aria-label,'Address')]")
	WebElement addressSortingButtonElement;
	//Patient Page numbers 
	@FindBy(xpath="//div[@id='DataTables_Table_0_paginate']//span//a")
	List<WebElement> patientPageNumbersElement;
	//next Page Button
	@FindBy(css="a#DataTables_Table_0_next")
	WebElement nextPageButtonElement;
	//disabled Next Page Button
	@FindBy(xpath="//a[@class='paginate_button next disabled']")
	WebElement disabledNextPageButtonElement;
	//current Page Button
	@FindBy(xpath="//a[@class='paginate_button current']")
	WebElement currentPageButtonElement;
	//Disabled Patient List Button
	@FindBy(xpath="//a[text()=' Disabled Patient List']")
	WebElement disabledPatientListButtonElement;
	
	
	By addPatientElementBy = By.id("addp");
	By nameElementBy = By.id("name");
	By toastMessageElementBY = By.xpath("//div[@class='toast-message']");
	By disablePatientElementBy = By.xpath("//a[@data-original-title='Disable']");
	By closePatientDataElementBy = By.xpath("//button[@class='close pt4']");

	public String getCurrentUrl() {
		String CurrentUrl = driver.getCurrentUrl();
		return CurrentUrl;
	}

	public void clickAddPatient() throws IOException {
		waits(addPatientElementBy);
		addPatientElement.click();
		screenshot("AddPatient");
	}

	public void enterPatientName(String PatientName) {
		waits(nameElementBy);
		nameElement.sendKeys(PatientName);
	}

	public void enterGuardianName(String guardianName) {
		guardianNameElement.sendKeys(guardianName);
	}

	public void selectGender(String Patientgender) {
		selectOption(genderElement, Patientgender);
	}

	public void enterDob(String Patientdob) {
		dobElement.sendKeys(Patientdob);
		ageElement.click();
	}

	public void selectBloodGroup(String PatientbloodGroup) {
		selectOption(bloodGroupElement, PatientbloodGroup);
	}

	public void selectMStatus(String PatientmStatus) {
		selectOption(mStatusElement, PatientmStatus);
	}

	public void enterPatientphNumber(String PatientphNumber) {
		phNumberElement.sendKeys(PatientphNumber);
	}

	public void enterPatientemail(String Patientemail) {
		emailElement.sendKeys(Patientemail);
	}

	public void enterPatientaddress(String Patientaddress) {
		addressElement.sendKeys(Patientaddress);
	}

	public void enterRemarks(String remarks) {
		remarksElement.sendKeys(remarks);
	}

	public void enterAllergies(String allergies) {
		allergiesElement.sendKeys(allergies);
	}

	public void savePatientData() throws IOException {
		screenshot("Add Patient window");
		saveElement.click();
		waits(toastMessageElementBY);
		System.out.println(toastMessageElement.getText());
	}

	public String toastMessageGetText() {
		waits(toastMessageElementBY);
		String toastMessage = toastMessageElement.getText();
		return toastMessage;
	}

	public void searchBy(String searchBy) throws InterruptedException {
		searchElement.sendKeys(searchBy);
		Thread.sleep(3000);
	}

	public String searchGetTexts(String searchByElement) {

		String searchGetText = null;
		if (searchByElement.equalsIgnoreCase("PatientId")) {
			searchGetText = tabelpatientIdElement.getText();
			return searchGetText;
		} else if (searchByElement.equalsIgnoreCase("PatientName")) {
			searchGetText = tabelPatientNameElement.getText();
			return searchGetText;
		} else if (searchByElement.equalsIgnoreCase("PatientAge")) {
			searchGetText = tabelAgeElement.getText();
			return searchGetText;
		} else if (searchByElement.equalsIgnoreCase("Patientgender")) {
			searchGetText = tabelGenderElement.getText();
			return searchGetText;
		} else if (searchByElement.equalsIgnoreCase("PatientphNumber")) {
			searchGetText = tabelPhNumberElement.getText();
			return searchGetText;
		} else if (searchByElement.equalsIgnoreCase("guardianName")) {
			searchGetText = tabelguardianNameElement.getText();
			return searchGetText;
		} else if (searchByElement.equalsIgnoreCase("Patientaddress")) {
			searchGetText = tabelAddressElement.getText();
			return searchGetText;
		}
		return searchGetText;
	}

	public void showPatientDataWindow() throws IOException {
		// String FileName = "show Patient Data Button working";
		showPatientDataButtonElement.click();
		waits(disablePatientElementBy);
		screenshot("show Patient Data Button working");
	}
	public void editPatientDataButtonClick() throws IOException {
		waitByElement(editPatientDataButtonElement);
		editPatientDataButtonElement.click();
		waitByElement(editSaveElement);
		screenshot("Edit Patient Data Window");
	}
	public void closePatientDataButonClick() {
		closePatientDataElement.click();
	}

	public void tablePatientButtonclick() throws IOException {
		patientDataElement.click();
		waits(disablePatientElementBy);
		screenshot("Table Patient Data Button working");
	}

	public void disablePatientButtonClick() {
		disablePatientElement.click();
	}

	public void alertHandlingPositive() {
		driver.switchTo().alert().accept();
		waits(toastMessageElementBY);
	}

	public void alertHandlingNegative() {
		driver.switchTo().alert().dismiss();
	}

	
	//Patient Tabel Sorting in ascending & descending order
	
	//First Tabel Entry Text
	public String firstTabelEntryGetText(String sortBy) {
		if(sortBy.equalsIgnoreCase("patient ID"))
		{columnElement= patientIDColumnElement;}
		else if(sortBy.equalsIgnoreCase("patient Name"))
		{columnElement= patientNameColumnElement;}
		else if(sortBy.equalsIgnoreCase("age"))
		{columnElement= ageColumnElement;}
		else if(sortBy.equalsIgnoreCase("gender"))
		{columnElement= genderColumnElement;}
		else if(sortBy.equalsIgnoreCase("phone"))
		{columnElement= phoneColumnElement;}
		else if(sortBy.equalsIgnoreCase("guardian name"))
		{columnElement= guardianNameColumnElement;}
		else if(sortBy.equalsIgnoreCase("address"))
		{columnElement= addressColumnElement;}
		String FirstTabelEntry=columnElement.get(0).getText();
		System.out.println(FirstTabelEntry);
		return FirstTabelEntry;
	}
	
	//Last Tabel Entry Text
	public String lastTabelEntryGetText(String sortBy) {
		String LastTabelEntry;
		if(sortBy.equalsIgnoreCase("patient ID")) 
		{columnElement= patientIDColumnElement;}
		else if(sortBy.equalsIgnoreCase("patient Name"))
		{columnElement= patientNameColumnElement;}
		else if(sortBy.equalsIgnoreCase("age"))
		{columnElement= ageColumnElement;}
		else if(sortBy.equalsIgnoreCase("gender"))
		{columnElement= genderColumnElement;}
		else if(sortBy.equalsIgnoreCase("phone"))
		{columnElement= phoneColumnElement;}
		else if(sortBy.equalsIgnoreCase("guardian name"))
		{columnElement= guardianNameColumnElement;}
		else if(sortBy.equalsIgnoreCase("address"))
		{columnElement= addressColumnElement;}
		if(patientPageNumbersElement.size()>1) {
			for (int i=1;i<patientPageNumbersElement.size();i++) {
				waitByElement(nextPageButtonElement);
				actions(nextPageButtonElement);
				nextPageButtonElement.click();
				}
				waitByElement(disabledNextPageButtonElement);
			}
			else{
				LastTabelEntry=columnElement.get(columnElement.size()-1).getText();
				System.out.println(LastTabelEntry);
				}
				System.out.println(columnElement.size());
				LastTabelEntry=columnElement.get(columnElement.size()-1).getText();
				System.out.println(LastTabelEntry);
				return LastTabelEntry;
	}
	
	//Sorting Button Click
	public void SortingButtonElementClick(String sortBy) throws InterruptedException {
		if(sortBy.equalsIgnoreCase("patient ID"))
		{SortingButtonElement= patientIDSortingButtonElement;}
		else if(sortBy.equalsIgnoreCase("patient Name"))
		{SortingButtonElement= patientNameSortingButtonElement;}
		else if(sortBy.equalsIgnoreCase("age"))
		{SortingButtonElement= ageSortingButtonElement;}
		else if(sortBy.equalsIgnoreCase("gender"))
		{SortingButtonElement= genderSortingButtonElement;}
		else if(sortBy.equalsIgnoreCase("phone"))
		{SortingButtonElement= phoneSortingButtonElement;}
		else if(sortBy.equalsIgnoreCase("guardian name"))
		{SortingButtonElement= guardianNameSortingButtonElement;}
		else if(sortBy.equalsIgnoreCase("address"))
		{SortingButtonElement= addressSortingButtonElement;}
	actions(SortingButtonElement);
	SortingButtonElement.click();
	Thread.sleep(3000);
	}
	
	//Get Sorting Order
	public String getSortingOrder(String sortBy) {
		if(sortBy.equalsIgnoreCase("patient ID"))
		{SortingButtonElement= patientIDSortingButtonElement;}
		else if(sortBy.equalsIgnoreCase("patient Name"))
		{SortingButtonElement= patientNameSortingButtonElement;}
		else if(sortBy.equalsIgnoreCase("age"))
		{SortingButtonElement= ageSortingButtonElement;}
		else if(sortBy.equalsIgnoreCase("gender"))
		{SortingButtonElement= genderSortingButtonElement;}
		else if(sortBy.equalsIgnoreCase("phone"))
		{SortingButtonElement= phoneSortingButtonElement;}
		else if(sortBy.equalsIgnoreCase("guardian name"))
		{SortingButtonElement= guardianNameSortingButtonElement;}
		else if(sortBy.equalsIgnoreCase("address"))
		{SortingButtonElement= addressSortingButtonElement;}
	String sortingOrder=SortingButtonElement.getAttribute("aria-sort");
	System.out.println(sortingOrder);
	return sortingOrder;
	}
	
	public DisabledPatientPage disabledPatientListButtonClick() {
		disabledPatientListButtonElement.click();
		DisabledPatientPage disabledPatient=new DisabledPatientPage(driver);
		return disabledPatient;
	}

}

