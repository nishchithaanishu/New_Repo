
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

@Component("LIC9371_PJT1011_PE_NLP79319722-b57c-48e3-8cc6-525d89fbd563")
public class Reverse_String implements Nlp {
	@InputParams({ @InputParam(name = "input", type = "java.lang.String") })
	@ReturnType(name = "returnValue", type = "java.lang.String")

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
		String input = (String) attributes.get("input");
		String returnValue = "";
		// Your program element business logic goes here ...
		try {
			for (int i = input.length() - 1; i >= 0; i--) {
				returnValue = returnValue + input.charAt(i);
			}
			nlpResponseModel.setMessage("Reverse string is " + returnValue);
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			nlpResponseModel.setMessage("Fail to execute NLP");
			nlpResponseModel.setStatus(CommonConstants.fail);
			// TODO: handle exception
		}
		nlpResponseModel.getAttributes().put("returnValue", returnValue);
		return nlpResponseModel;
	}
}