package Wrapper;

/**
 * 
 * @author Garret
 *
 */
public class Stick {

	double X, Y;
	
	/**
	 * 
	 * @param X Value of x-axis.
	 * @param Y Value of y-axis.
	 */
	public Stick(double X, double Y){
		this.X = X;
		this.Y = Y;
	}
	
	/**
	 * 
	 * @return Value of x-axis.
	 */
	public double getX(){
		return X;
	}
	
	/**
	 * 
	 * @return Value of y-axis.
	 */
	public double getY(){
		return Y;
	}
	
	/**
	 * 
	 * @param X Value of x-axis.
	 */
	public void setX(double X){
		this.X = X;
	}
	
	/**
	 * 
	 * @param Y Value of y-axis.
	 */
	public void setY(double Y){
		this.Y = Y; 
		
	}
}
