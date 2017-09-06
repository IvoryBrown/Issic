package hu.working.gui;

import hu.gui.Gui;


@SuppressWarnings("serial")
public class WorkingGui extends Gui {
	

	public WorkingGui() {

		setComponents();
	}

	protected void setComponents() {
		 
			tblWorking.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Partner név" }));
	}

	public static void iniComponent() {

	}
}
