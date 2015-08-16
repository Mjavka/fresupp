package com.mjavka.fresupp.dao;

import java.util.List;

import com.mjavka.fresupp.model.Solution;
 
public interface SolutionDAO {
 
    public void addSolution(Solution p);
    
    public List<Solution> listSolution();
    
}