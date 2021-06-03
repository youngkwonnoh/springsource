package com.spring.student;

public class StudentInfo {
	private Student student;
	
	public StudentInfo(Student student) {
		this.student = student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void getInfo() {
		System.out.println("이름 : " + student.getName());
		System.out.println("나이 : " + student.getAge());
		System.out.println("학년 : " + student.getGradeName());
		System.out.println("반 : " + student.getClassNum());
	}
}
