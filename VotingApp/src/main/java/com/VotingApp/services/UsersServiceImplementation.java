package com.VotingApp.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VotingApp.entity.Users;
import com.VotingApp.entitydto.UsersDTO;
import com.VotingApp.repository.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService
{
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
    SessionFactory sessionFactory; //hibernate class that provides factory for creating new Hibernate sessions.
	
	public UsersDTO getUserByUsername(String username)  //uses orm to retrive data
	{
		//open new session with fctry
		try (Session session = sessionFactory.openSession())
		{
			Query query = session.getNamedQuery("getUserByUsername");
			query.setParameter(1,username);
			List<Users> list = query.getResultList();
			Users objUser = list.get(0); //obj retrived if list empty arrayindxout excptn thrwn
			UsersDTO user = new UsersDTO();
			BeanUtils.copyProperties(objUser, user); //used to cpy prprts of objUser to user 
			return user; 
		} 
		catch (Exception e)
		{
			return null;
		}
	}
	
	public UsersDTO checkUserLogin(String username , String password)
	{
		UsersDTO objUser = getUserByUsername(username);
		if(objUser.getPassword().equals(password))
		{
			return objUser;
		}
		return objUser; 
	}
	
	public boolean addUser(UsersDTO objUser)
	{
		try
		{
			Users userEntity = new Users();
			BeanUtils.copyProperties(objUser,userEntity);
			usersRepository.save(userEntity);
			return true;
		} catch (Exception e)
		{
			return false;
		}
	}
	
	public long getVotesForCandidate(String candidateName)
	{
		Session session = sessionFactory.openSession();
			Query query = session.getNamedQuery("getVotesForCandidate");
			query.setParameter(1,candidateName);
			long votes = (long)query.uniqueResult(); //returns as singlevalue representing no of votes
			return votes;
	}
	
	public void updateVotingStatus(String candidateName, int userId)
	{
		try (Session session = sessionFactory.openSession())
		{
			Query query = session.getNamedQuery("updateVotingStatus");
			query.setParameter(1,candidateName);
			query.setParameter(2,userId);
			Transaction tx = session.beginTransaction();
			query.executeUpdate();
			tx.commit();
		} 
		catch (Exception e)
		{
			
		}
	}
	
	
	
	public List<UsersDTO> getAllVoters(String candidateName) {
		try(Session session = sessionFactory.openSession())
		{
			Query query = session.getNamedQuery("getVoters");
			query.setParameter(1,candidateName);
			List<UsersDTO> list = query.getResultList();
			return list;
		}catch (Exception e) {
			return null;
		}
    }
	
	public UsersDTO getUserById(int userId) {
	    try (Session session = sessionFactory.openSession()) {
	        Query query = session.getNamedQuery("getUserById");
	        query.setParameter(1, userId);
	        List<Users> list = query.getResultList();
	        Users objUser = list.get(0);
	        UsersDTO user = new UsersDTO();
	        BeanUtils.copyProperties(objUser, user);
	        return user;
	    } catch (Exception e) {
	        return null;
	    }
	}

	
}
