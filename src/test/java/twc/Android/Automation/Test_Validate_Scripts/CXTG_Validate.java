package twc.Android.Automation.Test_Validate_Scripts;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import io.appium.java_client.MobileElement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import junit.framework.Assert;
import junit.framework.ComparisonFailure;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import twc.Android.Automation.Driver.webDrivers;
import twc.Android.Automation.General.openCharlesControl;

public class CXTG_Validate extends webDrivers{
	
	openCharlesControl openCC = new openCharlesControl();
	/* --- Start Main Method For CXTGvalues  --- */
	public void Generate_CXTGvalues_For_All_Locations() throws InterruptedException, IOException{
		
		WebDriverWait wait = new WebDriverWait(Ad, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.weather.Weather:id/temperature")));

		//Temperature Element
		MobileElement temp = (MobileElement) Ad.findElementById("com.weather.Weather:id/temperature");
		System.out.println("Temp : "+temp.getText());
		
		//Menu Element
		Ad.findElementByClassName("android.widget.ImageButton").click();
	    
		//User Login Status Menu Element
		String login_status_xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.support.v7.widget.RecyclerView[1]/android.support.v7.widget.LinearLayoutCompat[1]/android.widget.CheckedTextView[1]";
		
		WebDriverWait wait1 = new WebDriverWait(Ad, 20);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(login_status_xpath)));

		WebElement login_status_text = Ad.findElementByXPath(login_status_xpath);
		
	    System.out.println("Login Status :"+login_status_text.getText());
	    
	    /* --- Start Login Status equals to Login  --- */
	    if(login_status_text.getText().contains("Log in"))
	    {
	    
	    login_status_text.click();
	    
	    WebDriverWait wait0 = new WebDriverWait(Ad, 10);
		wait0.until(ExpectedConditions.presenceOfElementLocated(By.id("com.weather.Weather:id/et_email_id")));
		
	    Ad.findElementById("com.weather.Weather:id/et_email_id").sendKeys("mohantestengg@gmail.com");
	    
	    WebDriverWait wait11 = new WebDriverWait(Ad, 10);
		wait11.until(ExpectedConditions.presenceOfElementLocated(By.id("com.weather.Weather:id/et_password")));
	    Ad.findElementById("com.weather.Weather:id/et_password").sendKeys("123456");
	    
	    WebDriverWait wait2 = new WebDriverWait(Ad, 10);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("com.weather.Weather:id/bt_twc_login")));
	    Ad.findElementById("com.weather.Weather:id/bt_twc_login").click();
	    
	    WebDriverWait wait3 = new WebDriverWait(Ad, 20);
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.ImageButton")));
		
		System.out.println("Login Done Successfully");
	    
	    }/* --- End Login Status equals to Login  --- */
	    
	    /* --- Start  Kill and Start The App in Background If required  --- */
	    
