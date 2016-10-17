RFC Function Module Test Drive  
=======================================================================================================================
**Certifies the SAP Camel Component's ability to invoke Remote Function Modules in SAP and process their results while running in a Fuse camel runtime.**  
![SAP Certification](../sap_tool_suite.png "SAP Tool Suite")

* * *
Author: William Collins - Fuse Team  
Summary: The RFC Function Module Test Drive certifies JBoss Fuse SAP Camel Component's usage of the RFC APIs specified in Section 8.2 of the BOR API Test Product Profile for JBoss Fuse.
Target Product: Fuse  
Source: <http://github.com/fusesource/sap-certification-tests/>  

* * *

What is it?  
-----------  

This project implements and performs the certification tests specified in Section 8.2 of the BOR API Test Product Profile for JBoss Fuse. These tests certify the use by the JBoss Fuse SAP Camel Component of BAPI and RFC APIs of SAP.    

In this certification test, a route is started which invokes the following Remote Function Modules in SAP:

   * `SWO_QUERY_OBJTYPES`
   * `SWO_QUERY_API_OBJTYPES`
   * `RPY_BOR_TREE_INIT`
   * `RPY_BOR_TREE_EXPAND`
   * `SWO_QUERY_OBJTYPE_INFO`
   * `SWO_QUERY_OBJTYPE_INFOS`
   * `SWO_QUERY_OBJTYPE_DOCU`
   * `SWO_QUERY_BASEDATA`
   * `SWO_QUERY_KEYFIELDS`
   * `SWO_QUERY_ATTRIBUTES`
   * `SWO_QUERY_METHODS`
   * `SWO_QUERY_EVENTS`
   * `SWO_QUERY_PARAMETERS`
   * `SWO_QUERY_RETURNCODES`
   * `DDIF_FIELDINFO_GET`
   * `SWO_TYPE_INFO_GET`
   * `SWO_CREATE`
   * `SWO_INVOKE`
   * `SWO_FREE`
   * `SWO_OBJECT_ID_GET`
   * `SWO_OBJECT_ID_SET`
   * `SWO_SET_ENVIRONMENT`
   * `RFC_FUNCTION_DOCU_GET`
   * `RFC_GET_FUNCTION_INTERFACE`

The route creates a sub-directory for each Remote Function Module its invokes and the name of each sub-directory contains the name of the Remote Function Module invoked. Within each sub-directory it logs and stores in two time-stamped files (`request-<time-stamp>.xml` and `response-<time-stamp>.xml`) the request sent and the response received in that remote function call. The time-stamp indicates when the request was sent or when the response was received.  

System requirements
-------------------

Before building and running this quick start you will need:

* Maven 3.0.4 or higher
* JDK 1.7 or 1.8
* A JBoss Fuse 6.3 container not running with a Fabric
* SAP JCo3 and IDoc3 libraries (sapjco3.jar, sapidoc3.jar and JCo native library for your OS platform)

Configuring the Certification Test for your environment
-------------------------------------------------------

To configure the quick start for your environment: 

1. Deploy the JCo3 library jar and native library (for your platform) and IDoc3 library jar to the `lib` folder of your JBoss Fuse installation.  
2. In your JBoss Fuse installation, create and entry for the `org.osgi.framework.system.packages.extra` property with the following packages specified in that property:   

> org.osgi.framework.system.packages.extra = \  
>> com.sap.conn.idoc, \  
>> com.sap.conn.idoc.jco, \   
>> com.sap.conn.jco, \   
>> com.sap.conn.jco.ext, \   
>> com.sap.conn.jco.monitor, \  
>> com.sap.conn.jco.rt, \   
>> com.sap.conn.jco.server  

3. Edit the parent project's POM file (`../pom.xml`) and modify the `SAP Instance Configuration Configuration Parameters` properties to match the connection configuration for your SAP instance.  

Build and Run the Certification Test
------------------------------------

To build and run the certification test:

