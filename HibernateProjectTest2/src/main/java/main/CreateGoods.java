package main;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.GoodsClient;
import dm.entity.Goods;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CreateGoods extends JFrame {

	private JPanel contentPane;
	private JTextField textFCode;
	private JTextField textFName;
	private JTextField textFWeight;
	private JTextField textFAmount;
	private JButton btnAdd;
	private JTextField textFPrice;
	public CreateGoods() {
		setFont(new Font("Tahoma", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCode.setBounds(10, 17, 70, 14);
		contentPane.add(lblCode);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(10, 42, 70, 14);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(10, 67, 70, 14);
		contentPane.add(lblPrice);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWeight.setBounds(10, 92, 70, 14);
		contentPane.add(lblWeight);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAmount.setBounds(10, 117, 70, 14);
		contentPane.add(lblAmount);
		
		textFCode = new JTextField();
		textFCode.setBounds(90, 11, 188, 20);
		contentPane.add(textFCode);
		textFCode.setColumns(10);
		
		textFName = new JTextField();
		textFName.setBounds(90, 36, 188, 20);
		contentPane.add(textFName);
		textFName.setColumns(10);
		
		textFPrice = new JTextField();
		textFPrice.setBounds(90, 61, 188, 20);
		contentPane.add(textFPrice);
		textFPrice.setColumns(10);
		
		textFWeight = new JTextField();
		textFWeight.setBounds(90, 86, 188, 20);
		contentPane.add(textFWeight);
		textFWeight.setColumns(10);
		
		textFAmount = new JTextField();
		textFAmount.setBounds(90, 111, 188, 20);
		contentPane.add(textFAmount);
		textFAmount.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String code = textFCode.getText();
				String name = textFName.getText();
				int price = Integer.parseInt(textFPrice.getText());
				double weight = Double.parseDouble(textFWeight.getText());
				int amount = Integer.parseInt(textFAmount.getText());
				GoodsClient.saveGoods(new Goods(code, name, price, weight, amount));
				MainFrame mainFrame = new MainFrame();
				dispose();
				mainFrame.setVisible(true);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(189, 142, 89, 23);
		contentPane.add(btnAdd);
	}
}
