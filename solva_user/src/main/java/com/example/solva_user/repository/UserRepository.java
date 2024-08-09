package com.example.solva_user.repository;
import com.example.solva_user.category.Category;
import com.example.solva_user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByCategory(Category category);
}