1. Change your working directory to the `8_2_RFC_Function_Module_Test_Drive` directory.
* Run `mvn clean install` to build the certification test.
* In your JBoss Fuse installation directory run, `./bin/fuse` to start the JBoss Fuse runtime.
* In the JBoss Fuse console, run `osgi:install -s mvn:org.fusesource/camel-sap` to install the JBoss Fuse SAP Camel component. Note the bundle number for the component bundle returned by this command.  
* In the JBoss Fuse console, run `osgi:install -s mvn:org.jboss.fuse/Performance_Load_And_Unicode_Test_Drive` to install and run the certification test. Note the bundle number for the certification test returned by this command.  

Evaluating Certification Test Results  
-------------------------------------  

**TEST_8_2_1_SWO_QUERY_OBJTYPES**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, the identifiers of the SAP Business Object types held in the Business Object Repository of an R/3 System are retrieved by invoking the `SWO_QUERY_OBJTYPES` remote function module. The certification test configures the RFC request to query for all identifiers in the BOR and displays the results of the query in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_1_SWO_QUERY_OBJTYPES` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_2_SWO_QUERY_API_OBJTYPES**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, the identifiers of the SAP Business Object types held in the Business Object Repository of an R/3 System are retrieved by invoking the `SWO_QUERY_API_OBJTYPES` remote function module. The certification test configures the RFC request to query for all identifiers in the BOR and displays the results of the query in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_1_SWO_QUERY_API_OBJTYPES` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_3_RPY_BOR_TREE_INIT**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, the top-level tree structure of the Business Object Repository of an R/3 System is retrieved by invoking the `RPY_BOR_TREE_INIT` remote function module. The certification test configures the RFC request to retrieve the entire  BOR tree and displays the tree in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_3_RPY_BOR_TREE_INIT` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_4_RPY_BOR_TREE_EXPAND**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, a node is expanded in the tree structure of the Business Object Repository of an R/3 System by invoking the `RPY_BOR_TREE_EXPAND` remote function module. The certification test configures the RFC request to retrieve all relationships in the  BOR sub-tree and displays that tree in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_4_RPY_BOR_TREE_EXPAND` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_5_SWO_QUERY_OBJTYPE_INFO**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, the certification test reads information about a specific SAP Business Object type in the Business Object Repository of an R/3 System. The certification test invokes the `SWO_QUERY_OBJTYPE_INFO` remote function module to retrieve all base data, key fields, attributes, methods and events of an SAP Business Object type and displays that data in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_5_SWO_QUERY_OBJTYPE_INFO` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_6_SWO_QUERY_OBJTYPE_INFOS**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, the certification test reads information about a specific set of SAP Business Object types in the Business Object Repository of an R/3 System. The certification test invokes the `SWO_QUERY_OBJTYPE_INFOS` remote function module to retrieve all documentation of an SAP Business Object type and displays that data in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_6_SWO_QUERY_OBJTYPE_INFOS` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_7_SWO_QUERY_OBJTYPE_DOCU**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, the certification test reads the entire documentation about about a specific SAP Business Object type in the Business Object Repository of an R/3 System. The certification test invokes the `SWO_QUERY_OBJTYPE_DOCU` remote function module to retrieve all base data, key fields, attributes, methods and events of an SAP Business Object type and displays that data in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_7_SWO_QUERY_OBJTYPE_DOCU` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_8_SWO_QUERY_BASEDATA**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, the certification test reads the base data about a specific SAP Business Object type in the Business Object Repository of an R/3 System. The certification test invokes the `SWO_QUERY_BASEDATA` remote function module to retrieve all base data of an SAP Business Object type and displays that data in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_8_SWO_QUERY_BASEDATA` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_9_SWO_QUERY_KEYFIELDS**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, the certification test reads the key fields of a specific SAP Business Object type in the Business Object Repository of an R/3 System. The certification test invokes the `SWO_QUERY_KEYFIELDS` remote function module to retrieve key fields of an SAP Business Object type and displays that data in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_9_SWO_QUERY_KEYFIELDS` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_10_SWO_QUERY_ATTRIBUTES**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, the certification test reads the attributes of a specific SAP Business Object type in the Business Object Repository of an R/3 System. The certification test invokes the `SWO_QUERY_ATTRIBUTES` remote function module to retrieve attributes of an SAP Business Object type and displays that data in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_10_SWO_QUERY_ATTRIBUTES` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_11_SWO_QUERY_METHODS**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, the certification test reads the methods of a specific SAP Business Object type in the Business Object Repository of an R/3 System. The certification test invokes the `SWO_QUERY_METHODS` remote function module to retrieve methods of an SAP Business Object type and displays that data in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_11_SWO_QUERY_METHODS` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_12_SWO_QUERY_EVENTS**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, the certification test reads the events of a specific SAP Business Object type in the Business Object Repository of an R/3 System. The certification test invokes the `SWO_QUERY_EVENTS` remote function module to retrieve events of an SAP Business Object type and displays that data in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_12_SWO_QUERY_EVENTS` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_13_SWO_QUERY_PARAMETERS**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, the certification test reads the parameters of a specific SAP Business Object type in the Business Object Repository of an R/3 System. The certification test invokes the `SWO_QUERY_PARAMETERS` remote function module to retrieve parameters of an SAP Business Object type and displays that data in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_13_SWO_QUERY_PARAMETERS` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_14_SWO_QUERY_RETURNCODES**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, the certification test reads the return codes of a specific SAP Business Object type in the Business Object Repository of an R/3 System. The certification test invokes the `SWO_QUERY_RETURNCODES` remote function module to retrieve return codes of an SAP Business Object type and displays that data in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_14_SWO_QUERY_RETURNCODES` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_15_DDIF_FIELDINFO_GET**  

