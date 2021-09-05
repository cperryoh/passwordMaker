package passwordMaker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class maker {

	private JFrame frmPasswordMaker;
	private JTextField passOut;
	private JTextField lengthIn;
	ArrayList<CharType> types;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maker window = new maker();
					window.frmPasswordMaker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	boolean isNum(char c) {
		try {
			Integer.parseInt(Character.toString(c));
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	/**
	 * Create the application.
	 */
	public maker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		types = new ArrayList<CharType>();
		frmPasswordMaker = new JFrame();
		frmPasswordMaker.setTitle("Password maker");
		frmPasswordMaker.setBounds(100, 100, 340, 300);
		frmPasswordMaker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPasswordMaker.getContentPane().setLayout(null);
		
		passOut = new JTextField();
		passOut.setEditable(false);
		passOut.setBounds(10, 230, 181, 20);
		frmPasswordMaker.getContentPane().add(passOut);
		passOut.setColumns(10);
		
		JButton copyBtn = new JButton("Copy");
		copyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				StringSelection stringSelection = new StringSelection(passOut.getText());
				clipboard.setContents(stringSelection, null);
			}
		});
		copyBtn.setBounds(198, 225, 118, 23);
		frmPasswordMaker.getContentPane().add(copyBtn);
		
		JCheckBox symbolsChc = new JCheckBox("Symbols");
		symbolsChc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(symbolsChc.isSelected()) {
					types.add(CharType.symbols);
				}else {
					types.remove(CharType.symbols);
				}
			}
		});
		symbolsChc.setBounds(24, 81, 97, 23);
		frmPasswordMaker.getContentPane().add(symbolsChc);
		
		JCheckBox numbersChc = new JCheckBox("Numbers");
		numbersChc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numbersChc.isSelected()) {
					types.add(CharType.numbers);
				}else {
					types.remove(CharType.numbers);
				}
			}
		});
		numbersChc.setBounds(24, 107, 97, 23);
		frmPasswordMaker.getContentPane().add(numbersChc);
		
		JCheckBox uppercaseChc = new JCheckBox("uppercase");
		uppercaseChc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(uppercaseChc.isSelected()) {
					types.add(CharType.uppercase);
				}else {
					types.remove(CharType.uppercase);
				}
			}
		});
		uppercaseChc.setBounds(24, 133, 97, 23);
		frmPasswordMaker.getContentPane().add(uppercaseChc);
		
		JCheckBox lowercaseChc = new JCheckBox("lowercase");
		lowercaseChc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lowercaseChc.isSelected()) {
					types.add(CharType.lowercase);
				}else {
					types.remove(CharType.lowercase);
				}
			}
		});
		lowercaseChc.setBounds(24, 158, 97, 23);
		frmPasswordMaker.getContentPane().add(lowercaseChc);
		
		JButton genBtn = new JButton("Generate");
		genBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(types.size()!=0) {
					passOut.setText(PassWordGen.MakePassWord(types, Integer.parseInt(lengthIn.getText())));
				}
			}
		});
		genBtn.setBounds(24, 188, 89, 23);
		frmPasswordMaker.getContentPane().add(genBtn);
		
		Label label = new Label("Length:");
		label.setBounds(21, 52, 40, 22);
		frmPasswordMaker.getContentPane().add(label);
		
		lengthIn = new JTextField();
		lengthIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				boolean isNumber = isNum(e.getKeyChar());
				if(!isNumber&&e.getKeyCode()!=10) {
					e.consume();
				}
			}
		});
		lengthIn.setBounds(67, 54, 86, 20);
		frmPasswordMaker.getContentPane().add(lengthIn);
		lengthIn.setColumns(10);
	}
}
