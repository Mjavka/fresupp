package com.mjavka.fresupp.dto;

import java.util.UUID;

/**
 *
 * @author mjavka
 */
public class RoleDTO
{
    private UUID uuid;

    private String role;
    
    public RoleDTO()
    {
        
    }
    
    public RoleDTO(UUID uuid, String role)
    {
        
        this.uuid = uuid;
        
        this.role = role;
        
    }
    
    public UUID getUuid()
    {
        return uuid;
    }

    public void setUuid(UUID uuid)
    {
        this.uuid = uuid;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
}
