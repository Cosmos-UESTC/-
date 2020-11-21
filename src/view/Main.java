package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import com.cn.dao.StudentDao;
import com.cn.dao.AdministratorDao;
import com.cn.dao.TeacherDao;
import com.cn.model.Admin;
import com.cn.model.Student;
import com.cn.model.Teacher;

@SuppressWarnings("unused")

public class Main{
		static String finalId = "-1";
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
//		        JLabel jl2 = new JLabel("����");
		        JTextField jt = new JTextField("",20);
//		        JPasswordField jpf = new JPasswordField();
//		        jpf.setEchoChar('*');
		        JButton jb1 = new JButton("��½");
		        JButton jb2 = new JButton("����");
		        //���õ�½��ť����
		        jb1.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println(jt.getText());
//		            	System.out.println(jpf.getText());
		            	
		            	finalId = jt.getText();
		            	int flag = 999;
		            	System.out.println(!StudentDao.findStudent(finalId).isEmpty());
		            	if(!StudentDao.findStudent(finalId).isEmpty()) {
//		            		ArrayList<Student> newlist = new ArrayList<>();
//			    			newlist = StudentDao.findStudent(finalId);
//			    			Student foundStudent = newlist.get(0);
//			    			System.out.println("Name="+foundStudent.getName()+" "+"ID="+foundStudent.getID());
			    			flag = 0;
			    			
		            	}
		            	
		            	else if(!TeacherDao.findTeacher(finalId).isEmpty()) {
//		            		ArrayList<Teacher> newlist1 = new ArrayList<>();
//			    			newlist1 = TeacherDao.findTeacher(finalId);
//			    			Teacher foundTeacher = newlist1.get(0);
//			    			System.out.println("Name="+foundTeacher.getName()+" "+"ID="+foundTeacher.getID());
			    			flag = 1;
			    			
		            	}
		            	else {flag = -1;}
		    			
//		    			ArrayList<Admin> newlist2 = new ArrayList<>();
//		    			newlist2 = AdministratorDao.findAdmin(finalId);
//		    			Admin foundAdmin = newlist2.get(0);
//		    			System.out.println("Name="+foundAdmin.getName()+" "+"ID="+foundAdmin.getID());
		    			
		            	jt.setText("");//�˴�ԭ����Ӧ��дΪ���ܺ��ID��
//		                jpf.setText("");	//��������Ϊ��*******��	 
		            	     
		                    
		                    switch(flag) {
		                    	case 0:
		                    		System.out.println("xs��½�ɹ���");
				                    JOptionPane.showMessageDialog(null, "��¼�ɹ���");
		                    		new StuOperation();dispose();
		                    		break;
		                    	case 1:
		                    		System.out.println("js��½�ɹ���");
				                    JOptionPane.showMessageDialog(null, "��¼�ɹ���");
		                    		new TeaOperation();dispose();
		                    		break;
		                    	case 2:
		                    		System.out.println("gly��½�ɹ���");
				                    JOptionPane.showMessageDialog(null, "��¼�ɹ���");
//		                    		new AdmOperation();dispose();
		                    		break;
		                    	default :
		                    		System.out.println("��¼ʧ�ܣ�");
				                    JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�");
				                    JOptionPane.showMessageDialog(null, "��������ȷ��ID��");
				                    jt.requestFocus();
		                    }
        
		            }
		        });
		        
		        //�������ð�ť����
		        jb2.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                jt.setText("");
//		                jpf.setText("");
		                //�������ý���
		                jt.requestFocus();
		            }
		        });    
		        //���ؼ�����������
		        cont.add(jl1);
//		        cont.add(jl2);
		        cont.add(jt);
//		        cont.add(jpf);
		        cont.add(jb1);
		        cont.add(jb2);
		       
		        //�ؼ��������е�λ�ü���С
		        jl1.setBounds(40, 20, 50, 20);
//		        jl2.setBounds(40, 50, 50, 20);
		        jt.setBounds(90,20,200,20);
