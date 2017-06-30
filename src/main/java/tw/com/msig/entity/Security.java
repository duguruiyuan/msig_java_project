package tw.com.msig.entity;

public class Security {
	private long id;
	private String employeeId;
	private String group;
	private String enabled;

	@Override
	public String toString() {
		return "Security [id=" + id + ", employeeId=" + employeeId + ", group=" + group + ", enabled=" + enabled + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}
