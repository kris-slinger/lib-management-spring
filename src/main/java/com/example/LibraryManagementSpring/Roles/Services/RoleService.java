package com.example.LibraryManagementSpring.Roles.Services;

import com.example.LibraryManagementSpring.Roles.Entities.Role;
import com.example.LibraryManagementSpring.Roles.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRoleById(Role roleMapped, Integer roleId){
        Role queriedRole = roleRepository.findById(roleId).orElseThrow(
                ()->new IllegalStateException("role doesn't exist")
        );
        queriedRole.setRoleName(roleMapped.getRoleName());
        return roleRepository.save(queriedRole);
    }
}
