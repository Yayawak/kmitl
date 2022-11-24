import java.io.*;
class Person  implements Serializable {
	private String name, phone;
	public Person(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String toString() {
		return "[" + name + "," + phone + "]";
	}
  }