//		        jpf.setBounds(90,50,200,20);
		        jb1.setBounds(110,90,60,20);
		        jb2.setBounds(180,90,60,20);
		        //�����ڵ����е�λ�ü���С
		        this.setBounds(780, 350, 360, 160);
		        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        //���ô��岻��������
		        this.setResizable(false);
		        this.setVisible(true);
		    }
		} 
		
		
		//ѧ����¼����
		@SuppressWarnings("serial")
		public static class StuOperation extends JFrame {
			public StuOperation() {
				super();
				this.setTitle("ѧ��");
		        //��������
		        Container cont = getContentPane();
		        //�رվ��Բ��� 
		        this.setLayout(null);
		        //�����ؼ�		        
		        JButton jb1 = new JButton("��Ϣ��ѯ");JButton jb2 = new JButton("�ɼ���ѯ");
		        JButton jb3 = new JButton("�γ̲�ѯ");JButton jb4 = new JButton("�޸���Ϣ");
		        JButton jb5 = new JButton("����");
		        //������Ϣ��ѯ��ť����
		        jb1.addActionListener(new ActionListener() {
		            
					@Override
		            public void actionPerformed(ActionEvent e) {
						System.out.println("��Ϣ��ѯ�������");
						ArrayList<Student> newlist = new ArrayList<>();
		    			newlist = StudentDao.findStudent(finalId);
		    			Student foundStudent = newlist.get(0);
		    			
		    			System.out.println("ID="+foundStudent.getID()+" "+"Name="+foundStudent.getName()+" "+"Gender="+foundStudent.getGender()+" "+
		    			"Birthday="+foundStudent.getBirthday()+" "+"Faculty="+foundStudent.getFaculty()+" "+"Major="+foundStudent.getMajor());
		    			
		    			JOptionPane.showMessageDialog(null, "ID="+foundStudent.getID()+" "+"Name="+foundStudent.getName()+"\n"+"Gender="+foundStudent.getGender()+" "+
				    			"Birthday="+foundStudent.getBirthday()+"\n"+"Faculty="+foundStudent.getFaculty()+" "+"Major="+foundStudent.getMajor());
		            }
		        });
		        //���óɼ���ѯ��ť����
		        jb2.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("�ɼ���ѯ");
		            }
		        });
		        //���ÿγ̲�ѯ����
		        jb3.addActionListener(new ActionListener() {
		        	@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("�γ̲�ѯ");
		            }
		        });		        
		        //�����޸���Ϣ����
				jb4.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("�޸���Ϣ");
		            	new StuEdit();
		            	dispose();
		            }
		        });
				//���÷��ذ�ť����
				jb5.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("����");
		            	new Login();
		            	dispose();
		            }
		        });
				
				
		        //���ؼ�����������		       
		        cont.add(jb1);cont.add(jb2);
		        cont.add(jb3);cont.add(jb4);
		        cont.add(jb5);	       
		        //�ؼ��������е�λ�ü���С		        
		        jb1.setBounds(100,50,300,100);jb2.setBounds(100,200,300,100);
		        jb3.setBounds(100,350,300,100);jb4.setBounds(100,500,300,100);
		        jb5.setBounds(100,650,300,100);
		        //�����ڵ����е�λ�ü���С
		        this.setBounds(720, 200, 500, 850);
		        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        //���ô��岻��������
		        this.setResizable(false);
		        this.setVisible(true);
		    }
		}
		
		//ѧ����Ϣ�޸�ҳ��
		@SuppressWarnings("serial")
		public static class StuEdit extends JFrame {
			public StuEdit() {
				super();
				this.setTitle("��Ϣ�޸�");
		        //��������
		        Container cont = getContentPane();
		        //�رվ��Բ��� 
		        this.setLayout(null);
		        //�����ؼ�
		        JLabel jl1 = new JLabel("����");JLabel jl2 = new JLabel("����");
		        JLabel jl3 = new JLabel("ѧԺ");JLabel jl4 = new JLabel("רҵ");
		        JLabel jl5 = new JLabel("������");JLabel jl6 = new JLabel("ȷ������");
		        JButton jb1 = new JButton("�ύ");JButton jb2 = new JButton("����");
		        JTextField jt1 = new JTextField("",20);JTextField jt2 = new JTextField("",20);
		        JTextField jt3 = new JTextField("",20);JTextField jt4 = new JTextField("",20);
		        JTextField jt5 = new JTextField("",20);JTextField jt6 = new JTextField("",20);
		        JRadioButton jr1 = new JRadioButton("��",true);JRadioButton jr2 = new JRadioButton("Ů");
		        ButtonGroup G=new ButtonGroup();
		        //�����ύ��ť����
		        jb1.addActionListener(new ActionListener() {
   
					@Override
		            public void actionPerformed(ActionEvent e) {
						System.out.println("�ύ�ɹ�");
						
						
						System.out.println(jt1.getText());System.out.println(jt2.getText());
						System.out.println(jt3.getText());System.out.println(jt4.getText());
						System.out.println(jt5.getText());System.out.println(jt6.getText());
						System.out.println("Male="+jr1.isSelected());System.out.println("Female="+jr2.isSelected());
						JOptionPane.showMessageDialog(null, "�ύ�ɹ���");
						new StuOperation();
		            	dispose();
		            }
		        });
				//���÷��ذ�ť����
				jb2.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("����");
		            	new StuOperation();
		            	dispose();
		            }
		        });
		        //���ؼ�����������		       
				cont.add(jl1);cont.add(jl2);cont.add(jl3);cont.add(jl4);
				cont.add(jl5);cont.add(jl6);cont.add(jb1);cont.add(jb2);
		        cont.add(jt1);cont.add(jt2);cont.add(jt3);cont.add(jt4);
		        cont.add(jt5);cont.add(jt6);cont.add(jr1);cont.add(jr2);		        
		        G.add(jr1);G.add(jr2);
		        //�ؼ��������е�λ�ü���С
		        jl1.setBounds(50,50,75,40);jr1.setBounds(150,125,75,40);
		        jr2.setBounds(250,125,75,40);jl2.setBounds(50,200,75,40);
		        jl3.setBounds(50,275,75,40);jl4.setBounds(50,350,75,40);
		        jl5.setBounds(50,425,75,40);jl6.setBounds(50,500,75,40);
		        jt1.setBounds(150,50,300,40);jt2.setBounds(150,200,300,40);
		        jt3.setBounds(150,275,300,40);jt4.setBounds(150,350,300,40);
		        jt5.setBounds(150,425,300,40);jt6.setBounds(150,500,300,40);
		        jb1.setBounds(100,600,100,50);jb2.setBounds(300,600,100,50);
		        //�����ڵ����е�λ�ü���С
		        this.setBounds(720, 150, 500, 750);
		        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        //���ô��岻��������
		        this.setResizable(false);
		        this.setVisible(true);
		    }
		}
		
		
		//��ʦ��¼����
		@SuppressWarnings("serial")
		public static class TeaOperation extends JFrame {
			public TeaOperation() {
				super();
				this.setTitle("��ʦ");
		        //��������
		        Container cont = getContentPane();
		        //�رվ��Բ��� 
		        this.setLayout(null);
		        //�����ؼ�		        
		        JButton jb1 = new JButton("��Ϣ��ѯ");JButton jb2 = new JButton("�޸���Ϣ");
		        JButton jb3 = new JButton("ȫ���γ�");JButton jb4 = new JButton("�ɼ���¼");
		        JButton jb5 = new JButton("�ɼ�ͳ��");JButton jb6 = new JButton("����");
		        //������Ϣ��ѯ��ť����
		        jb1.addActionListener(new ActionListener() {
		            
					@Override
		            public void actionPerformed(ActionEvent e) {
						System.out.println("��Ϣ��ѯ");
		            }
		        });
		        //�����޸���Ϣ��ť����
		        jb2.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("�޸���Ϣ");
		            }
		        });
		        //����ȫ���γ̹���
		        jb3.addActionListener(new ActionListener() {
		        	@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("ȫ���γ�");
		            }
		        });		        
		        //���óɼ���¼����
				jb4.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("�ɼ���¼");
		            }
		        });
				//���óɼ�ͳ��ť����
				jb5.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("�ɼ�ͳ��");
		            }
		        });
				//���÷��ذ�ť����
				jb6.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("����");
		            	new Login();
		            	dispose();
		            }
		        });
				
				
		        //���ؼ�����������		       
		        cont.add(jb1);cont.add(jb2);
		        cont.add(jb3);cont.add(jb4);
		        cont.add(jb5);cont.add(jb6);
		        //�ؼ��������е�λ�ü���С
		        
		        jb1.setBounds(100,50,300,75);jb2.setBounds(100,150,300,75);
		        jb3.setBounds(100,250,300,75);jb4.setBounds(100,350,300,75);
		        jb5.setBounds(100,450,300,75);jb6.setBounds(100,550,300,75);
		        //�����ڵ����е�λ�ü���С
		        this.setBounds(720, 200, 500, 750);
		        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        //���ô��岻��������
		        this.setResizable(false);
		        this.setVisible(true);
		    }
		}
		
		
