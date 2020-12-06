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
    public Role getRoleById(Long id) throws Exception {
        return roleRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void addRole(Role role) {
        //заменить логгером
        roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteRoleById(Long id) {
        try {
            roleRepository.deleteById(id);
        } catch (Exception e) {
            //заменить логгером
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateRole(Role newRole) throws Exception {
        roleRepository.findById(newRole.getId()).map(role -> {
            role.setName(newRole.getName());
            role.setUsers(newRole.getUsers());
            return roleRepository.save(role);
        }).orElseThrow(Exception::new);
    }
}
