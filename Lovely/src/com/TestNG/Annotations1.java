package com.TestNG;

import org.testng.annotations.Test;

public class Annotations1
{
	
	@Test
	public void gmailApplicationLaunch()
	{
		
		System.out.println("The Gmail Application is Launched Successfully");
		
	}
	
	@Test(priority=2)
	public void gmailInbox()
	{
		
		System.out.println(" Gmail Inbox ");
		
	}
	
	@Test(priority=3)
	public void gmailComposemail()
	{
		
		System.out.println("Compose Mail");
		
	}
	
	@Test(enabled=false)
	public void gmailSentBox()
	{
		
		System.out.println("Sent Box");
		
	}
	
	@Test(priority=5)
	public void gmailApplicationClose()
	{
		
		System.out.println("The GmailApplication is Closed Successfully");
		
	}
	
}
