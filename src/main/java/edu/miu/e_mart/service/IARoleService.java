package edu.miu.e_mart.service;

import edu.miu.e_mart.domain.ARole;

import java.util.List;
import java.util.Optional;

public interface IARoleService {
    public ARole saveARole(ARole role);
    public ARole findARoleById(Integer id);
    public List<ARole>  findAllARole();
    public void updateARoleById(Integer id);
    public void deleteARoleById(Integer id);



}
