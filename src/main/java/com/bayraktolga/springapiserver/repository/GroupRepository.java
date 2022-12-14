package com.bayraktolga.springapiserver.repository;


import com.bayraktolga.springapiserver.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}