This test is part of the set of Object Browser Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component retrieves information about the SAP Business Object types in the BOR and provides results that could be displayed in a browser type application.     

In this test, the certification test reads the runtime information of a type in the ABAP Dictionary of an R/3 System. The certification test invokes the `DDIF_FIELDINFO_GET` remote function module to retrieve the runtime information of an ABAP type and displays that data in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_15_DDIF_FIELDINFO_GET` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_16_SWO_TYPE_INFO_GET**  

This test is part of the set of Object Runtime Environment Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component can directly access attributes and process methods of SAP Business Object types using the BOR runtime environment. By making calls to the function modules provided by the BOR Programming Interface, JBoss Fuse can create object links to the required SAP Business Object types and invoke their methods or read their attributes.     

In this test, the certification test retrieves the type information of an object type in the Business Object Repository of an R/3 System. The certification test invokes the `SWO_TYPE_INFO_GET` remote function module to retrieve the type information about an object type and displays that data in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_16_SWO_TYPE_INFO_GET` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_17_SWO_CREATE**  

This test is part of the set of Object Runtime Environment Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component can directly access attributes and process methods of SAP Business Object types using the BOR runtime environment. By making calls to the function modules provided by the BOR Programming Interface, JBoss Fuse can create object links to the required SAP Business Object types and invoke their methods or read their attributes.     

In this test, the certification test creates a runtime object of the a requested SAP Business Object type. The certification test invokes the `SWO_CREATE` remote function module to create a runtime object and displays the result of that creation in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_17_SWO_CREATE` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_18_SWO_INVOKE**  

This test is part of the set of Object Runtime Environment Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component can directly access attributes and process methods of SAP Business Object types using the BOR runtime environment. By making calls to the function modules provided by the BOR Programming Interface, JBoss Fuse can create object links to the required SAP Business Object types and invoke their methods or read their attributes.     

In this test, the certification test invokes a method on a runtime object. The certification test invokes the `SWO_INVOKE` remote function module to invoke a runtime object with an object handle returned in a previous `SWO_CREATE` invocation and displays the result of that invocation in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_18_SWO_INVOKE` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_19_SWO_FREE**  

This test is part of the set of Object Runtime Environment Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component can directly access attributes and process methods of SAP Business Object types using the BOR runtime environment. By making calls to the function modules provided by the BOR Programming Interface, JBoss Fuse can create object links to the required SAP Business Object types and invoke their methods or read their attributes.     

