package Wrapper;

/**
 * 
 *
 */
public class Encoder{
	
	private final double ClicksPerRotation = 2048;
	
	public edu.wpi.first.wpilibj.Encoder encoder;
	
	private double radius;
	private double circumference;
	private double conversionFactor;
	
	public Encoder(int port1, int port2){
		encoder = new edu.wpi.first.wpilibj.Encoder(port1, port2);
	}
	
	public Encoder(int port1, int port2, double radius){
		encoder = new edu.wpi.first.wpilibj.Encoder(port1, port2);
		this.radius = radius;
		circumference = radius * 2 * Math.PI;
		conversionFactor = ClicksPerRotation / 360;
	}
	
	/**
	 * 
	 * @return The distance the encoder has traveled based on the unit of radius
	 */
	public double getDistance(){
		 return circumference * (encoder.getDistance() / ClicksPerRotation);
	}
	
	/**
	 * 
	 * @return Angle of rotation based off of start rotation
	 */
	public double getAngle(){
		double clicks = encoder.getDistance();
		clicks = (Math.abs(clicks / ClicksPerRotation) - (int)(Math.abs(clicks / ClicksPerRotation)));
		return (clicks * ClicksPerRotation) / conversionFactor;
	}
	
	public void reset(){
		encoder.reset();
	}
	
}
