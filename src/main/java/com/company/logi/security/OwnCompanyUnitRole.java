package com.company.logi.security;

import com.company.logi.entity.CompanyUnit;
import com.company.logi.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.security.model.RowLevelBiPredicate;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.role.annotation.PredicateRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;
import org.springframework.context.ApplicationContext;

@RowLevelRole(name = "OwnCompanyUnitRole", code = OwnCompanyUnitRole.CODE)
public interface OwnCompanyUnitRole {
    String CODE = "own-company-unit-role";


    @PredicateRowLevelPolicy(entityClass = CompanyUnit.class, actions = {RowLevelPolicyAction.UPDATE, RowLevelPolicyAction.DELETE})
    default RowLevelBiPredicate<CompanyUnit, ApplicationContext> companyUnitPredicate() {
        return (companyUnit, applicationContext) -> {
            CurrentAuthentication authentication = applicationContext.getBean(CurrentAuthentication.class);
            User current = (User) authentication.getUser();
            return companyUnit.getManager().equals(current);
        };
    }
}