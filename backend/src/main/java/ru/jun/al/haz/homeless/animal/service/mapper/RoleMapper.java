package ru.jun.al.haz.homeless.animal.service.mapper;

import org.mapstruct.Mapper;
import ru.jun.al.haz.homeless.animal.models.Role;
import ru.jun.al.haz.homeless.animal.service.dto.RoleDTO;

@Mapper(componentModel = "spring", uses = {})
public interface RoleMapper extends EntityMapper<RoleDTO, Role> {
}
