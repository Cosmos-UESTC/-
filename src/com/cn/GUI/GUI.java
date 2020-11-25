package com.cn.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.cn.dao.CourseDao;
import com.cn.dao.CourseStuDao;
import com.cn.dao.ScoreDao;
import com.cn.dao.StudentDao;
import com.cn.dao.TeacherDao;
import com.cn.model.Course;
import com.cn.model.CourseStu;
import com.cn.model.Score;
import com.cn.model.Student;
import com.cn.model.Teacher;
import com.cn.util.StringUtil;

import view.Main;


public class GUI {
			static String finalId = "-1";
			static String finalCourseId = "-1";
			
			//ѧ����¼����
			@SuppressWarnings("serial")
			public static class StuOperation extends JFrame {
				public StuOperation(String finalId) {
					super();
					this.setTitle("ѧ��");
			        //��������
			        Container cont = getContentPane();
			        //�رվ��Բ��� 
			        this.setLayout(null);
			        //�����ؼ�		        
			        JButton jb1 = new JButton("��Ϣ��ѯ");JButton jb2 = new JButton("�ɼ���ѯ");
			        JButton jb3 = new JButton("�γ̲�ѯ");JButton jb4 = new JButton("�޸���Ϣ");
			        JButton jb5 = new JButton("�˳���¼");
			        //������Ϣ��ѯ��ť����
			        jb1.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
							ArrayList<Student> newlist = new ArrayList<>();
			    			newlist = StudentDao.findStudent(finalId);
			    			Student foundStudent = newlist.get(0);
			    			JOptionPane.showMessageDialog(null, "ID = "+foundStudent.getID()+"\n"+"Name = "+foundStudent.getName()+"\n"+"Gender = "+foundStudent.getGender()
			    					+"\n"+"Birthday = "+foundStudent.getBirthday()+"\n"+"Faculty = "+foundStudent.getFaculty()+"\n"+"Major = "+foundStudent.getMajor());
			            }
			        });
			        
			        //���óɼ���ѯ��ť����
			        jb2.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("�ɼ���ѯ");
			            	new stuScoreCheck(finalId);
			            }
			        });
			        
			        //���ÿγ̲�ѯ����
			        jb3.addActionListener(new ActionListener() {
			        	@Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("�γ̲�ѯ");
			            	new stuCourseCheck(finalId);
			            }
			        });		        
			        //�����޸���Ϣ����
					jb4.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("�޸���Ϣ");
			            	new StuEdit(finalId);
			            	dispose();
			            }
			        });
					//�����˳���ť����
					jb5.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("�˳���¼");
			            	new Main.Login();
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
				public StuEdit(String finalId) {
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
			        JPasswordField jpf1 = new JPasswordField();JPasswordField jpf2 = new JPasswordField();
			        jpf1.setEchoChar('*');jpf2.setEchoChar('*');
			        JRadioButton jr1 = new JRadioButton("��",true);JRadioButton jr2 = new JRadioButton("Ů");
			        ButtonGroup G=new ButtonGroup();
			        
			        //�����ύ��ť����
			        jb1.addActionListener(new ActionListener() {
						@SuppressWarnings("deprecation")
						@Override
			            public void actionPerformed(ActionEvent e) {
							//���ݺϷ���У��
							if(jt1.getText().equals("")||jt2.getText().equals("")|| jt3.getText().equals("")||jt4.getText().equals("")||jpf1.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "����ȷ��д��Ϣ��");
								new StuEdit(finalId);
								dispose();
								return ;
							}
							//����һ����У��
							if(!(jpf1.getText().equals(jpf2.getText()))) {							
								JOptionPane.showMessageDialog(null, "�������벻ƥ�䣡��");					
								jpf2.setText("");							
								new StuEdit(finalId);
								dispose();
								return ;						
							}
							//���ڸ�ʽ�Ϸ���У��
							if(StringUtil.isNumeric(jt2.getText())) {
								JOptionPane.showMessageDialog(null, "���ڸ�ʽ�Ƿ�����");	
								JOptionPane.showMessageDialog(null, "��ʽ�ο���yyyy-MM-dd");	
								jpf2.setText("");							
								new StuEdit(finalId);
								dispose();
								return ;
							}
							//У��ͨ��
							StudentDao.delStudent(finalId);
							String genderTemp = "Error";
							if(jr1.isSelected()) {genderTemp = "Male";} 
							else {genderTemp = "Female";}
							Student newStu = new Student(finalId, jt1.getText(), genderTemp, jt2.getText(), jt3.getText(), jt4.getText());
							StudentDao.writeStudent(newStu);
							JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
							new StuOperation(finalId);
			            	dispose();
			            }
			        });
			        
					//���÷��ذ�ť����
					jb2.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	new StuOperation(finalId);
			            	dispose();
			            }
			        });
					
			        //���ؼ�����������		       
					cont.add(jl1);cont.add(jl2);cont.add(jl3);cont.add(jl4);
					cont.add(jl5);cont.add(jl6);cont.add(jb1);cont.add(jb2);
			        cont.add(jt1);cont.add(jt2);cont.add(jt3);cont.add(jt4);
			        cont.add(jpf1);cont.add(jpf2);cont.add(jr1);cont.add(jr2);		        
			        G.add(jr1);G.add(jr2);
			        
			        //�ؼ��������е�λ�ü���С
			        jl1.setBounds(50,50,75,40);jr1.setBounds(150,125,75,40);
			        jr2.setBounds(250,125,75,40);jl2.setBounds(50,200,75,40);
			        jl3.setBounds(50,275,75,40);jl4.setBounds(50,350,75,40);
			        jl5.setBounds(50,425,75,40);jl6.setBounds(50,500,75,40);
			        jt1.setBounds(150,50,300,40);jt2.setBounds(150,200,300,40);
			        jt3.setBounds(150,275,300,40);jt4.setBounds(150,350,300,40);
			        jpf1.setBounds(150,425,300,40);jpf2.setBounds(150,500,300,40);
			        jb1.setBounds(100,600,100,50);jb2.setBounds(300,600,100,50);
			        
			        //�����ڵ����е�λ�ü���С
			        this.setBounds(720, 150, 500, 750);
			        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			        //���ô��岻��������
			        this.setResizable(false);
			        this.setVisible(true);
			    }
			}
			
			//ѧ���ɼ���ѯҳ��
			@SuppressWarnings("serial")
			public static class stuScoreCheck extends JFrame {
				private JTable table;
			    private JPanel contentPane;
			    private DefaultTableModel defaultTableModel;
			    private int DEFAULE_HEIGH = 600;
			    private int DEFAULE_WIDTH = 1000;
			    Toolkit toolkit = Toolkit.getDefaultToolkit();	    
			    int Location_x = (int) (toolkit.getScreenSize().getWidth() - DEFAULE_WIDTH) / 2;
			    int Location_y = (int) (toolkit.getScreenSize().getHeight() - DEFAULE_HEIGH) / 2;
			    //����Ӧ����Ļ����
			    
			    public stuScoreCheck(String finalId) {
			        contentPane = new JPanel();
			        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			        contentPane.setLayout(new BorderLayout());
			        
			        ArrayList<Score> newlist1 = new ArrayList<>();
			        newlist1 = ScoreDao.findScore("Java", finalId);
			        
			        ArrayList<Score> newlist2 = new ArrayList<>();
			        newlist2 = ScoreDao.findScore("C", finalId);
			        
			        String[] n1 = { newlist1.get(0).getcourseId(), newlist1.get(0).getcourseName(), newlist1.get(0).getcourseTeacherId(), newlist1.get(0).getcourseTeacherName(),
			        		newlist1.get(0).getstudentId(), newlist1.get(0).getstudentName(), newlist1.get(0).getstudentScore()};
			        String[] n2 = { newlist2.get(0).getcourseId(), newlist2.get(0).getcourseName(), newlist2.get(0).getcourseTeacherId(), newlist2.get(0).getcourseTeacherName(),
			        		newlist2.get(0).getstudentId(), newlist2.get(0).getstudentName(), newlist2.get(0).getstudentScore()};
			        Object[][] p = {n1, n2};
			        String[] n = { "�γ̴���", "�γ�����", "��ʦID", "��ʦ����", "ѧ��", "ѧ������","�ɼ�"};

			        
			        defaultTableModel = new DefaultTableModel(p, n); // ��˫���鴴��DefaultTableModel����
			        table = new JTable(defaultTableModel);// ����������
			        table.setRowHeight(30);// ���ñ���п�
			        		        
			        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);// �����������������ʼ���б����
			        contentPane.add(scrollPane, BorderLayout.CENTER);

			        setVisible(true);
			        setTitle("�ɼ���ѯ");
			        setContentPane(contentPane);
			        setLocation(Location_x, Location_y);
			        setSize(DEFAULE_WIDTH, DEFAULE_HEIGH);
			        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//default = JFrame.EXIT_ON_CLOSE;
			    }
			}
			    
			//ѧ���γ̲�ѯ����
			@SuppressWarnings("serial")
			public static class stuCourseCheck extends JFrame{
				private JPanel contentPane;
			    private DefaultTableModel defaultTableModel;
			    private JTable table;
			    Toolkit toolkit = Toolkit.getDefaultToolkit();
			    private int DEFAULE_WIDTH = 1000;
			    private int DEFAULE_HEIGH = 600;
			    int Location_x = (int) (toolkit.getScreenSize().getWidth() - DEFAULE_WIDTH) / 2;
			    int Location_y = (int) (toolkit.getScreenSize().getHeight() - DEFAULE_HEIGH) / 2;
			    //����Ӧ����Ļ����
			    
			    public stuCourseCheck(String finalId) {

			        contentPane = new JPanel();
			        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			        contentPane.setLayout(new BorderLayout());
			        
			        ArrayList<CourseStu> list1 = new ArrayList<>();
			        list1 = CourseStuDao.findCourseStu(finalId,"java");
			        ArrayList<CourseStu> list2 = new ArrayList<>();
			        list2 = CourseStuDao.findCourseStu(finalId,"c");
			        String str1 = list1.get(0).getCourseId();
			        String str2 = list2.get(0).getCourseId();
			        
			        ArrayList<Course> newlist1 = new ArrayList<>();
			        newlist1 = CourseDao.findCourse(str1);
			        ArrayList<Course> newlist2 = new ArrayList<>();
			        newlist2 = CourseDao.findCourse(str2);
			        
//			        CourseStu.ifCourseStuExist("java", finalId);
			        String[] s = {"","","",""};
			        String[] n = { "�γ̴���", "�γ�����", "ѧ��", "ѧʱ", "�ον�ʦ"};
			        String[] n1 = { newlist1.get(0).getcourseId(), newlist1.get(0).getcourseName(), newlist1.get(0).getcourseCredit(), newlist1.get(0).getcourseHours(), newlist1.get(0).getcourseTeacherName()};
			        String[] n2 = { newlist2.get(0).getcourseId(), newlist2.get(0).getcourseName(), newlist2.get(0).getcourseCredit(), newlist1.get(0).getcourseHours(), newlist1.get(0).getcourseTeacherName()};
			        if(list1.isEmpty() && list2.isEmpty()) {
			        	Object[][] p = {s, s};
			        	defaultTableModel = new DefaultTableModel(p, n); // ��˫���鴴��DefaultTableModel����
			        }
			        else if(!list1.isEmpty() && list2.isEmpty()) {
			        	Object[][] p = {n1, s};
			        	defaultTableModel = new DefaultTableModel(p, n); // ��˫���鴴��DefaultTableModel����
			        }
			        else if(list1.isEmpty() && !list2.isEmpty()) {
			        	Object[][] p = {n2, s};
			        	defaultTableModel = new DefaultTableModel(p, n); 
			        }
			        else {
			        	Object[][] p = {n1, n2};
			        	defaultTableModel = new DefaultTableModel(p, n); 
			        }
			        
			        table = new JTable(defaultTableModel);// ����������
			        table.setRowHeight(30);// ���ñ���п�
			        
			        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);// ���������������Ĭ�Ϲ�����ʼ�ճ��֣���ʼ���б����
			        contentPane.add(scrollPane, BorderLayout.CENTER);

			        setVisible(true);
			        setTitle("�α��ѯ");
			        setContentPane(contentPane);
			        setLocation(Location_x, Location_y);
			        setSize(DEFAULE_WIDTH, DEFAULE_HEIGH);
			        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//default = JFrame.EXIT_ON_CLOSE;
			    }
			}
			
			//��ʦ��¼����
			@SuppressWarnings("serial")
			public static class TeaOperation extends JFrame {
				public TeaOperation(String finalId) {
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
							ArrayList<Teacher> newlist = new ArrayList<>();
					    	newlist = TeacherDao.findTeacher(finalId);
					    	Teacher foundTeacher = newlist.get(0);
					    	JOptionPane.showMessageDialog(null, "ID="+foundTeacher.getID()+"\n"+"Name="+foundTeacher.getName()+"\n"+"Gender="+foundTeacher.getGender()
					    				+"\n"+"Birthday="+foundTeacher.getBirthday()+"\n"+"Faculty="+foundTeacher.getFaculty()+"\n"+"Title="+foundTeacher.getTitle());
					    }
					});

			        //�����޸���Ϣ��ť����
			        jb2.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	new TeaEdit(finalId);
			            	dispose();
			            }
			        });
			        //�鿴ȫ���γ̹���
			        jb3.addActionListener(new ActionListener() {
			        	@Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("ȫ���γ�");
			            	new teaCourseCheck(finalId);
			            }
			        });		        
			        //���óɼ���¼����
					jb4.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("�ɼ���¼");
			            	new teaScoreManage(finalId);
			            }
			        });
					//���óɼ�ͳ��ť����
					jb5.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("�ɼ�ͳ��");
			            	new teaScoreAnalysis(finalId); 
			            }
			        });
					//���÷��ذ�ť����
					jb6.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("����");
			            	new Main.Login();
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
			
			//��ʦ��Ϣ�޸Ľ���
			@SuppressWarnings("serial")
			public static class TeaEdit extends JFrame {
				public TeaEdit(String finalId) {
					super();
					this.setTitle("��Ϣ�޸�");
			        //��������
			        Container cont = getContentPane();
			        //�رվ��Բ��� 
			        this.setLayout(null);
			        //�����ؼ�
			        JLabel jl1 = new JLabel("����");JLabel jl2 = new JLabel("����");
			        JLabel jl3 = new JLabel("רҵ");JLabel jl4 = new JLabel("ְ��");
			        JLabel jl5 = new JLabel("������");JLabel jl6 = new JLabel("ȷ������");
			        JButton jb1 = new JButton("�ύ");JButton jb2 = new JButton("����");
			        JTextField jt1 = new JTextField("",20);JTextField jt2 = new JTextField("",20);
			        JTextField jt3 = new JTextField("",20);JTextField jt4 = new JTextField("",20);
			        JPasswordField jpf1 = new JPasswordField();JPasswordField jpf2 = new JPasswordField();
			        jpf1.setEchoChar('*');jpf2.setEchoChar('*');
			        JRadioButton jr1 = new JRadioButton("��",true);JRadioButton jr2 = new JRadioButton("Ů");
			        ButtonGroup G=new ButtonGroup();
			        
			        //�����ύ��ť����
			        jb1.addActionListener(new ActionListener() {
						@SuppressWarnings("deprecation")
						@Override
			            public void actionPerformed(ActionEvent e) {
							//���ݺϷ���У��
							if(jt1.getText().equals("")||jt2.getText().equals("")|| jt3.getText().equals("")||jt4.getText().equals("")||jpf1.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "����ȷ��д��Ϣ��");
								new TeaEdit(finalId);
								dispose();
								return ;
							}
							//����һ����У��
							if(!(jpf1.getText().equals(jpf2.getText()))) {							
								JOptionPane.showMessageDialog(null, "�������벻ƥ�䣡��");					
								jpf2.setText("");							
								new TeaEdit(finalId);
								dispose();
								return ;						
							}
							//���ڸ�ʽ�Ϸ���У��
							if(StringUtil.isNumeric(jt2.getText())) {
								JOptionPane.showMessageDialog(null, "���ڸ�ʽ�Ƿ�����");	
								JOptionPane.showMessageDialog(null, "��ʽ�ο���yyyy-MM-dd");	
								jpf2.setText("");							
								new TeaEdit(finalId);
								dispose();
								return ;
							}
							//У��ͨ��
							TeacherDao.delTeacher(finalId);
							String genderTemp = "Error";
							if(jr1.isSelected()) {genderTemp = "Male";} 
							else {genderTemp = "Female";}
							Teacher newTea = new Teacher(finalId, jt1.getText(), genderTemp, jt2.getText(), jt3.getText(), jt4.getText());
							TeacherDao.writeTeacher(newTea);
							JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
							new TeaOperation(finalId);
			            	dispose();
			            }
			        });
			        
					//���÷��ذ�ť����
					jb2.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	new TeaOperation(finalId);
			            	dispose();
			            }
			        });
					
			        //���ؼ�����������		       
					cont.add(jl1);cont.add(jl2);cont.add(jl3);cont.add(jl4);
					cont.add(jl5);cont.add(jl6);cont.add(jb1);cont.add(jb2);
			        cont.add(jt1);cont.add(jt2);cont.add(jt3);cont.add(jt4);
			        cont.add(jpf1);cont.add(jpf2);cont.add(jr1);cont.add(jr2);		        
			        G.add(jr1);G.add(jr2);
			        
			        //�ؼ��������е�λ�ü���С
			        jl1.setBounds(50,50,75,40);jr1.setBounds(150,125,75,40);
			        jr2.setBounds(250,125,75,40);jl2.setBounds(50,200,75,40);
			        jl3.setBounds(50,275,75,40);jl4.setBounds(50,350,75,40);
			        jl5.setBounds(50,425,75,40);jl6.setBounds(50,500,75,40);
			        jt1.setBounds(150,50,300,40);jt2.setBounds(150,200,300,40);
			        jt3.setBounds(150,275,300,40);jt4.setBounds(150,350,300,40);
			        jpf1.setBounds(150,425,300,40);jpf2.setBounds(150,500,300,40);
			        jb1.setBounds(100,600,100,50);jb2.setBounds(300,600,100,50);
			        
			        //�����ڵ����е�λ�ü���С
			        this.setBounds(720, 150, 500, 750);
			        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			        //���ô��岻��������
			        this.setResizable(false);
			        this.setVisible(true);
			    }
			}
			
			//��ʦ�γ̲�ѯ����
			@SuppressWarnings("serial")
			public static class teaCourseCheck extends JFrame{
				private JPanel contentPane;
			    private DefaultTableModel defaultTableModel;
			    private JTable table;
			    Toolkit toolkit = Toolkit.getDefaultToolkit();
			    private int DEFAULE_WIDTH = 1000;
			    private int DEFAULE_HEIGH = 600;
			    int Location_x = (int) (toolkit.getScreenSize().getWidth() - DEFAULE_WIDTH) / 2;
			    int Location_y = (int) (toolkit.getScreenSize().getHeight() - DEFAULE_HEIGH) / 2;
			    //����Ӧ����Ļ����
			    
			    public teaCourseCheck(String finalId) {

			        contentPane = new JPanel();
			        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			        contentPane.setLayout(new BorderLayout());
			        
			        ArrayList<Course> list1 = new ArrayList<>();
			        list1 = CourseDao.findCourseTea(finalId);
//			        ArrayList<Course> list2 = new ArrayList<>();
//			        list2 = CourseDao.findCourseTea(finalId);
			        String str1 = list1.get(0).getcourseId();
//			        String str2 = list2.get(0).getcourseId();
			        
			        ArrayList<Course> newlist1 = new ArrayList<>();
			        newlist1 = CourseDao.findCourse(str1);
//			        ArrayList<Course> newlist2 = new ArrayList<>();
//			        newlist2 = CourseDao.findCourse(str2);
			        
			        String[] n1 = { newlist1.get(0).getcourseId(), newlist1.get(0).getcourseName(), newlist1.get(0).getcourseCredit(), newlist1.get(0).getcourseHours()};
//			        String[] n2 = { newlist2.get(0).getcourseId(), newlist2.get(0).getcourseName(), newlist2.get(0).getcourseCredit(), newlist1.get(0).getcourseHours()};
			        Object[][] p = {n1};
			        String[] n = { "�γ̴���", "�γ�����", "ѧ��", "ѧʱ"};

			        defaultTableModel = new DefaultTableModel(p, n); // ��˫���鴴��DefaultTableModel����
			        table = new JTable(defaultTableModel);// ����������
			        table.setRowHeight(30);// ���ñ���п�
			        
			        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);// ���������������Ĭ�Ϲ�����ʼ�ճ��֣���ʼ���б����
			        contentPane.add(scrollPane, BorderLayout.CENTER);

			        setVisible(true);
			        setTitle("�α��ѯ");
			        setContentPane(contentPane);
			        setLocation(Location_x, Location_y);
			        setSize(DEFAULE_WIDTH, DEFAULE_HEIGH);
			        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//default = JFrame.EXIT_ON_CLOSE;
			    }
			}
			
			//��ʦ�ɼ���¼����
			@SuppressWarnings("serial")
			public static class teaScoreManage extends JFrame {
				public teaScoreManage(String finalId) {
					super();
					this.setTitle("�ɼ�¼��");
			        //��������
			        Container cont = getContentPane();
			        //�رվ��Բ��� 
			        this.setLayout(null);
			        //�����ؼ�
			        JLabel jl1 = new JLabel("�γ̺�");JLabel jl2 = new JLabel("ѧ��");
			        JLabel jl3 = new JLabel("����");JLabel jl4 = new JLabel("�ɼ�");
			        JButton jb1 = new JButton("�ύ");JButton jb2 = new JButton("�˳�");
			        JTextField jt1 = new JTextField("",20);JTextField jt2 = new JTextField("",20);
			        JTextField jt3 = new JTextField("",20);JTextField jt4 = new JTextField("",20);
			        
			        //�����ύ��ť����
			        jb1.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
							String courseName = CourseDao.findCourse(jt1.getText()).get(0).getcourseName();
							//���ݺϷ���У��
							if(jt1.getText().equals("")||jt2.getText().equals("")|| jt3.getText().equals("")||jt4.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "����ȷ��д��Ϣ��");
								new teaScoreManage(finalId);
								dispose();
								return ;
							}
							//��ʦȨ�޼���
							if(CourseDao.findCourseTea(finalId).isEmpty() || (!CourseDao.findCourseTea(finalId).get(0).getcourseId().equals(jt1.getText()))) {
								JOptionPane.showMessageDialog(null, "����Ȩ���޸ı��γ̣�");
								new teaScoreManage(finalId);
								dispose();
								return ;
							}
							//ѧ�Ŵ�����У��
							if(StudentDao.findStudent(jt2.getText()).isEmpty()) {
								JOptionPane.showMessageDialog(null, "ѧ�Ų����ڣ�");
								new teaScoreManage(finalId);
								dispose();
								return ;
							}
							//ѧ��ƥ����У��
							if(!StudentDao.findStudent(jt2.getText()).get(0).getName().equals(jt3.getText())) {
								JOptionPane.showMessageDialog(null, "ѧ����������ƥ�䣡");
								new teaScoreManage(finalId);
								dispose();
								return ;
							}
							//ѧ���Ƿ�ѡ��У��
							if(CourseStuDao.findCourseStu(jt2.getText(), courseName).isEmpty()) {
								JOptionPane.showMessageDialog(null, "����δѡ�Σ�");
								new teaScoreManage(finalId);
								dispose();
								return ;
							}
							//У��ͨ��
							
							if(CourseStuDao.findCourseStu(jt2.getText(), courseName).isEmpty()) {
								Score newStu = new Score(jt1.getText(), courseName, finalId, TeacherDao.findTeacher(finalId).get(0).getName(), 
														jt2.getText(), jt3.getText(), jt4.getText());
								ScoreDao.writeScore(newStu, courseName);
							}
							
							else {
								ScoreDao.delScore(jt2.getText(), courseName);
								Score newStu = new Score(jt1.getText(), courseName, finalId, TeacherDao.findTeacher(finalId).get(0).getName(), 
														jt2.getText(), jt3.getText(), jt4.getText());
								ScoreDao.writeScore(newStu, courseName);
							}
							JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
							new teaScoreManage(finalId);
			            	dispose();
			            }
			        });
			        
					//���÷��ذ�ť����
					jb2.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	new TeaOperation(finalId);
			            	dispose();
			            }
			        });
					
			        //���ؼ�����������		       
					cont.add(jl1);cont.add(jl2);cont.add(jl3);cont.add(jl4);cont.add(jb1);
					cont.add(jb2);cont.add(jt1);cont.add(jt2);cont.add(jt3);cont.add(jt4);
			        
			        
			        //�ؼ��������е�λ�ü���С
			        jl1.setBounds(50,50,75,40);jl2.setBounds(50,125,75,40);
			        jl3.setBounds(50,200,75,40);jl4.setBounds(50,275,75,40);
			        jt1.setBounds(150,50,300,40);jt2.setBounds(150,125,300,40);
			        jt3.setBounds(150,200,300,40);jt4.setBounds(150,275,300,40);
			        jb1.setBounds(100,400,100,50);jb2.setBounds(300,400,100,50);
			        
			        //�����ڵ����е�λ�ü���С
			        this.setBounds(720, 150, 500, 500);
			        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			        //���ô��岻��������
			        this.setResizable(false);
			        this.setVisible(true);
			    }
			}
			
			//��ʦ�ɼ���������
			@SuppressWarnings("serial")
			public static class teaScoreAnalysis extends JFrame {
				public teaScoreAnalysis(String finalId) {
					super();
					this.setTitle("�ɼ�ͳ�ƽ��");
			        //��������
			        Container cont = getContentPane();
			        //�رվ��Բ��� 
			        this.setLayout(null);
			        //�����ؼ�
			        JLabel jl1 = new JLabel("�γ̺�");JLabel jl2 = new JLabel("����");
			        JLabel jl3 = new JLabel("����");JLabel jl4 = new JLabel("����");JLabel jl5 = new JLabel("������");
			        JButton jb1 = new JButton("ͳ��");JButton jb2 = new JButton("�˳�");
			        JTextField jt1 = new JTextField("",20);JTextField jt2 = new JTextField("",20);
			        JTextField jt3 = new JTextField("",20);JTextField jt4 = new JTextField("",20);JTextField jt5 = new JTextField("",20);
			        
			        //�����ύ��ť����
			        jb1.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
							//�γ̴�����У��
					        if(CourseDao.findCourse(jt1.getText()).isEmpty()) {
								JOptionPane.showMessageDialog(null, "�γ̲����ڣ�");
								new TeaOperation(finalId);
								dispose();
								return ;
							}
							String stuId;
							String str = CourseDao.findCourse(jt1.getText()).get(0).getcourseName();
							int best=0,better=0,good=0,normal=0;
							ArrayList<Score> foundScore = ScoreDao.readScore(str);
							for(int i = 0; i < foundScore.size(); i++) {
								stuId = ScoreDao.readScore(str).get(i).getstudentId();
								String score = ScoreDao.findScore(str, stuId).get(0).getstudentScore();
								int flag = Integer.parseInt(score);
								if(flag<=100 && flag >=85) {best+=1;}
								else if(flag<85 && flag >=75) {better+=1;}
								else if(flag<75 && flag >=60) {good+=1;}
								else if(flag<60 && flag >=0) {normal+=1;}
							}
							jt2.setText(Integer.toString(best));jt3.setText(Integer.toString(better));
							jt4.setText(Integer.toString(good));jt5.setText(Integer.toString(normal));
			            }
			        });
			        
					//���÷��ذ�ť����
					jb2.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	dispose();
			            }
			        });
					
			        //���ؼ�����������		       
					cont.add(jl1);cont.add(jl2);cont.add(jl3);cont.add(jl4);cont.add(jl5);cont.add(jb1);
					cont.add(jb2);cont.add(jt1);cont.add(jt2);cont.add(jt3);cont.add(jt4);cont.add(jt5);
			        		        
			        //�ؼ��������е�λ�ü���С
			        jl1.setBounds(50,50,75,40);jl2.setBounds(50,125,75,40);
			        jl3.setBounds(50,200,75,40);jl4.setBounds(50,275,75,40);jl5.setBounds(50,350,75,40);
			        jt1.setBounds(150,50,300,40);jt2.setBounds(150,125,300,40);
			        jt3.setBounds(150,200,300,40);jt4.setBounds(150,275,300,40);jt5.setBounds(150,350,300,40);
			        jb1.setBounds(100,450,100,50);jb2.setBounds(300,450,100,50);
			        
			        //�����ڵ����е�λ�ü���С
			        this.setBounds(720, 150, 550, 600);
			        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			        //���ô��岻��������
			        this.setResizable(false);
			        this.setVisible(true);
			    }
			}
