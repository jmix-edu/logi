package com.company.logi.security;

import com.company.logi.entity.Shipment;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "ShipmentFullAccessRole", code = ShipmentFullAccessRole.CODE, scope = "UI")
public interface ShipmentFullAccessRole {
    String CODE = "shipment-full-access-role";

    @EntityAttributePolicy(entityClass = Shipment.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Shipment.class, actions = EntityPolicyAction.ALL)
    void shipment();

    @MenuPolicy(menuIds = "Shipment.list")
    @ViewPolicy(viewIds = {"Shipment.list", "Shipment.detail"})
    void screens();
}