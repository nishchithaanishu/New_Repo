
package business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
public class ListOfWebElement implements Nlp {	
    @InputParams({@InputParam(name = "elements", type = "org.openqa.selenium.WebElement")})
    @ReturnType(name = "text", type = "java.lang.String")

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
           List <WebElement> elements = (List<WebElement>) attributes.get("xpath");
//          String string2 = (String) attributes.get("string2");
           String text=null;
       
           try {
			for (WebElement ele : elements) {
                    text = ele.getText();
                   nlpResponseModel.setStatus(CommonConstants.pass);
                   nlpResponseModel.setMessage("Successfully fetched the text");
           }
			}
           
           catch(Exception e) {
        	   nlpResponseModel.setStatus(CommonConstants.fail);
               nlpResponseModel.setMessage("Text cannot be fetched");      	  
           }
          //String string3 = "text";
          nlpResponseModel.getAttributes().put("text", text);
          return nlpResponseModel;
    
 } }