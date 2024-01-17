
package business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;


@Component("LIC9371_PJT1011_PE_NLP97b802b6-f8bf-4796-ac53-c7188129208f")
public class AdditionOfTwoNumbers implements Nlp {
	@InputParams({ @InputParam(name = "number1", type = "java.lang.Integer"),
			@InputParam(name = "number2", type = "java.lang.Integer") })
	@ReturnType(name = "number3", type = "java.lang.Integer")

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
		int number1 = (Integer) attributes.get("number1");
		int number2 = (Integer) attributes.get("number2");
		int number3 = 0;

		// Your program element business logic goes here ...
		try {
			number3 = number1 + number2;
			nlpResponseModel.setMessage("Successfully added 2 numbers");
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			// TODO: handle exception
			nlpResponseModel.setMessage("Filed to add two numbers");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
		nlpResponseModel.getAttributes().put("number3", number3);
		return nlpResponseModel;
	}
}