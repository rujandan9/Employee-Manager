package tech.getarray.employeemanager.security;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordEncoderConfig {
//
//	@Bean
//	public PasswordEncoder customPasswordEncoder() {
//		return new PasswordEncoder() {
//			@Override
//			public String encode(CharSequence rawPassword) {
//				System.out.println("RAW PASSWORD: " + rawPassword);
//				return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(4));
//			}
//
//			@Override
//			public boolean matches(CharSequence rawPassword, String encodedPassword) {
//
//				if (rawPassword.equals("my-secret")) {
//					return BCrypt.checkpw(rawPassword.toString(), encode(encodedPassword));
//				}
//				return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
//
//			}
//		};
//	}

}