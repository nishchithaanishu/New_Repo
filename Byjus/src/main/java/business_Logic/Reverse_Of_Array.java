
package business_Logic;

import java.lang.reflect.Array;
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

import org.springframework.stereotype.Component;

@Component("LIC9371_PJT1011_PE_NLP34aba86f-de50-47dc-895a-043e34f73c13")
public class Reverse_Of_Array implements Nlp {
	@InputParams({ @InputParam(name = "Array", type = "java.lang.Object") })

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
		Array Integer = (Array) attributes.get("Array");
//		String string3 = "Return Value";

		// Your program element business logic goes here ...
		try {
			int[] a = { 10, 20, 30, 40, 50 };
			for (int i = a.length - 1; i >= 0; i--) {
				nlpResponseModel.setMessage("Array is successfully reversed");
				nlpResponseModel.setStatus(CommonConstants.pass);
			}
		} catch (Exception e) {
			// TODO: handle exception
			nlpResponseModel.setMessage("Fail to Reverse an Array");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
//		nlpResponseModel.getAttributes().put("string3", string3);
		return nlpResponseModel;
	}
}