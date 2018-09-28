package com.wusc;

import com.wusc.service.*;
import java.util.Map;
public class HelloWorld{
	private static HelloWorldService  service = new HelloWorldService();
	public static void main(String [] args){
	for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
            Thread thread = (Thread) stackTrace.getKey();
            StackTraceElement[] stack = (StackTraceElement[]) stackTrace.getValue();
            if (thread.equals(Thread.currentThread())) {
                continue;
            }
            System.out.println("线程：" + thread.getName());
            for (StackTraceElement stackTraceElement : stack) {
                System.out.println(stackTraceElement);
            }
        }
		service.say("{\"name\":\"wusc\",\"age\":12}");
	}
}
