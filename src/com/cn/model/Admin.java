package com.cn.model;

public class Admin extends Person{
	private String Type; //ְλ
	public Admin(String ID, String Name, String Gender, String Birthday, String Faculty, String Type) {
		super(ID, Name, Gender, Birthday, Faculty);
		this.Type=Type;
	}
	
	public String getType() {
		return Type;
	}
	//��ȡְλ
	protected void setType(String Type) {
		this.Type=Type;
	}
	//����ְλ
	
	public void info()
    {
        String str = "ID:" + super.getID() + "\nName:" + super.getName() + "\nGender:" + super.getGender() + "\nBirthday:" + 
        			 super.getBirthday()+ "\nFaculty:" + super.getFaculty() + "\nType:" + this.getType();
        System.out.println(str);
    }
}
