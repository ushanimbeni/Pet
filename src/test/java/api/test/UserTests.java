package api.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import com.github.javafaker.Faker;
import api.endpoints.Routes;
import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	User payload;
	Faker faker;

	@BeforeTest
	public void setup()
	{
		payload = new User();
		faker =new Faker();
		
		payload.setId(faker.idNumber().hashCode());
		payload.setUserName(faker.name().username());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPwd(faker.internet().password(5,10));
		payload.setPhone(faker.phoneNumber().cellPhone());
		payload.setUserStatus(0);

	
	}
	
	@Test(priority = 1)
	public void testPostUser()
	{
		Response response = UserEndpoints.CreateUser(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void testGetUser()
	{
		System.out.println(Routes.get_url);
		System.out.println(this.payload.getUserName().toString());
		
		Response response = UserEndpoints.GetUser(this.payload.getUserName()); 
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void testUpdatetUser()
	{
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndpoints.UpdateeUser(this.payload.getUserName(),payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response responseAfterUpdate = UserEndpoints.GetUser(this.payload.getUserName()); 
		responseAfterUpdate.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		
	}
	
	
	@Test(priority = 4)
	public void testDeleteUser()
	{
		Response response = UserEndpoints.DeleteUser(this.payload.getUserName());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
