package person;

import java.io.Serializable;

public class Person implements Serializable {
	private String name;
	private String lastname;
	private String gender;
	private Integer age;
	private String tel;
	private String username;
	private String password;
	public Person(String name, String lastname, String gender, int age, String tel, String username, String password) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.age = age;
		this.tel = tel;
		this.username = username;
		this.password = password;
	}
	
	public Person() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastname=" + lastname + ", gender=" + gender + ", age=" + age + ", tel="
				+ tel + ", username=" + username + ", password=" + password + "]";
	}
}
