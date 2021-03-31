package privblock.gerald.ryan.entity;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import privblock.gerald.ryan.entity.Block;


/**
 * 
 * @author Gerald Ryan Blockchain class of blockchain app.
 *
 *
 *
 */

public class Blockchain {
	ArrayList<Block> chain = new ArrayList<Block>();

	/**
	 * Constructor function, initializes an array list and adds a genesis block
	 */
	Blockchain() {
		this.chain.add(Block.genesis_block());
	}

	public void add_block(String[] data) throws NoSuchAlgorithmException {
		Block new_block = Block.mine_block(this.chain.get(this.chain.size() - 1), data);
		this.chain.add(new_block);
	}

	/**
	 * Replace the local chain with the incoming chain if the following apply: - the
	 * incoming chain is longer than the local one - the incoming chain is formatted
	 * properly
	 * 
	 * @param chain
	 * @throws NoSuchAlgorithmException 
	 */
	public void replace_chain(Blockchain other_blockchain) throws NoSuchAlgorithmException {
		if (other_blockchain.chain.size() <= this.chain.size()) {
			System.out.println("Cannot replace chain. The incoming chain must be longer");
			return;
		} 
		else if (!Blockchain.is_valid_chain(other_blockchain)) {
			System.out.println("Cannot replace chain. The incoming chain is invalid");
			return;
		}
		
		this.chain = other_blockchain.chain;
//		else {
//			try {
//				Blockchain.is_valid_chain(other_blockchain);
//			} catch (Exception e) {
//				throw new // exception
//				// block of code to handle errors
//			}
//		}
	}

	/**
	 * Validate the incoming chain. Enforce the following rules: - the chain must
	 * start with the genesis block - blocks must be formatted correctly
	 * 
	 * @param blockchain
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean is_valid_chain(Blockchain blockchain) throws NoSuchAlgorithmException {
		if (blockchain.chain.get(0) != Block.genesis_block()) {
			System.out.println("The genesis block must be valid");
			return false;
			// throw exception: the genesis block must be valid
		}
		for (int i = 1; i < blockchain.chain.size(); i++) {
			Block current_block = blockchain.chain.get(i);
			Block last_block = blockchain.chain.get(i - 1);
			if (!Block.is_valid_block(last_block, current_block)) {
				System.out.println("At least one of the blocks in the chain is not valid");
				return false;
				// throw exception at least one of the blocks in the chain is not valid
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Blockchain: " + this.chain;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Blockchain blockchain = new Blockchain();
//		System.out.println(blockchain);
		blockchain.add_block(new String[] {"Shakespeare", "wrote", "it"});
		System.out.println(blockchain);
	}

}
