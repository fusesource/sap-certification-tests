package org.jboss.fuse.TEST_8_2_3_RPY_BOR_TREE_INIT;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;

public class CreateRequest {

	public void createRequest(Exchange exchange) throws Exception {

		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint("sap-srfc-destination:quickstartDest:RPY_BOR_TREE_INIT", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		
		Structure filterObjectTypes = request.get("FILTER_OBJECT_TYPES", Structure.class);
		filterObjectTypes.put("ALLOBJTYPS", "X");
		filterObjectTypes.put("MODELLED", "X");
		filterObjectTypes.put("IMPLEMNTED", "X");
		filterObjectTypes.put("RELEASED", "X");
		filterObjectTypes.put("OBSOLETE", "X");
		filterObjectTypes.put("BUSOBJECT", "X");
		filterObjectTypes.put("ORGTYPES", "X");
		filterObjectTypes.put("OTHERS", "X");
		filterObjectTypes.put("LOCAL", "X");
		filterObjectTypes.put("GLOBAL", "X");
		filterObjectTypes.put("WITH_INTF", "X");
		
		Structure filterRelationships = request.get("FILTER_RELATIONSHIPS", Structure.class);
		filterRelationships.put("ALLRELSHIP", "X");
		filterRelationships.put("INHSUB", "X");
		filterRelationships.put("COMPPART", "X");

		Structure filterMiscellaneous = request.get("FILTER_MISCELLANEOUS", Structure.class);
		filterMiscellaneous.put("COMPHIER", "X");

		exchange.getIn().setBody(request);
	}

}
