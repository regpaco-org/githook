package yadhav.githook;


import org.apache.catalina.filters.AddDefaultCharsetFilter.ResponseWrapper;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WebhookController {
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(WebhookController.class);

	private static final String XGitHubEvent = "X-GitHub-Event";
	private static final String XGitHubDelivery = "X-GitHub-Delivery";
	private static final String XHubSignature = "X-Hub-Signature";
	private static final String SUCCESS = "Success";
	private static final String ERROR = "Error";
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<String>  webhooks(@RequestHeader(XGitHubEvent) String xgithubevent, @RequestHeader(XGitHubDelivery) String xgithubdelivery, @RequestHeader(XHubSignature) String xhubsignature,@RequestBody String payload) {
    	// if signature is empty or invalid return 401
    	//if (!StringUtils.hasText(signature) || !signature.equalsIgnoreCase(SIGNATURE)) {
    	//	return new ResponseEntity<>(ERROR, HttpStatus.FORBIDDEN);
    	//}
    	LOG.info("request recieved ");
    	LOG.info(XGitHubDelivery+"="+xgithubdelivery);
    	LOG.info(XHubSignature+"="+xhubsignature);
    	LOG.info(XGitHubEvent+"="+xgithubevent);
    	
		LOG.info(payload);

    	return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}
}
