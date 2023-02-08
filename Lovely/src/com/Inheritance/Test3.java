package com.Inheritance;

public class Test3 extends Test2
{

	public void addition(int var1, int var2)
	{
		
		int var3=var1+var2;
		System.out.println(var3);
		
	}
	
	public static void main(String[] args) 
	{
		Test3 t3=new Test3();
		t3.addition(245, 6543);
		t3.addition();
		t3.multiplication(3456, 435);
		
	}
}
