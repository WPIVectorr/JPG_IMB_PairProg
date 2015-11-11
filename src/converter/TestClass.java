package converter;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClass {


	@Test
	public void correctInputRoman() throws MalformedNumberException {
		assertEquals(RomanArabicConverter.RomanArabicConverter("  MMM  "), "3000");
		assertEquals(RomanArabicConverter.RomanArabicConverter("ix"),"9");
		assertEquals(RomanArabicConverter.RomanArabicConverter("xi"),"11");
		assertEquals(RomanArabicConverter.RomanArabicConverter("mcm"),"1900");
		assertEquals(RomanArabicConverter.RomanArabicConverter("xlv"),"45");
		assertEquals(RomanArabicConverter.RomanArabicConverter("ivi"),"5");
		assertEquals(RomanArabicConverter.RomanArabicConverter(""),"0");
		
		

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
