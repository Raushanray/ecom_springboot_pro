//package com.ecom.service.impl;
//
//import com.ecom.entities.Role;
//import com.ecom.entities.User;
//import com.ecom.payload.UserDto;
//import com.ecom.repo.RoleRepository;
//import com.ecom.repo.UserRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.modelmapper.ModelMapper;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.*;
//
//import static org.mockito.Mockito.when;
//
//
//@SpringBootTest
//class UserServiceImplTest {
//
//    @Mock
//    RoleRepository roleRepository;
//
//
//    @InjectMocks
//    UserServiceImpl userService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private ModelMapper modelMapper;
//
//    Role role;
//
//    User user;
//
//    @Mock
//    UserDto userDtoMock;
//
//
//    @BeforeEach
//    void init() {
//        MockitoAnnotations.initMocks(this);
//        System.setProperty("spring.devtools.restart.enabled", "false");
//
//        role =Role.builder().roleId("role_normal_id").roleName("NORMAL").build();
//
//         user= User.builder()
//                 .userId(1)
//                 .name("arman")
//                .email("arman@gmail.com")
//                .password("rcwdpa")
//                .phone("2456453320")
//                .about("Engineer")
//                .address("Banaras")
//                .gender("male")
//                 .roles(Set.of(new Role()))
//                .build();
//
//
//
//
//    }
//
//
//    @AfterEach
//    void tearDown() {
//    }
//
////    @Test
//    void createTest() {
//
//        when(modelMapper.map(Mockito.any(UserDto.class),Mockito.any())).thenReturn(user);
//
//        when(roleRepository.findById(Mockito.any())).thenReturn(Optional.of(role));
//        when(userRepository.save(Mockito.any())).thenReturn(user);
//        when(modelMapper.map(Mockito.any(User.class),Mockito.any())).thenReturn(userDtoMock);
//
//        UserDto userDto = userService.create(userDtoMock);
//        Assertions.assertNotNull(userDto);
//        Assertions.assertEquals("arman", user.getName());
//    }
//
//
////    @Test
//    void getAll() {
//        List<User> mockUsers = Arrays.asList(
//                 User.builder()
//                        .name("gopal_kumar")
//                        .email("gopal@gmail.com")
//                        .password("rcwdpa")
//                        .phone("2456453320")
//                        .about("Engineer")
//                        .address("Banaras")
//                        .gender("male")
//                        .roles(Set.of(new Role()))
//                        .build(),
//
//                User.builder()
//                .name("ramkumar")
//                .email("ramkumar@gmail.com")
//                .password("rcwdpa")
//                .phone("2456453320")
//                .about("Engineer")
//                .address("Banaras")
//                .gender("male")
//                .roles(Set.of(new Role()))
//                .build()
//
//        );
//        when(modelMapper.map(Mockito.any(UserDto.class), Mockito.any())).thenReturn(mockUsers);
//        when(userRepository.findAll()).thenReturn(mockUsers);
//        List<UserDto> userDtos = userService.getAll();
//        when(modelMapper.map(Mockito.any(User.class), Mockito.any())).thenReturn(userDtos);
//
//        Assertions.assertNotNull(userDtos);
//        Assertions.assertEquals(mockUsers.size(), userDtos.size());
//    }
//
//
//    @Test
//    void getByUserId() {
////             user.setUserId(1);
//       when(modelMapper.map(Mockito.any(UserDto.class),Mockito.any())).thenReturn(user);
//         when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
//         when(modelMapper.map(Mockito.any(User.class),Mockito.any())).thenReturn(userDtoMock);
//        UserDto byUserId = userService.getByUserId(userDtoMock.getUserId());
//
//        Assertions.assertEquals(user.getUserId(), byUserId.getName());
//    }
//
//
//    void getByEmail() {
//    }
//
//
//    void update() {
//    }
//
//
//    void deleteUser() {
//    }
//
//
//    void toDto() {
//    }
//
//
//    void toEntity() {
//    }
//}