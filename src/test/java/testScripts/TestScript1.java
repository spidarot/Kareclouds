package testScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.print.attribute.standard.Chromaticity;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import objectFiles.AppointmentPriorityPage;
import objectFiles.BedGroupPage;
import objectFiles.BedListPage;
import objectFiles.BedPage;
import objectFiles.BedTypePage;
import objectFiles.ChargeCategoryPage;
import objectFiles.ChargeTypePage;
import objectFiles.ComplainTypePage;
import objectFiles.DisabledPatientPage;
import objectFiles.DoctorOPDChargePage;
import objectFiles.FloorPage;
import objectFiles.FrontOfficePage;
import objectFiles.HospitalChargesPage;
import objectFiles.LoginPage;
import objectFiles.PatientPage;
import objectFiles.SetupPage;
import objectFiles.SourcePage;
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

		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		PatientPage patient = setup.loadPatientPage();
		String CurrentUrl = patient.getCurrentUrl();
		Assert.assertEquals(CurrentUrl, prop.getProperty("patientPagetUrl"), "Url Mismatch");

		// AddPatient
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
		String toastMessage = patient.toastMessageGetText();
		Assert.assertEquals(toastMessage, "Record Saved Successfully");
		System.out.println(toastMessage);

		// SearchFunction
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
		// disable Patient
		patient.tablePatientButtonclick();
		patient.disablePatientButtonClick();
		patient.alertHandlingPositive();
		Assert.assertEquals(patient.toastMessageGetText(), "Record Disable");
		System.out.println(patient.toastMessageGetText());
		patient.closePatientDataButonClick();

	}

	@Test
	public void sorting() throws InterruptedException {
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		PatientPage patient = setup.loadPatientPage();
		String sortBy = prop.getProperty("sortBy");
		patient.SortingButtonElementClick(sortBy);
		patient.getSortingOrder(sortBy);
		String FirstTabelEntry = patient.firstTabelEntryGetText(sortBy);
		String LastTabelEntry = patient.lastTabelEntryGetText(sortBy);
		patient.SortingButtonElementClick(sortBy);
		patient.getSortingOrder(sortBy);
		String NewFirstTabelEntry = patient.firstTabelEntryGetText(sortBy);
		String NewLastTabelEntry = patient.lastTabelEntryGetText(sortBy);
		Assert.assertEquals(FirstTabelEntry, NewLastTabelEntry);
		Assert.assertEquals(LastTabelEntry, NewFirstTabelEntry);
		System.out.println("sorting working");
	}

	@Test
	public void editPatientData() throws IOException {
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		PatientPage patient = setup.loadPatientPage();
		patient.showPatientDataWindow();
		patient.editPatientDataButtonClick();

	}

	@Test
	public void deletPatientData() throws IOException, InterruptedException {
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		PatientPage patient = setup.loadPatientPage();
		DisabledPatientPage disabledPatient = patient.disabledPatientListButtonClick();
		disabledPatient.screenshot("deletPatientData1");
		disabledPatient.patientDataElementClick();
		disabledPatient.deletePatientData();
		disabledPatient.alertHandlingPositive();
		Thread.sleep(200);
		disabledPatient.screenshot("deletPatientData2");

		// enable Patient data
		disabledPatient.patientDataElementClick();
		disabledPatient.enablePatientDataButtonClick();
		disabledPatient.alertHandlingPositive();
		Assert.assertEquals(disabledPatient.toastMessageGetText(), "Record Active");
		System.out.println(disabledPatient.toastMessageGetText());
		disabledPatient.closePatientDataButtonclick();
		disabledPatient.screenshot("enablePatientData2");

		// patient List Button working
		disabledPatient.patientListButtonClick();
	}

