package com.tjds.jwt.tokenjwt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LDAPConfig {

    @Value("${ldap.pagseguro.endpoint}")
    private String ldapPagseguroBase;

    @Value("${ldap.pagseguro.authentication.key}")
    private String authorizationKey;

    @Bean
    public LdapContextSource contextSource()
    {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldapPagseguroBase");
        contextSource.setPassword("");

        /*contextSource.setBase("nos base do serv para procurar");
        contextSource.setUserDn("usuario do serv ldap");
        contextSource.setPassword("senha do usuario");*/

        contextSource.setPooled(false);
        contextSource.setReferral("follow");
        contextSource.afterPropertiesSet();

        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate(){
        LdapTemplate ldapTemplate = new LdapTemplate(contextSource());
        // ldapTemplate.setIgnorePartialResultException(true);

        return ldapTemplate;
    }

}
