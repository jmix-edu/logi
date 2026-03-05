package com.company.logi.ldap;

import com.company.logi.security.FullAccessRole;
import com.company.logi.security.ManagerRole;
import com.google.common.collect.ImmutableMap;
import io.jmix.ldap.userdetails.LdapAuthorityToJmixRoleCodesMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Component
public class LogiLdapRoleMapper implements LdapAuthorityToJmixRoleCodesMapper {
    private final static Map<String, String> roleCodes = ImmutableMap.of(
            "admin", FullAccessRole.CODE,
            "division", ManagerRole.CODE
    );

    @Override
    public Collection<String> mapAuthorityToJmixRoleCodes(String authority) {
        return Collections.singleton(roleCodes.getOrDefault(authority, authority));
    }
}
