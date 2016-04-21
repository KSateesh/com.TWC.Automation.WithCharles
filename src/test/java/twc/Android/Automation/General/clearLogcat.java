package twc.Android.Automation.General;

import java.io.IOException;

import twc.Android.Automation.Driver.webDrivers;

public class clearLogcat extends webDrivers{
	
	public void clearTWCLogs() throws InterruptedException{
		try {
			webDrivers.property();
			
			System.out.println("Clear Logcat Logs for TWC App");	
			 String[] clearLogcatdata ={"/bin/bash", "-c",  properties.getProperty("adbPath")+" logcat -c"};
		     Runtime.getRuntime().exec(clearLogcatdata);	
		     Thread.sleep(4000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
