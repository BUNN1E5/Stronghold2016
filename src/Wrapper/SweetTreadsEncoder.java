package Wrapper;

import edu.wpi.first.wpilibj.Encoder;

/**
 * 
 * @author Ghjf544912
 *
 */
public class SweetTreadsEncoder extends Encoder {

	/**
	 * TODO: Make it do something.
	 * @param channelA First channel of the encoder.
	 * @param channelB Second channel of the encoder.
	 * @param inReverse Tells if the motors are moving forwards/backwards.
	 * @param radius Radius of the wheel. 
	 */
	public SweetTreadsEncoder(int channelA, int channelB, boolean inReverse, double radius){
		super(channelA,channelB,inReverse);
		
	}
	
	/**
	 * TODO: Add math to change raw angle to position angle.
	 * @param angle The position angle of the motor. 
	 * @return The angle of the motor 0<=angle<360.
	 */
	public double getAngle(double angle){
		
		return angle;
	}
	
}