//		String adbPath = properties.getProperty("adbPath");
//		String[] str ={"/bin/bash", "-c", adbPath+" adb shell pm disable com.weather.Weather"};
//		Runtime.getRuntime().exec(str);
//		System.out.println("Kill The APP");
//		
//		Thread.sleep(2000);
//		//String adbPath = properties.getProperty("adbPath");
//		String[] str1 ={"/bin/bash", "-c", adbPath+" adb shell pm enable com.weather.Weather"};
//		Runtime.getRuntime().exec(str1);
//		System.out.println("Start The APP");
		
	    /* --- End App Kill and Start in Background If required  --- */
	    System.out.println("Kill The App First Time for getting cxtg values for all locations");
	    //CLose The App
		Ad.closeApp();
		//Open The App
		System.out.println("Relaunching The App");
		Ad.launchApp();
		
		System.out.println("Start The Session Capture in Headless Charles");
		openCC.open_Charles_Control_Start();
		
		//Current Location Element
		String lantxt = Ad.findElementById("com.weather.Weather:id/location_actionbar_name").getText(); 
		System.out.println("Current Locaion Text :::::"+lantxt);
		
		WebDriverWait wait4 = new WebDriverWait(Ad, 10);
		wait4.until(ExpectedConditions.presenceOfElementLocated(By.id("com.weather.Weather:id/location_actionbar_name")));
		
		//Root Location Element
		Ad.findElementById("com.weather.Weather:id/location_actionbar_name").click();
		
		WebDriverWait wait5 = new WebDriverWait(Ad, 20);
		wait5.until(ExpectedConditions.presenceOfElementLocated(By.id("com.weather.Weather:id/location_data_row")));
		
		//List Location Element
		@SuppressWarnings("unchecked")
		List<MobileElement> loclist = Ad.findElements(By.id("com.weather.Weather:id/location_data_row"));
		
		int loc_size = loclist.size() -1;
		
		String loc_length = Integer.toString(loc_size);
		
		System.out.println("Total Location :::::" + loc_length);
		
		Thread.sleep(2000);
		
		/* --- Start For Loop For Location Click --- */
		for(int i=2;i<= loclist.size();i++){
			
			String element = null;
			
			try {
				
				element = "//android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]";
						   
				MobileElement ele = (MobileElement) Ad.findElementByXPath(element);
				System.out.println("For This Location ====>"+ele.getText());
				
				WebDriverWait wait9 = new WebDriverWait(Ad, 20);
				wait9.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
				
				Ad.findElementByXPath(element).click();
				
				WebDriverWait wait10 = new WebDriverWait(Ad, 20);
				wait10.until(ExpectedConditions.presenceOfElementLocated(By.id("com.weather.Weather:id/location_actionbar_name")));
				
				Ad.findElementById("com.weather.Weather:id/location_actionbar_name").click();
			} catch (Exception e) {
				
				System.out.println(element+" is not found in the location list");
			}
			
			
			
		}/* --- End For Loop For Location Click --- */
		
		Thread.sleep(10000);
		
		WebDriverWait wait12 = new WebDriverWait(Ad, 10);
		wait12.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")));
		
		Ad.findElementByXPath("//android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]").click();
		
		System.out.println("Stop The Session Capture in Headless Charles");
		openCC.open_Charles_Control_Stop();
		System.out.println("Exporting The Session Data Into XML File");
		openCC.save_Export_Session_XML_File();
		System.out.println("Start The CXTG Values Validation");
		CXTG_Validation_Check(loc_length);
		
		
	}/* --- End Main Method For CXTGvalues  --- */

	/* --- Start CXTG Validation For Both PubAds as well as Triggers Response  --- */
	public void CXTG_Validation_Check(String locsize) throws InterruptedException, IOException{
		
		webDrivers.property();
		
		/* --- Start XML File Location and Saved into Properties File After Downloading  --- */
		String session_downloadPath = properties.getProperty("downloadPath");
		String get_xml_file_name = listFiles(properties.getProperty("downloadPath"));
		
		String concat_session_file_path = session_downloadPath.concat(get_xml_file_name);
		
		System.out.println("XML File Name : "+concat_session_file_path);
		
		properties.setProperty("xmlFilePath", concat_session_file_path);
		
		FileOutputStream xml_override = new FileOutputStream(properties.getProperty("dataFilePath"));		
		
		properties.store(xml_override, "override the session xml file");
		/* --- End XML File Location and Saved into Properties File After Downloading  --- */
		
		HashMap<String, String> pubad_res = pub_ads_validate();
		
		Iterator<String> keySetIterator = pubad_res.keySet().iterator(); 
		
		List<String> cxtg_not_match = new ArrayList<String>();
		
		/* --- Start While  --- */
		boolean isExceptionOccered = false;
		while(keySetIterator.hasNext()){ 
			
			String key = keySetIterator.next();
			
			Map<String, String> wfxtrigger_res = wfxtriggers_validate(locsize,key);
			System.out.println("For Location  : " + key);
			System.out.println("PubAd CXTG Values : " + pubad_res.get(key));
			System.out.println("Trigger CXTG Values : " + wfxtrigger_res.get("cxtg"));
			System.out.println("===================================================");
			// Assert CXTG Values from Pubads and WTX Trigger
			try {
				
				Assert.assertEquals(pubad_res.get(key),wfxtrigger_res.get("cxtg"));
			} catch (ComparisonFailure e) {
				
				System.out.println(key + " Doesn't Match");
				cxtg_not_match.add(key);
				isExceptionOccered= true;
				//Assert.fail( key + " Doesn't Match" );
			}
			
		}/* --- End While  --- */ 
		
		if(isExceptionOccered){
			System.out.println(cxtg_not_match);
			Assert.fail(cxtg_not_match + " are not matched");
		}
		
		
	}/* --- End CXTG Validation For Both PubAds as well as Triggers Response  --- */
	
	/* --- Start Getting the PubAds CXTG Values based on ZIP Code  --- */
	public HashMap<String, String> pub_ads_validate(){
		
		String zip = null;
		String cxtg_val = null;
		
		HashMap<String, String> zcs_array_list = new HashMap<String, String>();
		/* --- Start Try Cache Method  --- */
		try {
			
			File fXmlFile = new File(properties.getProperty("xmlFilePath"));
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("transaction");
			/* --- Start In XML Node Tag Name Start With transaction  --- */
			for (int temp = 0; temp < nList.getLength(); temp++) {
				
				Node nNode = nList.item(temp);
				/* --- Start In XML Node  --- */
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					/* --- Start In XML Host Value Equals to  pubads.g.doubleclick.net --- */
					if(eElement.getAttribute("host").equals("pubads.g.doubleclick.net")){
						
						String request = eElement.getElementsByTagName("first-line").item(0).getTextContent();
						String decoderstring = URLDecoder.decode(request, "UTF-8");
						
						String decoderstring_sub = decoderstring.substring(16);
						
						if(decoderstring_sub.contains("iu=/7646/app_android_us/display/bb") && decoderstring_sub.contains("cxtg")){
							
						String[] arrayval = decoderstring_sub.split("&");
						/* --- Start For Loop for Split With & Symbol --- */
						for (String keys : arrayval) {
							
							String[] key = keys.split("=");
								/* --- Start If Key pair contains ZIP Value --- */
								if (key[0].equals("zip")) {
									zip = key[1];
								}
								/* --- End If Key pair contains ZIP Value --- */
								
								/* --- Start If cxtg ---*/
								if (key[0].equals("cxtg")) {
										cxtg_val = key[1];
										
										/* --- Start If cxtg not equals to nl --- */
										if(!cxtg_val.equals("nl")){
											zcs_array_list.put(zip, cxtg_val);
										}/* --- End If cxtg not equals to nl --- */
										
								}/* --- End If cxtg ---*/
								
							}/* --- End For Loop for Split With & Symbol --- */
						
						}/* --- End In XML Host Value Equals to  pubads.g.doubleclick.net --- */
						
					}/* --- End In XML Host Value Equals to  pubads.g.doubleclick.net --- */
					
				}/* --- End In XML Node  --- */
				
			}/* --- End In XML Node Tag Name Start With transaction  --- */
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }/* --- Start Try Catch Method  --- */
		
		return zcs_array_list;
	}/* --- End Getting the PubAds CXTG Values based on ZIP Code  --- */
	
	/* --- Start Getting the CXTG Values From triggers.wfxtriggers.com based on ZIP Code  --- */
	public Map<String, String> wfxtriggers_validate( String loc_size, String zipValFrompubAd){
		
		String zip = null;
		String cxtg_val = null;
		Map<String , String> wfxtriggers_values = new HashMap<String, String>();
		String loclist = null;
		String[] zcs_loc_list=null;
		//ArrayList<String> zcs_list = new ArrayList<String>();
		/* --- Start Try Cache Method  --- */
		try {
			
			File fXmlFile = new File(properties.getProperty("xmlFilePath"));
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("transaction");
			/* --- Start In XML Node Tag Name Start With transaction  --- */
			for (int temp = 0; temp < nList.getLength(); temp++) {
				
				Node nNode = nList.item(temp);
				/* --- Start In XML Node  --- */
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					/* --- Start In XML Host Value Equals to  triggers.wfxtriggers.com --- */
				
					if(eElement.getAttribute("host").equals("triggers.wfxtriggers.com")){
						
						String request = eElement.getElementsByTagName("first-line").item(0).getTextContent();
						String decoderstring = URLDecoder.decode(request, "UTF-8");
						
						String[] arrayval = decoderstring.split("&");
						/* --- Start For Loop for Split With & Symbol --- */
						for (String keys : arrayval) {
							
							String[] key = keys.split("=");
							/* --- Start If Key pair contains ZCS Value --- */
							if (key[0].contains("zcs")) {
								
								loclist = key[1];
								zcs_loc_list = loclist.split(",");
								
								String zcs_size = Integer.toString(zcs_loc_list.length);
								/* --- Start Location Size equals to ZCS zip Code Size --- */
								if(zcs_size.equals(loc_size)){
									
//									for(int zcslist =0; zcslist < zcs_loc_list.length; zcslist++){
//										zcs_list.add(zcs_loc_list[zcslist]);
//									}
									
									String wxtgValues="";
									
									try {
										
										wxtgValues  = eElement.getElementsByTagName("body").item(0).getTextContent();
			
										/* --- Start JSON Parser for wfxtg Values --- */
										JSONParser parser = new JSONParser();
										Object obj = parser.parse(wxtgValues);
										JSONObject jsonObject = (JSONObject) obj;
										JSONObject wfxtgval = (JSONObject) jsonObject.get("wfxtg");
										JSONArray scatterSegsVal = (JSONArray) wfxtgval.get("scatterSegs"); 
										/* --- Start For Loop Main JSON Parser --- */
										for(int i=0;i< scatterSegsVal.size();i++){
											
											JSONObject zcsVal = (JSONObject) scatterSegsVal.get(i);
											/* --- Start Key Pair Contains ZCS --- */
											if(zcsVal.containsKey("zcs")){
												JSONArray jsonArray = (JSONArray) zcsVal.get("zcs");
												/* --- Start ZCS contains multipul ZIP Values --- */
												for(int j=0;j< jsonArray.size();j++){
													JSONObject zipval = (JSONObject) jsonArray.get(j);
													/* --- Start Key Pair Contains ZIP --- */
													if(zipval.containsKey("zip")){
														zip = zipval.get("zip").toString();
														/* --- Start ZIP Equals to Pubads ZIP --- */
														if(zipValFrompubAd.equals(zip)){
															cxtg_val = zipval.get("cxtg").toString();
															break;
														}/* --- Start ZIP Equals to Pubads ZIP --- */
														
													}/* --- End Key Pair Contains ZIP --- */
													
												}/* --- End ZCS contains multipul ZIP Values --- */
												
											}/* --- End Key Pair Contains ZCS --- */

										}/* --- End For Loop Main JSON Parser --- */
										/* --- End JSON Parser for wfxtg Values --- */
										wfxtriggers_values.put("cxtg", cxtg_val.substring(1, cxtg_val.length()-1));
									} catch (Exception e) {
										System.out.println(wxtgValues + " triggers.wfxtriggers.com call has not generated.");
										break;
									}
									
								}/* --- End Location Size equals to ZCS zip Code Size --- */
								
							}/* --- End If Key pair contains ZCS Value --- */
							
						}/* --- End For Loop for Split With & Symbol --- */
						
					}/* --- End In XML Host Value Equals to  triggers.wfxtriggers.com --- */
					
				}/* --- End In XML Node  --- */
				
			}/* --- End In XML Node Tag Name Start With transaction  --- */
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }/* --- End Try Cache Method  --- */
		
		
		
		return wfxtriggers_values;
	}/* --- End Getting the CXTG Values From triggers.wfxtriggers.com based on ZIP Code  --- */

	/* --- Start Get File Names from Folder  --- */
	public String listFiles(String directoryName){
	
	String file_name = null;
    File directory = new File(directoryName);
    //get all the files from a directory
    File[] fList = directory.listFiles();
    for (File file : fList){
        if (file.isFile()){
        	file_name = file.getName();
        	break;
        }
    }
    return file_name;
	}/* --- End Get File Names from Folder  --- */
	
}
