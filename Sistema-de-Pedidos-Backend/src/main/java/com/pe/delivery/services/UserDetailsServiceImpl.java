package com.pe.delivery.services;

import com.pe.delivery.domain.Cliente;
import com.pe.delivery.repositories.ClienteRepository;
import com.pe.delivery.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cli = repo.findByEmail(email);
        if (cli == null) {
            throw new UsernameNotFoundException(email);
        }
        //return new UserSS(cli.getIdCliente(), cli.getEmail(), cli.getClave(),cli.getPerfis());
        return new UserSS(cli.getIdCliente(), cli.getEmail(), cli.getClave(), cli.getTipo());
    }
}