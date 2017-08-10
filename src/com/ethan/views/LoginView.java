package com.ethan.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ethan.Util.StringUtil;
import com.ethan.daoimpl.UserDaoImpl;
import com.ethan.entity.UserInfo;

/**
 * 
 * @ClassName: MainLogin
 * @Description:用户登录面板
 * @author: GuoqingPang
 * @date: 2017年8月5日 下午2:30:25
 * 
 * @Copyright: 2017 Ethan.Pang Inc. All rights reserved.
 * 注意：本内容仅做毕业设计用。
 */
public class LoginView extends JFrame implements Runnable{
	private static final long serialVersionUID = 1289516744502384617L;

	UserDaoImpl userDao = new UserDaoImpl();
	
	private static Point origin = new Point();
	LoginView frame = null;
	
	//窗口最小化、关闭按钮
	JButton minbutton = null;//最小化按钮
	JButton closebutton = null;//关闭按钮，动态的
	
	//登录面板top面板+top图片标签
	JPanel toppanel = null;//登录顶部图片面板
	JLabel toplabel = null;//添加图片标签（透明）
	
	//设置中部面板
	JPanel centrepanel =null;//中心面板，放登录框等
	JLabel portraitlabel =null;//中心显示登录者的肖像,当鼠标移动到密码框的时候从 数据库中调出用户名对应的图片
	JLabel userlabel = null;//用户名标签，做成图片
	JTextField username = null;//用户名输入	
	JLabel passlabel = null;//密码标签，做成图片
	JPasswordField userpass = null;//用户密码
	JButton loginbutton = null;//登录按钮，做成图片
	
	public LoginView(){
		//无参构造
	}
	
