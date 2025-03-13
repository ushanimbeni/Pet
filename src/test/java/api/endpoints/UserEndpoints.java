package api.endpoints;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payload.User;



public class UserEndpoints {

	//implementation of CRUD -> Create,Read,Update,Delete
	
	public static Response CreateUser(User payload) { 
		try {
			return	given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
				.when()
					.post(Routes.post_url);	
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}		
				
	}
	
	public static Response GetUser(String userName) { 
		try {
			return	given()
					.pathParam("username", userName)
				.when()
					.get(Routes.get_url);	
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}		
				
	}
	
	public static Response UpdateeUser(String UserName,User payload) { 
		try {
			return	given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("username", UserName)
					.body(payload)
				.when()
					.put(Routes.update_url);	
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}		
				
	}
	
	public static Response DeleteUser(String userName) { 
		try {
			return	given()
					.pathParam("username", userName)
				.when()
					.delete(Routes.delete_url);	
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}		
				
	}
	
	
}
