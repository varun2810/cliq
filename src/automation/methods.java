package automation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class methods {
	
	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	static String email = "varunvishal08@gmail.com";
	static String password = "Tour2810";
	  
	
	@Test
	public void startServer() {
		CommandLine cmd = new CommandLine("/usr/local/bin/node");
		cmd.addArgument("/usr/local/bin/appium");
		cmd.addArgument("--address");
		cmd.addArgument("127.0.0.1");
		cmd.addArgument("--port");
		cmd.addArgument("4723");
		
		DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
		
			executor.execute(cmd, handler);
			Thread.sleep(10000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void stopServer() {
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void installation() throws MalformedURLException {
			
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "350df4d27d42");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		//capabilities.setCapability(CapabilityType.VERSION, "7.1.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", "C:\\Users\\Varun\\workspace\\Cliq\\apks\\Cliq.apk");
		capabilities.setCapability("appPackage", "com.zoho.chat");
		capabilities.setCapability("appActivity", "com.zoho.chat.ui.MyBaseActivity");
		capabilities.setCapability("noReset", false);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			
		
  }
}
