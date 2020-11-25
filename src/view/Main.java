package view;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.cn.GUI.GUI;
import com.cn.dao.AdministratorDao;
import com.cn.dao.CourseDao;
import com.cn.dao.CourseStuDao;
import com.cn.dao.ScoreDao;
import com.cn.dao.StudentDao;
import com.cn.dao.TeacherDao;

import com.cn.model.Admin;
import com.cn.model.Course;
import com.cn.model.CourseStu;
import com.cn.model.Score;
import com.cn.model.Student;
import com.cn.model.Teacher;
import com.cn.util.StringUtil;

@SuppressWarnings("unused")

public class Main{
		static String finalId = "-1";
		static String finalCourseId = "-1";
		@SuppressWarnings("serial")
		public static class Login extends JFrame {
			public Login() {
				super();
				this.setTitle("�˺Ź���");
		        //��������
		        Container cont = getContentPane();
		        //�رվ��Բ��� 
		        this.setLayout(null);
		        //�����ؼ�
		        JLabel jl1 = new JLabel("ID��");
		        JLabel jl2 = new JLabel("����");
		        JTextField jt = new JTextField("",20);
		        JPasswordField jpf = new JPasswordField();
		        jpf.setEchoChar('*');
		        JButton jb1 = new JButton("��½");
		        JButton jb2 = new JButton("����");
		        JOptionPane.showMessageDialog(null, "��������Ϊ��ֵ����������½��");
		        //���õ�½��ť����
		        jb1.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	finalId = jt.getText();
		            	int flag = -1;
//		            	System.out.println(!StudentDao.findStudent(finalId).isEmpty());
//		            	System.out.println(!TeacherDao.findTeacher(finalId).isEmpty());
//		            	System.out.println(!AdministratorDao.findAdmin(finalId).isEmpty());
		            	if(StringUtil.isNull(finalId)) {
		            		System.out.println("����Ϊ�գ�");
		            		JOptionPane.showMessageDialog(null, "����Ϊ�գ�");
		            		JOptionPane.showMessageDialog(null, "��������ȷ��ID��");
		            		jt.requestFocus();
		            	} 
		            	else if(!StringUtil.isNumeric(finalId)) {
		            		System.out.println("��ʽ����");
		            		JOptionPane.showMessageDialog(null, "��ʽ����");
		            		JOptionPane.showMessageDialog(null, "������IDΪ��������ϣ�");
		            		JOptionPane.showMessageDialog(null, "������Ϸ���ID��");
		            		jt.requestFocus();
		            	}
		            	else {
		            		if(!StudentDao.findStudent(finalId).isEmpty()) {
		            			flag = 0;	
		            		}
		            	
		            		else if(!TeacherDao.findTeacher(finalId).isEmpty()) {
		            			flag = 1;
			    			
		            		}
		            		else {flag = -1;}
		    			
		            	jt.setText("");jpf.setText("");
		                    switch(flag) {
		                    	case 0:
		                    		System.out.println("ѧ����½�ɹ���");
				                    JOptionPane.showMessageDialog(null, "��¼�ɹ���");
		                    		new GUI.StuOperation(finalId);dispose();
		                    		break;
		                    	case 1:
		                    		System.out.println("��ʦ��½�ɹ���");
				                    JOptionPane.showMessageDialog(null, "��¼�ɹ���");
		                    		new GUI.TeaOperation(finalId);dispose();
		                    		break;
		                    	case 2:
		                    		System.out.println("����Ա��½�ɹ���");
				                    JOptionPane.showMessageDialog(null, "��¼�ɹ���");
//		                    		new GUI.AdmOperation();dispose();
		                    		break;
		                    	default :
		                    		System.out.println("��¼ʧ�ܣ�");
				                    JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�");
				                    JOptionPane.showMessageDialog(null, "����������ID��");
				                    jt.requestFocus();
		                    }
		          		}
		            }
		        });
		        
		        //�������ð�ť����
		        jb2.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                jt.setText("");
		                jpf.setText("");
		                //�������ý���
		                jt.requestFocus();
		            }
		        });    
		        //���ؼ�����������
		        cont.add(jl1);cont.add(jl2);
		        cont.add(jt);cont.add(jpf);
		        cont.add(jb1);cont.add(jb2);
		        //�ؼ��������е�λ�ü���С
		        jl1.setBounds(40, 20, 50, 20);jl2.setBounds(40, 50, 50, 20);
		        jt.setBounds(90,20,200,20);jpf.setBounds(90,50,200,20);
		        jb1.setBounds(110,90,60,20);jb2.setBounds(180,90,60,20);
		        //�����ڵ����е�λ�ü���С
		        this.setBounds(780, 350, 360, 160);
		        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        //���ô��岻��������
		        this.setResizable(false);
		        this.setVisible(true);
			}
		} 
		
		public static void main(String[] args){
		 	new Login();
//          ���²���Ϊ��ʼ���������Բ��Բ��֣������趨data�ļ�����ʱ����ע�͡���ҵ�и�������Ѿ���ʼ����
//			Course Java = new Course("A00001", "Java", "6.0", "1-17", "100000002", "FuChong");
//			Course C = new Course("A00002", "C", "4.0", "1-17", "100000001", "BaiZhongjian");			
//			Admin HeadMaster = new Admin("000000001", "ZengYong", "Male", "19630101", "Management", "headMaster");
//			Teacher LaoBai = new Teacher("100000001", "BaiZhongjian", "Male", "19800101", "Software_engineering", "lecturer");
//			Teacher FuChong = new Teacher("100000002", "FuChong", "Male", "19800101", "Computer_science", "professor");
//			Student testStudent = new Student("2019091601001", "Unknown", "Male", "20000101", "Software_engineering", "Network_security");
//			Student LvGe = new Student("2019091602004", "CaiSiyuan", "Male", "20010202", "Software_engineering", "Network_security");
//			Student XuanXuanxuan = new Student("2019091602005", "PengXuanyue", "Male", "20000303", "Software_engineering", "Embedded_system");
//			Student YueXinfeng = new Student("2019091602014", "FengXinyue", "Male", "20010404", "Software_engineering", "Network_security");
//			Student HuangLao = new Student("2019091602025", "HuangZizhan", "Male", "20010505", "Software_engineering", "Digital_animation");
//			Student LinShudan = new Student("2019091602027", "LinShudan", "Female", "20010606", "Software_engineering", "System_and_technology");
//			Student XiuEr = new Student("2019091602009", "ShiMaoyuam", "Male", "20060707", "Software_engineering", "Digital_information_processing");
//			Student JiaCheng = new Student("2019458802347", "YuanJiacheng", "Male", "20010808", "Communication_engineering", "Telecommunication");
//			Student LanXin = new Student("2019271020123", "FuLanxin", "Female", "20010909", "Glasgow_Academy", "Communication_engineering");
//			Student Cosmos = new Student("2019451610028", "Cosmos_Von", "Male", "20011010", "Foreign_languages_College", "English");
//		 	
//			AdministratorDao.writeAdmin(HeadMaster);
//			TeacherDao.writeTeacher(LaoBai);
//			TeacherDao.writeTeacher(FuChong);
//			StudentDao.writeStudent(testStudent);
//			StudentDao.writeStudent(LvGe);
//			StudentDao.writeStudent(XuanXuanxuan);
//			StudentDao.writeStudent(YueXinfeng);
//			StudentDao.writeStudent(HuangLao);
//			StudentDao.writeStudent(LinShudan);
//			StudentDao.writeStudent(XiuEr);
//			StudentDao.writeStudent(JiaCheng);
//			StudentDao.writeStudent(LanXin);
//			StudentDao.writeStudent(Cosmos);
//			CourseDao.writeCourse(Java);
//			CourseDao.writeCourse(C);
		 	
//		 	System.out.println(Course.ifCourseExist(finalCourseId));     
//		 	System.out.println(Score.ifScoreExist(finalId,"Java"));	
//		 	System.out.println(	!TeacherDao.findTeacher("100000001").isEmpty());
//			System.out.println(StringUtil.isScoreLegal(-1));
	    }
}