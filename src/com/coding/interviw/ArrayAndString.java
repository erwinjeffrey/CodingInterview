package com.coding.interviw;



public class ArrayAndString {



	public static void main(String[] args) {
	
		System.out.println(isUnique("abcza"));
		System.out.println("permutation: " + checkPermutation("abc", "abc"));
		System.out.println(urlLify("Mr John Smith    ",13));
		System.out.println(replaceSpaces("Mr John Smith    ".toCharArray(),13));
	

	}

	private static boolean isUnique(String input) {

		boolean[] alphabet = new boolean[26];
		for (int i = 0; i < input.length(); i++) {
			int characterPos = input.charAt(i) - 'a';
			if (alphabet[characterPos]) {
				return false;
			} else {
				alphabet[characterPos] = true;
			}
		}
		return true;
	}

	private static boolean checkPermutation(String inputOne, String inputTwo) {

		if (inputOne.length() != inputTwo.length()) {
			return false;
		}
		int[] letters = new int[128];

		for (int i = 0; i < inputOne.length(); i++) {
			letters[inputOne.charAt(i)]++;
		}

		for (int i = 0; i < inputTwo.length(); i++) {
			int c = inputTwo.charAt(i);
			letters[c]--;
			if (letters[c] < 0) {
				return false;
			}
		}
		return true;
	}

	private static char[] addExtraSpace(String input, int trueLength) {
		char[] chars = input.toCharArray();
		int size = trueLength - 1;

		int countSpace = 0;
		int countWhile = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == 32) {

				while (i < size) {
					chars[size + 1] = chars[size];
					chars[size] = ' ';
					size--;
				}
				countSpace++;
				countWhile++;

				if (countSpace == 2) {
					countSpace = 0;
					i += 1;
				}
				size = trueLength;
				size += countWhile;

			}

		}
		return chars;
	}

	private static String urlLify(String input, int trueLength) {
		char[] chars = addExtraSpace(input, trueLength);
		int count = 1;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == 32) {

				switch (count) {
				case 1:

					chars[i]='%';
					count++;
					break;
					
				case 2:
					chars[i]='2';
					count++;
					break;
				
				case 3:
					chars[i] = '0';
					count = 1;
					break;
				}
			}
		}
		return new String(chars);
	}

	private static char [] replaceSpaces(char [] str, int trueLength){
		int spaceCount = 0;
		int index = 0;
		int i = 0;
		
		for(i=0;i< trueLength; i++){
			if(str[i] == ' '){
				spaceCount++;
			}
		}
		
		index = trueLength + (spaceCount * 2);
		if(trueLength < str.length){
			str[trueLength] = '\0';
		}
		for(i = trueLength -1; i >= 0; i--){
			if(str[i] == ' '){
				str[index -1] = '0';
				str[index -2] = '2';
				str[index -3] = '%';
			}else{
				str[index -1] = str[i];
				index--;
			}
		}
		return str;
	}
	
	

}
