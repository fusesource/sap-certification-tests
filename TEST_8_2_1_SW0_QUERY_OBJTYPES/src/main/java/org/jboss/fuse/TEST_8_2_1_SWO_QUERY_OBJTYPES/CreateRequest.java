package org.jboss.fuse.TEST_8_2_1_SWO_QUERY_OBJTYPES;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;

public class CreateRequest {

	public void createRequest(Exchange exchange) throws Exception {

		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint("sap-srfc-destination:quickstartDest:SWO_QUERY_OBJTYPES", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		
		request.put("OBJTYPE", "");
		request.put("OBJNAME", "");
		request.put("CHANGE_USER", "");
		request.put("LANGUAGE", "EN");
		request.put("OBJTYPECLASS_SAP", "");
		request.put("OBJTYPECLASS_IF", "");
		request.put("INTERFACE", "");
		request.put("TEXTPATTERN", "");
		request.put("RELEASED", "*");
		request.put("WITH_IMPLEMENTED", "X");
		request.put("WITH_OBSOLETE", "");
		request.put("WITH_DELEGATED_OBJTYPES", "X");
		
		exchange.getIn().setBody(request);
	}

}
