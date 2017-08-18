package tw.com.msig.entity;

import java.time.LocalDateTime;
import java.util.Set;

public class Employee {

	private long id;
	private String employeeId;
	private String name;
	private String departmentId;
	private String email;
	private String phoneNumber;
	private LocalDateTime hireDate;
	private String jobId;
	private String managerId;
	private String password;
	private Set<Leave> leaves;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeId=" + employeeId + ", name=" + name + ", departmentId=" + departmentId
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId
				+ ", managerId=" + managerId + ", password=" + password + "]";
	}

	public Set<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(final Set<Leave> leaves) {
		this.leaves = leaves;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(final String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(final String departmentId) {
		this.departmentId = departmentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getHireDate() {
		return hireDate;
	}

	public void setHireDate(final LocalDateTime hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(final String jobId) {
		this.jobId = jobId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(final String managerId) {
		this.managerId = managerId;
	}

	public String getPassword() {
	    return password;
	  }

	  public void setPassword(final String password) {
	    this.password = password;
	  }

}
