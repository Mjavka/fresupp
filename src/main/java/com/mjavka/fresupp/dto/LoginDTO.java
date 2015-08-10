package com.mjavka.fresupp.dto;

import com.mjavka.fresupp.annotations.PasswordMatches;
import java.util.Date;
import java.util.Set;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mjavka
 */
@PasswordMatches
public class LoginDTO
{
    
    private java.util.UUID uuid;
    
    @NotNull
    private String email;
    
    @NotNull
    private String password;
    
    @NotNull
    private String username;
    
    private Date regDate;
    
    private Boolean active;
    
    private Date lastLogin;
    
    private String status;

    private Set<RoleDTO> roles;

    public java.util.UUID getUuid()
    {
        return uuid;
    }

    public void setUuid(java.util.UUID uuid)
    {
        this.uuid = uuid;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Date getRegDate()
    {
        return regDate;
    }

    public void setRegDate(Date regDate)
    {
        this.regDate = regDate;
    }

    public Boolean getActive()
    {
        return active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    public Date getLastLogin()
    {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin)
    {
        this.lastLogin = lastLogin;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Set<RoleDTO> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles)
    {
        this.roles = roles;
    }
}
