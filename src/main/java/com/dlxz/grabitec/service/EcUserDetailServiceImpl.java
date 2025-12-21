package com.dlxz.grabitec.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dlxz.grabitec.entity.EcUser;
import com.dlxz.grabitec.mapper.EcUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EcUserDetailServiceImpl implements EcUserDetailService {
    @Autowired
    private EcUserMapper ecUserMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        EcUser user = ecUserMapper.selectOne(
                new LambdaQueryWrapper<EcUser>().eq(EcUser::getEmail, email)
        );
        if (user == null) {
            throw new UsernameNotFoundException("Email Or Password Error");
        }
        return user;
    }
}
