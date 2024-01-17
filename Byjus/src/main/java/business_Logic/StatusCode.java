
package business_Logic;

import java.net.HttpURLConnection;
import java.net.URL;
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
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC9371_PJT1011_PE_NLP6059b4fe-c88d-4b8a-9d94-c5f47d01489a")
public class StatusCode implements Nlp {
	@InputParams({ @InputParam(name = "url", type = "java.lang.String") })
	@ReturnType(name = "return value", type = "java.lang.Integer")

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
		String url1 = (String) attributes.get("url");
		WebDriver driver = nlpRequestModel.getWebDriver();
		int result = 0;
		// Your program element business logic goes here ...

		URL url = null;

		try {
			url = new URL(url1);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			result = connection.getResponseCode();
			nlpResponseModel.setMessage("status code will be fetched successfully");
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			// TODO: handle exception
			nlpResponseModel.setMessage("Fail to fetch status code");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
		nlpResponseModel.getAttributes().put("result", result);
		return nlpResponseModel;
	}
}