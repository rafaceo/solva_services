package com.example.solva_user.mapper;

import com.example.solva_user.dto.UserDto;
import com.example.solva_user.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-09T04:11:14+0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setCategory( user.getCategory() );
        userDto.setLimitUSD( user.getLimitUSD() );
        userDto.setTransaction( user.getTransaction() );

        return userDto;
    }

    @Override
    public UserEntity toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userDto.getId() );
        userEntity.setCategory( userDto.getCategory() );
        userEntity.setLimitUSD( userDto.getLimitUSD() );
        userEntity.setTransaction( userDto.getTransaction() );

        return userEntity;
    }
}
