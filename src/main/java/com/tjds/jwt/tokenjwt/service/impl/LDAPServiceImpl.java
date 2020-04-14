package com.tjds.jwt.tokenjwt.service.impl;

import com.tjds.jwt.tokenjwt.service.LDAPService;
import lombok.RequiredArgsConstructor;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class LDAPServiceImpl implements LDAPService {

    private final LdapTemplate ldapTemplate;

    public Boolean consultAD(String username, String password) {
        Filter filter = new EqualsFilter("sAMAccountName",username);

        /*RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange()*/

        return ldapTemplate.authenticate("OU=NoBase",filter.encode(),password);
    }

}
