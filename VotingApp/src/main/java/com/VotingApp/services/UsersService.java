package com.VotingApp.services;

import java.util.List;

import com.VotingApp.entitydto.UsersDTO;

public interface UsersService
{
	public UsersDTO getUserByUsername(String username);
	public UsersDTO checkUserLogin(String username , String password);
	public boolean addUser(UsersDTO objUser);
	public List<UsersDTO> getAllVoters(String candidateName);
	public void updateVotingStatus(String candidateName, int userId);
	public long getVotesForCandidate(String candidateName);
	public UsersDTO getUserById(int userId);
	
}
