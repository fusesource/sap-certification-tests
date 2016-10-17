package org.jboss.fuse.TEST_8_2_25_RFC_GET_FUNCTION_INTERFACE;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;
import org.fusesource.camel.component.sap.model.rfc.Table;

public class CreateRequest {

	public void createRequest(Exchange exchange) throws Exception {

		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint("sap-srfc-destination:quickstartDest:RFC_GET_FUNCTION_INTERFACE", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		
		request.put("FUNCNAME", "SWO_QUERY_OBJTYPES");
		request.put("LANGUAGE", "EN");
		request.put("NONE_UNICODE_LENGTH", "");

		exchange.getIn().setBody(request);
	}

}
