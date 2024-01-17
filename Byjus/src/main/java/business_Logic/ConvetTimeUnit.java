
package business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC9371_PJT1011_PE_NLP23a4b09c-d382-436c-a7a5-4425a692a0d8")
public class ConvetTimeUnit implements Nlp {
	@InputParams({ @InputParam(name = "Enter miliseconds", type = "java.lang.Long"),
			@InputParam(name = "Convert to", type = "java.lang.String") })
	@ReturnType(name = "return value", type = "java.lang.Long")

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
		Long miliSeconds = (Long) attributes.get("Enter miliseconds");
		String unitToConvert = (String) attributes.get("Convert to");
		long convertedTime = 0;

		// Your program element business logic goes here ...
		try {
			if (unitToConvert.equalsIgnoreCase("minutes") || unitToConvert.equalsIgnoreCase("minute")) {
				convertedTime = TimeUnit.MILLISECONDS.toMinutes(miliSeconds);
				nlpResponseModel.setMessage("Successfully convert to Time in minutes");
				nlpResponseModel.setStatus(CommonConstants.pass);
			} else if (unitToConvert.equalsIgnoreCase("seconds") || unitToConvert.equalsIgnoreCase("second")) {
				convertedTime = TimeUnit.MILLISECONDS.toSeconds(miliSeconds);
				nlpResponseModel.setMessage("Successfully convert to Time  in seconds");
				nlpResponseModel.setStatus(CommonConstants.pass);

			} else {
				nlpResponseModel.setMessage("Convertion unit is not defined");
				nlpResponseModel.setStatus(CommonConstants.fail);
			}

		}

		catch (Exception e) {
			// TODO: handle exception

			nlpResponseModel.setMessage("Failed to execute nlp");
			nlpResponseModel.setStatus(CommonConstants.fail);

		}
		nlpResponseModel.getAttributes().put("return value", convertedTime);
		return nlpResponseModel;
	}
}