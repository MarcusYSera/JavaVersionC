package com.markie.javabeltc.services;

import com.markie.javabeltc.models.IdeaModel;
import com.markie.javabeltc.repositories.IdeaRepository;
import java.util.Optional;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IdeaService{
    private final IdeaRepository repo;

    public IdeaService(IdeaRepository x){
        this.repo=x;
    }

    public List<IdeaModel> allIdeaLocations(){
        return repo.findAll();
    }

    public IdeaModel findIdeaId(Long id){
        Optional<IdeaModel> x = repo.findById(id);
        if(x.isPresent()){
            return x.get();
        }else{
            return null;
        }
    }
}