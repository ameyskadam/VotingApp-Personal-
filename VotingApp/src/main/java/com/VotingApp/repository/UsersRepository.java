package com.VotingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VotingApp.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>
{

}
