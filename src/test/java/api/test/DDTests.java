package api.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {

	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostUser(String userID,String uname,String fName,String lName,String email,String pwd,String phone)
	{
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUserName(uname);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
        userPayload.setEmail(email);
        userPayload.setPwd(pwd);
        userPayload.setPhone(phone);
        userPayload.setUserStatus(0);
        
        Response response = UserEndpoints.CreateUser(userPayload);
        response.then().log().all();
        
        Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2, dataProvider="UserName", dataProviderClass=DataProviders.class)
	public void testGetUer(String uName)
	{
		System.out.println(uName);
		Response response = UserEndpoints.GetUser(uName);
		response.then().log().body();
		
       // Assert.assertEquals(response.getStatusCode(), 200);
	
	}
	
	
}
