package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class dockerwithchrome {

	public static void main(String[] args) throws MalformedURLException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	
		//Capabilities driver = (Capabilities) new ChromeDriver(options);
		URL url=new URL("http://localhost:4545/wd/hub");
		RemoteWebDriver driver1=new RemoteWebDriver(url, options);
		driver1.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver1.getTitle());

	}

}
