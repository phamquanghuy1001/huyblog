package com.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blog.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
