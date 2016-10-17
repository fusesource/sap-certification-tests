Performance, Load and Unicode Test Drive  
=======================================================================================================================
**Certifies the performance, load and UNICODE capability of the SAP Camel Component running in a Fuse camel runtime.**  
![SAP Certification](../sap_tool_suite.png "SAP Tool Suite")

* * *
Author: William Collins - Fuse Team  
Summary: SAP requires to include the performance load testing during Test Drive. These performance load test cases will determine if the product can handle a pre-defined number of users or amount of data without running out of resources or having transactions suffer excessive delay. .       
Target Product: Fuse  
Source: <http://github.com/fusesource/sap-certification-tests/>  

* * *

What is it?  
-----------  

This project implements and performs the certification tests specified in Sections 8.3 and 8.4 of the BOR API Test Product Profile for JBoss Fuse. These tests certify the performance, load and UNICODE capabilities of the SAP Camel Component.    

In this certification test, 21 identical routes are started. Each route calls the RFC\_READ\_TABLE remote function module in SAP. These routes log and store in two time-stamped files (`request-<time-stamp>.xml` and `response-<time-stamp>.xml`) the request sent and the response received in their remote function call. The time-stamp indicates when the request was sent or when the response was received. In addition, each route posts in a time-stamped text file (`result-<time-stamp>.txt`) the contents of the RFCDOC table returned in their call. Each route stores these files in a route specific sub-directory of the JBoss Fuse installation's `work` directory. A routes sub-directory is named `TEST_8_3-4_RFC_READ_TABLE-<n>` where `<n>` indicates the instance of the route storing these files. 

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
2. In your JBoss Fuse installation, copy the `org.osgi.framework.system.packages.extra` property from the config properties file (`etc/config.properties`) to the custom properties file (`etc/custom.properties`) and append the following packages to the copied property:  

> org.osgi.framework.system.packages.extra = \  
>> ... \  
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

To build and run the quick start:

1. Change your working directory to the `8_3-4_Performance_Load_And_Unicode_Test_Drive` directory.
* Run `mvn clean install` to build the quick start.
* In your JBoss Fuse installation directory run, `./bin/fuse` to start the JBoss Fuse runtime.
* In the JBoss Fuse console, run `osgi:install -s mvn:org.fusesource/camel-sap` to install the JBoss Fuse SAP Camel component. Note the bundle number for the component bundle returned by this command.  
* In the JBoss Fuse console, run `osgi:install -s mvn:org.jboss.fuse/Performance_Load_And_Unicode_Test_Drive` to install and run the certification test. Note the bundle number for the certification test returned by this command.  

Evaluating Certification Test Results  
-------------------------------------  

**Have multiple connections (>20) to SAP server at the same time**  

That the SAP Camel Component can successfully establish 21 simultaneous connections can be determined by the successful start of each route and the successful sending and receiving of request and response messages by each route over its unique connection. Examine the serialized form of the response message, `response-<time-stamp>.xml`, for each route and verify that the contents of the `RFCDOC` table was passed in the `DATA` response parameter. If so, each route then successfully established a distinct and simultaneous connection.   

**Call a BAPI that would return a large amount of data**  

That the SAP Camel Component can successfully return a large amount of data in a call to a BAPI can be determined by the successful start of each route and the successful sending and receiving of request and response messages by each route over its unique connection. Examine the serialized form of the response message, `response-<time-stamp>.xml` for each route and verify that over 8000 rows of data from the `RFCDOC` table was received in the response. This can be verified by executing the following shell command in each route's `work` sub-directory:  

  ```  
  
	$> cat response-<time-stamp>.xml |grep row | wc -l  
	
  ```  

The number returned by this shell command will indicate the number of rows of data from the `RFCDOC` table that were returned in the response.  


**Post document with Chinese  character-Unicode test**  

That the SAP Camel Component can successfully post a document with Chinese UNICODE characters can be determined by each route successfully posting a `result-<time-stamp>.txt` document in its `work` sub-directory which contains Chinese UNICODE characters. Examine the `result-<time-stamp>.txt` document for each route and verify that the lines with an `RFCLANG` value of `1` properly display any Chinese characters contained in that line. 


Stopping and Uninstalling the Certification Test   
------------------------------------------------  

To uninstall the certification test and stop the JBoss Fuse run-time perform the following in the JBoss Fuse console:  

1. Enter Ctrl-c to stop monitoring the JBoss Fuse log.
* Run `osgi:uninstall <certification-test-bundle-number>` providing the bundle number for the certification test bundle. 
* Run `osgi:uninstall <camel-sap-bundle-number>` providing the bundle number for the component bundle. 
* Run `osgi:shutdown -f` to shutdown the JBoss Fuse runtime.
