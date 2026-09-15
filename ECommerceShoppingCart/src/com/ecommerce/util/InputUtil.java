package com.ecommerce.util;

import java.util.Scanner;

public class InputUtil {
	
	static Scanner sc=new Scanner(System.in);
	
	public static int readInt() {
		return sc.nextInt();
	}

	public static double readDouble() {
		return sc.nextDouble();
	}

	public static String readString() {
		return sc.next();
	}
}
