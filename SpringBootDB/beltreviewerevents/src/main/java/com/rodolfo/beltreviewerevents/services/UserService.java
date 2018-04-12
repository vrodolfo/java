package com.rodolfo.beltreviewerevents.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.rodolfo.beltreviewerevents.models.User;
import com.rodolfo.beltreviewerevents.repositories.RoleRepository;
import com.rodolfo.beltreviewerevents.repositories.UserRepository;
@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    public int checkAdmin() {    	
    	int admins = userRepository.countAdmin();
    	return admins;
    }
    
    public List<User> findAll2() {    	
    	return userRepository.findAll();
    }
    
    public String checkIfUserIsAdmin(long id) {    	
    	String admins = userRepository.checkIfAdmin(id);
    	return admins;
    }
    
    public void deleteUser(long id) {    	
    	User user = userRepository.findById(id).orElse(null);
    	user.getRoles().removeAll(user.getRoles());
    	userRepository.delete(user);
    }
    
    public void makeadmin(long id) {    	
    	User user = userRepository.findById(id).orElse(null);
    	user.getRoles().removeAll(user.getRoles());
    	user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
    	userRepository.save(user);
    }
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    // 3
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}

