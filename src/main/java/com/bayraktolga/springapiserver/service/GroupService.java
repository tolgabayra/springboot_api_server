package com.bayraktolga.springapiserver.service;

import com.bayraktolga.springapiserver.model.Group;
import com.bayraktolga.springapiserver.model.Product;
import com.bayraktolga.springapiserver.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group create(Group groupRequest){
        Group group = new Group();
        group.setId(groupRequest.getId());
        group.setName(groupRequest.getName());
        group.setDescription(groupRequest.getDescription());

        return groupRepository.save(group);
    }


    public void delete (Long id){
        groupRepository.deleteById(id);
    }

    public Optional<Group> update(Long id, Product productRequest){
        Optional<Group> group = groupRepository.findById(id);
        group.ifPresent(group1 -> {
            group1.setName(productRequest.getName());
            group1.setDescription(productRequest.getDescription());

            groupRepository.save(group1);
        });
        return group;

    }

    public Optional<Group> show(Long id){
        return groupRepository.findById(id);
    }

    public List<Group> list(){
        List<Group> groups = groupRepository.findAll();
        return groups;
    }


}
