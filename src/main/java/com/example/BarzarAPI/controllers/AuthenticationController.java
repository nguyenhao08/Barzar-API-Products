package com.example.BarzarAPI.controllers;

import com.example.BarzarAPI.dto.AuthenticationRequest;
import com.example.BarzarAPI.dto.AuthenticationResponse;
import com.example.BarzarAPI.services.jwt.UserDetailsServiceImpl;
import com.example.BarzarAPI.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@RestController
public class AuthenticationController {
  @Autowired
  private JwtUtil jwtUtil;
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @PostMapping("/authenticate")
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,
      HttpServletResponse response) throws IOException {
    try {
      // Xác thực thông tin đăng nhập sử dụng AuthenticationManager
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
          authenticationRequest.getPassword()));
    } catch (BadCredentialsException e) {
      // Trả về lỗi nếu thông tin đăng nhập không chính xác
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect username or password!");
    } catch (DisabledException disabledException) {
      // Trả về lỗi nếu người dùng bị vô hiệu hóa
      response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not activated");
      return null;
    }

    // Lấy thông tin người dùng từ UserDetailsServiceImpl dựa trên email
    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

    // Lấy tên người dùng từ UserDetails
    final String username = userDetails.getUsername();

    String roles = "user";
    // Kiểm tra xem người dùng có vai trò admin hay không
    if ("admin@gmail.com".equals(username) || "hao08@gmail.com".equals(username)) {
      roles = "admin";
    }

    // Tạo JWT (JSON Web Token) sử dụng JwtUtil và tên người dùng
    final String jwt = jwtUtil.generateToken(userDetails.getUsername());

    // Trả về ResponseEntity thành công với thông tin xác thực
    return ResponseEntity.ok(new AuthenticationResponse(username, jwt, roles));
  }
}