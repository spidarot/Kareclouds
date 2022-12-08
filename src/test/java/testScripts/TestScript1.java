package testScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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
	PatientPage patient=setup.LoadpatientPage();
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
	PatientPage patient=setup.LoadpatientPage();
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
	PatientPage patient=setup.LoadpatientPage();
	patient.showPatientDataWindow();
	patient.editPatientDataButtonClick();
	
}

@Test
public void deletPatientData() throws IOException {
	SetupPage setup =login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
	setup.setupClick();
	PatientPage patient=setup.LoadpatientPage();
	patient.disabledPatientListButtonClick();
	
}
}