//		//����Ա��¼����
//		@SuppressWarnings("serial")
//		public static class AdmOperation extends JFrame {
//			public AdmOperation() {
//				super();
//				this.setTitle("����Ա");
//		        //��������
//		        Container cont = getContentPane();
//		        //�رվ��Բ��� 
//		        this.setLayout(null);
//		        //�����ؼ�		        
//		        JButton jb1 = new JButton("Text1");
//		        JButton jb2 = new JButton("Text2");
//		        JButton jb3 = new JButton("Text3");
//		        JButton jb4 = new JButton("Text4");
//		        JButton jb5 = new JButton("����");
//		        //���ð�ť����
//		        jb1.addActionListener(new ActionListener() {
//		            
//					@Override
//		            public void actionPerformed(ActionEvent e) {
//						System.out.println("Text1");
//		            }
//		        });
//		        //���ð�ť����
//		        jb2.addActionListener(new ActionListener() {
//		            @Override
//		            public void actionPerformed(ActionEvent e) {
//		            	System.out.println("Text2");
//		            }
//		        });
//		        //���ð�ť����
//		        jb3.addActionListener(new ActionListener() {
//		        	@Override
//		            public void actionPerformed(ActionEvent e) {
//		            	System.out.println("Text3");
//		            }
//		        });		        
//		        //���ð�ť����
//				jb4.addActionListener(new ActionListener() {
//					@Override
//		            public void actionPerformed(ActionEvent e) {
//		            	System.out.println("Text4");
//		            }
//		        });
//				//���ð�ť����
//				jb5.addActionListener(new ActionListener() {
//					@Override
//		            public void actionPerformed(ActionEvent e) {
//		            	System.out.println("����");
//		            	new Login();
//		            	dispose();
//		            }
//		        });
//				
//				
//		        //���ؼ�����������		       
//		        cont.add(jb1);
//		        cont.add(jb2);
//		        cont.add(jb3);
//		        cont.add(jb4);
//		        cont.add(jb5);	       
//		        //�ؼ��������е�λ�ü���С
//		        jb1.setBounds(100,50,300,100);
//		        jb2.setBounds(100,200,300,100);
//		        jb3.setBounds(100,350,300,100);
//		        jb4.setBounds(100,500,300,100);
//		        jb5.setBounds(100,650,300,100);
//		        //�����ڵ����е�λ�ü���С
//		        this.setBounds(720, 200, 500, 850);
//		        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		        //���ô��岻��������
//		        this.setResizable(false);
//		        this.setVisible(true);
//		    }
//		}
		
		public static void main(String[] args){
		 	new Login();
			
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
			
			
//			String str = "2019271020123";
//			ArrayList<Student> newlist = new ArrayList<>();
//			newlist = StudentDao.findStudent(str);
//			Student foundStudent = newlist.get(0);
//			System.out.println("Name="+foundStudent.getName()+" "+"ID="+foundStudent.getID());
			
	    }
}

