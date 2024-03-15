package SchLibTrackingSystem;

public class Address {
	
	private String street, city, buildingName, country;
	private int POBox;

	public Address() {
		
	}
	
	public Address(String buildingName, String street, String city, String country, int POBox) {
		this.setBuildingName(buildingName);
		this.setStreet(street);
		this.setCity(city);
		this.setCountry(country);
		this.setPOBox(POBox);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getPOBox() {
		return POBox;
	}

	public void setPOBox(int pOBox) {
		POBox = pOBox;
	}
	
	public String toString() {
		return buildingName + " Building@" + street + " Street@" + city + "@" + POBox;
	}

}
