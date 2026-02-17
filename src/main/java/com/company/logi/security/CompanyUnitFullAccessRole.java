package com.company.logi.security;

import com.company.logi.entity.CompanyUnit;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Company unit full access role", code = CompanyUnitFullAccessRole.CODE, scope = "UI")
public interface CompanyUnitFullAccessRole {
    String CODE = "company-unit-full-access-role";

    @EntityAttributePolicy(entityClass = CompanyUnit.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = CompanyUnit.class, actions = EntityPolicyAction.ALL)
    void companyUnit();

    @MenuPolicy(menuIds = "CompanyUnit.list")
    @ViewPolicy(viewIds = {"CompanyUnit.list", "CompanyUnit.detail"})
    void screens();
}