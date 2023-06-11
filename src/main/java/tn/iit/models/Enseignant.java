package tn.iit.models;

public class Enseignant {
	private int id ;
	private String name ;
	private String email  ;
	private String institution ;
	public Enseignant(String name, String email, String institution) {
		super();
		this.name = name;
		this.email = email;
		this.institution = institution;
	}
	public Enseignant(int id, String name, String email, String institution) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.institution = institution;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
}
