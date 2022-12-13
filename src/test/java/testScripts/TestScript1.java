package testScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.print.attribute.standard.Chromaticity;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import objectFiles.ChargeCategoryPage;
import objectFiles.ChargeTypePage;
import objectFiles.DisabledPatientPage;
import objectFiles.DoctorOPDChargePage;
import objectFiles.HospitalChargesPage;
import objectFiles.LoginPage;
import objectFiles.PatientPage;
import objectFiles.SetupPage;
import testFiles.TestBaseFile;

public class TestScript1 extends TestBaseFile {

		
	public TestScript1() throws IOException, InterruptedException {
//		prop = new Properties();
//		FileInputStream fis = new FileInputStream("D:\\eclipse-workspace\\KareCloudsSprint2\\src\\main\\java\\resources\\config.properties");
////		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Config.properties");
//		prop.load(fis);
		super();
		
	}
@Test
public void loginAndPatientPageTest() throws IOException, InterruptedException {
	
	SetupPage setup =login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
	setup.setupClick();
	PatientPage patient=setup.loadPatientPage();
	String CurrentUrl=patient.getCurrentUrl();
	Assert.assertEquals(CurrentUrl, prop.getProperty("patientPagetUrl"),"Url Mismatch" );
	
	//AddPatient
	patient.clickAddPatient();
	patient.enterPatientName(prop.getProperty("PatientName"));
	patient.enterGuardianName(prop.getProperty("guardianName"));
	patient.selectGender(prop.getProperty("Patientgender"));
	patient.enterDob(prop.getProperty("Patientdob"));
	patient.selectBloodGroup(prop.getProperty("PatientbloodGroup"));
	patient.selectMStatus(prop.getProperty("PatientmStatus"));
	patient.enterPatientphNumber(prop.getProperty("PatientphNumber"));
	patient.enterPatientemail(prop.getProperty("Patientemail"));
	patient.enterPatientaddress(prop.getProperty("Patientaddress"));
	patient.enterRemarks(prop.getProperty("remarks"));
	patient.enterAllergies(prop.getProperty("allergies"));
	patient.savePatientData();
	String toastMessage=patient.toastMessageGetText();
	Assert.assertEquals(toastMessage, "Record Saved Successfully");
	System.out.println(toastMessage);
	
	//SearchFunction
	patient.searchBy(prop.getProperty("Patientaddress"));
	System.out.println(prop.getProperty("Patientaddress"));
	Thread.sleep(3000);
	
	Assert.assertEquals(patient.searchGetTexts("PatientName"), prop.getProperty("PatientName"));
	System.out.println(patient.searchGetTexts("PatientName"));
	Assert.assertEquals(patient.searchGetTexts("PatientAge"), prop.getProperty("PatientAge"));
	System.out.println(patient.searchGetTexts("PatientAge"));
	Assert.assertEquals(patient.searchGetTexts("Patientgender"), prop.getProperty("Patientgender"));
	System.out.println(patient.searchGetTexts("Patientgender"));
	Assert.assertEquals(patient.searchGetTexts("PatientphNumber"), prop.getProperty("PatientphNumber"));
	System.out.println(patient.searchGetTexts("PatientphNumber"));
	Assert.assertEquals(patient.searchGetTexts("guardianName"), prop.getProperty("guardianName"));
	System.out.println(patient.searchGetTexts("guardianName"));
	Assert.assertEquals(patient.searchGetTexts("Patientaddress"), prop.getProperty("Patientaddress"));
	System.out.println(patient.searchGetTexts("Patientaddress"));
	System.out.println("Search working perfectly");

//showPatientData Window
    patient.showPatientDataWindow();
	System.out.println("Show Patient Data Button is working perfectly");
	patient.closePatientDataButonClick();
	//disable Patient
	patient.tablePatientButtonclick();
	patient.disablePatientButtonClick();
	patient.alertHandlingPositive();
	Assert.assertEquals(patient.toastMessageGetText(), "Record Disable");
	System.out.println(patient.toastMessageGetText());
	patient.closePatientDataButonClick();
	
	
}

@Test
public void sorting() throws InterruptedException {
	SetupPage setup =login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
	setup.setupClick();
	PatientPage patient=setup.loadPatientPage();
	String sortBy=prop.getProperty("sortBy");
	patient.SortingButtonElementClick(sortBy);
	patient.getSortingOrder(sortBy);
	String FirstTabelEntry=patient.firstTabelEntryGetText(sortBy);
	String LastTabelEntry=patient.lastTabelEntryGetText(sortBy);
	patient.SortingButtonElementClick(sortBy);
	patient.getSortingOrder(sortBy);
	String NewFirstTabelEntry=patient.firstTabelEntryGetText(sortBy);
	String NewLastTabelEntry=patient.lastTabelEntryGetText(sortBy);
	Assert.assertEquals(FirstTabelEntry, NewLastTabelEntry);
	Assert.assertEquals(LastTabelEntry, NewFirstTabelEntry);
	System.out.println("sorting working");
}
@Test
public void editPatientData() throws IOException {
	SetupPage setup =login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
	setup.setupClick();
	PatientPage patient=setup.loadPatientPage();
	patient.showPatientDataWindow();
	patient.editPatientDataButtonClick();
	
}

@Test
public void deletPatientData() throws IOException, InterruptedException {
	SetupPage setup =login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
	setup.setupClick();
	PatientPage patient=setup.loadPatientPage();
	DisabledPatientPage disabledPatient=patient.disabledPatientListButtonClick();
	disabledPatient.screenshot("deletPatientData1");
	disabledPatient.patientDataElementClick();
	disabledPatient.deletePatientData();
	disabledPatient.alertHandlingPositive();
	Thread.sleep(200);
	disabledPatient.screenshot("deletPatientData2");
	
	//enable Patient data
	disabledPatient.patientDataElementClick();
	disabledPatient.enablePatientDataButtonClick();
	disabledPatient.alertHandlingPositive();
	Assert.assertEquals(disabledPatient.toastMessageGetText(), "Record Active");
	System.out.println(disabledPatient.toastMessageGetText());
	disabledPatient.closePatientDataButtonclick();
	disabledPatient.screenshot("enablePatientData2");
	
	//patient List Button working
	disabledPatient.patientListButtonClick();
}

//Hospital Charges add charge
@Test
public void hospitalChargesaddcharge() throws IOException, InterruptedException {
	SetupPage setup =login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
	setup.setupClick();
	HospitalChargesPage hospitalCharges=setup.loadHospitalChargesPage();
	hospitalCharges.addChargeButtonClick();
	hospitalCharges.selectChargeTypeOption("Investigations");
	//hospitalCharges.selectChargeCategoryOption("Select");
	hospitalCharges.enterCode("1011");
	hospitalCharges.enterStandardChargeAmount("200");
	hospitalCharges.applyAllButtonClick();
	hospitalCharges.enterDescription("pay me");
	hospitalCharges.saveButtonClick("hospitalChargesaddcharge");
	Assert.assertEquals(hospitalCharges.toastMessageGetText(), "The Charge Category field is required.");
	System.out.println(hospitalCharges.toastMessageGetText());
	hospitalCharges.closeAddChargeButtonClick();
	hospitalCharges.showChargeDetailswindowButtonclick(1);
	Thread.sleep(2000);
	hospitalCharges.screenshot("Charge Details window");
	hospitalCharges.closeChargeDetailsWindowButtonclick();
	Thread.sleep(2000);
	hospitalCharges.editChargeDetailsWindowButtonclick(8);
	hospitalCharges.screenshot("Edit Charge Details Window");
	hospitalCharges.saveEditChargeDetailsWindowButtonclick();
	hospitalCharges.closeEditChargeDetailsWindowButtonclick();
	Thread.sleep(2000);
	hospitalCharges.deleteChargeDetailsButtonclick(1);
	hospitalCharges.alertHandlingNegative();
	
}
//Charge Category
@Test
public void ChargeCategory() throws IOException, InterruptedException {
	SetupPage setup =login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
	setup.setupClick();
	HospitalChargesPage hospitalCharges=setup.loadHospitalChargesPage();
	ChargeCategoryPage chargeCategory=hospitalCharges.loadChargeCategoryPage();
	chargeCategory.addChargeCategoryButtonClick();
	chargeCategory.enterNameInAddChargeCategory("chargeName");
	chargeCategory.enterDescriptionInAddChargeCategory("charge discription");
	chargeCategory.selectChargeTypeInAddChargeCategory("Supplier");
	chargeCategory.saveAddChargeCategoryButtonClick();
	Thread.sleep(2000);
	chargeCategory.editChargeCategoryButtonClick(33);
	chargeCategory.screenshot("Edit Charge Category");
	chargeCategory.saveEditChargeCategoryButtonClick();
	System.out.println("saved Edit Charge Category");
	Thread.sleep(2000);
	chargeCategory.deleteChargeCategoryButtonClick(33);
	chargeCategory.alertHandlingPositive();
	System.out.println("deleted Charge Category successfully");

}
//Doctor OPD Charges
@Test
public void doctorOPDChargeTest() throws InterruptedException, IOException {
	SetupPage setup =login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
	setup.setupClick();
	HospitalChargesPage hospitalCharges=setup.loadHospitalChargesPage();
	DoctorOPDChargePage doctorOPDCharge=hospitalCharges.loadDoctorOPDChargePage();
	doctorOPDCharge.addChargeButtonClick();
	doctorOPDCharge.showDoctorOption();
	doctorOPDCharge.selectDoctorOption("Aditya");
	doctorOPDCharge.enterStandardCharges("122");
	doctorOPDCharge.applyToAllButtonClick();
	doctorOPDCharge.screenshot("Add Charge");
	doctorOPDCharge.saveButtonClick();
	Assert.assertEquals(hospitalCharges.toastMessageGetText(), "Record already exists");
	System.out.println(doctorOPDCharge.toastMessageGetText());
	Thread.sleep(3000);
	doctorOPDCharge.closeAddChargeButtonClick();
	Thread.sleep(3000);
	//view charge details
	doctorOPDCharge.viewChargeDetailsButtonClick(3);
	doctorOPDCharge.screenshot("View Charge Details");
	doctorOPDCharge.closeViewChargeDetailsButtonClick();
	Thread.sleep(3000);
	//edit charge details
	doctorOPDCharge.editChargeDetailsButtonClick(3);
	doctorOPDCharge.screenshot("Edit Charge Details");
	doctorOPDCharge.saveEditButtonClick();
	//doctorOPDCharge.deleteChargeDetailsButtonClick(3);
	
}
@Test
public void ChargeTypePageTest() throws InterruptedException {
	SetupPage setup =login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
	setup.setupClick();
	HospitalChargesPage hospitalCharges=setup.loadHospitalChargesPage();
	ChargeTypePage chargeType =hospitalCharges.loadChargeTypePage();
	chargeType.addChargeTypeButtonClick();
	chargeType.enterChargeType("chargesssss");
	chargeType.saveAddChargeTypeButtonClick();
	Thread.sleep(3000);
	chargeType.deleteChargeTypeButtonClick(33);
	
	
}

}