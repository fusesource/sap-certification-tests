package org.jboss.fuse.TEST_8_2_18_SWO_INVOKE;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;
import org.fusesource.camel.component.sap.model.rfc.Table;

public class CreateRequest {

	public void createRequest(Exchange exchange) throws Exception {

		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint("sap-srfc-destination:quickstartDest:SWO_INVOKE", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		
		// Retrive Object Handle from Exchange Message
		Structure objCreateResponse = exchange.getIn().getBody(Structure.class);
		Integer objectHandle = objCreateResponse.get("OBJECT", Integer.class);
		
		// Store Object Handle into Exchange
		exchange.setProperty("org.jboss.fuse.TEST_8_2_18_SWO_INVOKE.OBJECT_HANDLE", objectHandle);
		
		request.put("OBJECT", objectHandle);
		request.put("VERB", "GetList");
		request.put("ACCESS", "C");
		request.put("SYNCHRON", "*");
		request.put("UNSORTED_CONTAINER", "");
		
		exchange.getIn().setBody(request);
	}

}
