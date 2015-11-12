package converter;

/**
 * This class implements a converter that takes a string that represents a
 * number in either Arabic or Roman numeral form and offers methods that will
 * return either the integer value or a string representing the value in Roman
 * numeral form.
 * 
 * @version Nov 6, 2015
 */
public class RomanArabicConverter {

	/**
	 * Constructor that takes in a string. The string should contain either a
	 * valid Roman numeral or a valid Arabic numeral. The string can have
	 * leading and/or trailing spaces. There are no spaces within the actual
	 * number characters. If the string represents an Arabic number, it may be
	 * positive or negative. It will never be larger than a value that can fit
	 * into an int.
	 * 
	 * @param value
	 *            The string representing the Roman or Arabic number.
	 * @throws MalformedNumberException
	 *             if the string (less leading and trailing spaces) does not
	 *             represent a valid Roman or Arabic number.
	 * 
	 *             NOTE: an Arabic number may be out of the acceptable range and
	 *             will still be accepted by this constructor.
	 */

	public static String RomanArabicConverter(String input) throws MalformedNumberException, ValueOutOfBoundsException {
		input = input.toUpperCase(); // uppercases all the characters
		input = input.trim(); // trims whitespace on either side.

		
		//parses input to determine function to use
		try {
				return RomanArabicConverter.toRoman(Integer.parseInt(input)).toString();
		} catch (Exception e) {
			//if the above excepts, it means we have roman numerals, or text and the following runs.
				return RomanArabicConverter.toArabic(input).toString();			
		}
		

	}

	/**
	 * Returns the value of this object as an Arabic number.
	 * @param String roman ->roman numerals to be converted
	 * @return The integer value of the number
	 */
	public static Integer toArabic(String Roman) throws MalformedNumberException {
		Integer integerReturn = 0;
		int stringLength = Roman.length();
		int multRomanCount = 0;

		char[] romanChar = Roman.toCharArray();		//breaks the roman into an array of chars
		int[] romanInt = romanToInteger(romanChar);	//transforms the roman characters into an integer array

		//the below sanitzes and sums the array of integers to create a number.
		
		
		// ends at array-1 because of addition condition
		for (int i = 0; i < romanInt.length - 1; i++) 
		{

			if (romanInt[i] == romanInt[i + 1])// handles the formatting of the roman to ensure it is correct
				multRomanCount++;
			else
				multRomanCount = 0;
			
			
			if (multRomanCount > 2) 
				throw new MalformedNumberException("Three Numerals Together");

			//ensures input formed correctly, notably the subtraction case of "IX" and the like.
			if (romanInt[i] < romanInt[i + 1]) 
			{
				// sanitzes for decimal congruity
				if (romanInt[i] % 10 != 0 && romanInt[i] != 1)
					throw new MalformedNumberException("subtraction not Div 10!");
				// sanitzes for 1/10th
				if (romanInt[i + 1] / 10 > romanInt[i])
					throw new MalformedNumberException("Subtraction not 1/10!");

				// subtracts the previous value from the next in case of smaller
				// on left
				integerReturn -= romanInt[i];
			}

			//adds numbers together for the actual total 
			//numbers only added if the preceding is larger than the following
			if (romanInt[i] >= romanInt[i + 1]) 
				integerReturn += romanInt[i];
			

		}

		return integerReturn;

	}

	/*
	 * transforms roman numerals into integer values
	 * @param char[] romanChar array of roman numerals to be represented as integers
	 * @return int[] returns an array of integers
	 * 
	*/
	public static int[] romanToInteger(char[] romanChar) throws MalformedNumberException {
		int[] romanInt = new int[romanChar.length + 1];// allows for EoA handling

		
		//traverses the array, converting each element as it goes through
		for (int i = 0; i < romanChar.length; i++) {
			// I V X L C D M Q Z
			//Set of if statements determines the number that will be added to the final Roman Integer
			if (romanChar[i] == 'I') {
				romanInt[i] = 1;
			} else if (romanChar[i] == 'V') {
				romanInt[i] = 5;
			} else if (romanChar[i] == 'X') {
				romanInt[i] = 10;
			} else if (romanChar[i] == 'L') {
				romanInt[i] = 50;
			} else if (romanChar[i] == 'C') {
				romanInt[i] = 100;
			} else if (romanChar[i] == 'D') {
				romanInt[i] = 500;
			} else if (romanChar[i] == 'M') {
				romanInt[i] = 1000;
			} else if (romanChar[i] == 'Q') {
				romanInt[i] = 5000;
			} else if (romanChar[i] == 'Z') {
				romanInt[i] = 10000;
			} else if (romanChar[i] == ' ') {
				romanInt[i] = 0;
			} else {
				throw new MalformedNumberException("Not Roman Numeral");
			}
		}
		return romanInt;
	}

	/**
     * Returns the value of this object as a Roman Numeral
     * The algorithm cannot handle negative numbers or non-integer sized numbers.
     * 
     * @return
     * @throws ValueOutOfBoundsException if the number is too small or too large
     *             to be represented using Roman numerals
     */
    public static String toRoman(int input) throws ValueOutOfBoundsException {
    	//different strategy on this one, using associated values to convert to roman numerals
    	
    	//this algorithm cannot handle negative numbers.
    	if(input<0)
    		throw new ValueOutOfBoundsException("Negative numbers cannot be computed");
    
    	
    	//essential a hashmap of roman numerals and their associated values
		String[] descendingRoman = new String[]{"Z", "MZ", "Q", "MQ", "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] descendingArabic = new int[]{10000, 9000, 5000, 4000, 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String finalRoman = "";//initializes string to NULL
	

		//for loop traverses the numbers, then adds roman to the cat'ing string. 
		//exits when the arabic value is less than the smallest value in the array.
			for(int i = 0; i < descendingArabic.length; i++){
			
				//goes through the above arrays, once it reaches the value immediately less than the integer value, it adds
				//it to the String of characters.
				if(descendingArabic[i] <= input){					
					finalRoman += descendingRoman[i];
					input -= descendingArabic[i];
					
					i=0;//starts at the beginning to allow for multiple values
				}
			
			}	

    	return finalRoman;
    }


    
}
