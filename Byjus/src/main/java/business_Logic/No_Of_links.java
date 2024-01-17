
package business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC9371_PJT1011_PE_NLP7d3c229f-2f9f-4002-b1a7-135462cc8112")
public class No_Of_links implements Nlp {
	@ReturnType(name = "number of links", type = "java.lang.Integer")

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

		// Your program element business logic goes here ...
		int size = 0;
		try {
			List<WebElement> link = driver.findElements(By.xpath("//a"));
			size = link.size();
			nlpResponseModel.setMessage("Total number of links : " + size);
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			// TODO: handle exception
			nlpResponseModel.setMessage("Fail to fetch links");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
		nlpResponseModel.getAttributes().put("number of links", size);
		return nlpResponseModel;
	}
}