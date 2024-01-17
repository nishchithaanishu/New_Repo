
package business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import org.springframework.stereotype.Component;


@Component("LIC9371_PJT1011_PE_NLP30214975-98e0-44d8-b836-dcf66c1b3f50")
public class NavigateToUrl implements Nlp {
	@InputParams({ @InputParam(name = "url", type = "java.lang.String") })
	// @ReturnType(name = "string3", type = "java.lang.String")

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
		String url = (String) attributes.get("url");
		WebDriver driver = nlpRequestModel.getWebDriver();

		// Your program element business logic goes here ...
		try {

			driver.get(url);
			nlpResponseModel.setMessage("Successfully navigated to url");
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			// TODO: handle exception
			nlpResponseModel.setMessage("Failed to navigate to the url");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}

//          String string3 = "Return Value";
//          nlpResponseModel.getAttributes().put("string3", string3);
		return nlpResponseModel;
	}
}