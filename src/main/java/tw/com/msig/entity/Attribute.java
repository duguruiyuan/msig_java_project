package tw.com.msig.entity;

import java.io.Serializable;

public class Attribute implements Serializable {

	private String attType;// "leaveType"
	private String attValue;
	private String attComm;

	@Override
	public String toString() {
		return "Attribute [attType=" + attType + ", attValue=" + attValue + ", attComm=" + attComm + "]";
	}

	public String getAttType() {
		return attType;
	}

	public void setAttType(String attType) {
		this.attType = attType;
	}

	public String getAttValue() {
		return attValue;
	}

	public void setAttValue(String attValue) {
		this.attValue = attValue;
	}

	public String getAttComm() {
		return attComm;
	}

	public void setAttComm(String attComm) {
		this.attComm = attComm;
	}


}
