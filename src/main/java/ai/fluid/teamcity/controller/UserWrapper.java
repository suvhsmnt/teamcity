package ai.fluid.teamcity.controller;



public class UserWrapper {


	private String userName;


	private int gamesPlayed;


	private int gamesWon;

	private long lastGameId;

	public String getUserName() {
		return userName;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public int getGamesWon() {
		return gamesWon;
	}

	public long getLastGameId() {
		return lastGameId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

	public void setLastGameId(long lastGameId) {
		this.lastGameId = lastGameId;
	}



}
