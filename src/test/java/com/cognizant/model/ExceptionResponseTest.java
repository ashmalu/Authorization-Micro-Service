package com.cognizant.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.exception.ExceptionResponse;
import java.util.Date;



@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class ExceptionResponseTest {
	
	Date datestamp;

	@Test
	public void gettersetterExceptionResponseTest() {
		ExceptionResponse response = new ExceptionResponse();
		response.setDatestamp(datestamp);
		response.setDetails("details");;
		response.setMessage("message");
	
		assertEquals(datestamp,response.getDatestamp());
		assertEquals("details", response.getDetails());
		assertEquals("message", response.getMessage());
	}
	@Test
	public void constructerExceptionResponseTest() {
		ExceptionResponse responseNoArg = new ExceptionResponse();
		assertNotNull(responseNoArg);
		ExceptionResponse responseAllArg = new ExceptionResponse(datestamp, "details", "message");
		assertNotNull(responseAllArg);
	}

}