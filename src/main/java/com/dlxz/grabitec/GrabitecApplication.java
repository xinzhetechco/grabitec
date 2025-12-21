package com.dlxz.grabitec;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dlxz.grabitec.entity.EcUser;
import com.dlxz.grabitec.entity.EcUserState;
import com.dlxz.grabitec.mapper.EcUserMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GrabitecApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrabitecApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(EcUserMapper ecUserMapper, PasswordEncoder passwordEncoder) {
		return args -> {
			String adminEmail = "yuyifeng@xinzhetechco.com";
			EcUser existing = ecUserMapper.selectOne(new LambdaQueryWrapper<EcUser>().eq(EcUser::getEmail, adminEmail));
			if (existing == null) {
				EcUser admin = new EcUser();
				admin.setEmail(adminEmail);
				admin.setUsername("yuyifeng");
				admin.setState(EcUserState.ACTIVE);
				admin.setPassword(passwordEncoder.encode("1qaz!QAZ"));
				ecUserMapper.insert(admin);
				System.out.println(">>> 默认账号创建成功: yuyifeng@xinzhetechco.com / 1qaz!QAZ");
			}
		};
	}
}
