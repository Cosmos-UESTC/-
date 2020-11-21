package com.cn.model;

public class Student extends Person{
	private String Major; //ְλ
	
	public Student(String ID, String Name, String Gender, String Birthday, String Faculty, String Major) {
		super(ID, Name, Gender, Birthday, Faculty);
		this.Major=Major;
	}
	
	public Student() {
		super();
	}
	
	public String getMajor() {
		return Major;
	}
	//��ȡרҵ
	protected void setMajor(String Major) {
		this.Major=Major;
	}
	//����רҵ
	
	public void info()
    {
        String str = "ID:" + super.getID() + "\nName:" + super.getName() + "\nGender:" + super.getGender() + "\nBirthday:" + super.getBirthday()
                + "\nAcademy:" + super.getFaculty() + "\nProfession:" + this.getMajor();
        System.out.println(str);
    }

}
