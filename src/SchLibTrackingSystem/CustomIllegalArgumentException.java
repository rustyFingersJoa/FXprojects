package SchLibTrackingSystem;

public class CustomIllegalArgumentException extends IllegalArgumentException {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String myMsg = "";
	
	public CustomIllegalArgumentException() {
		  this("Please enter either 1 or 2:\n");
	}
	
	public CustomIllegalArgumentException(String userMsg) {
	  this.myMsg = userMsg;
	}
	
	
	@Override
	public String getMessage() {
	  return myMsg;
	}
}