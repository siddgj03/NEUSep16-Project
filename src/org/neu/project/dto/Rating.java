package org.neu.project.dto;

public class Rating {
	private float averRate;
	private int voteCount;
	public float getAverRate() {
		return averRate;
	}
	
	public void setAverRate(float averRate) {
		this.averRate =(float) (Math.round(averRate*100)/100.0);
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	
}
