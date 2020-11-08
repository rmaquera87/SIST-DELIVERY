package com.pe.delivery.services;

import com.pe.delivery.domain.Cliente;
import com.pe.delivery.domain.enums.Perfil;
import com.pe.delivery.repositories.ClienteRepository;
import com.pe.delivery.security.UserSS;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository repo;

    private Set<Integer> perfis = new HashSet<>();
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cli = repo.findByEmail(email);
        if (cli == null) {
            throw new UsernameNotFoundException(email);
        }
        //return new UserSS(cli.getIdCliente(), cli.getEmail(), cli.getClave(),cli.getPerfis());
        //return new UserSS(cli.getIdCliente(), cli.getEmail(), cli.getClave(), cli.getTipo());
        
        /*addPerfil(Perfil.CLIENTE);
        
        public void addPerfil(Perfil perfil) {
            perfis.add(perfil.getCod());
        }
            
        public Set<Perfil> getPerfis() {
            return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
            
        
        }*/
        addPerfil(Perfil.CLIENTE);
        
        return new UserSS(cli.getIdCliente(), cli.getEmail(), cli.getClave(), getPerfis());
        //return new UserSS(cli.getIdCliente(), cli.getEmail(), cli.getClave(), cli.getTipo());
    }
    
    public void addPerfil(Perfil perfil) {
        perfis.add(perfil.getCod());
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());


    }
    
    
}