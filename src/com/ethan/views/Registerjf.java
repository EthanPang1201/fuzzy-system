/**
 * 注册界面
 * 
 */

package com.ethan.views;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ethan.daoimpl.UserDaoImpl;

/**
 * 
 * @ClassName: Registerjf
 * @Description: 注册界面
 * @author: GuoqingPang
 * @date: 2017年8月5日 下午3:38:36
 * 
 * @Copyright: 2017 Ethan.Pang Inc. All rights reserved.
 * 注意：本内容仅做毕业设计用。
 */
public class Registerjf extends JFrame{
	/**   
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 5991879432108855317L;
	
	UserDaoImpl userDaoImpl = new UserDaoImpl();

	JPanel jp = null;

	JFileChooser jfc = null;
	
	JLabel vIP_Namejl = null;
	JLabel vIP_Passwordjl = null;
	
	JTextField jtf_name = null;
	JTextField jtf_pass = null;
	
	JCheckBox jcb = null;
	
	JButton jb = null;
	
	public Registerjf(){
		this.setSize(300, 240);
		this.setLayout(null);
		this.setTitle("注册");
		jp = new JPanel();
		jp.setLayout(null);
		
		vIP_Namejl = new JLabel("用户名：");
		vIP_Passwordjl = new JLabel("密码：");
		
		jtf_name = new JTextField("请输入用户名...");
		jtf_pass = new JTextField("请输入密码...");
		
		jcb = new JCheckBox("<html><a href= '#'>《同意用户协议》</a>");
		jb = new JButton("确认注册");
		
		this.add(jp);
		jp.add(vIP_Namejl);
		jp.add(vIP_Passwordjl);
		
		jp.add(jtf_name);
		jp.add(jtf_pass);
		
		jp.add(jcb);
		jp.add(jb);
		
		jp.setBounds(0, 0, 300, 240);
		
		vIP_Namejl.setBounds(30, 20, 70, 30);
		vIP_Passwordjl.setBounds(30, 60, 70, 30);
		
		jtf_name.setBounds(100, 20, 150, 30);
		jtf_pass.setBounds(100, 60, 150, 30);
		
		jcb.setBounds(80,100, 150, 30);
		jb.setBounds(50, 150, 200, 30);
		
		jb.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				boolean bo = jcb.isSelected();//判断是否选中
				if(bo){
					String name = jtf_name.getText();
					String pass = jtf_pass.getText();
					userDaoImpl.createUser(name, pass);
					JOptionPane.showMessageDialog(Registerjf.this,"注册成功！");
					Registerjf.this.setVisible(false);
					Registerjf.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
					LoginView vip = new LoginView();
					Thread th = new Thread(vip);
					th.start();
				}else{
					JOptionPane.showMessageDialog(Registerjf.this,"注册失败！");
				}
			}
		});
		
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Registerjf();
	}
}
