package com.example.solva_user.service;
import com.example.solva_user.category.Category;
import com.example.solva_user.dto.UserDto;
import com.example.solva_user.entity.UserEntity;
import com.example.solva_user.mapper.UserMapper;
import com.example.solva_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto setUser(Category category, BigDecimal transaction, BigDecimal limitUSD){
        UserEntity existingUser = userRepository.findByCategory(category);

        if (existingUser != null) {
            // Если лимит уже установлен, не разрешаем его менять
            if (existingUser.getLimitUSD() != null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Limit can only be set once.");
            }

            // обновляем только транзакцию
            existingUser.setTransaction(transaction);
            return userMapper.toDto(userRepository.save(existingUser));
        } else {
            // Создаем нового пользователя, если такой записи не существует
            UserDto userDto = new UserDto();
            userDto.setCategory(category);
            userDto.setTransaction(transaction);
            userDto.setLimitUSD(limitUSD);
            UserEntity savedUserEntity = userRepository.save(userMapper.toEntity(userDto));
            return userMapper.toDto(savedUserEntity);
        }
    }

    public UserDto getUserById(Long id){
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "BankEntity not found"));
        UserDto userDto = userMapper.toDto(userEntity);
        if(userDto.getLimitUSD()==null){
            userDto.setLimitUSD(new BigDecimal("1000"));
        }


        return userDto;
    }
}
