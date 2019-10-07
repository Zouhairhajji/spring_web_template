/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.services;

import fr.template.entities.RoleEntity;
import fr.template.entities.UserEntity;
import fr.template.forms.users.CreateUserForm;
import fr.template.repositories.RoleRepository;
import fr.template.repositories.UserRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 *
 * @author zouhairhajji
 */
@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Optional<UserEntity> findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }
    
    public Boolean  ifUserExists(String email) {
        return this.findUserByEmail(email).isPresent();
    }
    
    public void updateLockByUsername(String username, Boolean lock) {
        this.userRepository.updateLockByUsername(username, !lock);
    }
    
    public UserEntity createUser(CreateUserForm createUserForm) {
        Optional<UserEntity> optUser = this.findUserByEmail(createUserForm.getEmail());
        if (optUser.isPresent() == Boolean.TRUE) {
            return optUser.get();
        }
        
        
        String crypted_password = BCrypt.hashpw(createUserForm.getPassword(), BCrypt.gensalt(10));
        UserEntity userEntity = UserEntity.builder()
                .username(createUserForm.getEmail())
                .password(crypted_password)
                
                .email(createUserForm.getEmail())
                .entity(createUserForm.getEntity())
                .firstName(createUserForm.getFirstName())
                .lastName(createUserForm.getLastName())
                .enabled(Boolean.FALSE)
                .phoneNumber(createUserForm.getPhoneNumber())
                .roles(this.getDefaultRoles())
                .dateCreation(new Timestamp(System.currentTimeMillis()))
                
                .build();
        
        userEntity = this.userRepository.save(userEntity);
        
        
        
        return userEntity;
    }

    
    public List<RoleEntity> getDefaultRoles() {
        return this.roleRepository.findByDefaultRoleTrue();
    }
    
    
    
    public Boolean ifRoleExists(String roleName) {
        return findRoleByName(roleName).isPresent();
    }

    public Optional<RoleEntity> findRoleByName(String roleName) {
        return this.roleRepository.findRoleByLabel(roleName);
    }

    public RoleEntity createRole(String roleName, Boolean isDefault) {
        // vérifier si le role existe déjà
        Optional<RoleEntity> optRole = this.findRoleByName(roleName);
        if (optRole.isPresent() == Boolean.TRUE) {
            return optRole.get();
        }

        RoleEntity roleEntity = RoleEntity.builder()
                .dateCreation(new Timestamp(System.currentTimeMillis()))
                .defaultRole(isDefault)
                .idRole(null)
                .label(roleName)
                .users(new ArrayList<>())
                .build();
        return this.roleRepository.save(roleEntity);
    }

    public List<UserEntity> findAllUsers() {
        return this.userRepository.findAll();
    }

}
