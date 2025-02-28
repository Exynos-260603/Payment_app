package application;

	import java.util.List;
	public class UserDetails {
		
		private int userId ;
		private String userName;
		private String password;
		private String firstName;
		private String lastName;
		private String phoneNumber;
		private String email;
		private String address;
		private List<BankAccount> bankAccounts;
		
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
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
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public List<BankAccount> getBankAccounts() {
			return bankAccounts;
		}
		public void setBankAccounts(List<BankAccount> bankAccounts) {
			this.bankAccounts = bankAccounts;
		}
	}


