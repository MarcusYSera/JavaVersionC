package com.markie.javabeltc.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.markie.javabeltc.models.UserModel;
import com.markie.javabeltc.models.IdeaModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    UserModel findByEmail(String email);
    List<UserModel> findAll();
    List<UserModel> findByIdeasContaining(Long id);
}