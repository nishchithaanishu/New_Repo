
package business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import org.springframework.stereotype.Component;

@Component("LIC9371_PJT1011_PE_NLPc1ddfe6d-581f-4e1c-8847-55d1a4722486")
public class Sendkeys implements Nlp {
	@InputParams({ @InputParam(name = "Element", type = "org.openqa.selenium.WebElement"),
			@InputParam(name = "input", type = "java.lang.String") })
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
		WebElement Element = (WebElement) attributes.get("Element");
		String input = (String) attributes.get("input");
		WebDriver driver = nlpRequestModel.getWebDriver();
		// Your program element business logic goes here ...
		try {
			Element.sendKeys(input);
			nlpResponseModel.setMessage("Input entered into element");
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			// TODO: handle exception
			nlpResponseModel.setMessage("Fail to enter input into Element");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
//          String string3 = "Return Value";
//          nlpResponseModel.getAttributes().put("string3", string3);
		return nlpResponseModel;
	}
}