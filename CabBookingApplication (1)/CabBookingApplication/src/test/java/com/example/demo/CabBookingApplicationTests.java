package com.example.demo;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Cabre;
import com.example.demo.Entity.Driver;
import com.example.demo.ServiceImplementation.CabRegistrationImpl;
import com.example.demo.ServiceImplementation.DriverServiceImpl;



@SpringBootTest
class CabBookingApplicationTests {
	
	@Autowired
	CabRegistrationImpl cabRegistrationImpl;
	@Autowired
	DriverServiceImpl deriverimpl;
	
    @Test
	void contextLoads() {
		
     }
    @Test
    public void DisplayCab() // display
    {
    	assertThat( cabRegistrationImpl.Displayall()).isNotEqualTo(0);
    }
    @Test
    public void DisplayDriver() // display driver
    {
    	assertThat(deriverimpl.showAllDriver()).isNotEqualTo(0);
    }
			
   @Test
   public void Adddriver()
   {
	   Driver d=new Driver();
	   d.setDriverid(1);
	   d.setLicenceNo("magh");
	   d.setRating(4.5F);
	  Cabre c=new Cabre();
	   c.setCabid(1);
	   c.setCartype("swift");
	   c.setPerkmrate(11.0F);
	   d.setCabRegistrration(c);
	   deriverimpl.InsertDriver(d);
	   assertThat(d.getDriverid()).isGreaterThan(0);
	   
	   
   }
   @Test
   public void AddCab()
   {
	   Cabre c=new Cabre();
	   c.setCabid(1);
	   c.setCartype("swift");
	   c.setPerkmrate(11.0F);
	   cabRegistrationImpl.AddCab(c);
	   assertThat(c.getCabid()).isGreaterThan(0);
	 }
   
   @Test
   public void bestDriver()
   {
	   assertThat(deriverimpl.ViewBestDriver()).isNotEqualTo(-1);
   }
   @Test
   public void counttype()
   {
	  assertThat( cabRegistrationImpl.cabOfCountType("swift")).isNotEqualTo(-1);
   }
}
