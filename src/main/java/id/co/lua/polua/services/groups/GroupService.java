package id.co.lua.polua.services.groups;

import id.co.lua.polua.models.apps.Group;

import java.util.List;

public interface GroupService {
    void create(Group group);

    List<Group> getAll();

    Group getById(Long id);

}
