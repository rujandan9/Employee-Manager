package tech.getarray.employeemanager.security;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.getarray.employeemanager.repository.RepositoryUser;


@Service
public class UUserDetailsService implements UserDetailsService {


    @Autowired
    private RepositoryUser daoUser;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findLocalOrFacebookUser(username);
    }


    private UserDetails findLocalOrFacebookUser(String username){
        Optional<tech.getarray.employeemanager.model.User> optional = daoUser.findByEmail(username);

        if(optional.isPresent()){
            tech.getarray.employeemanager.model.User theUser = optional.get();



            UserDetails springSecurityUser = User.withDefaultPasswordEncoder()
                    .username(theUser.getEmail())
                    .password(theUser.getPassword())
                    .authorities(getAuthority())
                    .build();


            return springSecurityUser;
        }

        else{
            throw new UsernameNotFoundException("");
        }

    }



    private List<SimpleGrantedAuthority> getAuthority() {
        return Collections.emptyList();
    }
}