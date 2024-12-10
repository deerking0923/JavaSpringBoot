package com.springboot.biz;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Hellolombok {

	private final String hello;
	private final int num;
	public static void main(String[] args) {
		Hellolombok he = new Hellolombok("서인하", 24);
		System.out.println(he.getHello());
		System.out.println(he.getNum());
	}

}
