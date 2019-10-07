/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.repositories;

import fr.template.entities.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author zouhairhajji
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    
    public Optional<UserEntity> findUserByEmail(String email);

    
    @Modifying
    @Query("UPDATE UserEntity SET enabled = ?2 where username = ?1")
    public void updateLockByUsername(String username, Boolean lock);
    
}
