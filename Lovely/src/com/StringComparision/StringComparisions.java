package com.StringComparision;

public class StringComparisions 
{
	public static void main(String[] args) 
	{
		
		String string1="Vara Lakshmi";
		System.out.println(" The Character/Alphabet at the index of the String is :- "+string1.charAt(7));
		
		char charAtAnIndex=string1.charAt(9);
		System.out.println(" The Character/Alphabet at the Index of the String is :- "+charAtAnIndex);
		
		int charAtAnIndex7=string1.charAt(4);
		System.out.println(" The Charecter at the index of the String related ASCII Value is :- "+charAtAnIndex7);
		System.out.println(" ### String Values conversion to UpperCase and LowerCase### ");
		
		String string2="VARA LAKSHMI";
		String convertedStringValueToLowerCase=string2.toLowerCase();
		System.out.println(" The String After Conversion is :- "+convertedStringValueToLowerCase);
		
		String string3="vara lakshmi";
		String convertedStringValueToUpperCase=string3.toUpperCase();
		System.out.println(" The String After Conversion is :- "+convertedStringValueToUpperCase);
		
		System.out.println(" **** String Comparision **** ");
		String string4="Testing Tools";
		String string5="Testing  Tools";
		
		if(string4.equals(string5))
		{
			System.out.println(" Both The String Variables String4 and String5 are Equal ");
		}
		else
		{
			System.out.println(" Both The String Values String4 and String5 NOT Equal ");
		}
		
		String string6="Web Driver";
		String string7="Web driver";
		if(string6.endsWith(string7))
		{
			System.out.println(" Both the String Values string6 and string7 are Equal ");
		}
		else
		{
			System.out.println(" Both The String Values String6 and string7 are NOT Equal ");
		}
		
		System.out.println(" **** Strings should be Equal but Lower Case and Upper Case Letters should be Ignored **** ");
		
		if(string6.equalsIgnoreCase(string7))
		{
			System.out.println(" Both the String Values string6 and string7 are Equal ");
		}
		else
		{
			System.out.println(" Both The String Values String6 and string7 are NOT Equal ");
		}
		
		System.out.println(" **** Checking for an existance of String Text **** ");
		
		String string8="Live Tech";
		String string9="Tech";
		if(string8.contains(string9))
		{
			System.out.println(" Expected String Value of string9 found in string8 ");
		}
		else
		{
			System.out.println(" Expected String Value of string9 NOT found in string8 ");
		}
		
		System.out.println(" **** Compare Strings Ignore Case **** ");
		
		String string10="SELENIUM";
		String string11="selenium";
		
		if(string10.equals(string11))
		{
			System.out.println(" Both the Strings are same ");
		}
		else
		{
			System.out.println(" Both The Strings are NOT Same ");
		}
	}
}
