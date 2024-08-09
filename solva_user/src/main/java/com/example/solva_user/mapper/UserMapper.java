package com.example.solva_user.mapper;
import com.example.solva_user.dto.UserDto;
import com.example.solva_user.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(UserEntity user);
    UserEntity toEntity(UserDto userDto);
}
