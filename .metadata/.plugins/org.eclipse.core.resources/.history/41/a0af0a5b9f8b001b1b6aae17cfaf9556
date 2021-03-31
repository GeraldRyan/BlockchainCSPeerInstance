package tests;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import privblock.gerald.ryan.entity.Block;

public class TestBlock {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMine_block() {
//		fail("Not yet implemented");
	}

	@Test
	public void testGenesis_block() {
		Block genesis = Block.genesis_block();
		assertTrue(genesis instanceof Block);
		assertEquals(Block.GENESIS_DATA.get("hash"), genesis.getHash());
//		for (Map.Entry<String, Object> entry : Block.GENESIS_DATA.entrySet()){
//			assertArrayEquals(Block.GENESIS_DATA.get(entry), genesis.);
//		}
	}

}
