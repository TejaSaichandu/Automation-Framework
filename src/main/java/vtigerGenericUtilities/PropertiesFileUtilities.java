package vtigerGenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtilities {
	/**
	 * This method is to read the data from properties file
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public String readDataFromProperties(String data) throws IOException
	{
		FileInputStream fis = new FileInputStream(ConstantUtilities.propertiesFilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(data);
		return value;
	}
}