	public LoginView(String ss){
		this.setUndecorated(true);//去掉window窗口的模式
		this.setLayout(null);//取消默认窗口布局
		this.setSize(400, 300);//设置窗口大小
		
		toppanel = new JPanel();
		toppanel.setLayout(null);
		ImageIcon icon1 = new ImageIcon("images/icon1_1.png");//根据图像创建图标
		ImageIcon icon2 = new ImageIcon("images/icon2_2.png");
		minbutton = new JButton(icon1);
		closebutton = new JButton(icon2);
		minbutton.setBorderPainted(false);//去掉按钮边框线
		closebutton.setBorderPainted(false);
		ImageIcon labelicon = new ImageIcon("images/login.png");
		toplabel = new JLabel(labelicon);
		
		centrepanel = new JPanel();
		centrepanel.setLayout(null);
		ImageIcon touxiang = new ImageIcon("images/test.png");
		portraitlabel = new JLabel(touxiang);
		username = new JTextField();
		userpass = new JPasswordField();
		ImageIcon name = new ImageIcon("images/username.png");
		userlabel = new JLabel(name);
		ImageIcon password = new ImageIcon("images/password.png");
		passlabel = new JLabel(password);
		ImageIcon loginicon = new ImageIcon("images/loginicon.png");
		loginbutton = new JButton(loginicon);
		loginbutton.setBorderPainted(false);
		
		this.add(toppanel);
		this.add(centrepanel);
		toppanel.add(minbutton);//必须加载在面板上，不能加入到窗口上
		toppanel.add(closebutton);
		toppanel.add(toplabel);
		centrepanel.add(portraitlabel);
		centrepanel.add(username);
		centrepanel.add(userpass);
		centrepanel.add(userlabel);
		centrepanel.add(passlabel);
		centrepanel.add(loginbutton);
		
		toppanel.setBounds(0, 0, 400, 100);
		minbutton.setBounds(340, 0, 30, 30);
		closebutton.setBounds(370, 0, 30, 30);
		toplabel.setBounds(0, 0, 400, 100);
		centrepanel.setBounds(0, 100, 400, 170);
		portraitlabel.setBounds(30, 10, 100, 100);
		username.setBounds(140, 20, 150, 30);
		userpass.setBounds(140, 70, 150, 30);
		userlabel.setBounds(300, 20, 80, 30);
		passlabel.setBounds(300, 70, 80, 30);
		loginbutton.setBounds(120, 130, 200, 30);
		
		
		Color topcolor = new Color(0, 132, 190);//自定义颜色
		toppanel.setBackground(topcolor);
		Color centrecolor = new Color(255, 255, 255);
		centrepanel.setBackground(centrecolor);
		
		//最下化按钮事件监听
		minbutton.addMouseListener(new  MouseListener() {
			public void mouseReleased(MouseEvent e) {
				//System.out.println("按下");
			}
			public void mousePressed(MouseEvent e) {
				//System.out.println("释放");
			}
			public void mouseExited(MouseEvent e) {
				//System.out.println("鼠标移开");
				ImageIcon icon = new ImageIcon("images/icon1_1.png");
				minbutton.setIcon(icon);
			}
			public void mouseEntered(MouseEvent e) {
				//System.out.println("鼠标移入");
				ImageIcon icon = new ImageIcon("images/icon1_2.png");
				minbutton.setIcon(icon);
			}
			public void mouseClicked(MouseEvent e) {
				//System.out.println("点击");
				setExtendedState(JFrame.ICONIFIED);//最下化窗口
			}
		});
		closebutton.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				ImageIcon icon = new ImageIcon("images/icon2_2.png");
				closebutton.setIcon(icon);
			}
			public void mouseEntered(MouseEvent e) {
				ImageIcon icon = new ImageIcon("images/icon2_1.png");
				closebutton.setIcon(icon);
			}
			public void mouseClicked(MouseEvent e) {
				System.exit(0);//关闭窗口
			}
		});
		
		loginbutton.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				String jtf_name = username.getText();
				String jtf_pass = userpass.getText();
				UserInfo user = userDao.getUserInfo(jtf_name);
				if(null == user || StringUtil.isEntrty(user.getUserName()) || StringUtil.isEntrty(user.getUserPass())){
					JOptionPane.showMessageDialog(LoginView.this, "此用户名还没有注册！");
					int a=JOptionPane.showConfirmDialog(LoginView.this,"您是否要注册成会员？");
					if(a==0){
						LoginView.this.setVisible(false);
						LoginView.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
						new Registerjf();
					}else{
						JOptionPane.showMessageDialog(LoginView.this, "请重新输入您的用户名！");
					}
				}else{
					if(user.getUserPass().equals(jtf_pass)){
						LoginView.this.setVisible(false);
						LoginView.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
						System.exit(0);
						new HomeView(user.getUserName());
					}else{
						JOptionPane.showMessageDialog(LoginView.this,"用户名或密码错误！");
						LoginView.this.setVisible(false);
						LoginView.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
						System.exit(0);
					}
				}
			}
		});
		
		this.setVisible(true);//显示窗口
		this.setLocationRelativeTo(null);//窗口居中显示
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
	}
	public void run() {
		frame = new LoginView("画面板");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screensize = kit.getScreenSize();
		int x = screensize.width / 2 - frame.getWidth() / 2;
		int y = screensize.height / 2 - frame.getHeight() / 2;
		frame.setLocation(x, y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addMouseListener(new MouseAdapter() {
			// 按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
			public void mousePressed(MouseEvent e) {
				// 当鼠标按下的时候获得窗口当前的位置
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			// 拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
			public void mouseDragged(MouseEvent e) {
				// 当鼠标拖动时获取窗口当前位置
				Point p = frame.getLocation();
				// 设置窗口的位置
				// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
				frame.setLocation(p.x + e.getX() - origin.x, p.y
						+ e.getY() - origin.y);
			}
		});
	}
	
	public static void main(String[] args) {
		LoginView vip = new LoginView();
		Thread th = new Thread(vip);
		th.start();
	}
}
