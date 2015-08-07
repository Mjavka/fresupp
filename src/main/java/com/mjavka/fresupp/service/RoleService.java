package com.mjavka.fresupp.service;

import com.mjavka.fresupp.model.Role;
import java.util.UUID;

/**
 *
 * @author mjavka
 */
public interface RoleService
{
    public Role getRoleByUuid(UUID uuid);
}
