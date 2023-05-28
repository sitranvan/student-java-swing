package model;

import java.util.ArrayList;

public class ManageStudentModel {
	private ArrayList<Student> listStudent;
	private String fileName;
	
	public ManageStudentModel() {
		this.listStudent = new ArrayList<Student>();
		this.setFileName("");
	}

	public ManageStudentModel(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}

	public ArrayList<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}

	public void insert(Student sv) {
		try {
			this.listStudent.add(sv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Student st) {
		try {
			this.listStudent.remove(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Student st) {
		this.delete(st);
		this.insert(st);
	}

	
	public boolean checkExists(Student st) {
		for (Student student : listStudent) {
			if(student.getId()==st.getId()) {
				return true;
			}
		}
		return false;

	}
	public Student findStudentById(int id) {
	    for (Student st : listStudent) {
	        if(st.getId()==id) {
	        	return st;
	        }
	    }
	    return null;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



}
