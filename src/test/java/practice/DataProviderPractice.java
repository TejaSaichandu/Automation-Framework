package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider = "Phones")
	public void data(String pname, int price)
	{
		System.out.println(pname+"---"+price);
	}
	@DataProvider(name = "Phones")
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0]="Iqoo";
		data[0][1]=15000;
		
		data[1][0]="Redmi";
		data[1][1]=13000;
		
		data[2][0]="Vivo";
		data[2][1]=14000;
		
		return data;
		
	}
}
