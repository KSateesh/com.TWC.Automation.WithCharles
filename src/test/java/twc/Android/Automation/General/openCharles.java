package twc.Android.Automation.General;

import java.io.IOException;

public class openCharles {

	public void open_Headless_Charles() throws IOException, InterruptedException{
		//Open Charles Using Terminal
		String[] openCharles_str ={"/bin/bash", "-c", "open -a charles"};
		Runtime.getRuntime().exec(openCharles_str);	
		Thread.sleep(5000);
	}
}
