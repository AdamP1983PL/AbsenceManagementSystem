//package com.amsysytem.security_basket;
//
//import com.amsysytem.entity.Authority;
//import com.amsysytem.entity.User;
//import com.amsysytem.repositories.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@RequiredArgsConstructor
//@Service
////public class JpaUsersDetailService implements UserDetailsService {
//public class JpaUsersDetailService {
//
////    private final UserRepository userRepository;
//
////    @Transactional
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
////        User user = userRepository.findByUsername(username).orElseThrow(() -> {
////            return new UsernameNotFoundException("User name: " + username + " not found");
////        });
////
////        return new org.springframework.security.core.userdetails.User(
////                user.getUsername(),
////                user.getPassword(),
////                convertToStringAuthorities(user.getAuthorities()));
////    }
////
////    private Collection<? extends GrantedAuthority> convertToStringAuthorities(Set<Authority> authorities) {
////        if (authorities != null & authorities.size() > 0) {
////            return authorities.stream()
////                    .map(Authority::getRole)
////                    .map(SimpleGrantedAuthority::new)
////                    .collect(Collectors.toSet());
////        } else {
////            return new HashSet<>();
////        }
////    }
////    }
////}
//}