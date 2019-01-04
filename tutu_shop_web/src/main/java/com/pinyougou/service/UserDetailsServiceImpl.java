package com.pinyougou.service;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import javafx.beans.property.SimpleListProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    private SellerService sellerService;

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("=========================经过了UserDetailsServiceImpl=================================");
        TbSeller seller = sellerService.findOne(username);
        if (seller!=null && "1".equals(seller.getStatus())){
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            SimpleGrantedAuthority role_user = new SimpleGrantedAuthority("ROLE_SELLER");
            authorities.add(role_user);
            return new User(username, seller.getPassword(), authorities);
        }else {
            return null;
        }
    }
}
