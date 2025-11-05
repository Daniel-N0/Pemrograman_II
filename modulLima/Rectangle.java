package modulLima;

public class Rectangle extends Shape{
	private double length;
	private double width;
	
	public Rectangle(double l, double w) {
		super("Rectangle");
		this.length = l;
		this.width = w;
	}
	
	@Override
	public double area() {
		return length * width;
	}
	
	@Override 
	public String toString() {
		return super.toString() + " of Length " + this.length + " and Width " + this.width;
	}
	
}
