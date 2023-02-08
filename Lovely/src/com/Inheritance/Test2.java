package com.Inheritance;

public class Test2 extends Test1
{

	private void multiplication()
	{
		
		int var1=456;
		int var2=233;
		int var3=var1*var2;
		System.out.println(var3);
		
	}
	
	protected void multiplication(int var1,int var2)
	{
		
		int var3=var1*var2;
		System.out.println(var3);
		
	}
	
	public static void main(String[] args) 
	{
	
		Test2 t2=new Test2();
		t2.multiplication();
		t2.multiplication(9876, 458);
		t2.addition();
		
	}
}
