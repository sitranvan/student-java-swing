package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@SuppressWarnings("serial")
public class Student implements Serializable{
	private int id;
	private String fullName;
	private City city;
	private Date birthday;
	private boolean sex;
	private float subScore_1, subScore_2, subScore_3;

	public Student() {
		this.id = 0;
		this.fullName = "";
		this.city = new City();
		this.birthday = null;
		this.sex = true;
		this.subScore_1 = 0;
		this.subScore_2 = 0;
		this.subScore_3 = 0;
	}

	

	public Student(int id, String fullName, City city, Date birthday, boolean sex, float subScore_1, float subScore_2, float subScore_3) {
	    this.id = id;
	    this.fullName = fullName;
	    this.city = city;
	    this.birthday = birthday;
	    this.sex = sex;
	    this.subScore_1 = subScore_1;
	    this.subScore_2 = subScore_2;
	    this.subScore_3 = subScore_3;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public float getSubScore_1() {
		return subScore_1;
	}

	public void setSubScore_1(float subScore_1) {
		this.subScore_1 = subScore_1;
	}

	public float getSubScore_2() {
		return subScore_2;
	}

	public void setSubScore_2(float subScore_2) {
		this.subScore_2 = subScore_2;
	}

	public float getSubScore_3() {
		return subScore_3;
	}

	public void setSubScore_3(float subScore_3) {
		this.subScore_3 = subScore_3;
	}


	@Override
	public String toString() {
		return "Contestant [id=" + id + ", fullName=" + fullName + ", city=" + city + ", birthday=" + birthday
				+ ", subScore_1=" + subScore_1 + ", subScore_2=" + subScore_2 + ", subScore_3=" + subScore_3 + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthday, city, fullName, id, subScore_1, subScore_2, subScore_3);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(city, other.city)
				&& Objects.equals(fullName, other.fullName) && id == other.id
				&& Float.floatToIntBits(subScore_1) == Float.floatToIntBits(other.subScore_1)
				&& Float.floatToIntBits(subScore_2) == Float.floatToIntBits(other.subScore_2)
				&& Float.floatToIntBits(subScore_3) == Float.floatToIntBits(other.subScore_3);
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
}
