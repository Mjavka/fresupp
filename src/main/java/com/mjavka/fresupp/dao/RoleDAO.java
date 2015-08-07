package com.mjavka.fresupp.dao;

import com.mjavka.fresupp.model.Role;
import java.util.UUID;

/**
 *
 * @author mjavka
 */
public interface RoleDAO
{
    public Role getRoleByUuid(UUID uuid);
}
