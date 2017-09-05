package hu.gui;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class Gui extends JFrame {
	protected static JMenuBar jMnBar;
	protected static JMenu jMnFile;
	protected static JMenuItem jMnExitItem;
	protected static JPanel jPanelGui;
	protected static JTabbedPane jTbdPaneGui;
	protected JPanel jPnlGuiDataSheet;
	protected static JButton btnNewButton;
	protected static JPanel jPnlGuiWorking;

	public Gui() {
		setComponent();

	}

	@SuppressWarnings("static-access")
	public void setComponent() {
		this.setSize(1300, 750);
		this.setVisible(true);
		this.iniComponent();
		this.setJMenuBar(jMnBar);
		jPnlGuiDataSheet = new JPanel();
		GroupLayout gl_jPanelGui = new GroupLayout(jPanelGui);
		gl_jPanelGui.setHorizontalGroup(
			gl_jPanelGui.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelGui.createSequentialGroup()
					.addComponent(jTbdPaneGui, GroupLayout.DEFAULT_SIZE, 1159, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_jPanelGui.setVerticalGroup(
			gl_jPanelGui.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelGui.createSequentialGroup()
					.addGap(24)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
					.addGap(634))
				.addComponent(jTbdPaneGui, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
		);
		jTbdPaneGui.addTab("Adatlap", null, jPnlGuiDataSheet, null);
		GroupLayout gl_jPnlGuiDataSheet = new GroupLayout(jPnlGuiDataSheet);
		gl_jPnlGuiDataSheet.setHorizontalGroup(
				gl_jPnlGuiDataSheet.createParallelGroup(Alignment.LEADING).addGap(0, 1146, Short.MAX_VALUE));
		gl_jPnlGuiDataSheet.setVerticalGroup(
				gl_jPnlGuiDataSheet.createParallelGroup(Alignment.LEADING).addGap(0, 662, Short.MAX_VALUE));
		jPnlGuiDataSheet.setLayout(gl_jPnlGuiDataSheet);

		jTbdPaneGui.addTab("Dolgozok", null, jPnlGuiWorking, null);
		jPanelGui.setLayout(gl_jPanelGui);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(jPanelGui,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(jPanelGui,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		getContentPane().setLayout(groupLayout);

	}

	public static void iniComponent() {
		jMnBar = new JMenuBar();
		jMnFile = new JMenu("Fájl");
		jMnExitItem = new JMenuItem("Kilépés");
		jMnBar.add(jMnFile);
		jMnFile.add(jMnExitItem);
		jPanelGui = new JPanel();
		jTbdPaneGui = new JTabbedPane(JTabbedPane.TOP);
		jPnlGuiWorking = new JPanel();
		btnNewButton = new JButton("New button");
	}
}
