package com.ExceptionHandling;

public class TryCatch 
{
	public static void main(String[] args) 
	{
		try
		{
			int var1=10;
			int var2=3;
			int var3;
			var3=var1+var2;
			System.out.println("The Value of Variable var3 after Addition :-"+var3);
			var3=var1-var2;
			System.out.println("The Value of Variable var3 after Subtraction :-"+var3);
			var3=var1*var2;
			System.out.println("The Value of Variable var3 after Multiplication :-"+var3);
			var3=var1/var2;
			System.out.println("The Value of Variable var3 after Division :-"+var3);
			var3=var1%var2;
			System.out.println("The Value of Variable var3 after Mod :-"+var3);
		}
		catch(Exception Error)
		{
			System.out.println("The Exception Error is :-"+Error);
		}
	}
}
