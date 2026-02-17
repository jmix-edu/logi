package com.company.logi.security;

import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "ManagerRole", code = ManagerRole.CODE, scope = "UI")
public interface ManagerRole {
    String CODE = "manager-role";
}