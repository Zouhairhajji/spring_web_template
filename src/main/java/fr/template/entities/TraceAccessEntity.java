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
@Table(name = "trace_access")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TraceAccessEntity implements Serializable {

    @Id
    @Column(name = "id_trace")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTrace;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "roles")
    private String roles;
    
    @Column(name = "url")
    private String url;
    
    @Column(name = "params")
    private String params;
    
    @Column(name = "body")
    private String body;
    
    @Column(name = "schema")
    private String schema;
    
    @Column(name = "verb")
    private String verb;
    
    @Column(name = "ip")
    private String ip;
    
    @Column(name = "date")
    private Timestamp date;
    
    
}
