package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dao.LoginDAO;
import com.mjavka.fresupp.model.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mjavka
 */
@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService
{

    @Autowired
    private LoginDAO loginDAO;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException
    {

        com.mjavka.fresupp.model.Login domainUser = loginDAO.getLogin(login);

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(
                domainUser.getUsername(),
                domainUser.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(domainUser.getRoles())
        );
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Set<Role> dbRoles)
    {

        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(dbRoles));

        return authList;
    }

    public List<String> getRoles(Set<Role> dbRoles)
    {

        List<String> roles = new ArrayList<String>();
        
        for (Role role : dbRoles)
        {
            roles.add(role.getRole());
        }
        
        return roles;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles)
    {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles)
        {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}
