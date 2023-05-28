package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ManageStudentModel;
import model.Student;
import view.ManageStudentView;

public class ManageStudentController implements ActionListener {

	private ManageStudentView view;

	public ManageStudentController(ManageStudentView view, ManageStudentModel model) {

		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();

		if (cm.equals("Clean")) {
			this.view.cleanForm();
		} else if (cm.equals("Save")) {
			Student st = this.view.getInfo();
			this.view.insertOrUpdate(st);
		} else if (cm.equals("Update")) {
			this.view.edit();
		} else if (cm.equals("Delete")) {
			this.view.delete();
		} else if (cm.equals("Cancle")) {
			System.out.println("Hello");
			this.view.cancle();
		} else if(cm.equals("Filter")) {
			this.view.filterByCity();
		} else if(cm.equals("Exit")) {
			this.view.exit();
		} else if(cm.equals("Save File")) {
			this.view.handleSaveFile();
		} else if(cm.equals("Open File")) {
			this.view.handleOpenFile();
		}

	}

}
