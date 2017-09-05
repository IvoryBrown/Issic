package hu.main;

import javax.swing.SwingUtilities;

import hu.working.gui.WorkingGui;

public class MainProgram {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new WorkingGui();
			}
		});

	}

}
