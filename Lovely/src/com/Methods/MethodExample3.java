package com.Methods;

public class MethodExample3 
{
	int var1=150;
	int var2=100;
	protected void addition() 
	{
		
		int var1=60;
		int var2=62;
		int var3;
		var3=var1+var2;
		System.out.println(var3);
		
	}
	
	protected void subtration()
	{
		
		int var3;
		var3=var1-var2;
		System.out.println(var3);
		
	}
	protected void subtraction(int a, int b)
	{
		
		int var3;
		var3=var1-var2;
		System.out.println(var3);
		
	}
	
	public static void main(String[] args) 
	{
		
		MethodExample3 m3=new MethodExample3();
		m3.addition();
		m3.subtration();
		m3.subtraction(85, 74);
		
	}
}
