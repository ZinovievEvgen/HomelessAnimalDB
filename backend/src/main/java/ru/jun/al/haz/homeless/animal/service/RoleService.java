package ru.jun.al.haz.homeless.animal.service;

import ru.jun.al.haz.homeless.animal.service.dto.RoleDTO;

public interface RoleService {

    RoleDTO findByName(String name);
}
