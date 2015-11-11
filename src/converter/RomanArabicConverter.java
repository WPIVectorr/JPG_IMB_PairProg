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
     * @param value The string representing the Roman or Arabic number.
     * @throws MalformedNumberException if the string (less leading and trailing
     *             spaces) does not represent a valid Roman or Arabic number.
     * 
     *             NOTE: an Arabic number may be out of the acceptable range and
     *             will still be accepted by this constructor.
     */


	
	public static String RomanArabicConverter(String input) throws MalformedNumberException {
        input = input.toUpperCase(); //uppercases all the characters
        input = input.trim(); // trims whitespace on either side.
        
        try {
        	return RomanArabicConverter.toRoman(Integer.parseInt(input)).toString();
        } catch (Exception e) {
        	return RomanArabicConverter.toArabic(input).toString();
        }  
        	
    }

    /**
     * Returns the value of this object as an Arabic number.
     * 
     * @return The integer value of the number
     */
    public static Integer toArabic(String Roman) throws MalformedNumberException{
        Integer integerReturn = 0;
        int stringLength = Roman.length();
        int multRomanCount = 0;

        char[] romanChar = Roman.toCharArray();
        
        int[] romanInt = romanToInteger(romanChar);
        

        
        
        //traverse integer array to add/subtract together
        //ends at array-1 because of addition condition
        for(int i=0; i<romanInt.length-1;i++)
        {
        	
        	
    		if(romanInt[i] == romanInt[i+1])//handles three characters the same
    			multRomanCount++;
    		else
    			multRomanCount = 0;
    		if(multRomanCount > 2)
    		{
    			throw new MalformedNumberException("Three Numerals Together");
    		}
    		
    		
        	if(romanInt[i]<romanInt[i+1])
        	{
        		//sanitzes for decimal congruity
        		if(romanInt[i] % 10 != 0 && romanInt[i]!=1)
        			throw new MalformedNumberException("subtraction not Div 10!");
        		//sanitzes for 1/10th 
        		if(romanInt[i+1]/10 > romanInt[i])
        			throw new MalformedNumberException("Subtraction not 1/10!");

        		
        	//subtracts the previous value from the next in case of smaller on left	
        		integerReturn -= romanInt[i];	
        	}
        	
        	
        	
        	if(romanInt[i]>=romanInt[i+1])
        	{
        		integerReturn += romanInt[i];
        	}
        	
        }
        

    	
    	return integerReturn;

    }
    
    public static int[] romanToInteger(char[] romanChar)throws MalformedNumberException{
    	int[] romanInt = new int[romanChar.length+1];//allows for EoA handling
    	
    	for(int i =0; i < romanChar.length; i++){
    		//I V X L C D M Q Z
    		if(romanChar[i] == 'I'){
    			romanInt[i] = 1;
    		}
    		else if(romanChar[i] == 'V'){
    			romanInt[i] = 5;
    		}
    		else if(romanChar[i] == 'X'){
    			romanInt[i] = 10;
    		}
    		else if(romanChar[i] == 'L'){
    			romanInt[i] = 50;
    		}
    		else if(romanChar[i] == 'C'){
    			romanInt[i] = 100;
    		}
    		else if(romanChar[i] == 'D'){
    			romanInt[i] = 500;
    		}
    		else if(romanChar[i] == 'M'){
    			romanInt[i] = 1000;
    		}
    		else if(romanChar[i] == 'Q'){
    			romanInt[i] = 5000;
    		}
    		else if(romanChar[i] == 'Z'){
    			romanInt[i] = 10000;
    		}
    		else if(romanChar[i] == ' '){
    			romanInt[i] = 0;
    		}else{
    			throw new MalformedNumberException("Not Roman Numeral");
    		}
    	}
    	return romanInt;
    }

    /**
     * Returns the value of this object as a Roman Numeral
     * 
     * @return
     * @throws ValueOutOfBoundsException if the number is too small or too large
     *             to be represented using Roman numerals
     */
    public static String toRoman(int input) throws ValueOutOfBoundsException {
    	
    	
    	
    	return "I";
    }


    
}