In this test, the certification test releases the runtime object created for an SAP Business Object type. The certification test invokes the `SWO_FREE` remote function module to release the runtime object with an object handle returned in a previous `SWO_CREATE` invocation and displays the result of that invocation in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_19_SWO_FREE` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_20_SWO_OBJECT_ID_GET**  

This test is part of the set of Object Runtime Environment Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component can directly access attributes and process methods of SAP Business Object types using the BOR runtime environment. By making calls to the function modules provided by the BOR Programming Interface, JBoss Fuse can create object links to the required SAP Business Object types and invoke their methods or read their attributes.     

In this test, the certification test reads the persistent identification of a runtime object. The certification test invokes the `SWO_OBJECT_ID_GET` remote function module to get the persistent identification (OBJID) of a runtime object and displays the result of that invocation in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_20_SWO_OBJECT_ID_GET` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_21_SWO_OBJECT_ID_SET**  

This test is part of the set of Object Runtime Environment Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component can directly access attributes and process methods of SAP Business Object types using the BOR runtime environment. By making calls to the function modules provided by the BOR Programming Interface, JBoss Fuse can create object links to the required SAP Business Object types and invoke their methods or read their attributes.     

In this test, the certification test reads the persistent identification of a runtime object. The certification test invokes the `SWO_OBJECT_ID_SET` remote function module to set the persistent identification (OBJID) of a runtime object and displays the result of that invocation in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_21_SWO_OBJECT_ID_SET` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_22_SWO_SET_ENVIRONMENT**  

This test is part of the set of Object Runtime Environment Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component can directly access attributes and process methods of SAP Business Object types using the BOR runtime environment. By making calls to the function modules provided by the BOR Programming Interface, JBoss Fuse can create object links to the required SAP Business Object types and invoke their methods or read their attributes.     

In this test, the certification test configures the behavior of the runtime system by setting the environment variables of the runtime environment. The certification test invokes the `SWO_SET_ENVIRONMENT` remote function module to set the persistent identification (OBJID) of a runtime object and displays the result of that invocation in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_22_SWO_SET_ENVIRONMENT` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_23_RFC_FUNCTION_DOCU_GET**  

This test is part of the set of the RFC1 Group Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component can invoke selected remote function modules in the RFC1 Group as specified in the BOR API Test Product Profile for JBoss Fuse.     

In this test, the certification test retrieves the documentation for a remote function module. The certification test invokes the `RFC_FUNCTION_DOCU_GET` remote function module to retrieve the documentation of a remote function module and displays the result of that invocation in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_23_RFC_FUNCTION_DOCU_GET` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

**TEST_8_2_25_RFC_GET_FUNCTION_INTERFACE**  

This test is part of the set of the RFC1 Group Scenario tests which demonstrates how the JBoss Fuse SAP Camel Component can invoke selected remote function modules in the RFC1 Group as specified in the BOR API Test Product Profile for JBoss Fuse.     

In this test, the certification test retrieves the complete information about a remote function module interface. The certification test invokes the `RFC_GET_FUNCTION_INTERFACE` remote function module to retrieve the complete information of a remote function module interface and displays the result of that invocation in the serialized form of the response message, `response-<time-stamp>.xml`, stored in the `TEST_8_2_25_RFC_GET_FUNCTION_INTERFACE` sub-directory of the `work` folder. The performance of this call can be determined by the difference between the time-stamp of the `response-<time-stamp>.xml` file and the `request-<time-stamp>.xml` file.      

Stopping and Uninstalling the Certification Test   
------------------------------------------------  

To uninstall the certification test and stop the JBoss Fuse run-time perform the following in the JBoss Fuse console:  

1. Enter Ctrl-c to stop monitoring the JBoss Fuse log.
* Run `osgi:uninstall <certification-test-bundle-number>` providing the bundle number for the certification test bundle. 
* Run `osgi:uninstall <camel-sap-bundle-number>` providing the bundle number for the component bundle. 
* Run `osgi:shutdown -f` to shutdown the JBoss Fuse runtime.
