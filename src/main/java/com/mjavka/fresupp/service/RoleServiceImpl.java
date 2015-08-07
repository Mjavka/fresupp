package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dao.RoleDAO;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mjavka.fresupp.model.Role;
import java.util.UUID;

@Service
@ManagedBean(name = "roleService")
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService
{

    private RoleDAO roleDao;

    public void setRoleDAO(RoleDAO roleDAO)
    {
        this.roleDao = roleDAO;
    }

    @Override
    public Role getRoleByUuid(UUID uuid)
    {
        return this.roleDao.getRoleByUuid(uuid);
    }

}
