package business_Logic;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import org.springframework.stereotype.Component;

@Component("LIC9371_PJT1011_PE_NLPe829c88c-06ba-4a5b-abb2-6a74626aae80")
public class Upload_file implements Nlp {
	@InputParams({ @InputParam(name = "xPath", type = "java.lang.String"),
			@InputParam(name = "filePath", type = "java.lang.String") })

	@Override
	public List<String> getTestParameters() throws NlpException {
		List<String> params = new ArrayList<>();
		return params;
	}

	@Override
	public StringBuilder getTestCode() throws NlpException {
		StringBuilder sb = new StringBuilder();
		return sb;
	}

	@Override
	public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

		NlpResponseModel nlpResponseModel = new NlpResponseModel();
		Map<String, Object> attributes = nlpRequestModel.getAttributes();
		String xPath = (String) attributes.get("xpath");
		String filePath = (String) attributes.get("filePath");
		WebDriver driver = nlpRequestModel.getWebDriver();

		try {
			FileUpload(xPath, filePath, driver);
			nlpResponseModel.setStatus("PASS");
			nlpResponseModel.setMessage("File Uploaded successfully");

		} catch (Exception e) {
			nlpResponseModel.setStatus("FAIL");
			nlpResponseModel.setMessage("Failed to upload file");
		}
		return nlpResponseModel;
	}

	private static void FileUpload(String xPath, String filePath, WebDriver driver) throws AWTException {
		int iterations = 500, time = iterations;
		WebElement upload = driver.findElement(By.xpath(xPath));

		Robot r = new Robot();
		Actions a = new Actions(driver);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle re = new Rectangle(d);
		BufferedImage n = r.createScreenCapture(re);

		a.moveToElement(upload).click().perform();

		BufferedImage n1 = r.createScreenCapture(re);
		iterations = time;
		while (iterations > 0) {
			double d1 = 1.2;
			double percentage = check(n, n1);
			if (percentage >= d1) {
				n1 = r.createScreenCapture(re);
				break;
			}
			n1 = r.createScreenCapture(re);
			iterations--;
		}
		StringSelection path = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		BufferedImage n2 = r.createScreenCapture(re);
		iterations = time;
		while (iterations > 0) {
			System.out.println("inside the inner true");
			double percentage = check(n1, n2);
			if (percentage > 0.03)
				break;
			n2 = r.createScreenCapture(re);
			iterations--;
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	static double check(BufferedImage imgA, BufferedImage imgB) {

		double percentage = 0;
		int width1 = imgA.getWidth();
		int width2 = imgB.getWidth();
		int height1 = imgA.getHeight();
		int height2 = imgB.getHeight();

		if ((width1 != width2) || (height1 != height2))

			// Display message straightaway
			System.out.println("Error: Images dimensions" + " mismatch");
		else {

			// By now, images are of same size

			long difference = 0;

			// treating images likely 2D matrix

			// Outer loop for rows(height)
			for (int y = 0; y < height1; y++) {

				// Inner loop for columns(width)
				for (int x = 0; x < width1; x++) {

					int rgbA = imgA.getRGB(x, y);
					int redA = (rgbA >> 16) & 0xff;
					int greenA = (rgbA >> 8) & 0xff;
					int blueA = (rgbA) & 0xff;

					// System.out.println(rgbA+"\n"+redA);
					///////////////////////////////
					///////////////////////////////
					int rgbB = imgB.getRGB(x, y);
					int redB = (rgbB >> 16) & 0xff;
					int greenB = (rgbB >> 8) & 0xff;
					int blueB = (rgbB) & 0xff;

					difference += Math.abs(redA - redB);
					difference += Math.abs(greenA - greenB);
					difference += Math.abs(blueA - blueB);
				}
			}

			double total_pixels = width1*height1*3;

			double avg_different_pixels = difference / total_pixels;

			// There are 255 values of pixels in total
			percentage = (avg_different_pixels / 255) * 100;

			//System.out.println("Difference Percentage-->" + percentage);

		}
		return percentage;

	}

}