package com.bayraktolga.springapiserver.repository;

import com.bayraktolga.springapiserver.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
