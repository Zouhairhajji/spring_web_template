/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author FQLH0717
 */
@Entity
@Table(name = "roles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleEntity implements Serializable {

    @Id
    @Column(name = "id_role")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRole;

    @NotNull
    @Column(name = "role")
    private String label;
    

    @Column(name = "is_default")
    private boolean defaultRole;

    @Column(name = "date_creation")
    private Timestamp dateCreation;

    @ManyToMany()
    @JoinTable(name = "role_users",
            joinColumns = @JoinColumn(name = "id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private List<UserEntity> users;

}
