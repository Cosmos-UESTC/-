package com.cn.dao;

import java.io.*;
import java.util.*;
import com.cn.model.Admin;

public class AdministratorDao {
//		//����ID-Key�Ĺ���Ա��֤��չģ��
//		public Map<String, String> readAdmin() {
//			Map<String, String> map = new HashMap<>();
//	        try (BufferedReader br = new BufferedReader(new FileReader("administrator.txt"))) {
//	            String line = br.readLine();
//	            String[] textData = null;
//	            while (line != null) {
//	                textData = line.split(" ");
//	                String name = textData[0];
//	                String password = textData[1];
//	                map.put(name, password);
//	                line = br.readLine();
//	            }
//	        } catch (FileNotFoundException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	        return map;
//	    }
	
		//���ļ���ȡ����Ա��Ϣ
		public static ArrayList<Admin> readAdmin(){
			ArrayList<Admin> list = new ArrayList<>();  //�½�����
			try (BufferedReader br = new BufferedReader(new FileReader("D:\\Eclipse-Workplace\\MNO_Grade_Management_System/src/data/administrator.txt"))) {
				String line = br.readLine();
				String[] textData = null;
				while (line != null) {
					textData = line.split(" ");
					String ID = textData[0];
					String Name = textData[1];
					String Gender = textData[2];
					String Birthday = textData[3];
					String Faculty = textData[4];
					String Type = textData[5];
					Admin admin = new Admin(ID, Name, Gender, Birthday, Faculty, Type);
					list.add(admin);
					line = br.readLine();
				}	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			return list;
		}
	//******************************************************//
		//д����Ա��Ϣ���ļ�
		public static int writeAdmin(Admin admin) {
			ArrayList<Admin> list = readAdmin();
			list.add(admin);
			int num = 0;
			try {
				FileWriter fileWriter = new FileWriter("D:\\Eclipse-Workplace\\MNO_Grade_Management_System/src/data/administrator.txt");
				for (int i = 0; i < list.size(); i++) {
					Admin stu = list.get(i);
					fileWriter.write(
							stu.getID() + " " + stu.getName() + " " + stu.getGender() + " " + 
							stu.getBirthday() + " " + stu.getFaculty() + " " + stu.getType() + "\r\n");
				}
				fileWriter.flush();
				fileWriter.close();
				num = 1;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return num;
		}
	//******************************************************//
		//ɾ����Ӧ����Ա��Ϣ
		public int delAdmin(String name) {
			ArrayList<Admin> list = readAdmin();
			int num = 0;
			for (int i = 0; i < list.size(); i++) {
				if (name.equals(list.get(i).getName())) {
					list.remove(i);
				}
			}
			try {
				FileWriter fileWriter = new FileWriter("D:\\Eclipse-Workplace\\MNO_Grade_Management_System/src/data/administrator.txt");
				for (int i = 0; i < list.size(); i++) {
					Admin stu = list.get(i);
					fileWriter.write(
							stu.getID() + " " + stu.getName() + " " + stu.getGender() + " " + 
							stu.getBirthday() + " " + stu.getFaculty() + " " + stu.getType() + "\r\n");
				}
				fileWriter.flush();
				fileWriter.close();
				num = 1;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return num;
		}
	//******************************************************//
		//��ѯ����Ա��Ϣ
		public static ArrayList<Admin> findAdmin(String name) {
			ArrayList<Admin> list = readAdmin();
			ArrayList<Admin> newlist = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().contains(name)){
					newlist.add(list.get(i));
				}
			}	
			return newlist;
		}
	}
