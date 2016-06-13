package it.uniroma3.model;

public class Amministratore {
	private String username;
	private String password;

	public Amministratore() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// TODO equals e hash code su username
	@Override
	public boolean equals(Object obj) {
		Amministratore admin = (Amministratore) obj;
		return this.getUsername().equals(admin.getUsername());
	}
	
	@Override
	public int hashCode() {
		return this.getUsername().hashCode();
	}
}
