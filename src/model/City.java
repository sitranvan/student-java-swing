package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

@SuppressWarnings("serial")
public class City implements Serializable{
	private int cityId;
	private String cityName;

	public City() {
		this.cityId = 0;
		this.cityName = "";
	}

	public City(int cityId, String cityName) {
		this.cityId = cityId;
		this.cityName = cityName;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cityId, cityName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return cityId == other.cityId && Objects.equals(cityName, other.cityName);
	}

	public static ArrayList<City> getListCity() {
		String[] arr_City = { "", "Bac Lieu", "Can Tho", "Ca Mau", "Soc Trang", "An Giang", "Tien Giang", "Ben Tre",
				"Vinh Long", "Binh Phuoc", "Dong Nai", "Hau Giang", "Ha Noi", "Lang Son", "Cao Bang" };
		ArrayList<City> listCity = new ArrayList<City>();
		int i = 0;
		for (String city : arr_City) {
			City t = new City(i, city);
			listCity.add(t);
			i++;
		}
		return listCity;
	}

	public static City getCityById(int index) {
		return City.getListCity().get(index);
	}

	public static City getCityByName(String s) {
		ArrayList<City> listCity = City.getListCity();
		for (City city : listCity) {
			if (city.getCityName().equals(s)) {
				return city;
			}
		}
		return null;
	}
}
