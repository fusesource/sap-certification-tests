package org.jboss.fuse.TEST_8_2_21_SWO_OBJECT_ID_SET;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;
import org.fusesource.camel.component.sap.model.rfc.Table;

public class CreateRequest {

	public void createRequest(Exchange exchange) throws Exception {

		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint("sap-srfc-destination:quickstartDest:SWO_OBJECT_ID_SET", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		
		// Retrive Object Handle from Exchange
		Integer objectHandle = exchange.getProperty("org.jboss.fuse.TEST_8_2_18_SWO_INVOKE.OBJECT_HANDLE", Integer.class);

		request.put("OBJECT", objectHandle);
		request.put("OBJECTKEY", "TEST_8_2_21_SWO_OBJECT_ID_SET");
		request.put("REFRESH_OBJECT", "");

		exchange.getIn().setBody(request);
	}

}
