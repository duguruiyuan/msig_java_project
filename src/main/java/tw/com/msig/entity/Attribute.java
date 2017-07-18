package tw.com.msig.entity;

public class Attribute {

	private long id;
	private String attType;// "leaveType"
	private String attValue;
	private String attComm;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getattType() {
		return attType;
	}

	public void setattType(String attType) {
		this.attType = attType;
	}

	public String getattValue() {
		return attValue;
	}

	public void setattValue(String attValue) {
		this.attValue = attValue;
	}

	public String getattComm() {
		return attComm;
	}

	public void setattComm(String attComm) {
		this.attComm = attComm;
	}

}
