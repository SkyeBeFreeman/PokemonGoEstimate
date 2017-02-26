package com.zhtian;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Runner {

	public static void main(String[] args) {
		
		try {  
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (InstantiationException e) {  
            e.printStackTrace();  
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
        } catch (javax.swing.UnsupportedLookAndFeelException e) {  
            e.printStackTrace();  
        }
		
		Calculator app = new Calculator();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(750, 300);
		int windowWidth = app.getWidth();
        int windowHeight = app.getHeight();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        app.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
		app.setVisible(true);
	}

}
