package com.coding.interviw;



public class ArrayAndString {



	public static void main(String[] args) {
	
		System.out.println(isUnique("abcza"));
		System.out.println("permutation: " + checkPermutation("abc", "abc"));
		System.out.println(urlLify("Mr John Smith    ",13));
		System.out.println(replaceSpaces("Mr John Smith    ".toCharArray(),13));
		System.out.println("isPalindromePerm: " + isPermutationOfPalindrome("tact Coa"));
		System.out.println("isPalindromePerm1: " + isPermutationOfPalindromeBookSolOne("tactcoapapa"));
	
		System.out.println("isOneAway: " + isOneAway("pale","aa"));
		System.out.println("isOneAway 2: " + oneEditAway("pale","ple"));
		System.out.println("oneEditAwayBook " + oneEditAwayBook("pale","ple"));
		System.out.println("compression " + compression("aabcccccaab"));
		System.out.println("StringCompressionBetter: " + StringCompressionBetter("aabcccccaab"));
		System.out.println("compressBad: " + compressGood("a"));
		System.out.println("compress " + compress("aabcccccaaa"));
		System.out.println("isRotation: " + isRotation("waterbottle","erbottlewate"));

		/*char [][] values ={
				           {'a','b','c'},
				           {'d','e','f'},
				           {'g','h','i'}};*/
		
		int [][] values ={
		           {1,2,3,4,5},
		           {6,7,8,9,10},
		           {11, 12, 13, 14, 15},
		           {16, 17, 18, 19, 20},
		           {21, 22, 23, 24, 25}
		           };
	
		int [][] valueZero ={
		           {1,2,3,4,5},
		           {6,7,8,9,9},
		           {1,8,1,1,0},
		           {2,3,8,5,6},
		           {2,3,1,3,1}
		           };
		
		//int [] [] result = rotate(values);
		int [][] result = setZerosMuchBetter(valueZero);
		for (int i = 0; i <= result.length -1; i++) {
			System.out.print("{");
			for(int j = 0; j <= result.length -1; j++){
				System.out.print(result[i][j] +  " ");
			}
			System.out.print("}");
			System.out.println();
		}

		Integer a = new Integer(3);
		Integer b = new Integer(3);
		System.out.println(a == b);
		
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
		int countWhile = -1;
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
		/*if(trueLength < str.length){
			str[trueLength] = '\0';
		}*/
		for(i = trueLength -1; i >= 0; i--){
			if(str[i] == ' '){
				str[index -1] = '0';
				str[index -2] = '2';
				str[index -3] = '%';
				index = index -3;
			}else{
				str[index -1] = str[i];
				index--;
			}
		}
		return str;
	}
	
	private static boolean isPermutationOfPalindrome(String input){
		
		String value = input.replaceAll(" ", "").toLowerCase();
		int [] letters = new int[26];
		int count=0;
		
		for(int i = 0 ; i< value.length();i++){
			int eachEl = value.charAt(i) - 'a';
			letters[eachEl]++;
		}
		
		for(int i: letters){
			if(i!= 0 && i%2 != 0){
				count++;
			}
			if(count > 1){
				return false;
			}
		}
		
		return true;
	}

	private static boolean isPermutationOfPalindromeBookSolOne(String phrase){
		int countOdd = 0;
		int [] table = new int [Character.getNumericValue('z') - Character.getNumericValue('a')+1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if(x != -1){
				table[x]++;
				if(table[x] % 2 == 1){
					countOdd++;
				}else{
					countOdd--;
				}
			}
		}
		return countOdd <= 1;
	}
	


