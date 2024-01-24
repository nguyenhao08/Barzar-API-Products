package com.example.BarzarAPI.dto;

public record AuthenticationResponse(String name, String jwtToken, String roles) {

}