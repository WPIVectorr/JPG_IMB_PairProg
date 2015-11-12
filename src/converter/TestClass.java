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
		assertEquals(RomanArabicConverter.RomanArabicConverter(""),"0");
		
		

	}
	
	@Test
	public void validInputArabic() throws MalformedNumberException {
		try{
			assertEquals(RomanArabicConverter.RomanArabicConverter("3000"), "MMM");
			assertEquals(RomanArabicConverter.RomanArabicConverter("9"),"IX");
			assertEquals(RomanArabicConverter.RomanArabicConverter("11"),"XI");
			assertEquals(RomanArabicConverter.RomanArabicConverter("1900"),"MCM");
			assertEquals(RomanArabicConverter.RomanArabicConverter("45"),"XLV");
			assertEquals(RomanArabicConverter.RomanArabicConverter("5"),"V");
			assertEquals(RomanArabicConverter.RomanArabicConverter("0"),"");
		}
		catch(MalformedNumberException e)
		{
			System.out.println(e);
		}
	}
/*	
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
	}*/

}
