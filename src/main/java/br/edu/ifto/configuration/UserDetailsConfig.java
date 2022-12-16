package br.edu.ifto.configuration;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.edu.ifto.model.repository.UserRepository;

@Transactional
@Repository
public class UserDetailsConfig implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    var user = userRepository.findByEmail(email);
    if (user == null)
      throw new UsernameNotFoundException("User not found.");
    return new User(user.getEmail(), user.getPassword(), true, true, true, true, user.getAuthorities());
  }

}