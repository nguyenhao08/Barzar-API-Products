// package com.example.BarzarAPI.controllers;

// import com.example.BarzarAPI.dto.SignUpDTO;
// import com.example.BarzarAPI.dto.UserDTO;
// import com.example.BarzarAPI.services.AuthService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class SignUpController {
// @Autowired
// private AuthService authService;

// @PostMapping("/sign-up")
// @CrossOrigin(origins = "http://localhost:3000")
// public ResponseEntity<?> signupUser(@RequestBody SignUpDTO signupDTO) {
// UserDTO createdUser = authService.createUser(signupDTO);
// if (createdUser == null) {
// return new ResponseEntity<>("User not created, come again later!",
// HttpStatus.BAD_REQUEST);
// }
// return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
// }
// }