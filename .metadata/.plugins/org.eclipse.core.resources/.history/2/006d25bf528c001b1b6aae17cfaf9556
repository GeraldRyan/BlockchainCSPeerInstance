package tests;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import privblock.gerald.ryan.entity.Block;
import privblock.gerald.ryan.entity.Blockchain;

public class TestBlockchain {

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
	public void testBlockchainInstance() {
		Blockchain blockchain = new Blockchain();
		assertTrue(blockchain instanceof Blockchain);
	}

	@Test
	public void testAddBlock() throws NoSuchAlgorithmException {
		Blockchain blockchain = Blockchain.createBlockchainInstance("test");
		String[] testData = { "foo", "bar" };
		blockchain.add_block(testData);
		assertTrue(blockchain.getChain().get(blockchain.getChain().size() - 1).getData() == testData); // assertEquals
																										// appears to be
																										// deprecated
	}

	@Test
	public void testIsValidChain() throws NoSuchAlgorithmException {
		Blockchain blockchain = Blockchain.createBlockchainInstance("Test");
		for (int i = 0; i < 5; i++) {
			blockchain.add_block(new String[] { "foo", "bar" });
		}
		// Test code implicitly with no exception (WARNING, NOT SURE THIS IS PROPERLY
		// SET UP YET AS TO GIVE US ASSURANCE)
	}

	@Test
	public void testIsValidChainBadGenesis() {

	}

	@Test
	public void testReplaceChain() throws NoSuchAlgorithmException {
		Blockchain blockchain5 = Blockchain.createBlockchainInstance("Test");
		for (int i = 0; i < 5; i++) {
			blockchain5.add_block(new String[] { "foo", "bar" });
		}
		Blockchain blockchain = Blockchain.createBlockchainInstance("veryoriginal");
		assertEquals(1, blockchain.getLength_of_chain());
		blockchain.replace_chain(blockchain5);
		assertEquals(6, blockchain.getLength_of_chain());

	}

}
