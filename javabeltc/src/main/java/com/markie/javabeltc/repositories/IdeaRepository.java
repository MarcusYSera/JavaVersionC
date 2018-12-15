package com.markie.javabeltc.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import com.markie.javabeltc.models.IdeaModel;
import com.markie.javabeltc.models.UserModel;

@Repository
public interface IdeaRepository extends CrudRepository<IdeaModel, Long> {
    List<IdeaModel> findAll();
    List<IdeaModel> findByUsersContaining(Long id);
    Optional<IdeaModel> findById(Long id);
    // List<IdeaModel> findOrderByUsersAsc();
    // List<IdeaModel> findOrderByUsersDesc();
}