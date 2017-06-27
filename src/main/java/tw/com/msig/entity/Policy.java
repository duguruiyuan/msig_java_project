package tw.com.msig.entity;

import java.util.Set;

/** @author Matt S.Y Ho */
public class Policy {

  private long id;
  private String policyNo;
  private String applicantName;
  private Set<Item> items;

  @Override
  public String toString() {
    return "Policy{" +
            "id=" + id +
            ", policyNo='" + policyNo + '\'' +
            ", applicantName='" + applicantName + '\'' +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPolicyNo() {
    return policyNo;
  }

  public void setPolicyNo(String policyNo) {
    this.policyNo = policyNo;
  }

  public String getApplicantName() {
    return applicantName;
  }

  public void setApplicantName(String applicantName) {
    this.applicantName = applicantName;
  }

  public Set<Item> getItems() {
    return items;
  }

  public void setItems(Set<Item> items) {
    this.items = items;
  }
}
