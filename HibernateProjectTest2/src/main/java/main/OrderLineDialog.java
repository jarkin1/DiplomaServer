package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.GoodsClient;
import client.OrderLineClient;
import dm.entity.Goods;
import dm.entity.OrderLine;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class OrderLineDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFAmount;
	private List<OrderLine> orderLinesCart = new ArrayList<>();
	public List<OrderLine> getOrderLinesCart() {
		return orderLinesCart;
	}

	public void setOrderLinesCart(List<OrderLine> orderLinesCart) {
		this.orderLinesCart = orderLinesCart;
	}

	private JTextField textFDiscount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrderLineDialog dialog = new OrderLineDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrderLineDialog() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 311, 151);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textFAmount = new JTextField();
			textFAmount.setBounds(127, 11, 126, 20);
			contentPanel.add(textFAmount);
			textFAmount.setColumns(10);
		}
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAmount.setBounds(10, 11, 107, 20);
		contentPanel.add(lblAmount);
		{
			textFDiscount = new JTextField();
			textFDiscount.setBounds(127, 42, 126, 20);
			contentPanel.add(textFDiscount);
			textFDiscount.setColumns(10);
		}
		{
			JLabel lblDiscount = new JLabel("Discount:");
			lblDiscount.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblDiscount.setBounds(10, 41, 107, 17);
			contentPanel.add(lblDiscount);
		}
		{
			JLabel lblItems = new JLabel("items");
			lblItems.setBounds(263, 14, 46, 14);
			contentPanel.add(lblItems);
		}
		{
			JLabel label = new JLabel("%");
			label.setBounds(263, 45, 46, 14);
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						int position = MainFrame.tableGoods.getSelectedRow();
						String code = (String) MainFrame.tableGoods.getModel().getValueAt(position, 0);
						String name = (String) MainFrame.tableGoods.getModel().getValueAt(position, 1);
						String price2 = (String) MainFrame.tableGoods.getModel().getValueAt(position, 2);
						Double weight = (Double) MainFrame.tableGoods.getModel().getValueAt(position, 3);
						int amountOfStock = (Integer) MainFrame.tableGoods.getModel().getValueAt(position, 4);
						String priceTemp = price2.substring(0, price2.indexOf('.'));
						String priceTemp2 = price2.substring(price2.indexOf('.') + 1, price2.length());
						int price = Integer.parseInt(priceTemp + priceTemp2);
						Goods tempGood = new Goods(code, name, price, weight, amountOfStock);
						int amountOrder = Integer.parseInt(textFAmount.getText());
						int discount = Integer.parseInt(textFDiscount.getText());
						OrderLine orderLine = new OrderLine(amountOrder, discount, tempGood);
						List<Goods> goods = GoodsClient.findAllGoods();
						for (Goods goods2 : goods) {
							if(goods2.getCode().equals(tempGood.getCode())){
								orderLine = new OrderLine(amountOrder, discount, goods2);
							}
						}
						orderLinesCart.add(orderLine);
						OrderLineClient.saveOrderLine(orderLine);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
