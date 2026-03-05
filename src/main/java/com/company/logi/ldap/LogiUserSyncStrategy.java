package com.company.logi.ldap;

import com.company.logi.entity.User;
import io.jmix.ldap.userdetails.AbstractLdapUserDetailsSynchronizationStrategy;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.stereotype.Component;

@Component
public class LogiUserSyncStrategy extends AbstractLdapUserDetailsSynchronizationStrategy<User> {
    @Override
    protected Class<User> getUserClass() {
        return User.class;
    }

    @Override
    protected void mapUserDetailsAttributes(User user, DirContextOperations ctx) {
        user.setFirstName(ctx.getStringAttribute("givenName"));
        user.setLastName(ctx.getStringAttribute("sn"));
        user.setEmail(ctx.getStringAttribute("mail"));
    }
}
