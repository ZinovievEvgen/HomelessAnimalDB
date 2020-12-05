package homahoma.service_impl;

import homahoma.model.Role;
import homahoma.repository.RoleRepository;
import homahoma.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleById(Long id) {
        return null;
    }

    @Override
    public void addRole(Role role) {

    }

    @Override
    public List<Role> getAllRole() {
        return null;
    }

    @Override
    public void deleteRoleById(Long id) {

    }

    @Override
    public void updateRole(Role role) {

    }
}
