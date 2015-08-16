package com.mjavka.fresupp.service;


import com.mjavka.fresupp.dto.SolutionDTO;
import com.mjavka.fresupp.model.Solution;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service("solutionManipulationService")
@Transactional(readOnly = true)
public class SolutionManipulationServiceImpl implements SolutionManipulationService
{

    @Autowired
    private SolutionService solutionService;
    

    @Override
    @Transactional(readOnly = false)
    public void registerNewSolution(SolutionDTO p)
    {
        Solution solution = new Solution();
        
        solution.setName(p.getName());
        
        solution.setDescription(p.getDescription());
        
        solution.setStatus(p.getStatus());
        
        solution.setType(p.getType()); //@TODO set other task fields
        
        //@TODO preprocess and final validation
        
        getSolutionService().registerNewSolution(solution);
    }

    public SolutionService getSolutionService()
    {
        return solutionService;
    }

    public void setSolutionService(SolutionService solutionService)
    {
        this.solutionService = solutionService;
    }

        

   

}
