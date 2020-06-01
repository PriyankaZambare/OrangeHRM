package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties pro;

  public ReadConfig()
  {
	  File scr=new File("./Configuration\\config.properties");
	 
	  try
	  {
		  FileInputStream fis=new FileInputStream(scr);
		  pro=new Properties();
		  pro.load(fis);
	  }
	  catch(Exception e)
	  {
		  System.out.println("Exception is "+e.getMessage());
	  }
  }
  
  public String getApplicationurl()
  { 
	  String Url=pro.getProperty("baseURL");
	  return Url;
  }
 public String getusername()
 {
	 String username=pro.getProperty("username");
	 return username;
	 
 }
  
 public String getpassword()
 {
	 String password=pro.getProperty("password");
	 return password;
	 
 }
 public String getChromepath()
 {
	 String chromepath=pro.getProperty("chromepath");
	 return chromepath;
 }
 
 public String getfirefoxpath()
 {
	 String firefoxpath=pro.getProperty("firefoxpath");
	 return firefoxpath;
 }
 
 public String getIEpath()
 {
	 String iepath=pro.getProperty("iepath");
	 return iepath;
 }

 
 

}
