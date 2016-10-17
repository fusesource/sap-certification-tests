package org.jboss.fuse.TEST_8_2_22_SWO_SET_ENVIRONMENT;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;
import org.fusesource.camel.component.sap.model.rfc.Table;

public class CreateRequest {

	public void createRequest(Exchange exchange) throws Exception {

		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint("sap-srfc-destination:quickstartDest:SWO_SET_ENVIRONMENT", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		
		request.put("DEBUG", "*");
		request.put("RETURN_DIALOG", "*");
		request.put("RETURN_TEXT", "*");
		request.put("NO_GUI", "*");
		request.put("TRACE", "*");
		request.put("EDITOR_MODE", "*");
		request.put("CONTAINER_COMPRESSION", "*");
		request.put("LOCAL_RUNTIME", "*");
		request.put("CHAINED_DELEGATION", "*");

		exchange.getIn().setBody(request);
	}

}
