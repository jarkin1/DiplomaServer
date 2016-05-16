package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import client.LoginClient;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

public class Login {

	private JFrame frmSignIn;
	private JTextField textFUsername;
	private JTextField textFPassword;
	final Toolkit toolkit = Toolkit.getDefaultToolkit();
	final Dimension screenSize = toolkit.getScreenSize();
	final int x = (screenSize.width-383) / 2;
	final int y = (screenSize.height-230) / 2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmSignIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login(){
		initialize();
	}

	private void initialize(){
		frmSignIn = new JFrame();
		frmSignIn.setTitle("Sign in");
		frmSignIn.setResizable(false);
		frmSignIn.setBounds(100, 100, 383, 230);
		frmSignIn.setLocation(x, y);
		frmSignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignIn.getContentPane().setLayout(null);
		
		JLabel lblSignIn = new JLabel("Sign in");
		lblSignIn.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSignIn.setBounds(10, 0, 74, 38);
		frmSignIn.getContentPane().add(lblSignIn);
		
		JLabel lblUsarname = new JLabel("Username");
		lblUsarname.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblUsarname.setBounds(42, 65, 108, 23);
		frmSignIn.getContentPane().add(lblUsarname);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(42, 102, 119, 23);
		frmSignIn.getContentPane().add(lblPassword);
		
		final JLabel lblMassege = new JLabel("");
		lblMassege.setForeground(Color.RED);
		lblMassege.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMassege.setBounds(160, 45, 126, 14);
		frmSignIn.getContentPane().add(lblMassege);
		textFUsername = new JTextField();
		textFUsername.setBounds(160, 70, 142, 20);
		frmSignIn.getContentPane().add(textFUsername);
		textFUsername.setColumns(10);
		
		textFPassword = new JTextField();
		textFPassword.setBounds(160, 107, 142, 20);
		frmSignIn.getContentPane().add(textFPassword);
		textFPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = textFUsername.getText();
				String password = textFPassword.getText();
				if(LoginClient.checkLogin(userName, password)){
					MainFrame mainFrame = new MainFrame();
					frmSignIn.dispose();
					mainFrame.setVisible(true);
				}else{
					lblMassege.setText("Enter again");
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(213, 138, 89, 23);
		frmSignIn.getContentPane().add(btnLogin);
		
		
		
	}
}
