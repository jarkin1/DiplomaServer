package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import client.GoodsClient;
import dm.entity.Goods;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTable table;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1361, 726);
		setResizable(false);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JMenuItem mntmCreate = new JMenuItem("Create");
		mntmCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateGoods createGoods = new CreateGoods();
				createGoods.setVisible(true);
			}
		});
		mnFile.add(mntmCreate);
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			        
				tableShow();
				table.setModel(tableModel);
			}
		});
		mnFile.add(mntmUpdate);
		mnFile.add(mntmExit);
		
		JMenu mnUser = new JMenu("User");
		menuBar.add(mnUser);
		
		JMenuItem mntmSignUp = new JMenuItem("Sign up");
		mntmSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp signUp = new SignUp();
				signUp.setVisible(true);
			}
		});
		mnUser.add(mntmSignUp);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1335, 620);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableShow();
				table.setModel(tableModel);
			}
		});
		btnUpdate.setBounds(109, 642, 89, 23);
		getContentPane().add(btnUpdate);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateGoods createGoods = new CreateGoods();
				createGoods.setVisible(true);
			}
		});
		btnCreate.setBounds(10, 642, 89, 23);
		getContentPane().add(btnCreate);
		
		JButton btnDelete = new JButton("Remove");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = table.getSelectedRow();
				System.out.println(position);
				int id = (Integer) table.getModel().getValueAt(position, 0);
				String code = (String) table.getModel().getValueAt(position, 1);
				String name = (String) table.getModel().getValueAt(position, 2);
				int price = (Integer) table.getModel().getValueAt(position, 3);
				double weight = (Double) table.getModel().getValueAt(position, 4);
				int amount = (Integer) table.getModel().getValueAt(position, 5);
				Goods goods = new Goods(id, code, name, price, weight, amount);
				System.out.println(goods);
				GoodsClient.removeGoods(goods);
			}
		});
		btnDelete.setBounds(208, 642, 89, 23);
		getContentPane().add(btnDelete);
		
		JButton btnSortByName = new JButton("Sort by name");
		btnSortByName.setBounds(843, 642, 115, 23);
		getContentPane().add(btnSortByName);
		
		JButton btnSortById = new JButton("Sort by ID");
		btnSortById.setBounds(619, 642, 89, 23);
		getContentPane().add(btnSortById);
		
		JButton btnSortByPrice = new JButton("Sort by price");
		btnSortByPrice.setBounds(968, 642, 115, 23);
		getContentPane().add(btnSortByPrice);
		
		JButton btnSortByAmount = new JButton("Sort by amount");
		btnSortByAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSortByAmount.setBounds(1218, 642, 127, 23);
		getContentPane().add(btnSortByAmount);
		
		JButton btnSortByCode = new JButton("Sort by code");
		btnSortByCode.setBounds(718, 642, 115, 23);
		getContentPane().add(btnSortByCode);
		
		JButton btnSortByWeight = new JButton("Sort by weight");
		btnSortByWeight.setBounds(1093, 642, 115, 23);
		getContentPane().add(btnSortByWeight);
		
		
	}

	private void tableShow() {
		tableModel.addColumn("ID");
        tableModel.addColumn("Code");
        tableModel.addColumn("Name");
        tableModel.addColumn("Price");
        tableModel.addColumn("Weight");
        tableModel.addColumn("Amount");
        List<Goods> goods = GoodsClient.findAllGoods();
        for (Goods goods2 : goods) {
			tableModel.addRow(new Object[]{
					goods2.getId(),
					goods2.getCode(),
					goods2.getName(),
					goods2.getPrice(),
					goods2.getWeight(),
					goods2.getAmount()
			});
		}
	}
}
