package com.test.aop;

import org.springframework.stereotype.Component;

@Component
public class MyCalculateByCglib {
	
	
	public int add(int a, int b) {
		return a+b;
	}

	
	public int sub(int a, int b) {
		return a-b;
	}

	
	public int mul(int a, int b) {
		return a*b;
	}

	
	public int dev(int a, int b) {
		return a/b;
	}

}
