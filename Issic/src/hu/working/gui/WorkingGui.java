package hu.working.gui;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import hu.gui.Gui;

@SuppressWarnings("serial")
public class WorkingGui extends Gui {

	public WorkingGui() {

		setComponents();
	}

	protected void setComponents() {
		GroupLayout groupLayout = new GroupLayout(jPnlGuiWorking);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1154, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 662, Short.MAX_VALUE)
		);
		jPnlGuiWorking.setLayout(groupLayout);

	}

	public static void iniComponent() {

	}
}
