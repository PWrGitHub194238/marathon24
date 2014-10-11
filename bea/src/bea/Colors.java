package bea;

public enum Colors {
	BLUE("bl"),
	GREEN("gr"),
	RED("rd"),
	BLACK("bk"),
	ORANGE("or"),
	AZURE("az"),
	YELLOW("yl");
	
	
	private String color;
	
	private Colors(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
}
