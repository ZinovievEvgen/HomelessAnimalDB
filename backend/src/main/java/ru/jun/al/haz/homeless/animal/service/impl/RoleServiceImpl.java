package ru.jun.al.haz.homeless.animal.service.impl;

import liquibase.pro.packaged.A;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jun.al.haz.homeless.animal.models.Role;
import ru.jun.al.haz.homeless.animal.repository.RoleRepository;
import ru.jun.al.haz.homeless.animal.service.RoleService;
import ru.jun.al.haz.homeless.animal.service.dto.RoleDTO;
import ru.jun.al.haz.homeless.animal.service.mapper.RoleMapper;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleDTO findByName(String name) {
        Role role = roleRepository.findByName(name);
        if (role == null)
            return null;
        return roleMapper.toDto(role);
    }
}
