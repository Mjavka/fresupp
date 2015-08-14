package com.mjavka.fresupp.actions;

import com.mjavka.fresupp.annotations.PasswordMatches;

/**
 *
 * @author mjavka
 */
@PasswordMatches
public abstract class AbstractRegistrationAction
{
    
    private String email;
    private String userName;
    private String password;
    private String matchingPassword;

    
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getMatchingPassword()
    {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword)
    {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }
}
