package Default;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Interface extends Currency {

	private JFrame frame;
	private JTextField txt;
	private JButton btn;
	private JComboBox cmb;
	private JLabel lbl;
	private JComboBox cmb_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

	public String AMoneda(double cantidad, String moneda) {
		return "$" + cantidad + " " + moneda;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(130, 130, 130));
		frame.setFont(new Font("Arial Black", Font.BOLD, 29));
		frame.setBounds(100, 100, 1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txt = new JTextField();
		txt.setFont(new Font("Arial Black", Font.BOLD, 32));
		txt.setBounds(290, 222, 401, 52);
		frame.getContentPane().add(txt);
		txt.setColumns(10);

		cmb = new JComboBox();
		cmb.setForeground(new Color(0, 0, 0));
		cmb.setBackground(new Color(255, 255, 255));
		cmb.setFont(new Font("Arial Black", Font.BOLD, 32));
		cmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				de = cmb.getSelectedItem().toString();
				Converter();
			}
		});
		cmb.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "DOP", "LIBRAS", "YEN", "WON"}));
		cmb.setBounds(161, 328, 231, 64);
		frame.getContentPane().add(cmb);

		// event btn
		btn = new JButton("");
		btn.setIcon(new ImageIcon(
				"D:\\Dev kit\\workspace\\proyectos\\CurrencyConverter\\src\\asset\\exchange-icon-design-free-vector.jpg"));
		btn.setFont(new Font("Arial Black", Font.BOLD, 32));
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Converter();
			}

		});
		btn.setBounds(389, 457, 186, 91);
		frame.getContentPane().add(btn);

		lbl = new JLabel("00.00");
		lbl.setFont(new Font("Arial Black", Font.BOLD, 32));
		lbl.setBounds(360, 583, 513, 75);
		frame.getContentPane().add(lbl);

		cmb_1 = new JComboBox();
		cmb_1.setForeground(new Color(0, 0, 0));
		cmb_1.setBackground(new Color(255, 255, 255));
		cmb_1.setFont(new Font("Arial Black", Font.BOLD, 32));
		cmb_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = cmb_1.getSelectedItem().toString();
				Converter();
			}
		});
		cmb_1.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "DOP", "LIBRAS", "YEN", "WON"}));
		cmb_1.setBounds(557, 328, 231, 64);
		frame.getContentPane().add(cmb_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon("D:\\Dev kit\\workspace\\proyectos\\CurrencyConverter\\src\\asset\\dollar.png"));
		lblNewLabel.setBounds(164, 534, 141, 128);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(
				new ImageIcon("D:\\Dev kit\\workspace\\proyectos\\CurrencyConverter\\src\\asset\\dollar_coin.png"));
		lblNewLabel_1.setBounds(914, 28, 142, 128);
		frame.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Enter Amount");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 32));
		lblNewLabel_2.setBounds(290, 171, 528, 52);
		frame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("From");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 32));
		lblNewLabel_3.setBounds(167, 284, 204, 52);
		frame.getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Convert");
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 32));
		lblNewLabel_4.setBounds(403, 410, 164, 37);
		frame.getContentPane().add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("To");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Arial Black", Font.BOLD, 32));
		lblNewLabel_5.setBounds(737, 292, 58, 37);
		frame.getContentPane().add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Currency Converter");
		lblNewLabel_6.setFont(new Font("Arial Black", Font.BOLD, 38));
		lblNewLabel_6.setBounds(290, 54, 453, 52);
		frame.getContentPane().add(lblNewLabel_6);
	}

	public void Converter() {
		if (Validar(txt.getText())) {
			switch (de) {
			case "EUR":
				if (a.equals("USD")) {
					conversion = cantidad * 1.11;
				} else if (a.equals("DOP")) {
					conversion = cantidad * 62.90;
				} else if (a.equals("LIBRAS")) {
					conversion = cantidad * 0.87;
				}else if (a.equals("YEN")) {
					conversion = cantidad * 157.86;
				} else if (a.equals("WON")) {
					conversion = cantidad *1431.41;
				} else {// EUR
					conversion = cantidad ;
				}
				break;
			case "USD":
				if (a.equals("EUR")) {
					conversion = cantidad * 0.90;
				} else if (a.equals("DOP")) {
					conversion = cantidad * 56.47;
				}else if (a.equals("LIBRAS")) {
					conversion = cantidad * 0.78;
				}else if (a.equals("YEN")) {
					conversion = cantidad * 141.78;
				} else if (a.equals("WON"))
					conversion = cantidad *1286.65;
				else {//USD
					conversion = cantidad;
				}
				break;
			case "LIBRAS":
				if (a.equals("EUR")) {
					conversion = cantidad * 1.15;
				} else if (a.equals("USD")) {
					conversion = cantidad * 1.29;
				}else if (a.equals("DOP")) {
					conversion = cantidad * 72.06;
				}else if (a.equals("YEN")) {
					conversion = cantidad * 182.30;
				} else if (a.equals("WON"))
					conversion = cantidad * 1654.12;
				else {// LIBRAS
					conversion = cantidad;
				}
				break;
			case "YEN":
				if (a.equals("EUR")) {
					conversion = cantidad * 0.0063;
				} else if (a.equals("USD")) {
					conversion = cantidad * 0.0071;
				}else if (a.equals("LIBRAS")) {
					conversion = cantidad * 0.0055;
				}else if (a.equals("DOP")) {
					conversion = cantidad * 0.40;
				} else if (a.equals("WON"))
					conversion = cantidad * 9.07;
				else {// YEN
					conversion = cantidad;
				}
				break;
			case "WON":
				if (a.equals("EUR")) {
					conversion = cantidad * 0.00070;
				} else if (a.equals("USD")) {
					conversion = cantidad * 0.00078;
				}else if (a.equals("LIBRAS")) {
					conversion = cantidad * 0.00060;
				}else if (a.equals("YEN")) {
					conversion = cantidad * 0.11;
				} else if (a.equals("DOP"))
					conversion = cantidad * 0.044;
				else {// WON
					conversion = cantidad;
				}
				break;
			case "DOP":
				if (a.equals("EUR")) {
					conversion = cantidad * 0.018;
				} else if (a.equals("USD")) {
					conversion = cantidad * 0.016;
				}else if (a.equals("LIBRAS")) {
					conversion = cantidad * 0.014;
				}else if (a.equals("YEN")) {
					conversion = cantidad * 2.53;
				} else if (a.equals("WON"))
					conversion = cantidad * 22.96;
				else {// DOP
					conversion = cantidad;
				}
				break;

			}
		}

		lbl.setText(AMoneda(cantidad, a) + "-->" + AMoneda(conversion, de));
	}

	public boolean Validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if (x > 0)
				;
			cantidad = x;
			return true;
		} catch (NumberFormatException e) {
			lbl.setText("Ingresa un monto valido");
			return false;

		}
	}
}
