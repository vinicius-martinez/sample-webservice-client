package com.redhat.sample.webservice.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Main {
	
	private static URL WSDL_URL = Main.class.getClassLoader().getResource("META-INF/wsdl/HelloWorldService.wsdl");
	private static QName QNAME = new QName("http://www.jboss.org/eap/quickstarts/wshelloworld/HelloWorld", "HelloWorldService");

	public static void main(String[] args) throws MalformedURLException {
		String endpointUrl = "http://localhost:9080/sample-webservice/HelloWorldService";
		//JaxWsProyFactory
	    JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	    factory.setServiceClass(HelloWorldService.class);
	    factory.setAddress(endpointUrl);
	    HelloWorldService helloWorldService = (HelloWorldService) factory.create();
	    String result = helloWorldService.sayHello();
	    System.out.println("Return >>>>> " + result);
	    //WSDL2JAVA
		HelloWorldServiceClient client = new HelloWorldServiceClient(endpointUrl, WSDL_URL);
		String result2 = client.sayHello();
		System.out.println("Return *****" + result2);
		//Jax-WS Proxy
		HelloWorldServiceClient client2 = new HelloWorldServiceClient(endpointUrl, WSDL_URL, QNAME);
		String result3 = client2.sayHello();
		System.out.println("Return #####" + result3);
	}

}
