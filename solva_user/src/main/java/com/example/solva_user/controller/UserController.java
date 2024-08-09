package com.example.solva_user.controller;
import com.example.solva_user.category.Category;
import com.example.solva_user.dto.UserDto;
import com.example.solva_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;


@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @PostMapping("/set")
    public ResponseEntity<UserDto> setUser(@RequestParam Category category,
                                           @RequestParam BigDecimal transaction,
                                           @RequestParam BigDecimal limitUSD) {
        UserDto userDto = userService.setUser(category, transaction, limitUSD);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(name = "id") Long id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }
}




