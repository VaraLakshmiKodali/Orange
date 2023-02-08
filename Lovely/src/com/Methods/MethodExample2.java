package com.Methods;

public class MethodExample2 
{
	public void addition() 
	{
		int var1=10;
		int var2=52;
		int var3;
		var3=var1+var2;
		System.out.println(var3);
		
	}
	
	protected void multiplication()
	{
		
		int var1=40;
		int var2=9;
		int var3;
		var3=var1*var2;
		System.out.println(var3);
		
	}

	public static void main(String[] args) 
	{
		
		MethodExample2 m2=new MethodExample2();
		m2.addition();
		m2.multiplication();
		
	}
	
}


