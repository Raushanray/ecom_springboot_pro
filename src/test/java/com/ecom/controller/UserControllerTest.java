//package com.ecom.controller;
//
//import com.ecom.payload.UserDto;
//import com.ecom.service.UserService;
//import com.ecom.service.impl.UserServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//
//@SpringBootTest
//class UserControllerTest {
//
//    private UserController userController;
//
//    @InjectMocks
//    private UserService userService = new UserServiceImpl();
//
//    @BeforeEach
//    void setUp() {
//        userController = new UserController();
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void create() {
//    }
//
//    @Test
//    void updateUser() {
//    }
//
//    @Test
//    void getAll() {
//    }
//
//    @Test
//    void getById() {
//            //userService = Mockito.mock(UserService.class);
//            UserDto userDto = new UserDto();
//            Mockito.when(userService.getByUserId(any(Integer.class))).thenReturn(userDto);
//            userController.getById(123);
//    }
//
//    @Test
//    void getByEmail() {
//    }
//
//    @Test
//    void deleteUser() {
//    }
//}