package com.DAO;

/**
 * @author Zhiwei Qiao
 * User operation
 */

public class User
{
	private String username;
	private String password;
	private String usertype;
	
	
	public String getUserName()
	{
		return this.username;
	}
	public void setUserName(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getUserType()
	{
		return this.usertype;
	}
	public void setUserType(String usertype) 
	{
		this.usertype = usertype;
	}
}
