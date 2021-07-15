package com.cloudmandu.dictionary.inputHelper;

import java.util.Scanner;

public class InputHelper {
	
	private Scanner scanner = new Scanner(System.in);
	
	public String getString() {
		return scanner.next();
	}
	
	public char getChar() {
		scanner.nextLine();
		return scanner.nextLine().charAt(0);
	}

}
