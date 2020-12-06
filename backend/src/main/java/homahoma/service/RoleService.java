package homahoma.service;


import homahoma.model.Role;

import java.util.List;

public interface RoleService {

    Role getRoleById(Long id) throws Exception;

    void addRole(Role role);

    List<Role> getAllRole();

    void deleteRoleById(Long id);

    void updateRole(Role role) throws Exception;
}

