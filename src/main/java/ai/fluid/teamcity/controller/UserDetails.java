package ai.fluid.teamcity.controller;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;


@Entity
@Access(AccessType.FIELD)
public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1999081990036221695L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String userName;

	private int gamesPlayed;

	private int gamesWon;

	private long lastGameId;

	@Deprecated
	public UserDetails() {
		super();
	}

	public UserDetails(UserWrapper wrapper) {
		super();
		setUserName(wrapper.getUserName());
		setGamesPlayed(wrapper.getGamesPlayed());
		setGamesWon(wrapper.getGamesWon());
		setLastGameId(wrapper.getLastGameId());
	}

	public long getUserId() {
		return id;
	}

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

	public void setUserId(long userId) {
		this.id = userId;
	}
	// Error code -> UD00(01-10)
	public void setUserName(String userName) {
		if(StringUtils.isEmpty(userName))
		{
			throw new GenericException(400, "UD0001", "User Name can not be null or empty.");
		}
		this.userName = userName;
	}

	// Error code -> UD00(10-20)
	public void setGamesPlayed(int gamesPlayed) {
		if (gamesPlayed < 0) {
			throw new GenericException(400, "UD0010", "Games Played can not be negative.");
		}
		this.gamesPlayed = gamesPlayed;
	}

	public void setGamesWon(int gamesWon) {
		if (gamesPlayed < 0) {
			throw new GenericException(400, "UD0010", "Games won can not be negative.");
		}
		this.gamesWon = gamesWon;
	}

	public void setLastGameId(long lastGameId) {
		if (gamesPlayed != 0) {
			if (lastGameId == 0) {
				throw new GenericException(400, "UD0010", "Please provide the last game id.");
			}
		}
		this.lastGameId = lastGameId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gamesPlayed;
		result = prime * result + gamesWon;
		result = prime * result + (int) (lastGameId ^ (lastGameId >>> 32));
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		if (gamesPlayed != other.gamesPlayed)
			return false;
		if (gamesWon != other.gamesWon)
			return false;
		if (lastGameId != other.lastGameId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + id + ", userName=" + userName + ", gamesPlayed=" + gamesPlayed + ", gamesWon="
				+ gamesWon + ", lastGameId=" + lastGameId + "]";
	}

}
