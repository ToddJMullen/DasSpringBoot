package com.boot;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {

	@InjectMocks
	private ShipwreckController shipwreckController;
	@Mock
	private ShipwreckRepository repo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testShipwreckGet(){
//		ShipwreckController sc = new ShipwreckController();//<< replaced with mock above
		Shipwreck mockWreck = new Shipwreck();
		mockWreck.setId(1l);
		when( repo.findOne(1l) ).thenReturn(mockWreck);
		//^^^ setup mock behavior

		Shipwreck foundWreck = shipwreckController.get(1L);
		//^^^^ setup tested call

		verify(repo).findOne(1L);
		//^^^ verify that mock was used (once) in test

//		assertEquals( 1l, foundWreck.getId().longValue() );//og junit assertion
		assertThat( foundWreck.getId(), is(1L) );//hamcrest version is easier to read
		//still run as junit, just improves clarity
	}

}
