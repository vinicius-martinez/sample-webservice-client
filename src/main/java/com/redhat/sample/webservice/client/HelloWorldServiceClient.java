package com.redhat.sample.webservice.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

public class HelloWorldServiceClient implements HelloWorldService {

	private HelloWorldService helloWorldService;

	public HelloWorldServiceClient(String endpoint, URL wsdlUrl) {
		HelloWorldService_Service helloWorldService_Service = new HelloWorldService_Service(wsdlUrl);
		helloWorldService = helloWorldService_Service.getHelloWorld();
		((BindingProvider)helloWorldService).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
	}
	
	public HelloWorldServiceClient(String endpoint, URL wsdlUrl, QName qName){
		Service service = Service.create(wsdlUrl, qName);
		helloWorldService = service.getPort(HelloWorldService.class);
		((BindingProvider)helloWorldService).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
	}

	public String sayHello() {
		return helloWorldService.sayHello();
	}

}
