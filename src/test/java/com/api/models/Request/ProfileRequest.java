package com.api.models.Request;

public class ProfileRequest {
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	
	public ProfileRequest(String firstName, String lastName, String email, String mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	@Override
	public String toString() {
		return "ProfileRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + "]";
	}

	
	public static class Builder {
		private String firstName;
		private String lastName;
		private String email;
		private String mobileNumber;
		
		public Builder firstName(String firstName) {
			this .firstName=firstName;
			Builder x=this;
			return x;
			
		}
		
		public Builder lastName(String lastName) {
			this .lastName=lastName;
			Builder x=this;
			return x;
			
		}
		
		public Builder email(String email) {
			this .email=email;
			Builder x=this;
			return x;
			
		}
		
		public Builder mobileNumber(String mobileNumber) {
			this .mobileNumber=mobileNumber;
			Builder x=this;
			return x;
			
		}
		
		public ProfileRequest build() {
				ProfileRequest profilerequest = new ProfileRequest(firstName, lastName, email, mobileNumber);
				return profilerequest;
		}
	}
}
	

