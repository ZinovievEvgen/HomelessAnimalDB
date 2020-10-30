package ru.jun.al.haz.homeless.animal.service.mapper;

import org.mapstruct.Mapper;
import ru.jun.al.haz.homeless.animal.models.User;
import ru.jun.al.haz.homeless.animal.service.dto.UserDTO;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDTO, User>{
}
