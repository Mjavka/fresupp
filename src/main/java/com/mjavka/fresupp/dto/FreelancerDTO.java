package com.mjavka.fresupp.dto;

import java.util.UUID;

/**
 *
 * @author mjavka
 */
public class FreelancerDTO
{
    private UUID uuid;

    private UUID freelanserUuid;
    
    //@TODO update with Freelancer
    
    public FreelancerDTO()
    {
        
    }
    
    public FreelancerDTO(UUID uuid)
    {
        
        this.uuid = uuid;
        
    }
    
    public UUID getUuid()
    {
        return uuid;
    }

    public void setUuid(UUID uuid)
    {
        this.uuid = uuid;
    }

    public UUID getFreelanserUuid()
    {
        return freelanserUuid;
    }

    public void setFreelanserUuid(UUID freelanserUuid)
    {
        this.freelanserUuid = freelanserUuid;
    }
}