//			//����Ա��¼����
//			@SuppressWarnings("serial")
//			public static class AdmOperation extends JFrame {
//				public AdmOperation() {
//					super();
//					this.setTitle("����Ա");
//			        //��������
//			        Container cont = getContentPane();
//			        //�رվ��Բ��� 
//			        this.setLayout(null);
//			        //�����ؼ�		        
//			        JButton jb1 = new JButton("Text1");
//			        JButton jb2 = new JButton("Text2");
//			        JButton jb3 = new JButton("Text3");
//			        JButton jb4 = new JButton("Text4");
//			        JButton jb5 = new JButton("����");
//			        //���ð�ť����
//			        jb1.addActionListener(new ActionListener() {
//			            
//						@Override
//			            public void actionPerformed(ActionEvent e) {
//							System.out.println("Text1");
//			            }
//			        });
//			        //���ð�ť����
//			        jb2.addActionListener(new ActionListener() {
//			            @Override
//			            public void actionPerformed(ActionEvent e) {
//			            	System.out.println("Text2");
//			            }
//			        });
//			        //���ð�ť����
//			        jb3.addActionListener(new ActionListener() {
//			        	@Override
//			            public void actionPerformed(ActionEvent e) {
//			            	System.out.println("Text3");
//			            }
//			        });		        
//			        //���ð�ť����
//					jb4.addActionListener(new ActionListener() {
//						@Override
//			            public void actionPerformed(ActionEvent e) {
//			            	System.out.println("Text4");
//			            }
//			        });
//					//���ð�ť����
//					jb5.addActionListener(new ActionListener() {
//						@Override
//			            public void actionPerformed(ActionEvent e) {
//			            	System.out.println("����");
//			            	new Login();
//			            	dispose();
//			            }
//			        });
//					
//					
//			        //���ؼ�����������		       
//			        cont.add(jb1);
//			        cont.add(jb2);
//			        cont.add(jb3);
//			        cont.add(jb4);
//			        cont.add(jb5);	       
//			        //�ؼ��������е�λ�ü���С
//			        jb1.setBounds(100,50,300,100);
//			        jb2.setBounds(100,200,300,100);
//			        jb3.setBounds(100,350,300,100);
//			        jb4.setBounds(100,500,300,100);
//			        jb5.setBounds(100,650,300,100);
//			        //�����ڵ����е�λ�ü���С
//			        this.setBounds(720, 200, 500, 850);
//			        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//			        //���ô��岻��������
//			        this.setResizable(false);
//			        this.setVisible(true);
//			    }
//			}
}
