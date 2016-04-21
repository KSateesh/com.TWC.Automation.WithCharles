package twc.Android.Automation.General;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import twc.Android.Automation.Driver.webDrivers;

public class launchApp extends webDrivers {

	@SuppressWarnings("rawtypes")
	public void launchTWCApp() throws IOException, InterruptedException{
		
		webDrivers.property();
		Start_Stop_Appium_Server appServer = new Start_Stop_Appium_Server();
		
		System.out.println("Ready to Stop the ADB server");
		appServer.killadb();
		System.out.println("ADB Server stopped");
		
		
		System.out.println("Uninstall the APP and Install");	
		String[] uninstall ={"/bin/bash", "-c",  properties.getProperty("adbPath")+" shell pm uninstall com.weather.Weather"};
	    Runtime.getRuntime().exec(uninstall);	
	    Thread.sleep(4000);
	    
	    System.out.println("Stopping the appium server");
	    appServer.stopAppiumServer();
		System.out.println("Appium server is stopped");
     	
		Thread.sleep(5000);
     	
		System.out.println("Starting the appium server");
		appServer.startAppiumServer();
		System.out.println("Appium server is started and running");
		System.out.println("Install the app");
		Thread.sleep(5000);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName",  properties.getProperty("platformName")); 
		capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
		capabilities.setCapability("deviceName", properties.getProperty("deviceName")); 
		capabilities.setCapability("app", properties.getProperty("appPath"));
		capabilities.setCapability("appPackage", "com.weather.Weather");
		capabilities.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
		capabilities.setCapability("autoAcceptAlerts",true);
		capabilities.setCapability("newCommandTimeout",100000);

		Ad = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Ad.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Capabilities are launched");
	}
}