//Hospital Charges add charge
	@Test
	public void hospitalChargesaddcharge() throws IOException, InterruptedException {
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		HospitalChargesPage hospitalCharges = setup.loadHospitalChargesPage();
		Assert.assertEquals(hospitalCharges.titleTextGetText(), "Charges Details");
		System.out.println("Title Text= " + hospitalCharges.titleTextGetText());
		hospitalCharges.addChargeButtonClick();
		hospitalCharges.selectChargeTypeOption("Investigations");
		// hospitalCharges.selectChargeCategoryOption("Select");
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
		hospitalCharges.editChargeDetailsWindowButtonclick(7);
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
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		HospitalChargesPage hospitalCharges = setup.loadHospitalChargesPage();
		ChargeCategoryPage chargeCategory = hospitalCharges.loadChargeCategoryPage();
		Assert.assertEquals(chargeCategory.titleTextGetText(), "Charge Category List");
		System.out.println("Title Text= " + chargeCategory.titleTextGetText());
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
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		HospitalChargesPage hospitalCharges = setup.loadHospitalChargesPage();
		DoctorOPDChargePage doctorOPDCharge = hospitalCharges.loadDoctorOPDChargePage();
		Assert.assertEquals(doctorOPDCharge.titleTextGetText(), "Doctor OPD Charge");
		System.out.println("Title Text= " + doctorOPDCharge.titleTextGetText());
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
		// view charge details
		doctorOPDCharge.viewChargeDetailsButtonClick(3);
		doctorOPDCharge.screenshot("View Charge Details");
		doctorOPDCharge.closeViewChargeDetailsButtonClick();
		Thread.sleep(3000);
		// edit charge details
		doctorOPDCharge.editChargeDetailsButtonClick(3);
		doctorOPDCharge.screenshot("Edit Charge Details");
		doctorOPDCharge.saveEditButtonClick();
		// doctorOPDCharge.deleteChargeDetailsButtonClick(3);

	}

	@Test
	public void ChargeTypePageTest() throws InterruptedException {
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		HospitalChargesPage hospitalCharges = setup.loadHospitalChargesPage();
		ChargeTypePage chargeType = hospitalCharges.loadChargeTypePage();
		Assert.assertEquals(chargeType.titleTextGetText(), "Charge Type List");
		System.out.println("Title Text= " + chargeType.titleTextGetText());
		chargeType.addChargeTypeButtonClick();
		chargeType.enterChargeType("chargesssss");
		chargeType.saveAddChargeTypeButtonClick();
		Thread.sleep(3000);
		chargeType.deleteChargeTypeButtonClick(33);

	}

	@Test
	public void bedTest() {
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		BedPage bed = setup.loadBedPage();
		Assert.assertEquals(bed.titleTextGetText(), "Bed Status");
		System.out.println("Title Text= " + bed.titleTextGetText());

	}

	@Test
	public void bedListTest() throws IOException, InterruptedException {
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		BedPage bed = setup.loadBedPage();
		BedListPage bedList = bed.loadbedListPage();
		Assert.assertEquals(bedList.titleTextGetText(), "Bed List");
		System.out.println("Title Text= " + bedList.titleTextGetText());
		bedList.addButtonClick();
		bedList.enterNameField("Big Bed2");
		bedList.selectBedTypeOption("VIP");
		bedList.selectBedGroupOption("ICU - Ground Floor");
		bedList.screenshot("Add Bed List");
		bedList.saveAddWindowButtonClick();
		Assert.assertEquals(bedList.toastMessageGetText(), "Bed already exists");
		System.out.println(bedList.toastMessageGetText());
		bedList.closeAddButtonClick();
		Thread.sleep(3000);
		bedList.editBedListButtonClick(10);
		bedList.saveEditBedListWindowButtonClick();
		// bedList.deleteBedListButtonClick(4);
	}

	@Test
	public void testBedTypePage() throws InterruptedException, IOException {
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		BedPage bed = setup.loadBedPage();
		BedTypePage bedType = bed.loadbedTypePage();
		Assert.assertEquals(bedType.titleTextGetText(), "Bed Type List");
		System.out.println("Title Text= " + bedType.titleTextGetText());
		bedType.addButtonClick();
		bedType.enterNameInAddWindow("vvip");
		bedType.screenshot("add bed Type");
		bedType.saveInAddButtonClick();
		Thread.sleep(3000);
		bedType.editButtonClick(6);
		bedType.screenshot("edit bed Type");
		bedType.saveButtonInEditBedTypeWindowClick();
		// bedType.deleteButtonClick(5);
	}

	@Test
	public void testBedGroupPage() throws InterruptedException, IOException {
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		BedPage bed = setup.loadBedPage();
		BedGroupPage bedGroup = bed.loadbedGroupPage();
		Assert.assertEquals(bedGroup.titleTextGetText(), "Bed Group List");
		System.out.println("Title Text= " + bedGroup.titleTextGetText());
		bedGroup.addBedGroupButtonClick();
		bedGroup.enterNameInAddBedGroupWindow("vvvvvip");
		bedGroup.selectFloorOptionInAddBedGroupWindow("4th floor");
		bedGroup.enterdescriptionInAddBedGroupWindow("biggggg floor");
		bedGroup.screenshot("add bed Group");
		bedGroup.saveButtonInAddBedGroupClick();
		Thread.sleep(3000);
		bedGroup.editBedGroupButtonClick(6);
		bedGroup.enterNameInEditBedGroupWindow("small room");
		bedGroup.enterdescriptionInEditBedGroupWindow("room ok ok");
		bedGroup.screenshot("edit bed Group");
		bedGroup.saveButtonInEditBedGroupWindowClick();
		// bedType.deleteBedGroupButtonClick(5);

	}

	@Test
	public void testFloorPage() throws InterruptedException, IOException {
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		BedPage bed = setup.loadBedPage();
		FloorPage floor = bed.loadFloorPage();
		Assert.assertEquals(floor.titleTextGetText(), "Floor List");
		System.out.println("Title Text= " + floor.titleTextGetText());
		floor.addFloorButtonClick();
		floor.enterNameInAddFloorWindow("vcip");
		floor.enterdescriptionInAddFloorWindow("biggggg floor");
		floor.screenshot("add Floor");
		floor.saveButtonInAddFloorClick();
		Thread.sleep(3000);
		floor.editFloorButtonClick(6);
		floor.enterNameInEditFloorWindow("small Floor");
		floor.enterdescriptionInEditFloorWindow("Floor ok ok");
		floor.screenshot("edit Floor");
		floor.saveButtonInEditFloorWindowClick();
		//floor.deleteFloorButtonClick(5);
		//floor.alertHandlingPositive();
		
	}
	
	@Test
	public void testFrontOfficePage() throws InterruptedException, IOException {
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		FrontOfficePage frontOffice = setup.loadFrontOfficePage();
		Assert.assertEquals(frontOffice.titleTextGetText(), "Purpose List");
		System.out.println("Title Text= " + frontOffice.titleTextGetText());
		//frontOffice.addPurposeButtonClick();
		//frontOffice.enterPurposeInAddPurposeWindow("dsvcjosdv");
		//frontOffice.enterDescriptionInAddPurposeWindow("fdcoesdvd");
		//frontOffice.saveButtonInAddPurposeWindowClick();
		frontOffice.editPurposeButtonClick(2);
		frontOffice.enterDescriptionInEditPurposeWindow("hi aditya");
		frontOffice.enterPurposeInEditPurposeWindow("visit aditya");
		frontOffice.saveEditPurposeWindowButtonClick();
	
	}
	@Test
	public void testComplainTypePage() throws InterruptedException, IOException {
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		FrontOfficePage frontOffice = setup.loadFrontOfficePage();
		ComplainTypePage complainType=frontOffice.loadComplainTypePage();
		Assert.assertEquals(complainType.titleTextGetText(), "Complain Type List");
		System.out.println("Title Text= " + complainType.titleTextGetText());
		complainType.addComplainTypeButtonClick();
		complainType.enterComplainTypeInAddComplainTypeWindow("delete not working");
		complainType.enterDescriptionInAddComplainTypeWindow("delete button not working");
		complainType.saveButtonInAddComplainTypeWindowClick();
		complainType.editComplainTypeButtonClick(100);
		complainType.enterDescriptionInEditComplainTypeWindow("hi aditya");
		complainType.enterComplainTypeInEditComplainTypeWindow("visit aditya");
		complainType.saveEditComplainTypeWindowButtonClick();
	
	}
	
	@Test
	public void testSourcePage() throws InterruptedException, IOException {
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		FrontOfficePage frontOffice = setup.loadFrontOfficePage();
		SourcePage source=frontOffice.loadSourcePage();
		Assert.assertEquals(source.titleTextGetText(), "Source");
		System.out.println("Title Text= " + source.titleTextGetText());
		source.addSourceButtonClick();
		source.enterSourceInAddSourceWindow("delete not working");
		source.enterDescriptionInAddSourceWindow("delete button not working");
		source.saveButtonInAddSourceWindowClick();
		source.editSourceButtonClick(60);
		source.enterDescriptionInEditSourceWindow("hi aditya");
		source.enterSourceInEditSourceWindow("visit aditya");
		source.saveEditSourceWindowButtonClick();
				
	}
	
	@Test
	public void testAppointmentPriorityPage() throws InterruptedException, IOException {
		SetupPage setup = login.loginApplicatio(prop.getProperty("Username"), prop.getProperty("Password"));
		setup.setupClick();
		FrontOfficePage frontOffice = setup.loadFrontOfficePage();
		AppointmentPriorityPage appointmentPriority=frontOffice.loadAppointmentPriorityPage();
		Assert.assertEquals(appointmentPriority.titleTextGetText(), "Appointment Priority List");
		System.out.println("Title Text= " + appointmentPriority.titleTextGetText());
		appointmentPriority.addPriorityButtonClick();
		appointmentPriority.enterPriorityInAddPriorityWindow("delete not working");
		appointmentPriority.saveButtonInAddPriorityWindowClick();
		appointmentPriority.editPriorityButtonClick(30);
		appointmentPriority.enterPriorityInEditPriorityWindow("visit aditya");
		appointmentPriority.saveEditPriorityWindowButtonClick();
	
	}
}