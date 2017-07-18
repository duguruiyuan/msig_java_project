package tw.com.msig.entity;

public class Attribute {
	
	private long id;
	private String att_type;
	private String att_value;
	private String att_comm;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAtt_type() {
		return att_type;
	}
	public void setAtt_type(String att_type) {
		this.att_type = att_type;
	}
	public String getAtt_value() {
		return att_value;
	}
	public void setAtt_value(String att_value) {
		this.att_value = att_value;
	}
	public String getAtt_comm() {
		return att_comm;
	}
	public void setAtt_comm(String att_comm) {
		this.att_comm = att_comm;
	}
	
	

}
