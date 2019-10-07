/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.services;

import fr.template.entities.LoginHistoryEntity;
import fr.template.entities.TraceAccessEntity;
import fr.template.entities.UserEntity;
import fr.template.repositories.LoginHistoryRepository;
import fr.template.repositories.TraceAccessRepository;
import fr.template.repositories.UserRepository;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author zouhairhajji
 */
@Service("authentificationService")
public class AuthentificationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    
    @Autowired
    private LoginHistoryRepository loginHistoryRepository;
    
    @Autowired
    private TraceAccessRepository traceAccessRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<UserEntity> user = this.userRepository.findUserByEmail(login);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException(MessageFormat.format("The user identified by [{0}] not found", login));
        }
    }
    
    
    public void logLoginAttempt(String username, String ip, Boolean state, List<String> roles) {
        LoginHistoryEntity historyEntity = LoginHistoryEntity.builder()
                .date(new Timestamp(System.currentTimeMillis()))
                .idHistory(null)
                .ip(ip)
                .roles(roles.stream().collect(Collectors.joining(",")))
                .username(username)
                .state(state)
                .build();
        
        this.loginHistoryRepository.save(historyEntity);
    }

    public void logRequest(String username, String roles, String schema, String ip, String verb, String url, String params, String body) {
        TraceAccessEntity log = TraceAccessEntity.builder()
                .username(username)
                .roles(roles)
                .schema(schema)
                .ip(ip)
                .verb(verb)
                .url(url)
                .params(params)
                .body(body)
                .date(Timestamp.from(Instant.now()))
                .build();
        
        this.traceAccessRepository.save(log);
    }
    
    
    
    

}
