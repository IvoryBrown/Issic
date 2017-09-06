package hu.main;

import hu.working.gui.WorkingGui;

public class MainProgram{
	

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new WorkingGui();
				
				
			}
		});

	}

}
