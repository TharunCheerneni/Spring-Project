package com.taashee.SpringApplicationAssignment.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum UserRole {
	STUDENT(new HashSet<>(Arrays.asList(UserPermission.INSTRUCTOR_READ,UserPermission.COURSE_READ))),
	INSTRUCTOR(new HashSet<>(Arrays.asList(UserPermission.COURSE_READ,UserPermission.STUDENT_READ,UserPermission.ASSIGN_COURSE))),
	ADMIN(new HashSet<>(Arrays.asList(UserPermission.INSTRUCTOR_READ,UserPermission.COURSE_READ,UserPermission.STUDENT_READ,
			UserPermission.ASSIGN_CLASS,UserPermission.COURSE_WRITE,UserPermission.INSTRUCTOR_WRITE,
			UserPermission.STUDENT_WRITE)));
	
	private final Set<UserPermission> permissions;
	
	
	public Set<UserPermission> getPermissions() {
		return permissions;
	}

	private UserRole(Set<UserPermission> permissions) {
		this.permissions = permissions;
	}
	
	public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
		Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
				.collect(Collectors.toSet());
		
		return permissions;
	}
}
