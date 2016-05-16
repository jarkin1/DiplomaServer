package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import client.GoodsClient;
import dm.entity.Goods;
import dm.entity.OrderLine;

import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private OrderLineDialog dialog = new OrderLineDialog();
	final Toolkit toolkit = Toolkit.getDefaultToolkit();
	final Dimension screenSize = toolkit.getScreenSize();
	final int x = (screenSize.width) / 2;
	final int y = (screenSize.height) / 2;
	public static JTable tableGoods = new JTable();;
	private DefaultTableModel tableGoodsModel = new DefaultTableModel();
	private DefaultTableModel tableCartModel = new DefaultTableModel();
	private List<Goods> goods;
	private boolean checkCreateGoods = true;
	private JTextField textField;
	private JTable tableCart = new JTable();;



	public MainFrame() {
		updateListGoods();
		setColumn(tableGoodsModel);
		setColumn(tableCartModel);
		addRows();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1361, 726);
		setLocation(x-1361/2, y-726/2);
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

		final JPanel goodds = new JPanel();
		final JPanel cart = new JPanel();
		goodds.setBounds(0, 0, 1355, 676);
		getContentPane().add(goodds);
		goodds.setLayout(null);
		JScrollPane scrollPaneGoods = new JScrollPane();
		scrollPaneGoods.setBounds(10, 11, 1335, 581);
		goodds.add(scrollPaneGoods);
		scrollPaneGoods.setViewportView(tableGoods);
		tableGoods.setModel(tableGoodsModel);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(120, 603, 100, 23);
		goodds.add(btnUpdate);

		final JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(10, 603, 100, 23);
		goodds.add(btnCreate);

		JButton btnDelete = new JButton("Remove");
		btnDelete.setBounds(230, 603, 100, 23);
		goodds.add(btnDelete);

		JButton btnSortByName = new JButton("Sort by name");
		btnSortByName.setBounds(705, 642, 120, 23);
		goodds.add(btnSortByName);

		JButton btnSortByPrice = new JButton("Sort by price");
		btnSortByPrice.setBounds(965, 642, 120, 23);
		goodds.add(btnSortByPrice);

		JButton btnSortByAmount = new JButton("Sort by amount");
		btnSortByAmount.setBounds(1225, 642, 120, 23);
		goodds.add(btnSortByAmount);

		JButton btnSortByCode = new JButton("Sort by code");
		btnSortByCode.setBounds(835, 642, 120, 23);
		goodds.add(btnSortByCode);

		JButton btnSortByWeight = new JButton("Sort by weight");
		btnSortByWeight.setBounds(1095, 642, 120, 23);
		goodds.add(btnSortByWeight);
		JButton btnCart = new JButton("Cart");
		
		
		//============================CART============================
		
		
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodds.setVisible(false);
				cart.setVisible(true);
				tableCart.setModel(tableCartModel);
				addRowsCart();
			}
		});
		btnCart.setBounds(10, 642, 100, 23);
		goodds.add(btnCart);

	
		JButton btnAddToCart = new JButton("Add to Cart");
		
		
		//============================ADD TO CART============================
		
		
		
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dialog.setVisible(true);
				dialog.setLocation(x-297/2,y-114/2);
				
			}
		});
		btnAddToCart.setBounds(340, 603, 100, 23);
		goodds.add(btnAddToCart);

		textField = new JTextField("Search");
		textField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				textField.setText("");
			}

			public void focusLost(FocusEvent e) {
				// nothing
			}
		});
		textField.setToolTipText("");
		textField.setBounds(705, 604, 250, 20);
		goodds.add(textField);
		textField.setColumns(10);
		btnSortByWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showGoodsSortedByWeight();
			}
		});
		btnSortByCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showGoodsSortedByCode();
			}
		});
		btnSortByAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showGoodsSortedByAmount();
			}
		});
		btnSortByPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showGoodsSortedByPrice();
			}
		});
		btnSortByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showGoodsSortedByName();
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = false;
				int position = tableGoods.getSelectedRow();
				String code = (String) tableGoods.getModel().getValueAt(position, 0);
				Iterator<Goods> iterator = GoodsClient.findAllGoods().iterator();
				while (iterator.hasNext()) {
					Goods goods = iterator.next();
					if (goods.getCode().equals(code)) {
						GoodsClient.removeGoods(goods.getId());
						check = true;
					}
				}
				if (check) {
					JOptionPane.showMessageDialog(null, "Succseed", "Message", JOptionPane.INFORMATION_MESSAGE, null);
				} else {
					JOptionPane.showMessageDialog(null, "Error", "Message", JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkCreateGoods) {
					tableGoodsModel.addRow(new Object[] { "", "", "", "", "", "" });
					btnCreate.setText("Submit");
					checkCreateGoods = false;
				} else {
					int cell = tableGoods.getRowCount() - 1;
					String code = (String) tableGoods.getModel().getValueAt(cell, 0);
					String name = (String) tableGoods.getModel().getValueAt(cell, 1);
					String price2 = (String) tableGoods.getModel().getValueAt(cell, 2);
					String weight2 = (String) tableGoods.getModel().getValueAt(cell, 3);
					String amount2 = (String) tableGoods.getModel().getValueAt(cell, 4);
					if (amount2.isEmpty() || price2.isEmpty() || weight2.isEmpty() || code.isEmpty()
							|| name.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Error", "Message", JOptionPane.ERROR_MESSAGE, null);
					} else {
						String priceTemp = price2.substring(0, price2.indexOf('.'));
						String priceTemp2 = price2.substring(price2.indexOf('.') + 1, price2.length());
						int price = Integer.parseInt(priceTemp + priceTemp2);
						double weight = Double.parseDouble(weight2);
						int amount = Integer.parseInt(amount2);
						GoodsClient.saveGoods(new Goods(code, name, price, weight, amount));
						updateListGoods();
						JOptionPane.showMessageDialog(null, "Succseed", "Message", JOptionPane.INFORMATION_MESSAGE,
								null);
						btnCreate.setText("Create");
						checkCreateGoods = true;
					}

				}

			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateListGoods();
			}
		});

		cart.setBounds(0, 0, 1355, 676);
		getContentPane().add(cart);
		cart.setLayout(null);

		JButton btnAdd = new JButton("Goods");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cart.setVisible(false);
				goodds.setVisible(true);

			}
		});
		
		JScrollPane scrollPaneCart = new JScrollPane();
		scrollPaneCart.setBounds(0, 0, 1333, 592);
		cart.add(scrollPaneCart);
		
		scrollPaneCart.setViewportView(tableCart);
		btnAdd.setBounds(10, 642, 89, 23);
		cart.add(btnAdd);

	}

	private void removeAllRow(DefaultTableModel model) {
		if (model.getRowCount() > 0) {
			for (int i = model.getRowCount() - 1; i > -1; i--) {
				model.removeRow(i);
			}
		}
	}

	private void setColumn(DefaultTableModel model) {
		
		model.addColumn("Code");
		model.addColumn("Name");
		model.addColumn("Price");
		model.addColumn("Weight");
		model.addColumn("Amount");
	}

	private void addRows() {
		for (Goods goods2 : goods) {
			tableGoodsModel.addRow(new Object[] { goods2.getCode(), goods2.getName(),
					goods2.getPrice() / 100 + "." + goods2.getPrice() % 100, goods2.getWeight(), goods2.getAmount() });
		}
	}
	private void addRowsCart(){
		removeAllRow(tableCartModel);
		for (OrderLine orderLine : dialog.getOrderLinesCart()) {
			tableCartModel.addRow(new Object[] { 
					orderLine.getGoods().getCode(), 
					orderLine.getGoods().getName(),
					orderLine.getGoods().getPrice() / 100 + "." + orderLine.getGoods().getPrice() % 100, 
					orderLine.getGoods().getWeight(), 
					orderLine.getAmount() });
		}
		
	}

	private void updateListGoods() {
		goods = GoodsClient.findAllGoods();
	}

	private void showGoodsSortedByCode() {
		removeAllRow(tableGoodsModel);
		Comparator<Goods> comparator = new Comparator<Goods>() {
			@Override
			public int compare(Goods o1, Goods o2) {
				return o1.getCode().compareTo(o2.getCode());
			}
		};
		Collections.sort(goods, comparator);
		addRows();
		tableGoods.setModel(tableGoodsModel);
	}

	private void showGoodsSortedByName() {
		removeAllRow(tableGoodsModel);
		Comparator<Goods> comparator = new Comparator<Goods>() {
			@Override
			public int compare(Goods o1, Goods o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(goods, comparator);
		addRows();
		tableGoods.setModel(tableGoodsModel);
	}

	private void showGoodsSortedByPrice() {
		removeAllRow(tableGoodsModel);
		Comparator<Goods> comparator = new Comparator<Goods>() {
			@Override
			public int compare(Goods o1, Goods o2) {
				if (o1.getPrice() < o2.getPrice()) {
					return -1;
				} else if (o1.getPrice() > o2.getPrice()) {
					return 1;
				} else {
					return 0;
				}
			}
		};
		Collections.sort(goods, comparator);
		addRows();
		tableGoods.setModel(tableGoodsModel);
	}

	private void showGoodsSortedByWeight() {
		removeAllRow(tableGoodsModel);
		Comparator<Goods> comparator = new Comparator<Goods>() {
			@Override
			public int compare(Goods o1, Goods o2) {
				if (o1.getWeight() < o2.getWeight()) {
					return -1;
				} else if (o1.getWeight() > o2.getWeight()) {
					return 1;
				} else {
					return 0;
				}
			}
		};
		Collections.sort(goods, comparator);
		addRows();
		tableGoods.setModel(tableGoodsModel);
	}

	private void showGoodsSortedByAmount() {
		removeAllRow(tableGoodsModel);
		Comparator<Goods> comparator = new Comparator<Goods>() {
			@Override
			public int compare(Goods o1, Goods o2) {
				if (o1.getAmount() < o2.getAmount()) {
					return -1;
				} else if (o1.getAmount() > o2.getAmount()) {
					return 1;
				} else {
					return 0;
				}
			}
		};
		Collections.sort(goods, comparator);
		addRows();
		tableGoods.setModel(tableGoodsModel);
	}
}
