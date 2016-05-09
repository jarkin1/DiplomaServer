package main;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.LoginClient;
import dm.entity.Login;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textFUsername;
	private JTextField textFPassword;
	private JLabel lblPassword;

	public SignUp() {
		
		setTitle("Sign up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblUsername.setBounds(42, 76, 108, 23);
		contentPane.add(lblUsername);
		
		textFUsername = new JTextField();
		textFUsername.setColumns(10);
		textFUsername.setBounds(160, 81, 142, 20);
		contentPane.add(textFUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(42, 113, 119, 23);
		contentPane.add(lblPassword);
		
		textFPassword = new JTextField();
		textFPassword.setColumns(10);
		textFPassword.setBounds(160, 118, 142, 20);
		contentPane.add(textFPassword);
		
		JLabel lblSignUp = new JLabel("Sign up");
		lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSignUp.setBounds(10, 11, 101, 38);
		contentPane.add(lblSignUp);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textFUsername.getText();
				String password = textFPassword.getText();
				LoginClient.saveLogin(new Login(userName, password));
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreate.setBounds(213, 149, 89, 23);
		contentPane.add(btnCreate);
	}
}
