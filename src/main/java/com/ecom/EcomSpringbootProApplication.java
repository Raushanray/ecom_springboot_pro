package com.ecom;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EcomSpringbootProApplication {


//	@Autowired
//	private RoleRepository roleRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Value("${role_normal_id}")
//    private String role_normal_id;
//    @Value("${role_admin_id}")
//    private String role_admin_id;


	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(EcomSpringbootProApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		try {
//
//            Role role_admin = Role.builder().roleId(role_admin_id).roleName("ROLE_ADMIN").build();
//            Role role_normal = Role.builder().roleId(role_normal_id).roleName("ROLE_NORMAL").build();
//
//
//
//            User adminUser = User.builder()
//                    .name("admin")
//                    .email("admin@gmail.com")
//                    .password(passwordEncoder.encode("admin@321"))
//                    .address("Bangalore")
//                    .about("I am admin User")
//                    .phone("9060088065")
//                    .gender("Male")
//                    .createAt(new Date())
//                    .roles(Set.of(role_admin, role_normal))
//                    .build();
//
//
//            User normalUser = User.builder()
//                    .name("normal")
//                    .email("normal@gmail.com")
//                    .password(passwordEncoder.encode("admin@3214"))
//                    .address("Bangalore")
//                    .about("I am admin normal")
//                    .phone("906008546")
//                    .gender("Male")
//                    .createAt(new Date())
//                    .roles(Set.of(role_normal))
//                    .build();
//
//
//            roleRepository.save(role_admin);
//            roleRepository.save(role_normal);
//
//        userRepository.save(adminUser);
//        userRepository.save(normalUser);
//
//        } catch (Exception e) {
//            System.out.println("User already there !!");
//            e.printStackTrace();
//        }
//
//    }
}