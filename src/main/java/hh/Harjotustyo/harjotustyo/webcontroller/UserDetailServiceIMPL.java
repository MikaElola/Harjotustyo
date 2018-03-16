package hh.Harjotustyo.harjotustyo.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.Harjotustyo.harjotustyo.domain.User;
import hh.Harjotustyo.harjotustyo.domain.UserRepository;

@Service
public class UserDetailServiceIMPL implements UserDetailsService {
private final UserRepository urepo;

@Autowired
public UserDetailServiceIMPL(UserRepository userRepository) {
this.urepo = userRepository;
}
	
@Override
public UserDetails loadUserByUsername(String username) throws
UsernameNotFoundException {
User curruser = (User) urepo.findByUsername(username);
UserDetails user = new org.springframework.security.core.userdetails.User(username,
curruser.getPasswordHash(),
AuthorityUtils.createAuthorityList(curruser.getRole()));
return user;
}
	
	
	

}
