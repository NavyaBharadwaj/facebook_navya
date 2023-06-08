package test_scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Objects.googlesearch_page;
import Objects.faceooksearch_page;

public class test_methods_googlesearch {
	
	WebDriver driver;
	googlesearch_page googlesearch_page;

	facebooksearch_page facebooksearch_page;

	@BeforeTest
	public void beforetest() {
		// WebDriverManager.chmedriver().setup();
	 driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}

	@Test(priority=0)
	public void SearchOperation() throws InterruptedException {
		googlesearch_page page = new googlesearch_page(driver);
		// page.click();
		page.searchgoogle("facebook");
		

		// Thread.sleep(5000);
	}

	@Test(priority=1)
	public void VerifyandAccessFacebook() throws InterruptedException {
		googlesearch_page page = new googlesearch_page(driver);

		page.ClickFacebook();
	}

	@Test(priority=2)
	public void VerifyLoginfunctionality() throws InterruptedException {
		facebooksearch_page page = new facebooksearch_page(driver);

		Thread.sleep(2000);
		page.EnterUsername();
		page.EnterPassword();
		//Thread.sleep(1000);
		page.VerifyLogin();
	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}

}
