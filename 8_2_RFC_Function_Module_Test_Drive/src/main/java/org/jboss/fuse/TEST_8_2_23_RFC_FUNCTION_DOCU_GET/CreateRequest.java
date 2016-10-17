package org.jboss.fuse.TEST_8_2_23_RFC_FUNCTION_DOCU_GET;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;
import org.fusesource.camel.component.sap.model.rfc.Table;

public class CreateRequest {

	public void createRequest(Exchange exchange) throws Exception {

		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint("sap-srfc-destination:quickstartDest:RFC_FUNCTION_DOCU_GET", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		
		request.put("FUNCNAME", "SWO_QUERY_OBJTYPES");
		request.put("LANGUAGE", "EN");

		exchange.getIn().setBody(request);
	}

}
