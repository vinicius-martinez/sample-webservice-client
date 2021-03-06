package com.redhat.sample.webservice.client;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.8.redhat-1
 * 2018-01-29T12:51:16.075-02:00 Generated source version: 3.1.8.redhat-1
 * 
 */
@WebService(targetNamespace = "http://ws.sample.redhat.com/", name = "HelloWorldService")
@XmlSeeAlso({ ObjectFactory.class })
public interface HelloWorldService {

	@WebMethod
	@RequestWrapper(localName = "sayHello", targetNamespace = "http://ws.sample.redhat.com/", className = "com.redhat.sample.webservice.client.SayHello")
	@ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://ws.sample.redhat.com/", className = "com.redhat.sample.webservice.client.SayHelloResponse")
	@WebResult(name = "return", targetNamespace = "")
	public java.lang.String sayHello();
}
