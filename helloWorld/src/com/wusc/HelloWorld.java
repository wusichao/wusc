package com.wusc;

import com.wusc.service.*;
public class HelloWorld{
	private static HelloWorldService  service = new HelloWorldService();
	public static void main(String [] args){
		service.say("my name is wusc");
	}
}