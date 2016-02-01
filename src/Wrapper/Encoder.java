package Wrapper;

/**
 * 
 * @author Owen & Stephen (un peqeno)
 */
public class Encoder{
	
	private final double ClicksPerRotation = 2048;
	
	public edu.wpi.first.wpilibj.Encoder encoder;
	
	private double radius, circumference, conversionFactor;
	
	/**
	 * 
	 * @param port1 Channel A
	 * @param port2 Channel B
	 */
	public Encoder(int port1, int port2){
		encoder = new edu.wpi.first.wpilibj.Encoder(port1, port2);
	}
	
	/**
	 * 
	 * @param port1 Channel A
	 * @param port2 Channel B
	 * @param radius Radius of the wheel.
	 */
	public Encoder(int port1, int port2, double radius){
		encoder = new edu.wpi.first.wpilibj.Encoder(port1, port2);
		this.radius = radius;
		circumference = radius * 2 * Math.PI;
		conversionFactor = ClicksPerRotation / 360;
	}
	
	/**
	 * 
	 * @return The distance the encoder has spun based on the units of the radius.
	 */
	public double getDistance(){
		 return circumference * (encoder.getDistance() / ClicksPerRotation);
	}
	
	/**
	 * @author Ghjf544912
	 * @return The speed the encoder is at based on the units of the radius per second.
	 */
	public double getSpeed(){
		return (encoder.getRate() / ClicksPerRotation) * circumference;
	}
	
	/**
	 * 
	 * @return Angle of rotation based on initial angle.
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
