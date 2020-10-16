package edu.miu.e_mart.service.impl;


import edu.miu.e_mart.domain.ARole;
import edu.miu.e_mart.repository.IARoleRepository;
import edu.miu.e_mart.service.IARoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ARoleServiceImpl implements IARoleService {
    @Autowired
    private IARoleRepository repo;
    @Override
    public ARole saveARole(ARole role) {

        return repo.save(role);
    }

    @Override
    public ARole findARoleById(Integer id) {

        Optional<ARole> aRole = repo.findById(id);

        return aRole!=null?aRole.get():null;
    }

    @Override
    public List<ARole> findAllARole() {
        List<ARole> list = new ArrayList<>();
         Iterable<ARole> itr =repo.findAll();
        for (ARole a:itr) {
            list.add(a);
        }
        return list;
    }

    @Override
    public void updateARoleById(Integer id) {
               ARole aRole = findARoleById(id);
               // toDo
               repo.save(aRole);
    }

    @Override
    public void deleteARoleById(Integer id) {
        ARole aRole = findARoleById(id);
        if(aRole!=null){
            repo.deleteById(id);
        }
        return;
    }
}