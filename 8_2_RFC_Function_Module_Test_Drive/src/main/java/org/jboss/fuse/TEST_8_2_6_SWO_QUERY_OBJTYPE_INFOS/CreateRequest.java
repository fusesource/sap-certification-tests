package org.jboss.fuse.TEST_8_2_6_SWO_QUERY_OBJTYPE_INFOS;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;
import org.fusesource.camel.component.sap.model.rfc.Table;

public class CreateRequest {

	public void createRequest(Exchange exchange) throws Exception {

		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint("sap-srfc-destination:quickstartDest:SWO_QUERY_OBJTYPE_INFOS", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		
		request.put("TEXT", "X");
		request.put("LANGUAGE", "EN");

		Table objTypes = request.get("OBJTYPES", Table.class);
		Structure objType = objTypes.add();
		objType.put("OBJTYPE", "BUS1001");
		
		exchange.getIn().setBody(request);
	}

}
