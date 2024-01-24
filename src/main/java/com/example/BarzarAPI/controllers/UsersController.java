// package com.example.BarzarAPI.controllers;

// import com.example.BarzarAPI.models.OrderProducts;
// import com.example.BarzarAPI.models.User;
// import com.example.BarzarAPI.repositories.UserRepository;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/user")
// @CrossOrigin(origins = "http://localhost:3000")
// public class UsersController {
// @Autowired
// private UserRepository userRepository;

// @GetMapping("/all")
// public List<User> getAllUsers() {
// return userRepository.findAll();
// }

// @GetMapping("/{email}")
// public User getMe(@PathVariable String email) {
// return userRepository.findFirstByEmail(email);
// }
// }
