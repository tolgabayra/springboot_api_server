package com.bayraktolga.springapiserver.controller;

import com.bayraktolga.springapiserver.service.GroupService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }



}
