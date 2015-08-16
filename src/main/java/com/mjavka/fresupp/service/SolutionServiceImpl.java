package com.mjavka.fresupp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mjavka.fresupp.dao.SolutionDAO;
import com.mjavka.fresupp.model.Solution;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service("solutionService")
@Transactional(readOnly = true)
public class SolutionServiceImpl implements SolutionService
{

    @Autowired
    private SolutionDAO solutionDAO;

    @Override
    public void registerNewSolution(Solution p)
    {
        
        //@TODO preprocess and final validation
        p.setCreationDate(new Date());
        solutionDAO.addSolution(p);
    }
    
    @Override
    public List<Solution> listSolution()
    {
        return this.solutionDAO.listSolution();
    }

    public SolutionDAO getSolutionDAO()
    {
        return solutionDAO;
    }

    public void setSolutionDAO(SolutionDAO solutionDAO)
    {
        this.solutionDAO = solutionDAO;
    }

}
