/**
 * 管理员操作界面
 */
package com.ethan.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.ethan.Util.DateUtil;
import com.ethan.daoimpl.PassWordDaoImpl;
import com.ethan.daoimpl.UserDaoImpl;
import com.ethan.entity.PassWordInfo;
import com.ethan.entity.UserInfo;

public class HomeView extends JFrame{
	private static final long serialVersionUID = -622883704562470591L;
	private String userNameStr;
	Right ri = new Right();
	Leftpanel leftjp = null;//管理员左侧面板
	JPanel rightjp = null;
	JSplitPane jsp = null;
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	UserInfo user;
	PassWordDaoImpl passWordDaoImpl = new PassWordDaoImpl();
	PassWordInfo passWordInfo;
	 
	public HomeView(String userNameStr){
		this.userNameStr = userNameStr;
		this.setLayout(null);
		this.setSize(800, 600);
		user = userDaoImpl.getUserInfo(userNameStr);
		
		leftjp = new Leftpanel();
		rightjp = ri.passWordInfo();
		
		jsp = new JSplitPane();
		jsp.setLeftComponent(leftjp);
		jsp.setRightComponent(rightjp);
		
		this.add(jsp);
		
		jsp.setBounds(0, 0, 800, 600);
		
		jsp.setDividerLocation(150);//分隔条位置
		jsp.setDividerSize(2);//分割挑大小
		jsp.setEnabled(false);//设置分割不变
		
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * 管理员左侧面板
	 * @庞国庆
	 */
	class Leftpanel extends JPanel{
		private static final long serialVersionUID = 2157709923041309588L;
		JButton passButton = null;
		JButton userButton = null;
		
		public Leftpanel(){
			this.setLayout(null);
			this.setSize(150, 600);
			
			passButton = new JButton("++密码管理++");
			
			userButton = new JButton("++用户中心++");
			
			this.add(passButton);
			this.add(userButton);
			
			passButton.setBounds(0, 10, 150, 30);
			userButton.setBounds(0, 40, 150, 30);
			
			passButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel jp = ri.passWordInfo();
					jsp.setRightComponent(jp);
					jsp.setDividerLocation(150);//设置分割位置
				}
			});
			userButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel jp = ri.updateUserPass();
					jsp.setRightComponent(jp);
					jsp.setDividerLocation(150);//设置分割位置
				}
			});
			this.setBackground(Color.BLUE);
		}
		
	}
	
	/**
	 * 右侧界面
	 * @author 庞国庆
	 */
	public class Right {
		DefaultTableModel dtm = null;
		JTable jt = null;
		JScrollPane jscp = null;//表格这三个组合使用才会出现表头
		
		Vector<Object> vc= new Vector<Object>();
		
		/**
		 * 
		 * @Title: passWordInfo
		 * @Description: 查找密码区
		 * @param: @return
		 * @return: JPanel
		 * @throws
		 */
		public JPanel passWordInfo(){
			final JPanel seleall = new JPanel();
			seleall.setLayout(null);
			seleall.setSize(650, 600);
			
			final JTextField search = new JTextField("名称...");
			search.setForeground(Color.GRAY);
			ImageIcon searchim = new ImageIcon("images/search.png");
			JButton jbss = new JButton(searchim);
			
			JLabel jlId = new JLabel("ID：");
			final JTextField id = new JTextField();
			id.setEditable(false);
			JLabel jlName = new JLabel("名称：");
			final JTextField locationName = new JTextField();
			JLabel jlUrl = new JLabel("地址(URL)：");
			final JTextField locationUrl = new JTextField();
			JLabel jluserName = new JLabel("用户名：");
			final JTextField userName = new JTextField();
			JLabel jluserPass = new JLabel("密码：");
			final JTextField userPass = new JTextField();
			JLabel jlPhone = new JLabel("绑定手机：");
			final JTextField bindingPhone = new JTextField();
			JLabel jlEmail = new JLabel("邮箱：");
			final JTextField bindingEmail = new JTextField();
			JLabel jlQQ = new JLabel("QQ：");
			final JTextField bindingQQ = new JTextField();
			
			JButton addRow = new JButton("新增");
			JButton updateRow = new JButton("修改");
			JButton removeRow = new JButton("删除");
			JButton saveRow = new JButton("保存");
			
			//表头
			String top[] = {"序号","ID","名称","URL","用户名","密码","绑定手机","绑定邮箱","绑定QQ","创建时间"};
			dtm = new DefaultTableModel(top,0);
			jt = new JTable(dtm){
				private static final long serialVersionUID = -1522206244453575994L;
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
			//设置行高
			jt.setRowHeight(23);
			//设置列宽
			jt.getColumnModel().getColumn(0).setPreferredWidth(30);
			jt.getColumnModel().getColumn(1).setMinWidth(0);
			jt.getColumnModel().getColumn(1).setMaxWidth(0);
			jt.getColumnModel().getColumn(2).setPreferredWidth(80);
			//隐藏
			jt.getColumnModel().getColumn(3).setPreferredWidth(60);
			jt.getColumnModel().getColumn(4).setPreferredWidth(100);
			jt.getColumnModel().getColumn(5).setPreferredWidth(100);
			jt.getColumnModel().getColumn(6).setPreferredWidth(60);
			jt.getColumnModel().getColumn(7).setPreferredWidth(60);
			jt.getColumnModel().getColumn(8).setPreferredWidth(60);
			jt.getColumnModel().getColumn(9).setPreferredWidth(50);
			jt.getTableHeader().setReorderingAllowed(false);//设置表格中的列不能拖动
			
			jscp = new JScrollPane(jt);
			List<PassWordInfo> lists = passWordDaoImpl.selectPassInfo(userNameStr);
			for (int i = 0; i < lists.size(); i++) {
				PassWordInfo row = lists.get(i);
				vc = new Vector<>();
				vc.add(i+1);
				vc.add(row.getId());
				vc.add(row.getLocationName());
				vc.add(row.getLocationUrl());
				vc.add(row.getUserName());
				vc.add(row.getUserPass());
				vc.add(row.getBindingPhone());
				vc.add(row.getBindingEmail());
				vc.add(row.getBindingQQ());
				vc.add(row.getCreateTime());
				dtm.addRow(vc);
			}
			seleall.add(jscp);
			seleall.add(search);
			seleall.add(jbss);
			seleall.add(jlId);
			seleall.add(id);
			seleall.add(jlName);
			seleall.add(locationName);
			seleall.add(jlUrl);
			seleall.add(locationUrl);
			seleall.add(jluserName);
			seleall.add(userName);
			seleall.add(jluserPass);
			seleall.add(userPass);
			seleall.add(jlPhone);
			seleall.add(bindingPhone);
			seleall.add(jlEmail);
			seleall.add(bindingEmail);
			seleall.add(jlQQ);
			seleall.add(bindingQQ);
			seleall.add(addRow);
			seleall.add(removeRow);
			seleall.add(updateRow);
			seleall.add(saveRow);
			
			search.setBounds(100, 10, 300, 30);
			jbss.setBounds(400, 10, 30, 30);
			jscp.setBounds(25, 50, 600, 350);
			jlId.setBounds(25, 403, 75, 30);
			id.setBounds(100, 403, 190, 30);
			jlName.setBounds(310, 403, 75, 30);
			locationName.setBounds(385, 403, 190, 30);
			jlUrl.setBounds(25, 438, 75, 30);
			locationUrl.setBounds(100, 438, 190, 30);
			jluserName.setBounds(310, 438, 75, 30);
			userName.setBounds(385, 438, 190, 30);
			jluserPass.setBounds(25, 473, 75, 30);
			userPass.setBounds(100, 473, 190, 30);
			jlPhone.setBounds(310, 473, 75, 30);
			bindingPhone.setBounds(385, 473, 190, 30);
			jlEmail.setBounds(25, 508, 75, 30);
			bindingEmail.setBounds(100, 508, 190, 30);
			jlQQ.setBounds(310, 508, 75, 30);
			bindingQQ.setBounds(385, 508, 190, 30);
			
			addRow.setBounds(140, 540, 70, 30);
			updateRow.setBounds(250, 540, 70, 30);
			removeRow.setBounds(360, 540, 70, 30);
			saveRow.setBounds(470, 540, 70, 30);
			
			search.addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent e) {
				}
				public void mousePressed(MouseEvent e) {
				}
				public void mouseExited(MouseEvent e) {
					if(search.getText().equals("")){
						search.setText("名称...");
					}
				}
				public void mouseEntered(MouseEvent e) {
				}
				public void mouseClicked(MouseEvent e) {
					search.setText("");
				}
			});
			
			jbss.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(dtm.getRowCount()==0){
						JOptionPane.showMessageDialog(seleall, "没有任何数据");
					}else{
						while(true){//删除表格里面所有数据
							dtm.removeRow(dtm.getRowCount()-1);
							if(dtm.getRowCount()-1<0){
								break;
							}
						}
						String searchStr = ("名称...".equals(search.getText())) ? "" :search.getText();
						List<PassWordInfo> lists = passWordDaoImpl.searchPassInfo(userNameStr, searchStr);
						for (int i = 0; i < lists.size(); i++) {
							PassWordInfo row = lists.get(i);
							vc = new Vector<>();
							vc.add(i+1);
							vc.add(row.getId());
							vc.add(row.getLocationName());
							vc.add(row.getLocationUrl());
							vc.add(row.getUserName());
							vc.add(row.getUserPass());
							vc.add(row.getBindingPhone());
							vc.add(row.getBindingEmail());
							vc.add(row.getBindingQQ());
							vc.add(row.getCreateTime());
							dtm.addRow(vc);
						}
					}
				}
			});
			
			jt.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int selRow = jt.getSelectedRow(); // 获得选中行索引
					id.setText(jt.getValueAt(selRow, 1).toString());
					locationName.setText(jt.getValueAt(selRow, 2).toString());
					locationUrl.setText(jt.getValueAt(selRow, 3).toString());
					userName.setText(jt.getValueAt(selRow, 4).toString());
					userPass.setText(jt.getValueAt(selRow, 5).toString());
					bindingPhone.setText(jt.getValueAt(selRow, 6).toString());
					bindingEmail.setText(jt.getValueAt(selRow, 7).toString());
					bindingQQ.setText(jt.getValueAt(selRow, 8).toString());
				}
			});
			
			//新增
			addRow.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					id.setText(DateUtil.dateToStamp());
					locationName.setText("");
					locationUrl.setText("");
					userName.setText("");
					userPass.setText("");
					bindingPhone.setText("");
					bindingEmail.setText("");
					bindingQQ.setText("");
				}
			});
			
			
			//更新
			updateRow.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int selRow = jt.getSelectedRow();
					if(selRow == -1){
						JOptionPane.showMessageDialog(seleall, "请选择一行！");
					}else{
						id.setText(jt.getValueAt(selRow, 1).toString());
						locationName.setText(jt.getValueAt(selRow, 2).toString());
						locationUrl.setText(jt.getValueAt(selRow, 3).toString());
						userName.setText(jt.getValueAt(selRow, 4).toString());
						userPass.setText(jt.getValueAt(selRow, 5).toString());
						bindingPhone.setText(jt.getValueAt(selRow, 6).toString());
						bindingEmail.setText(jt.getValueAt(selRow, 7).toString());
						bindingQQ.setText(jt.getValueAt(selRow, 8).toString());
					}
				}
			});
			
			//删除
			removeRow.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int selRow = jt.getSelectedRow();
					if(selRow == -1){
						JOptionPane.showMessageDialog(seleall, "请选择一行！");
					}else{
						dtm.removeRow(selRow);
						String id = jt.getValueAt(selRow, 1).toString();
						passWordDaoImpl.delPassInfo(userNameStr, id);
					}
				}
			});
			
			//提交
			saveRow.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(null == id.getText() || "".equals(id.getText())){
						JOptionPane.showMessageDialog(seleall, "有必填项未填！");
					}else{
						passWordInfo = new PassWordInfo();
						passWordInfo.setId(id.getText());
						passWordInfo.setLocationName(locationName.getText());
						passWordInfo.setLocationUrl(locationUrl.getText());
						passWordInfo.setUserName(userName.getText());
						passWordInfo.setUserPass(userPass.getText());
						passWordInfo.setBindingPhone(bindingPhone.getText());
						passWordInfo.setBindingEmail(bindingEmail.getText());
						passWordInfo.setBindingQQ(bindingQQ.getText());
						passWordDaoImpl.createPassInfo(passWordInfo,userNameStr);
						JOptionPane.showMessageDialog(seleall, "保存成功！");
						id.setText("");
						locationName.setText("");
						locationUrl.setText("");
						userName.setText("");
						userPass.setText("");
						bindingPhone.setText("");
						bindingEmail.setText("");
						bindingQQ.setText("");
						JPanel jp = ri.passWordInfo();
						jsp.setRightComponent(jp);
						jsp.setDividerLocation(150);//设置分割位置
					}
				}
			});
			return seleall;
		}
		
		/**
		 * 
		 * @Title: updateUserPass
		 * @Description: 修改用户登录密码
		 * @param: @return
		 * @return: JPanel
		 * @throws
		 */
		public JPanel updateUserPass(){
			final JPanel updateUp= new JPanel();
			updateUp.setLayout(null);
			updateUp.setSize(650, 600);
			JLabel jl1 = new JLabel("用  户  名：");
			JLabel jl2 = new JLabel("旧  密  码：");
			JLabel jl3 = new JLabel("新  密  码：");
			final JTextField jtf1 = new JTextField(userNameStr);
			jtf1.setEditable(false);
			final JTextField jtf2 = new JTextField();
			final JTextField jtf3 = new JTextField();
			JButton jb = new JButton("确认修改");
			
			updateUp.add(jl1);
			updateUp.add(jl2);
			updateUp.add(jl3);
			updateUp.add(jtf1);
			updateUp.add(jtf2);
			updateUp.add(jtf3);
			updateUp.add(jb);
			
			jl1.setBounds(150, 100, 80, 30);
			jl2.setBounds(150, 150, 80, 30);
			jl3.setBounds(150, 200, 80, 30);
			jtf1.setBounds(230, 100, 200, 30);
			jtf2.setBounds(230, 150, 200, 30);
			jtf3.setBounds(230, 200, 200, 30);
			jb.setBounds(220, 250, 150, 30);
			
			jb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String oldStr = jtf2.getText();
					user = userDaoImpl.getUserInfo(userNameStr);
					if(user.getUserPass().equals(oldStr)){
						String newStr = jtf3.getText();
						int a=JOptionPane.showConfirmDialog(updateUp,"您确定要修改密码吗？");
						if(a==0){
							user.setUserName(userNameStr);
							user.setUserPass(newStr);
							if(userDaoImpl.updateUser(user)){
								JOptionPane.showMessageDialog(updateUp,"修改成功.");
							}else{
								JOptionPane.showMessageDialog(updateUp,"修改失败.");
							}
						}else{
							JOptionPane.showMessageDialog(updateUp,"您的操作已取消！");
						}
					}else{
						JOptionPane.showMessageDialog(updateUp, "旧密码输入有误！请确认后重新输入.");
					}
				}
			});
			return updateUp;
		}
	}
//	public static void main(String[] args) {
//		new HomeView("ethan");
//	}
}
