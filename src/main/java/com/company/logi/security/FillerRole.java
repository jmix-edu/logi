package com.company.logi.security;

import com.company.logi.entity.*;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "FillerRole", code = FillerRole.CODE, scope = "UI")
public interface FillerRole extends UserReadOnlyRole, UiMinimalRole{
    String CODE = "filler-role";

    @EntityAttributePolicy(entityClass = CompanyUnit.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = CompanyUnit.class, actions = EntityPolicyAction.READ)
    void companyUnit();

    @EntityAttributePolicy(entityClass = Filling.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Filling.class, actions = EntityPolicyAction.ALL)
    void filling();

    @EntityAttributePolicy(entityClass = Product.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Product.class, actions = EntityPolicyAction.READ)
    void product();

    @EntityAttributePolicy(entityClass = Shipment.class, attributes = "fillings", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Shipment.class, attributes = {"id", "shipmentDate", "volume", "product", "originStorage", "destinationStorage", "version"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Shipment.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void shipment();

    @EntityAttributePolicy(entityClass = Storage.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Storage.class, actions = EntityPolicyAction.READ)
    void storage();

    @EntityAttributePolicy(entityClass = Transport.class, attributes = "isFilled", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Transport.class, attributes = {"id", "code", "ownerNawme", "model", "capacity", "tareWeight", "version"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Transport.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void transport();

    @MenuPolicy(menuIds = {"Shipment.list", "Transport.list"})
    @ViewPolicy(viewIds = {"Shipment.list", "Product.list", "Storage.list", "CompanyUnit.list", "Transport.list", "CompanyUnit.detail", "Filling.detail", "Product.detail", "Shipment.detail", "Storage.detail", "User.detail"})
    void screens();
}