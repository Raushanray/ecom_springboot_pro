package com.ecom.controller;

import com.ecom.payload.ApiResonse;
import com.ecom.payload.UserDto;
import com.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
//@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//create user data
	@PostMapping("/")
	public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto) {
	
		userDto.setCreateAt(new Date());
		userDto.setActive(true);
		
		userDto.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
		
		UserDto createdUser = this.userService.create(userDto);

        return new ResponseEntity<UserDto>(createdUser, HttpStatus.CREATED);
	}
	
	//update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody  UserDto userDto, @PathVariable int userId) {
        UserDto updatedUser = this.userService.update(userDto, userId);
        return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);
    }
	
	//get all user
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAll()
	{
		List<UserDto> all = this.userService.getAll();
		return new ResponseEntity<List<UserDto>>(all, HttpStatus.OK);
	}
	
	
	//get single user by id
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getById(@PathVariable int userId)
	{
		UserDto userDto = this.userService.getByUserId(userId);
		
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
	//get single user by email
	@GetMapping("/email/{userEmail}")
	
	public ResponseEntity<UserDto> getByEmail(@PathVariable String  userEmail)
	{
		UserDto userDto = this.userService.getByEmail(userEmail);
		
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
	//delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResonse> deleteUser(@PathVariable int userId)
	{
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResonse>(new ApiResonse("User is deleted successfully !!", true), HttpStatus.OK);
	}
}
