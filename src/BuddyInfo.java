
public class BuddyInfo {
	
	String name,address,phonenumber,greeting; 
	int age;
	
	
	public BuddyInfo(int age, String name, String address, String phonenumber, String greeting) {
		super();
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.greeting=greeting;
		this.age=age;
	}

	public BuddyInfo(String name, String address, String phonenumber) {
		super();
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.age = -1;
		this.greeting = "";
	}

	/**
	 * Copy constructor.
	 */
	public BuddyInfo(BuddyInfo buddy) {
		this(buddy.getAge(), buddy.getName(), buddy.getAddress(), buddy
				.getPhonenumber(), buddy.getGreeting());
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public String getGreeting() {
		return greeting;
	}

	public boolean isOver18(){
		return (this.getAge() >= 18);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result
				+ ((greeting == null) ? 0 : greeting.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((phonenumber == null) ? 0 : phonenumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuddyInfo other = (BuddyInfo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (greeting == null) {
			if (other.greeting != null)
				return false;
		} else if (!greeting.equals(other.greeting))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phonenumber == null) {
			if (other.phonenumber != null)
				return false;
		} else if (!phonenumber.equals(other.phonenumber))
			return false;
		return true;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public String toString(){
		String info="";
		info= "Name: "+getName()+ " | "+"Address: "+getAddress()+" | " +"Phone Number: "+getPhonenumber();
		return info;
	}
	
}



