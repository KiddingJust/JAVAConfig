package org.kidding.security;

import org.kidding.domain.MemberVO;
import org.kidding.mapper.MemberMapper;
import org.kidding.security.domain.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	@Setter(onMethod_=@Autowired)
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info("loadUserByUsername........................" );
		log.info("PARAM: " + username);
		
		MemberVO vo = mapper.getMember(username);
		
		if(vo == null) {
			throw new UsernameNotFoundException("Cann't find such user");
		}
		
		log.info(vo);
		
		return new CustomUser(vo);
	}

}











