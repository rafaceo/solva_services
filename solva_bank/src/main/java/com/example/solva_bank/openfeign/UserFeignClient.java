package com.example.solva_bank.openfeign;
import com.example.solva_bank.Dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-feign-client", url = "${USER_FEIGN_URL}")
public interface UserFeignClient {

    @GetMapping("user/{id}")
    UserDto getUserById(@PathVariable(name = "id") Long id);

}

