package com.example.BarzarAPI.services;

import com.example.BarzarAPI.dto.SignUpDTO;
import com.example.BarzarAPI.dto.UserDTO;
import com.example.BarzarAPI.models.User;
import com.example.BarzarAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDTO createUser(SignUpDTO signupDTO) {
    User user = new User();

    user.setRoles("user");
    user.setName(signupDTO.getName());
    user.setEmail(signupDTO.getEmail());
    user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
    User createdUser = userRepository.save(user);

    UserDTO userDTO = new UserDTO();
    userDTO.setId(createdUser.getId());
    userDTO.setEmail(createdUser.getEmail());
    userDTO.setName(createdUser.getName());
    return userDTO;
  }
}
