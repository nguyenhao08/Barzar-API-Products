package com.example.BarzarAPI.services;

import com.example.BarzarAPI.dto.SignUpDTO;
import com.example.BarzarAPI.dto.UserDTO;

public interface AuthService {
  UserDTO createUser(SignUpDTO signupDTO);
}
