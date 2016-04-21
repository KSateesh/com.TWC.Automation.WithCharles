package twc.Android.Automation.TestCases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import twc.Android.Automation.General.openCharles;
import twc.Android.Automation.General.launchApp;
import twc.Android.Automation.General.openCharlesControl;
import twc.Android.Automation.General.clearLogcat;
import twc.Android.Automation.Driver.webDrivers;
import twc.Android.Automation.Test_Validate_Scripts.CXTG_Validate;

public class smokeTestCases extends webDrivers{
	
	
	
	@Test(priority=0)
	public void CXTG_Test_Case_Using_Charles() throws InterruptedException, IOException{
		
		CXTG_Validate cxtgValidate = new CXTG_Validate();
		cxtgValidate.Generate_CXTGvalues_For_All_Locations();
	}

	@BeforeTest
	public void Before_Launch_App() throws IOException, InterruptedException{
		
		openCharles opencharles = new openCharles();
		opencharles.open_Headless_Charles();
		
		openCharlesControl openCC = new openCharlesControl();
		openCC.open_Charles_Control_From_Browser();
		
		launchApp launchapp = new launchApp();
		launchapp.launchTWCApp();
		
	}
	
	@BeforeMethod
	public void Before_Method_Clear_Logcat_Logs() throws IOException, InterruptedException{
		
		clearLogcat clear_logcat_data = new clearLogcat();
		clear_logcat_data.clearTWCLogs();
	}
	
//	@AfterTest
//	public void After_Launch_App() throws IOException, InterruptedException{
//		
//		
//	}
}
