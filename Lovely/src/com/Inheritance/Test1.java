package com.Inheritance;

public class Test1 
{
	public void addition()
		{
			
			int var1=987;
			int var2=567;
			int var3=var1+var2;
			System.out.println(var3);
			
		}
		
		private void multiplication()
		{
			
			int var1=567;
			int var2=232;
			int var3=var1*var2;
			System.out.println(var3);
			
		}
		
		public static void main(String[] args)
		{
		
			Test1 t1=new Test1();
			t1.addition();
			t1.multiplication();
			
		}
	}


