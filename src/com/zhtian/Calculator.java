package com.zhtian;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calculator extends JFrame {

	private JLabel title = new JLabel("Pokemon PerfectDegree Calculator", JLabel.CENTER);
	private JLabel pokemonId = new JLabel("Pokemon #");
	private JTextField pokemonIdInput = new JTextField(10);
	private JLabel pokemonCp = new JLabel("Pokemon Cp ");
	private JTextField pokemonCpInput = new JTextField(10);
	private JLabel pokemonStar = new JLabel("Stardust");
	private JTextField pokemonStarInput = new JTextField(10);
	private JCheckBox isThefirst = new JCheckBox("is sure of this stardust.");
	private JButton calculate = new JButton("Calculate it !");
	private JTextArea displayArea = new JTextArea(5, 20);
	private JLabel writter = new JLabel("2016-7-25 by skyebefreeman", JLabel.CENTER);
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private Data data = new Data();
	
	public Calculator() {
		
		super("Pokemon PerfectDegree Calculator");
		
		
		try {
			Image image = ImageIO.read(getClass().getResource("icon.jpg"));
			this.setIconImage(image);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		
		
		layout = new GridBagLayout();
		setLayout(layout);
		constraints = new GridBagConstraints();
		constraints.ipadx = 10;
		constraints.ipady = 10;
		
		constraints.fill = GridBagConstraints.BOTH;
		
		title.setFont(new Font("Dialog", 1, 25));
		pokemonId.setFont(new Font("Dialog", 0, 20));
		pokemonIdInput.setFont(new Font("Dialog", 0, 20));
		pokemonCp.setFont(new Font("Dialog", 0, 20));
		pokemonCpInput.setFont(new Font("Dialog", 0, 20));
		pokemonStar.setFont(new Font("Dialog", 0, 20));
		pokemonStarInput.setFont(new Font("Dialog", 0, 20));
		calculate.setFont(new Font("Dialog", 1, 20));
		displayArea.setFont(new Font("Dialog", 0, 15));
		displayArea.setEditable(false);
		writter.setForeground(Color.RED);
		writter.setFont(new Font("DIALOG", 1, 15));
		
		
		addComponent(title, 0, 0, 3, 1);
		
		constraints.weightx = 0;
		constraints.weighty = 0;
		addComponent(pokemonId, 1, 0, 1, 1);
		addComponent(pokemonIdInput, 1, 1, 1, 1);
		addComponent(pokemonCp, 2, 0, 1, 1);
		addComponent(pokemonCpInput, 2, 1, 1, 1);
		addComponent(pokemonStar, 3, 0, 1, 1);
		addComponent(pokemonStarInput, 3, 1, 1, 1);
		addComponent(isThefirst, 4, 0, 1, 1);
		
		calculate.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							String idStr = pokemonIdInput.getText();
							String cpStr = pokemonCpInput.getText();
							String starStr = pokemonStarInput.getText();
							int id = Integer.parseInt(idStr);
							int cp = Integer.parseInt(cpStr);
							int star = Integer.parseInt(starStr);
							if (id <= 0 || cp <= 0 || star <= 0) {
								JOptionPane.showMessageDialog(getContentPane(),
										"Please enter positive numbers.", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							int hp = 0, attack = 0, defense = 0, spattack = 0, spdefense = 0, speed = 0;
							for (HiddenData a : data.hiddenData) {
								if (a.num == id) {
									hp = a.hp;
									attack = a.attack;
									defense = a.defense;
									spattack = a.spAttack;
									spdefense = a.spDefense;
									speed = a.speed;
									break;
								}
							}
							double cp_mul_1 = 0, cp_mul_2 = 0, cp_mul_3 = 0, cp_mul_4 = 0;
							for (Star_Cp b : data.star_Cps) {
								if (b.stardust == star) {
									cp_mul_1 = b.cp_multiplier1;
									cp_mul_2 = b.cp_multiplier2;
									cp_mul_3 = b.cp_multiplier3;
									cp_mul_4 = b.cp_multiplier4;
									break;
								}
							}
							double baseStamina = 2*hp;
							double baseAttack = 2*(Math.sqrt(attack*spattack) + Math.sqrt(speed));
							double baseDefense = 2*(Math.sqrt(defense*spdefense) + Math.sqrt(speed));
							
							double ans_1_min = (baseAttack)*(Math.sqrt(baseDefense))*(Math.sqrt(baseStamina)
									*(cp_mul_1*cp_mul_1)*0.1);
							double ans_1_max = (baseAttack + 15.0)*(Math.sqrt(baseDefense + 15.0))*(Math.sqrt(baseStamina + 15.0)
									*(cp_mul_1*cp_mul_1)*0.1);
							double ans_1 = (cp - ans_1_min)/(ans_1_max - ans_1_min)*100;
							
							double ans_2_min = (baseAttack)*(Math.sqrt(baseDefense))*(Math.sqrt(baseStamina)
									*(cp_mul_2*cp_mul_2)*0.1);
							double ans_2_max = (baseAttack + 15.0)*(Math.sqrt(baseDefense + 15.0))*(Math.sqrt(baseStamina + 15.0)
									*(cp_mul_2*cp_mul_2)*0.1);
							double ans_2 = (cp - ans_2_min)/(ans_2_max - ans_2_min)*100;
							
							double ans_3_min = (baseAttack)*(Math.sqrt(baseDefense))*(Math.sqrt(baseStamina)
									*(cp_mul_3*cp_mul_3)*0.1);
							double ans_3_max = (baseAttack + 15.0)*(Math.sqrt(baseDefense + 15.0))*(Math.sqrt(baseStamina + 15.0)
									*(cp_mul_3*cp_mul_3)*0.1);
							double ans_3 = (cp - ans_3_min)/(ans_3_max - ans_3_min)*100;
							
							double ans_4_min = (baseAttack)*(Math.sqrt(baseDefense))*(Math.sqrt(baseStamina)
									*(cp_mul_4*cp_mul_4)*0.1);
							double ans_4_max = (baseAttack + 15.0)*(Math.sqrt(baseDefense + 15.0))*(Math.sqrt(baseStamina + 15.0)
									*(cp_mul_4*cp_mul_4)*0.1);
							double ans_4 = (cp - ans_4_min)/(ans_4_max - ans_4_min)*100;							
							
							System.out.println(ans_1);
							System.out.println(ans_2);
							System.out.println(ans_3);
							System.out.println(ans_4);
							
							double ans_max = ans_1, ans_min = ans_4;
							if (ans_max > 100)
								ans_max = ans_2;
							if (ans_2 > 100)
								ans_max = ans_3;
							if (ans_3 > 100)
								ans_max = ans_4;
							
							if (ans_min < 0)
								ans_min = ans_3;
							if (ans_3 < 0)
								ans_min = ans_2;
							if (ans_2 < 0)
								ans_min = ans_1;
							
							if (ans_max < 0 || ans_max > 100 || ans_min < 0 || ans_min > 100) {
								JOptionPane.showMessageDialog(getContentPane(),
										"Please enter right numbers.\nThe answer is outof range.", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							if (isThefirst.isSelected() || ans_min == ans_max)
								displayArea.append("You #" + id + " pokemon's perfect degree is " + (int)ans_min + "%.\n");
							else
								displayArea.append("You #" + id + " pokemon's perfect degree is " + (int)ans_min + "%~" + (int)ans_max + "%.\n");
						} catch (NumberFormatException exception) {
							JOptionPane.showMessageDialog(getContentPane(),
									"Please enter numbers.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
		addComponent(calculate, 4, 1, 1, 1);
		
		addComponent(new JScrollPane(displayArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), 1, 2, 2, 3);
		
		addComponent(writter, 4, 2, 2, 1);
		
	}
	
	public void addComponent(Component component, int row, int column, int width, int height) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		layout.setConstraints(component, constraints);
		add(component);
	}
	
}
