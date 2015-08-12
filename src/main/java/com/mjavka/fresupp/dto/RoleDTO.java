package com.mjavka.fresupp.dto;

import java.util.UUID;

/**
 *
 * @author mjavka
 */
public class RoleDTO
{
    public static final UUID USER = UUID.fromString("a390e388-3ce6-11e5-a808-cfc3b31c6443");
    public static final UUID MODERATOR = UUID.fromString("ffbf4dee-3ce5-11e5-aec3-c7412f8e153f");
    public static final UUID ADMIN = UUID.fromString("91a1c958-3ce6-11e5-87ac-df76351b03db");
    
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
