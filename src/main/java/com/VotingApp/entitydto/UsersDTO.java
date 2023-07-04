package com.VotingApp.entitydto;

public class UsersDTO
{
	int userId;
	String userName;
	String password;
	String email;
	long phoneNumber;
	boolean submittedVote;
	String voted_for;
	int role;
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String username)
	{
		this.userName = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public long getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public boolean isSubmittedVote()
	{
		return submittedVote;
	}
	public void setSubmittedVote(boolean submittedVote)
	{
		this.submittedVote = submittedVote;
	}
	public String getVotedFor()
	{
		return voted_for;
	}
	public void setVotedFor(String votedFor)
	{
		this.voted_for = votedFor;
	}
	public int getRole()
	{
		return role;
	}
	public void setRole(int role)
	{
		this.role = role;
	}
	
	
}
