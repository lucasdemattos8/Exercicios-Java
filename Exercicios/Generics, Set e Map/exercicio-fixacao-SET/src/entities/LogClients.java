package entities;

import java.time.Instant;
import java.util.Objects;

public class LogClients {
	
	private String username;
	private Instant logDate;
	
	public LogClients(String username, Instant logDate) {
		this.username = username;
		this.logDate = logDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Instant getLogDate() {
		return logDate;
	}

	public void Instant(Instant logDate) {
		this.logDate = logDate;
	}

	@Override
	public String toString() {
		return username + " " + logDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogClients other = (LogClients) obj;
		return Objects.equals(username, other.username);
	}	
}
