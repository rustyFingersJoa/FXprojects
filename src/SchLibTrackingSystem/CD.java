package SchLibTrackingSystem;

public class CD extends LibraryItem{
	
	private int trackNo;
	private Name composer;

	public CD() {
		
	}
	
	public CD(int trackNo, Name composer){
		this.setTrackNo(trackNo);
		this.setComposer(composer);
	}
	
	
	public int getTrackNo() {
		return trackNo;
	}

	public void setTrackNo(int trackNo) {
		this.trackNo = trackNo;
	}
	
	public Name getComposer() {
		return composer;
	}

	public void setComposer(Name composer) {
		this.composer = composer;
	}
	
	
	public String toString() {
		return "trackNo " + trackNo + " by " + composer;
	}

	

}
