package id.co.lua.polua.services.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.co.lua.polua.models.apps.Group;
import id.co.lua.polua.models.repositories.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServicelmpl implements GroupService {
    @Autowired
    GroupRepository groupRepository;

    @Override
    public void create(Group group) {
        //set nilai default if needed
        // group.setSick(0);

        //insert into db
        groupRepository.save(group);
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group getById(Long id) {
        Optional<Group> GroupOptional = groupRepository.findById(id);
        if(!GroupOptional.isPresent()){
            throw  new RuntimeException();
        }
        return GroupOptional.get();
    }

}
