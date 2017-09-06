package hu.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Gui extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JMenuBar jMnBar;
	private static JMenu jMnFile;
	private static JMenuItem jMnExitItem;
	protected static JPanel jPanelGui;
	private static JPanel jPnlGui;
	protected static JTabbedPane jTbdPaneGui;
	protected static JPanel jPnlWorkingGui;
	private static JButton btnNewGui;
	private static JPanel panel;

	public Gui() {
		setComponent();

	}

	private void setComponent() {
		this.setSize(1300, 750);
		this.setVisible(true);
		Gui.iniComponent();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jPnlGui.setLayout(null);
		jPnlGui.add(jTbdPaneGui);
		jPnlGui.add(btnNewGui);
		this.getContentPane().add(jPnlGui);
		jMnBar = new JMenuBar();
		jMnFile = new JMenu("Fájl");
		jMnExitItem = new JMenuItem("Kilépés");
		jMnBar.add(jMnFile);
		jMnFile.add(jMnExitItem);
		this.setJMenuBar(jMnBar);
	}

	public static void iniComponent() {
		btnNewGui = new JButton("Új");
		btnNewGui.setBounds(1161, 26, 113, 33);

		jPanelGui = new JPanel();
		jPnlGui = new JPanel();

		jTbdPaneGui = new JTabbedPane(JTabbedPane.TOP);
		jTbdPaneGui.setBounds(0, 0, 1151, 690);
		panel = new JPanel();
		jTbdPaneGui.addTab("New tab", null, panel, null);

		jPnlWorkingGui = new JPanel();
		jTbdPaneGui.addTab("Dolgozok", null, jPnlWorkingGui, null);
		jPnlWorkingGui.setLayout(null);
	}
}
