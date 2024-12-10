package com.learning.apiRequestValidation.service;

import com.learning.apiRequestValidation.dto.UserRequest;
import com.learning.apiRequestValidation.entity.User;
import com.learning.apiRequestValidation.exception.UserNotFoundException;
import com.learning.apiRequestValidation.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User savedUser(UserRequest userRequest){

        User user=User.build(null,userRequest.getName(),
                userRequest.getAge(),
                userRequest.getGender(),
                userRequest.getMobile(),
                userRequest.getNationality(),
                userRequest.getEmail());
        userRepo.save(user);
        log.info(user.toString());
        return user;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    public User getById(Integer id) throws UserNotFoundException{

        return userRepo.findById(id)
                .orElseThrow(()->new UserNotFoundException("user not found"));
    }

}
