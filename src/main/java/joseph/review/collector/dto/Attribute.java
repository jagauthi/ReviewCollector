package joseph.review.collector.dto;

public class Attribute {
	
	String aisleTitle, color, size;
	
	public Attribute() {
		//Empty constructor
	}

	public String getAisleTitle() {
		return aisleTitle;
	}

	public void setAisleTitle(String aisleTitle) {
		this.aisleTitle = aisleTitle;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Attribute [aisleTitle=" + aisleTitle + ", color=" + color + ", size=" + size + "]";
	}

}
