package com.example.solva_bank.controller;
import com.example.solva_bank.Dto.UserDto;
import com.example.solva_bank.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping( "user")
public class UserController {

    private final UserService userService;

    //возвращает пользоватя из solva_user
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(name = "id") Long id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }
}
