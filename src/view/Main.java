package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main{
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
		            	
		            	jt.setText("");//�˴�ԭ����Ӧ��дΪ���ܺ��ID��
//		                jpf.setText("");	//��������Ϊ��*******��	 
		                		        
		            	if(jt.getText().equals("")){
		                    System.out.println("��½�ɹ���");
		                    JOptionPane.showMessageDialog(null, "��¼�ɹ���");
		                    int flag = 0;
		                    switch(flag) {
		                    	case 0:
		                    		new StuOperation();dispose();
		                    		break;
		                    	case 1:
		                    		new TeaOperation();dispose();
		                    		break;
		                    	case 2:
//		                    		new AdmOperation();dispose();
		                    		break;
		                    }
		                }
		                else {
		                    System.out.println("��¼ʧ�ܣ�");
		                    JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�");
		                    JOptionPane.showMessageDialog(null, "��������ȷ��ID��");
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
		        JButton jb1 = new JButton("��Ϣ��ѯ");
		        JButton jb2 = new JButton("�ɼ���ѯ");
		        JButton jb3 = new JButton("�γ̲�ѯ");
		        JButton jb4 = new JButton("�޸���Ϣ");
		        JButton jb5 = new JButton("����");
		        //������Ϣ��ѯ��ť����
		        jb1.addActionListener(new ActionListener() {
		            
					@Override
		            public void actionPerformed(ActionEvent e) {
						System.out.println("��Ϣ��ѯ");
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
		        cont.add(jb1);
		        cont.add(jb2);
		        cont.add(jb3);
		        cont.add(jb4);
		        cont.add(jb5);	       
		        //�ؼ��������е�λ�ü���С
		        
		        jb1.setBounds(100,50,300,100);
		        jb2.setBounds(100,200,300,100);
		        jb3.setBounds(100,350,300,100);
		        jb4.setBounds(100,500,300,100);
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
		        JLabel jl1 = new JLabel("����");
		        JLabel jl2 = new JLabel("����");
		        JLabel jl3 = new JLabel("ѧԺ");
		        JLabel jl4 = new JLabel("רҵ");
		        JLabel jl5 = new JLabel("������");
		        JLabel jl6 = new JLabel("ȷ������");
		        JButton jb1 = new JButton("�ύ");
		        JButton jb2 = new JButton("����");
		        JTextField jt1 = new JTextField("",20);
		        JTextField jt2 = new JTextField("",20);
		        JTextField jt3 = new JTextField("",20);
		        JTextField jt4 = new JTextField("",20);
		        JTextField jt5 = new JTextField("",20);
		        JTextField jt6 = new JTextField("",20);
		        JRadioButton jr1 = new JRadioButton("��",true);
		        JRadioButton jr2 = new JRadioButton("Ů");
		        //�����ύ��ť����
		        jb1.addActionListener(new ActionListener() {
		            
					@Override
		            public void actionPerformed(ActionEvent e) {
						System.out.println("�ύ�ɹ�");
						JOptionPane.showMessageDialog(null, "�ύ�ɹ���");
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
				cont.add(jl1);
				cont.add(jl2);
				cont.add(jl3);
				cont.add(jl4);
				cont.add(jl5);
				cont.add(jl6);
				cont.add(jb1);
		        cont.add(jb2);
		        cont.add(jt1);
		        cont.add(jt2);
		        cont.add(jt3);
		        cont.add(jt4);
		        cont.add(jt5);
		        cont.add(jt6);
		        cont.add(jr1);
		        cont.add(jr2);
		        //�ؼ��������е�λ�ü���С
		        jl1.setBounds(50,50,75,40);
		        jr1.setBounds(150,125,75,40);
		        jr2.setBounds(250,125,75,40);
		        jl2.setBounds(50,200,75,40);
		        jl3.setBounds(50,275,75,40);
		        jl4.setBounds(50,350,75,40);
		        jl5.setBounds(50,425,75,40);
		        jl6.setBounds(50,500,75,40);
		        jt1.setBounds(150,50,300,40);
		        jt2.setBounds(150,200,300,40);
		        jt3.setBounds(150,275,300,40);
		        jt4.setBounds(150,350,300,40);
		        jt5.setBounds(150,425,300,40);
		        jt6.setBounds(150,500,300,40);
		        jb1.setBounds(100,600,100,50);
		        jb2.setBounds(300,600,100,50);
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
		        JButton jb1 = new JButton("��Ϣ��ѯ");
		        JButton jb2 = new JButton("�޸���Ϣ");
		        JButton jb3 = new JButton("ȫ���γ�");
		        JButton jb4 = new JButton("�ɼ���¼");
		        JButton jb5 = new JButton("�ɼ�ͳ��");
		        JButton jb6 = new JButton("����");
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
		        cont.add(jb1);
		        cont.add(jb2);
		        cont.add(jb3);
		        cont.add(jb4);
		        cont.add(jb5);
		        cont.add(jb6);
		        //�ؼ��������е�λ�ü���С
		        
		        jb1.setBounds(100,50,300,75);
		        jb2.setBounds(100,150,300,75);
		        jb3.setBounds(100,250,300,75);
		        jb4.setBounds(100,350,300,75);
		        jb5.setBounds(100,450,300,75);
		        jb6.setBounds(100,550,300,75);
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
	    }
}

