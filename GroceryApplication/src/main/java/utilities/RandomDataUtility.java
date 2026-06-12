package utilities;

import com.github.javafaker.Faker;

//Faker class is used to test with randam data= 

public class RandomDataUtility {

	Faker fk = new Faker();
	public String generateRandomUsername()
	{
		return fk.name().username();
	}
	public String generateRandomPaswword()
	{
		return fk.internet().password();
	}
	
	public String generateFullName()
	{
		return fk.name().firstName();
	}
	
	public String generateEmailId()
	{
		return fk.internet().emailAddress();
	}
	
	public String generatePhoneNumber()
	{
		return fk.phoneNumber().cellPhone();
	}
}
