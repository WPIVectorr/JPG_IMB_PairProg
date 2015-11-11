package converter;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClass {


	@Test
	public void correctInputRoman() throws MalformedNumberException {
		System.out.println(RomanArabicConverter.toArabic("  MMM  "));
		System.out.println(RomanArabicConverter.toArabic("ix"));
		System.out.println(RomanArabicConverter.toArabic("xi"));
		System.out.println(RomanArabicConverter.toArabic("mcm"));
		System.out.println(RomanArabicConverter.toArabic("xlv"));
		System.out.println(RomanArabicConverter.toArabic("ivi"));
		System.out.println(RomanArabicConverter.toArabic(""));
		

	}
	
	@Test
	public void validInputArabic() throws ValueOutOfBoundsException {
		try{
			System.out.println(RomanArabicConverter.toRoman(1));
			System.out.println(RomanArabicConverter.toRoman(9));
			System.out.println(RomanArabicConverter.toRoman(3000));
			System.out.println(RomanArabicConverter.toRoman(50));
		}
		catch(ValueOutOfBoundsException e)
		{
			System.out.println(e);
		}
	}
	
	@Test
	public void invalidInputRoman() throws MalformedNumberException {
		try{
			System.out.println(RomanArabicConverter.toArabic("MM m"));
			System.out.println(RomanArabicConverter.toArabic("iix"));
			System.out.println(RomanArabicConverter.toArabic("xM"));
			System.out.println(RomanArabicConverter.toArabic("Z q t"));
			System.out.println(RomanArabicConverter.toArabic("113"));
			System.out.println(RomanArabicConverter.toArabic("MMMM"));
		}
		catch(MalformedNumberException e)
		{
			System.out.println(e);
		}
	}

}
