package ui.vehicleView;

import java.util.HashMap;

public class Special {
	private HashMap<String, String> criteria;
	private HashMap<String, Integer> type;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String description;
	private String disclosure;
	private String Expires;

	public HashMap<String, String> getCriteria() {
		return criteria;
	}

	public void setCriteria(HashMap<String, String> criteria) {
		this.criteria = criteria;
	}

	public HashMap<String, Integer> getType() {
		return type;
	}

	public void setType(HashMap<String, Integer> type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisclosure() {
		return disclosure;
	}

	public void setDisclosure(String disclosure) {
		this.disclosure = disclosure;
	}

	public String getExpires() {
		return Expires;
	}

	public void setExpires(String expires) {
		Expires = expires;
	}

}
