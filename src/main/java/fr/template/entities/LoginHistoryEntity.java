/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author zouhairhajji
 */
@Entity
@Table(name = "login_history")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginHistoryEntity implements Serializable {

    @Id
    @Column(name = "id_history")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHistory;
    
    @NotNull
    @Column(name = "username")
    private String username;
    
    
    @Column(name = "ip", insertable = false, updatable = false)
    private String ip;
    
    @NotNull
    @Column(name = "state")
    private Boolean state;
    
    @NotNull
    @Column(name = "ip")
    private String roles;
    
    @NotNull
    @Column(name = "date")
    private Timestamp date;
    
}
