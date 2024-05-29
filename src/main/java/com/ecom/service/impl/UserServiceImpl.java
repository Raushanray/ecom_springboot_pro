package com.ecom.service.impl;

import com.ecom.entities.Role;
import com.ecom.entities.User;
import com.ecom.exception.ResourceNotFoundException;
import com.ecom.payload.UserDto;
import com.ecom.repo.RoleRepository;
import com.ecom.repo.UserRepository;
import com.ecom.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;


	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Value("${role_normal_id}")
	private String role_normal_id;


	@Override
	public UserDto create(UserDto userDto) {


		//dto to entity
		User user = toEntity(userDto);

		//fetch role of normal and set it to user
		Role role = roleRepository.findById(role_normal_id).get();
		user.setRoles(Set.of(role));
//		user.getRoles().add(role);

		User createdUser = userRepository.save(user);

		//Entity to dto

		return toDto(createdUser);
	}

	@Override
	public List<UserDto> getAll() {
		List<User> allUser = this.userRepository.findAll();
		List<UserDto> allDtos = allUser.stream().map(user-> this.toDto(user)).collect(Collectors.toList());
		
		return allDtos;
	}

	@Override
	public UserDto getByUserId(int userId) {
		User u = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found"+ userId));
		return this.toDto(u);
	}

	@Override
	public UserDto getByEmail(String email) {
	 User u = this.userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("user with this email is  found"));
		return this.toDto(u);
	}

	@Override
	public UserDto update(UserDto userDto, int userId) {
	
		User u = this.userRepository.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException("user not found"+ userId));
		
		u.setName(userDto.getName());
		u.setEmail(userDto.getEmail());
		u.setPassword(userDto.getPassword());
		u.setAbout(userDto.getAbout());
		u.setAddress(userDto.getAddress());
		u.setActive(userDto.isActive());
		u.setGender(userDto.getGender());
		u.setCreateAt(userDto.getCreateAt());
		u.setPhone(userDto.getPhone());
		
		User updatedUser = this.userRepository.save(u);
		
		return this.toDto(updatedUser);
	}

	@Override
	public void deleteUser(int userId) {

		User u = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found"+ userId));
		this.userRepository.delete(u);
		
	}
	

	
	
	public UserDto toDto(User user) {

		return this.modelMapper.map(user, UserDto.class);
	}
	
	
	public User toEntity(UserDto dto)
	{
		return this.modelMapper.map(dto, User.class);
	}
	
}
