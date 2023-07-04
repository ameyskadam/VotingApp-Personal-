package com.VotingApp.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.VotingApp.entitydto.UsersDTO;
import com.VotingApp.services.UsersService;

@Controller
@RequestMapping("/")
public class GeneralController
{
	@Autowired
	UsersService service;
	
	@GetMapping("/")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String authenticateUser(Model data,HttpSession session,@RequestParam("username")String username,@RequestParam("password")String password) {//object usd to pass to the view
		
		UsersDTO user = service.checkUserLogin(username, password);
		
			
		if(user.getRole()==1)
		{
			long votesForCandidate1 = service.getVotesForCandidate("Candidate 1");
			long votesForCandidate2 = service.getVotesForCandidate("Candidate 2");
			long votesForCandidate3 = service.getVotesForCandidate("Candidate 3");
			long votesForCandidate4 = service.getVotesForCandidate("Candidate 4");
			long sum = votesForCandidate1+votesForCandidate2+votesForCandidate3+votesForCandidate4;
			data.addAttribute("votesForCandidate1", votesForCandidate1);
			data.addAttribute("votesForCandidate2", votesForCandidate2);
			data.addAttribute("votesForCandidate3", votesForCandidate3);
			data.addAttribute("votesForCandidate4", votesForCandidate4);
			data.addAttribute("sum", sum);
			boolean loginStatus = true;
			session.setAttribute("loginStatus", loginStatus);
			return "adminHomepage";
		}
		else if(user.getRole()==0)
		{
			boolean loginStatus = true;
			session.setAttribute("loginStatus", loginStatus); //track of whether user logged in or not
			UsersDTO objUser = service.getUserByUsername(username); // it retrives data from database and strs 
			if(objUser.getVotedFor() == null)
			{
				data.addAttribute("userId", objUser.getUserId()); //If the user has not voted,userId added to data object
				return "votePage";
			}
			else
			{
				data.addAttribute("votedFor", objUser.getVotedFor());
				return "alreadyVoted";
				
			}
			
		}
		return "register";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("email")String email,@RequestParam("phoneNumber")long phoneNumber)
	{
		UsersDTO objUser = new UsersDTO();
		
		objUser.setUserName(username);
		objUser.setPassword(password);
		objUser.setEmail(email);
		objUser.setPhoneNumber(phoneNumber);
		objUser.setVotedFor(null);
		service.addUser(objUser);
		return "login";
	}
	
	@PostMapping("/receiveVote/{userId}")
	public String Voted(Model data,HttpSession session, @RequestParam("candidate") String candidate,@PathVariable("userId")int userId, HttpServletResponse response) //updates the user's voting status, adds an attribute to the model object, & returns a logical view name
	{                                                   //modeldata use to pass data between controller and view 
		
		
		UsersDTO objUser = service.getUserById(userId);
		if (objUser.getVotedFor() == null) {
		    service.updateVotingStatus(candidate, userId);
		    data.addAttribute("votedFor", candidate);
		    session.setAttribute("voted", true);
		    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		    response.setHeader("Pragma", "no-cache");
		    response.setHeader("Expires", "0");
		    return "alreadyVoted";
		} else {
		    // User has already voted, redirect to the results page
		    data.addAttribute("votedFor", objUser.getVotedFor());
		    return "alreadyVoted";
		}
	
	}

	/*service.updateVotingStatus(candidate, userId);
    data.addAttribute("votedFor", candidate);
    session.setAttribute("voted", true);
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setHeader("Expires", "0"); // Proxies
    return "alreadyVoted";*/
	
	
	 @GetMapping("/logout")
	 public String logout(HttpSession session, HttpServletResponse response) { 
		 session.removeAttribute("voted");
		    session.removeAttribute("loginStatus");
		    session.invalidate(); 
		    
		    response.setHeader("Cache-Control", "no-store"); // Set the Cache-Control header to prevent caching   
      return "login";
	 }
}
