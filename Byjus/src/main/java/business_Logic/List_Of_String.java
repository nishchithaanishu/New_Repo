
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

import org.springframework.stereotype.Component;


@Component("LIC9371_PJT1011_PE_NLP8d07d723-797c-45ca-bbf0-390abcb07a2b")
public class List_Of_String implements Nlp {
	@InputParams({ @InputParam(name = "string", type = "java.lang.String") })
//	@ReturnType(name = "string3", type = "java.lang.String")

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
		String string = (String) attributes.get("string");
//		String string2 = (String) attributes.get("string2");

		// Your program element business logic goes here ...
		try {
			List<String> stringList = new ArrayList<>();

			stringList.add("apple");
			stringList.add("banana");
			stringList.add("cherry");

			boolean isAscending = isListInAscendingOrder(stringList);

			if (isAscending) {
				nlpResponseModel.setMessage("The list is not in ascending order");
				nlpResponseModel.setStatus(CommonConstants.pass);
			} else {
				nlpResponseModel.setMessage("Fail to naviagte nlp");
				nlpResponseModel.setStatus(CommonConstants.fail);
			}

		} catch (Exception e) {
			// TODO: handle exception
			nlpResponseModel.setMessage("The lis not in ascending order");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
//		String string3 = "Return Value";
//		nlpResponseModel.getAttributes().put("string3", string3);
		return nlpResponseModel;
	}

	public static boolean isListInAscendingOrder(List<String> list) {
		for (int i = 1; i < list.size(); i++) {
			String current = list.get(i);
			String previous = list.get(i - 1);

			if (current.compareTo(previous) < 0) {
				return false;
			}
		}

		return true;
	}
}
