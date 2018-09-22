package com.wusc.service;

import com.alibaba.fastjson.*;
public class HelloWorldService{
	
	public void say(String voice){
		JSONObject jsonObject = JSON.parseObject(voice);

		System.out.println(jsonObject.getString("name"));
	}
}
