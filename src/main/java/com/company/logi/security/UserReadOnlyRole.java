package com.company.logi.security;

import com.company.logi.entity.User;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "UserReadOnlyRole", code = UserReadOnlyRole.CODE, scope = "UI")
public interface UserReadOnlyRole {
    String CODE = "user-read-only-role";

    @EntityAttributePolicy(entityClass = User.class, attributes = {"username", "firstName", "lastName", "email", "active", "timeZoneId", "companyUnit"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.READ)
    void user();

    @ViewPolicy(viewIds = "User.list")
    void screens();
}