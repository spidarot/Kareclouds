package testFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import org.testng.annotations.BeforeMethod;
//import ObjectFiles.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectFiles.LoginPage;

public class TestBaseFile {
	public WebDriver driver;
	public Properties prop;
	public LoginPage login;
	
	public TestBaseFile() throws IOException {
		
		try {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\eclipse-workspace\\KareCloudsSprint2\\src\\main\\java\\resources\\config.properties");
//		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Config.properties");
		prop.load(fis);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
public WebDriver driverInitialization() throws InterruptedException, IOException {
	

	String Browsername = prop.getProperty("browser");
	System.out.println(Browsername);
//	String Browsername ="chrome";
	if (Browsername.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
	else if(Browsername.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else if(Browsername.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	else if(Browsername.equalsIgnoreCase("safari")) {
		WebDriverManager.safaridriver().setup();
		driver = new SafariDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	return driver;
	}

@BeforeMethod
public LoginPage launchApplicatio() throws InterruptedException, IOException {
	driver=driverInitialization();
	login=new LoginPage(driver);
	login.goTo(prop.getProperty("GoToUrl"));
	System.out.println(prop.getProperty("GoToUrl"));
	return login;
}

//@AfterTest
//public void tearDown() {
//driver.quit();
//}

}