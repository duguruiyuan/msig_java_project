package tw.com.msig.entity;

public class Security {
	private long id;
	  private String Empoloyee_id;
	  private String Group;
	  private String Enabled;
	  
	@Override
	public String toString() {
		return "Security [id=" + id + ", Empoloyee_id=" + Empoloyee_id + ", Group=" + Group + ", Enabled=" + Enabled
				+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpoloyee_id() {
		return Empoloyee_id;
	}

	public void setEmpoloyee_id(String empoloyee_id) {
		Empoloyee_id = empoloyee_id;
	}

	public String getGroup() {
		return Group;
	}

	public void setGroup(String group) {
		Group = group;
	}

	public String getEnabled() {
		return Enabled;
	}

	public void setEnabled(String enabled) {
		Enabled = enabled;
	}
	  
}
