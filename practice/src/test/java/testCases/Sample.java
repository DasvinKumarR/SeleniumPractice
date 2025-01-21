package testCases;

import java.util.Scanner;

public class Sample {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your name: ");
		String name = scanner.nextLine();
		System.out.println("Hi!, "+name);
		
		String[] inputArr = name.split("");
		String ouput = "";
		for(int i=inputArr.length-1; i>=0; i--) {
			ouput += inputArr[i];
		}
		System.out.println(ouput);
		String[] word = ouput.split("");
		String symbolBetweenWords = String.join("-", word);
		System.out.println(symbolBetweenWords);
		
		int value = scanner.nextInt();
		int reversedNum = 0;
		while(value != 0) {
			int digit = value%10;
			reversedNum = reversedNum * 10 + digit;
			value /= 10;
		}
		System.out.println(reversedNum);
		scanner.close();
	}

}
