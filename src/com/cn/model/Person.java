package com.cn.model;

public abstract class Person {
	private String ID;
	private String Name;
	private String Gender;
	private String Birthday;
	private String Faculty;
	
	public Person (String ID, String Name, String Gender, String Birthday, String Faculty){
		super();
		this.ID = ID;
		this.Name = Name;
		this.Gender = Gender;
		this.Birthday = Birthday;
		this.Faculty = Faculty;
	}
	
	public Person() {
		super();
	}
	
	public String getID() {
		return ID;
	}
	//��ȡID
	public String getName() {
		return Name;
	}
	//��ȡ����
	public String getGender() {
		return Gender;
	}
	//��ȡ�Ա�
	public String getBirthday() {
		return Birthday;
	}
	//��ȡ������
	public String getFaculty() {
		return Faculty;
	}
	//��ȡ����רҵ
	
//*********************************************//
	public void setID(String ID) {
		this.ID=ID;
	}
	//����ID
	public void setName(String Name) {
		this.Name=Name;
	}
	//��������
	public void setGender(String Gender) {
		this.Gender=Gender;
	}
	//�����Ա�
	public void setBirthday(String Birthday) {
		this.Birthday = Birthday;
	}
	//���ó�����
	public void setFaculty(String Faculty) {
		this.Faculty=Faculty;
	}
	//��������רҵ
	public abstract void info();
		
}

