package com.company.logi.security;

import com.company.logi.entity.*;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "ManagerRole", code = ManagerRole.CODE, scope = "UI")
public interface ManagerRole extends CompanyUnitFullAccessRole, UiMinimalRole, ShipmentFullAccessRole {
    String CODE = "manager-role";

    @EntityAttributePolicy(entityClass = Filling.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Filling.class, actions = EntityPolicyAction.READ)
    void filling();

    @EntityAttributePolicy(entityClass = Product.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Product.class, actions = EntityPolicyAction.ALL)
    void product();

    @EntityAttributePolicy(entityClass = Storage.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Storage.class, actions = EntityPolicyAction.ALL)
    void storage();

    @EntityAttributePolicy(entityClass = Transport.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Transport.class, actions = EntityPolicyAction.ALL)
    void transport();

    @EntityAttributePolicy(entityClass = User.class, attributes = {"username", "active"}, action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = User.class, attributes = {"firstName", "lastName", "email", "companyUnit"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = User.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void user();

    @MenuPolicy(menuIds = {"User.list", "Product.list", "Storage.list", "Transport.list"})
    @ViewPolicy(viewIds = {"User.list", "Product.list", "Storage.list", "Transport.list", "Filling.detail", "Product.detail", "Storage.detail", "User.detail"})
    void screens();
}