	static int getCharNumber(Character c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && val<= z){
			return  val -a;
		}
		return -1;
	}
	
	static boolean isOneAway(String firtInput, String secondInput){
		
		if(Math.abs(firtInput.length()-secondInput.length()) > 1){
			return false;
		}
		int [] letters = new int[26];
		int count =0;
		for (int i = 0; i < firtInput.length(); i++) {
			int  value = firtInput.charAt(i) - 'a';
			letters[value]++;
		}
		for (int i = 0; i < secondInput.length(); i++) {
			int  value = secondInput.charAt(i) - 'a';
			if(letters[value] != 0){
				count++;
			}
			
		}
		return (firtInput.length() + secondInput.length()) -(count * 2) <=2;
	}
	
	static boolean oneEditAwayBook(String first, String second){
		if(Math.abs(first.length() - second.length()) > 1){
			return false;
		}
		
		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;
		
		int index = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while(index2 < s2.length() && index < s1.length()){
			if(s1.charAt(index) != s2.charAt(index2)){
				if(foundDifference){
					return false;
				}
				foundDifference = true;
				
				if(s1.length() == s2.length()){
					index++;
				}
			}else{
				index++;
			}
			index2++;
		}
		return true;
	}
	
	static boolean oneEditAway(String first, String second){
		if(first.length() == second.length()){
			return onEditReplace(first, second);
		}else if(first.length()+1 == second.length()){
			return oneEditInsert(first, second);
		}else if(first.length() - 1 == second.length()){
			return oneEditInsert(second, first);
		}
		return false;
	}
	static boolean onEditReplace(String s1, String s2){
		boolean foundDifference = false;
		for (int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)){
				if(foundDifference){
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}
	static boolean oneEditInsert(String s1, String s2){
		int index1 = 0;
		int index2 = 0;
		
		while(index1 < s2.length() && index1 < s1.length()){
			if(s1.charAt(index1) != s2.charAt(index2)){
				if(index1 != index2){
					return false;
				}
				index2++;
			}else{
				index1++;
				index2++;
			}
			
		}
		return true;
	}
	
	private static String compression(String input){
		StringBuilder builder = new StringBuilder();
		String value = input.toLowerCase();
		char lastValue =' ';
		int count = 1;
		for (int i = 0; i < value.length()-1; i++) {
			if(value.charAt(i) == value.charAt(i+1)){
				count++;
				lastValue = value.charAt(i+1);
				if(i == value.length() -2){
					builder.append(value.charAt(i));
					builder.append(count);
				}
			}else{
				if(lastValue != ' ' && lastValue != value.charAt(i+1)){
					builder.append(value.charAt(i));
					builder.append(count);
					count = 1;
				}else{
					builder.append(value.charAt(i));
					builder.append(count);
					count = 1;
				}
				
			}
		}
		return input.length()< builder.toString().length() ? input :  builder.toString();
	}
	
	private static String StringCompressionBetter(String input){
		if(input.length()==1){return input;}
		int [] letters = new int [26];
		char lastChar = input.charAt(0);
		int lastPosition = 0;
		StringBuilder  builder = new StringBuilder();
		for (int i = 1; i < input.length(); i++) {
			int value = input.charAt(i) - 'a';
			if(input.charAt(i) != lastChar){
				builder.append(lastChar);
				builder.append(letters[lastPosition]+1);
				letters[lastPosition]=0;
				lastChar = input.charAt(i);
				if(i == input.length()-1){
					builder.append(lastChar);
					builder.append(letters[value]+1);
				}
			}else{
				letters[value]++;
				lastPosition = value;
				lastChar = input.charAt(i);
				if(i == input.length()-1){
					builder.append(lastChar);
					builder.append(letters[lastPosition]+1);
				}
			}
			
		}
		
		return input.length() < builder.length() ? input: builder.toString();
	}
	
	private static String  compressGood(String input){
		StringBuilder compressedString = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < input.length(); i++) {
			countConsecutive++;
			
			if(i+1 >= input.length() || input.charAt(i) != input.charAt(i+1)){
				compressedString.append(input.charAt(i));
				compressedString.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressedString.length() < input.length() ? compressedString.toString() : input;
	}
	
	private static String compress(String input){
	
		int finalLength = countCompression(input);
		if(finalLength >= input.length()){
			return input;
		}
		int countConsecutive = 0;
		StringBuilder compressed = new StringBuilder(finalLength);
		for (int i = 0; i < input.length(); i++) {
			countConsecutive++;
			
			if(i+1 >= input.length() || input.charAt(i) != input.charAt(i+1)){
				compressed.append(input.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();
	}
	private static int countCompression(String input){
		int compressedLength = 0;
		int countConcecutive = 0;
		for (int i = 0; i < input.length(); i++) {
			countConcecutive++;
			
			if(i + 1 >= input.length() || input.charAt(i) != input.charAt(i+1)){
				compressedLength += 1 + String.valueOf(countConcecutive).length();
				countConcecutive = 0;
			}
		}
		return compressedLength;
	}
	
	private static int [][] rotateMatrix90Degree(int [][]input){
		int row = input.length -1;
		int column = 0;
		
		int [][] result = new int [input.length][input.length];
		
			for (int i = 0; i <= input.length -1; i++) {
				for(int j = 0; j <= input.length -1; j++){
					result[i][j] = input[row][column];
					row--;
				}
				column++;
				row =input.length -1;
			}
		
		return result;
	}
	
	static int [][] rotate(int [][] matrix){
		if(matrix.length == 0 || matrix.length != matrix[0].length){
			return new int[][]{};
		}
		int n = matrix.length;
		for (int layer = 0; layer <  n/2; layer++) {
			int first = layer;
			int last = n -1 -layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				
				int top = matrix[first][i]; //save top
				
				//left -> top
				matrix[first][i] = matrix[last - offset][first];
				
				//bottom -> left
				matrix[last - offset][first]= matrix[last][last - offset];
				
				//right -> bottom
				matrix[last][last-offset] = matrix[i][last];
				
				//top -> right
				matrix[i][last] = top; // right <- saved top
				
			}
		}
		return matrix;
	}
	
	static int [][] setZero(int [][] matrix){
		label:
		for (int i = 0; i < matrix.length; i++) {
			
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j]==0){
					for (int j2 = 0; j2 < matrix.length; j2++) {
						matrix[i][j2]=0;
						matrix[j2][j]=0;
					}
					break label;
				}
				
			}
			
		}
		return matrix;
	}
	
	static int [][] setZeroBetter(int [][] matrix){
		boolean [] row = new boolean [matrix.length];
		boolean [] column = new boolean[matrix.length];
		
		// store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
		  for (int j = 0; j < matrix[0].length; j++) {
			  if(matrix[i][j]==0){
				  row[i]= true;
				  column[j] = true;
			  }
		  }
	  }	
      
        // nullify rows
        for (int i = 0; i < row.length; i++) {
			if(row[i]){
				nullifyRow(matrix, i);
			}
		}
        //nullify columns
        for (int j = 0; j < column.length; j++) {
			if(column[j]){
				nullifyColumn(matrix, j);
			}
		}
        
        
       return matrix;
	}
	
	static void nullifyRow(int[][] matrix, int row){
     	for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}
     }
	
	static void nullifyColumn(int[][] matrix, int col){
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col]=0;
		}
	}
	
	static int [][] setZerosMuchBetter(int [][] matrix){
		boolean rowHasZero = false;
		boolean colHasZero = false;
		
		//check if first row has a zero
		for (int j = 0; j < matrix[0].length; j++) {
			if(matrix[0][j]== 0){
				rowHasZero = true;
				break;
			}
		}
		
		//check if first column has a zero
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == 0){
				colHasZero = true;
				break;
			}
		}
		
		//check for zeros in the rest of the array
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix.length; j++) {
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		// Nullify rows based on values in first column
		for (int i = 1; i < matrix.length; i++) {
			if(matrix[i][0] == 0){
				nullifyRow(matrix, i);
			}
		}
		
		//Nullify columns based on values in first row
		for (int j = 1; j < matrix[0].length; j++) {
			if(matrix[0][j]==0){
				nullifyColumn(matrix, j);
			}
		}
		
		// Nullify first row
		if(rowHasZero){
			nullifyRow(matrix, 0);
		}
		
		//Nullify first column
		if(colHasZero){
			nullifyColumn(matrix, 0);
		}
		
		return matrix;
	}
	
	static boolean isRotation(String s1, String s2){
		int len = s1.length();
		// check that s1 and s2 are equal length and not empty
		if(len == s2.length() && len > 0){
			// concatenate s1 and s1 within new buffer
			String s1s1 = s1+s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}
	static boolean isSubstring(String inputOne, String inputTwo){
		
		String inputMaxLength = inputOne.length() >= inputTwo.length() ? inputOne : inputTwo;
		String inputMinLength = inputOne.length() >= inputTwo.length() ? inputTwo : inputOne;
		
		boolean [] letters = new boolean[26];
		int count = 0;
		for (int i = 0; i < inputMaxLength.length(); i++) {
			int value = inputMaxLength.charAt(i) - 'a';
			letters[value] = true;
		}
		
		for (int i = 0; i < inputMinLength.length(); i++) {
			int value = inputMinLength.charAt(i) - 'a';
			if(letters[value]){
				count++;
			}
		}
		
		return count == inputMinLength.length();
	}


}


