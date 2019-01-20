package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)//instructs to use as test context
@SpringApplicationConfiguration(App.class)//instructs the context to create IN the test context
@WebIntegrationTest
public class ShipwreckControllerWebIntegrationTest {

	@Test
	public void testListAll() throws IOException{
		RestTemplate restTemplate = new TestRestTemplate();
		//^^^ RestTemplate is used to call an API programmatically
		ResponseEntity<String> rsp = restTemplate.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class );
		//endpoint is hard coded, but in practice should be part of configuration and point to test environment

		assertThat( rsp.getStatusCode(), equalTo(HttpStatus.OK) );//fails if we do not get a 200 response

		ObjectMapper objMapper = new ObjectMapper();
		JsonNode rspJson = objMapper.readTree( rsp.getBody() );

		assertThat( rspJson.isMissingNode(), is(false) );
		assertThat( rspJson.toString(), equalTo("[]") );
		//there are none saved at this point, so none expected
	}

}




















