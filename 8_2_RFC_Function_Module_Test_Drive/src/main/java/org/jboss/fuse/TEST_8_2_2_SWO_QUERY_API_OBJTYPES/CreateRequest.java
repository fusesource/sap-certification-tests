package org.jboss.fuse.TEST_8_2_2_SWO_QUERY_API_OBJTYPES;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;

public class CreateRequest {

	public void createRequest(Exchange exchange) throws Exception {

		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint("sap-srfc-destination:quickstartDest:SWO_QUERY_API_OBJTYPES", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		
		request.put("OBJECT_NAME", " ");
		request.put("LANGUAGE", "EN");
		request.put("WITH_INTERNAL_API_METHODS", "X");
		request.put("WITH_IMPLEMENTED", "X");
		request.put("WITH_TEXTS", "X");
		request.put("WITH_OBJECT_NAMES", "X");

		exchange.getIn().setBody(request);
	}

}
