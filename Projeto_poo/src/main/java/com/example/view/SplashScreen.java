package com.example.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

@SuppressWarnings("serial")
public class SplashScreen extends JWindow {

	private int duration;

	public SplashScreen(int d) {
		duration = d;
	}

	public void showSplash() {
		JPanel content = (JPanel) getContentPane();
		content.setBackground(Color.white);

		int width = 450;
		int height = 300;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);

		JLabel label = new JLabel(new ImageIcon(
				"C:\\Users\\mateus\\Documents\\workspace-sts-3.8.2.RELEASE\\POO_TRAB_JAVALINGO2.0\\src\\main\\java\\com\\javalingo\\img\\Icones\\fundo1.jpg"));
		JLabel copyrt = new JLabel("Copyright 2016, Javalingo", JLabel.CENTER);
		copyrt.setFont(new Font("Papyrus", Font.BOLD, 14));
		JProgressBar bp = new JProgressBar();
		bp.setBackground(new Color(0, 0, 128));
		bp.setBounds(0, 315, 521, 20);
		bp.setStringPainted(true);
		new Thread() {
			public void run() {
				for (int progress = 0; progress < 101; progress++) {
					try {
						bp.setValue(progress);

						sleep(80);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		}.start();
		content.add(bp, BorderLayout.NORTH);
		content.add(label, BorderLayout.CENTER);
		content.add(copyrt, BorderLayout.SOUTH);
		Color oraRed = new Color(0, 0, 128);
		content.setBorder(BorderFactory.createLineBorder(oraRed, 10));

		setVisible(true);

		try {
			Thread.sleep(duration);
		} catch (Exception e) {
		}
		setVisible(false);
	}

	public void showSplashAndExit() {
		showSplash();
		TelaInicial ti = new TelaInicial();
		ti.setVisible(true);
	}

	public static void main(String[] args) {

		SplashScreen splash = new SplashScreen(8000);
		splash.showSplashAndExit();

	}
}
