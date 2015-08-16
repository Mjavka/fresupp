package com.mjavka.fresupp.service;

import com.mjavka.fresupp.model.Solution;
import java.util.List;

 
public interface SolutionService {
 
    public void registerNewSolution(Solution p);
    
    public List<Solution> listSolution();
     
}