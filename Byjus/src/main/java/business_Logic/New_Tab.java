
package business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;

import org.springframework.stereotype.Component;

@Component("LIC9371_PJT1011_PE_NLPab21d015-0759-43b8-a8c5-cc5392b54a06")
public class New_Tab implements Nlp {
	// @InputParams({ @InputParam(name = "url", type = "java.lang.String") })
//    @ReturnType(name = "string3", type = "java.lang.String")

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
		WebDriver driver = nlpRequestModel.getWebDriver();
//   
		// Your program element business logic goes here ...
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.open()");
			nlpResponseModel.setMessage("New tab should be opened successfully");
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			// TODO: handle exception
			nlpResponseModel.setMessage("Failed to open new tab");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
		return nlpResponseModel;
	}
}