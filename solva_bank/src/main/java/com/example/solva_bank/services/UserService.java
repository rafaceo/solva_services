package com.example.solva_bank.services;

import com.example.solva_bank.Dto.UserDto;
import com.example.solva_bank.openfeign.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFeignClient userFeignClient;

    public UserDto getUserById(Long id) {
        return userFeignClient.getUserById(id);
    }
}
