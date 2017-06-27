package tw.com.msig.entity;

/** @author Matt S.Y Ho */
public class Item {

  private long id;
  private String name;

  @Override
  public String toString() {
    return "Item{" + "id=" + id + ", name='" + name + '\'' + '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
