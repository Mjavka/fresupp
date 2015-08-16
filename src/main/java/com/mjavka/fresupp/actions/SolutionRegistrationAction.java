package com.mjavka.fresupp.actions;

import com.mjavka.fresupp.dto.SolutionDTO;
import com.mjavka.fresupp.service.SolutionManipulationService;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author mjavka
 */
@ManagedBean(name = "solutionRegistrationAction")
@ViewScoped
public class SolutionRegistrationAction
{
    
    private static final Logger logger = LoggerFactory.getLogger(SolutionRegistrationAction.class);
    
    @ManagedProperty(value = "#{solutionManipulationService}")
    private SolutionManipulationService solutionManipulationService;

    private SolutionDTO solutionDTO = new SolutionDTO();
    
    private String taskUuidString;

    public String register()
    {
        try
        {
            getSolutionDTO().setTaskUuid(UUID.fromString(taskUuidString));
            
            getSolutionManipulationService().registerNewSolution(getSolutionDTO());
        } catch (Exception ex)
        {
            logger.error("error registering ", ex);
            
            return "incorrect";
        }
        return "correct";
    }

    public String cancel()
    {
        return null;
    }

    public String logout()
    {
        SecurityContextHolder.clearContext();
        return "loggedout";
    }

    public SolutionManipulationService getSolutionManipulationService()
    {
        return solutionManipulationService;
    }

    public void setSolutionManipulationService(SolutionManipulationService solutionManipulationService)
    {
        this.solutionManipulationService = solutionManipulationService;
    }

    public SolutionDTO getSolutionDTO()
    {
        return solutionDTO;
    }

    public void setSolutionDTO(SolutionDTO solutionDTO)
    {
        this.solutionDTO = solutionDTO;
    }

    public String getTaskUuidString()
    {
        return taskUuidString;
    }

    public void setTaskUuidString(String taskUuidString)
    {
        this.taskUuidString = taskUuidString;
    }

}
