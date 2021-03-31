package tests;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import privblock.gerald.ryan.entity.Block;
import privblock.gerald.ryan.utilities.CryptoHash;

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

	/*
	 * Test each attribute of genesis block against genesis data.
	 */
	@Test
	public void testGenesis_block() {
		Block genesis = Block.genesis_block();
		assertTrue(genesis instanceof Block);
		assertEquals(Block.GENESIS_DATA.get("timestamp"), genesis.getTimestamp());
		assertEquals(Block.GENESIS_DATA.get("last_hash"), genesis.getLastHash());
		assertEquals(Block.GENESIS_DATA.get("hash"), genesis.getHash());
		assertEquals(Block.GENESIS_DATA.get("data"), genesis.getData());
		assertEquals(Block.GENESIS_DATA.get("difficulty"), genesis.getDifficulty());
		assertEquals(Block.GENESIS_DATA.get("nonce"), genesis.getNonce());
//		for (Map.Entry<String, Object> entry : Block.GENESIS_DATA.entrySet()){
//			assertArrayEquals(Block.GENESIS_DATA.get(entry), genesis.);
//		}
	}

	@Test
	public void testMineBlock() throws NoSuchAlgorithmException {
		Block last_block = Block.genesis_block();
		String[] data = { "one", "two", "four" };
		Block test_block = Block.mine_block(last_block, data);
		assertTrue(test_block instanceof Block);
		assertTrue(test_block.getData() == data);
		assertEquals(test_block.getLastHash(), last_block.getHash());
		String proof_of_work_bits = CryptoHash.hex_to_binary(test_block.getHash()).substring(0,
				test_block.getDifficulty());
		String expected_proof_of_work = CryptoHash.n_len_string("0", test_block.getDifficulty());
		assertEquals(proof_of_work_bits, expected_proof_of_work);
	}

}
