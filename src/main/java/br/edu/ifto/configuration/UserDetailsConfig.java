package br.edu.ifto.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.edu.ifto.model.entity.User;
import br.edu.ifto.model.repository.UserRepository;

@Repository
public class UserDetailsConfig implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(email);
    if (user == null)
      throw new UsernameNotFoundException("User not found.");
    return user;
  }

}