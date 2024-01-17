
package business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import org.springframework.stereotype.Component;

@Component("LIC9371_PJT1011_PE_NLP3cd40d25-d37d-4a87-a5ae-dd7ce881165e")
public class Right_Click implements Nlp {
	@InputParams({ @InputParam(name = "Element", type = "org.openqa.selenium.WebElement") })

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
		WebDriver driver = nlpRequestModel.getWebDriver();
//          String string3 = "Return Value";

		// Your program element business logic goes here ...
		try {
			Actions actions = new Actions(driver);

			actions.contextClick(Element).perform();
			nlpResponseModel.setMessage("Successfully right click on Elment");
			nlpResponseModel.setStatus(CommonConstants.pass);

		} catch (Exception e) {
			// TODO: handle exception
			nlpResponseModel.setMessage("Failed to right click on Elment");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}

//          nlpResponseModel.getAttributes().put("string3", string3);
		return nlpResponseModel;
	}
}