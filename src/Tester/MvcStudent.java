package Tester;

import java.awt.EventQueue;

import view.ManageStudentView;

public class MvcStudent {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentView frame = new ManageStudentView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
