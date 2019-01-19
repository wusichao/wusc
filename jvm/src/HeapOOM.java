package com.wusc;

import java.util.List;
public class HeapOOM {
	public static void main (String[] args) {
		List<Object> lists = new ArrayList<>();
		while (true) {
			lists.add(new Object());
			int i = 0;
			System.out.println(i++);
			if (i > 10) {
			break;}
		}
	}

}
