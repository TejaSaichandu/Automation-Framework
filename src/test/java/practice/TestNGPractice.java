package practice;

import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(enabled =  false)
	public void createuser() {
		System.out.println("Create");
	}
	@Test
	public void updateuser() {
		System.out.println("Update");
	}
	@Test()
	public void deleteuser() {
		System.out.println("delete");
	}
}
