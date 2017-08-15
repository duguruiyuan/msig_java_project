package tw.com.msig.entity;

import java.time.LocalDateTime;

public class Leave {

	private long id;
	private String leave_type;
	private LocalDateTime start_time;
	private LocalDateTime end_time;
	private String agent;
	private LocalDateTime approve_time;
	private LocalDateTime key_time;
	private String user_cancel_flag;
	private String manager_approve_flag;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}

	public LocalDateTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}

	public LocalDateTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public LocalDateTime getApprove_time() {
		return approve_time;
	}

	public void setApprove_time(LocalDateTime approve_time) {
		this.approve_time = approve_time;
	}

	public LocalDateTime getKey_time() {
		return key_time;
	}

	public void setKey_time(LocalDateTime key_time) {
		this.key_time = key_time;
	}

	public String getUser_cancel_flag() {
		return user_cancel_flag;
	}

	public void setUser_cancel_flag(String user_cancel_flag) {
		this.user_cancel_flag = user_cancel_flag;
	}

	public String getManager_approve_flag() {
		return manager_approve_flag;
	}

	public void setManager_approve_flag(String manager_approve_flag) {
		this.manager_approve_flag = manager_approve_flag;
	}

}
