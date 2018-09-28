package com.wusc.service;

import com.alibaba.fastjson.*;
import java.util.Map;
public class HelloWorldService{

	public void say(String voice){
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
		JSONObject jsonObject = JSON.parseObject(voice);

		System.out.println(jsonObject.getString("name"));
	}
}
}
