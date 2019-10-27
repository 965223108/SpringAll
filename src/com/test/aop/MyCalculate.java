package com.test.aop;

import org.springframework.stereotype.Component;

@Component
public class MyCalculate implements Calculate{

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		return a*b;
	}

	@Override
	public int dev(int a, int b) {
		return a/b;
	}



}
