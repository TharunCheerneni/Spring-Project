package com.taashee.SpringApplicationAssignment.security;

public enum UserPermission {
	INSTRUCTOR_READ("instructor:read"),
	INSTRUCTOR_WRITE("instructor:write"),
	COURSE_READ("course:read"),
	COURSE_WRITE("course:write"),
	STUDENT_READ("student:read"),
	STUDENT_WRITE("student:write"),
	ASSIGN_CLASS("instructor:assign"),
	ASSIGN_COURSE("student:assign");
	
	private final String permission;
	

	private UserPermission(String permission) {
		this.permission = permission;
	}


	public String getPermission() {
		return permission;
	}
	
}
