package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation 
{	
	public boolean checkEmail(String sEmail)
	{
		boolean email=false;
		
		Pattern p=Pattern.compile("[a-z0-9]{1,15}[@]{1}[a-z]{1,10}[.]{1}[c]{1}[o]{1}[m]{1}");
		Matcher m=p.matcher(sEmail);
		email=m.matches();
		
		return email;
	}
	public boolean checkMobile(String sMobile)
	{
		boolean mobile=false;
		Pattern p=Pattern.compile("[789]{1}[0-9]{9}");;
		Matcher m=p.matcher(sMobile);
		mobile=m.matches();
		
		return mobile;
	}
	public boolean checkName(String sName)
	{
		boolean name=false;
		if(sName!=null && sName.trim().length()>0)
			name=true;
		return name;
	}
}
