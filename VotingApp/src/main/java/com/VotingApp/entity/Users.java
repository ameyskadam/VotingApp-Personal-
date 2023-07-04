package com.VotingApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({
	@NamedQuery(name = "updateVotingStatus",query = " Update Users objUser set objUser.voted_for=?1 where objUser.userId=?2"),
	@NamedQuery(name = "getUserByUsername",query = "Select objUser from Users objUser where username=?1"), //?1 placeholder for parameter 
	@NamedQuery(name = "getVotesForCandidate" ,query = "Select count(*) from Users objUser where voted_for =?1"),
	@NamedQuery(name = "getVoters" ,query = "Select objUser from Users objUser where objUser.voted_for =?1"),
	@NamedQuery(name = "getUserById", query = "SELECT objUser FROM Users objUser WHERE objUser.userId = ?1")

	})
public class Users
{
	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "userid")
	int userId;
	
	@Column(name = "username")
	String userName;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "phonenumber")
	long phoneNumber;
	
	@Column(name = "voted_for")
	String voted_for;
	
	@Column(name = "role")
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

	public void setUserName(String userName)
	{
		this.userName = userName;
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

	public String getVoted_for()
	{
		return voted_for;
	}

	public void setVoted_for(String voted_for)
	{
		this.voted_for = voted_for;
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
