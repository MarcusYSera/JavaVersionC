package com.markie.javabeltc.services;

import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.markie.javabeltc.models.UserModel;
import java.util.List;
import com.markie.javabeltc.repositories.UserRepository;;
@Service
public class UserService {
    private final UserRepository repo;
    
    public UserService(UserRepository x) {
        this.repo = x;
    }
    
    public List<UserModel> allUser(){
        return repo.findAll();
    }

    // register user and hash their password
    public UserModel registerUser(UserModel user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return repo.save(user);
    }
    
    // find user by email
    public UserModel findByEmail(String email) {
        return repo.findByEmail(email);
    }
    
    // find user by id
    public UserModel findUserById(Long id) {
    	Optional<UserModel> u = repo.findById(id);
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        UserModel user = repo.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
