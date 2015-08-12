package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dao.RoleDAO;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mjavka.fresupp.model.Role;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService
{
    @Autowired
    private RoleDAO roleDao;

    @Override
    public Role getRoleByUuid(UUID uuid)
    {
        return this.getRoleDao().getRoleByUuid(uuid);
    }

    public RoleDAO getRoleDao()
    {
        return roleDao;
    }

    public void setRoleDao(RoleDAO roleDao)
    {
        this.roleDao = roleDao;
    }

}
