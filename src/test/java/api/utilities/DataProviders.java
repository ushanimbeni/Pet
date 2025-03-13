package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")
	public static String[][] getallData()
	{
			return new String[][]{
				{"101","Johnd","John","Deer","john.deer@me.com","John123","1408678903"},
				{"102","MikeW","Mike","Water","mike.water@me.com","mike123","6087899098"}
			};
	}
	
	@DataProvider(name = "UserName")
	public static String[] getUserNames()
	{
			return new String[] {"Johnd","MikeW"};
	}
}
