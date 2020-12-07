package homahoma.controller;

import homahoma.model.Role;
import homahoma.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/role")
public class RoleController {

    @Autowired
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    private Logger logger = Logger.getLogger(RoleController.class.getName());

    @PostMapping("/create")
    public void addRole(@RequestBody Role role) {
        roleService.addRole(role);
    }

    @GetMapping("/get/{id}")
    public Role getRoleById(@PathVariable Long id) throws Exception {
        return roleService.getRoleById(id);
    }

    @GetMapping("/allRoles")
    public List<Role> getAllRole() {
        return roleService.getAllRole();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoleById(@PathVariable Long id) {
        try {
            roleService.deleteRoleById(id);
            logger.info("Role (id = " + id + ") was deleted");
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    @PutMapping("/update")
    public void updateRole(@RequestBody Role newRole) throws Exception {
        roleService.updateRole(newRole);
    }
}