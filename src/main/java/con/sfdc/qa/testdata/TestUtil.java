package con.sfdc.qa.testdata;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sfdc.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 5;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	

	public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		
		/*TakesScreenshot ts = (TakesScreenshot) driver; //Screenshot setup is done
		File Source = ts.getScreenshotAs(OutputType.FILE);//Taken the screenshot and saving it to source
		//TakeScreenshot object it is saved. not saved physically.
		String sPathOfDestinationImage = System.getProperty("user.dir")+"//screenshot//Screenshot_<timeStamp>.png";
		File dest = new File(sPathOfDestinationImage);
		FileUtils.copyFile(Source, dest);
		return sPathOfDestinationImage;*/
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshot/" + System.currentTimeMillis() + ".png"));
		
	}
	


}
