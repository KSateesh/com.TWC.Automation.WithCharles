package twc.Android.Automation.General;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import twc.Android.Automation.Driver.webDrivers;

public class openCharlesControl extends webDrivers{
	
	public void open_Charles_Control_From_Browser() throws IOException, InterruptedException{
		
		webDrivers.property();
		
		String downloadPath = properties.getProperty("downloadPath");
		
		File index = new File(downloadPath);
		
		if (!index.exists()) {
			System.out.println("Specified folder is not exist and creating the same folder now");
		    index.mkdir();
		} else {
			System.out.println("Specified folder is exist and deleting the same folder");
			FileUtils.cleanDirectory(index);
			System.out.println("Deleted all the files in the specified folder");
		}
		
		
		
		FirefoxProfile profile = new FirefoxProfile();
		
		profile.setPreference("browser.download.folderList", 2);
		
		profile.setPreference("browser.download.dir", downloadPath);
		
		profile.setPreference("browser.helperApps.neverAsk.openFile","text/xml");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/xml");
		
//		profile.setPreference("browser.download.manager.showWhenStarting", false);
//		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
//		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
//		profile.setPreference("browser.download.manager.focusWhenStarting", false);
//		profile.setPreference("browser.download.manager.useWindow", false);
//		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
//		profile.setPreference("browser.download.manager.closeWhenDone", false);
//		profile.setPreference("browser.download.useDownloadDir", false); 

		driver = new FirefoxDriver(profile);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get("http://mohantestengg:123456@control.charles");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Session")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Clear Session")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Back")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Recording")).click();
		
	}
	
	public void open_Charles_Control_Start() throws IOException, InterruptedException{
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("Start")).click();
		
	}
	public void open_Charles_Control_Stop() throws IOException, InterruptedException{
	
		Thread.sleep(1000);
		driver.findElement(By.linkText("Stop")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Back")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Session")).click();
	}
	
	public void save_Export_Session_XML_File() throws IOException, InterruptedException{
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("Export Session as XML")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	
	
	
}
