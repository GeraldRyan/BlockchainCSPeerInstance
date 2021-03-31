package privblock.gerald.ryan;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date; // gets time in ms.
import privblock.gerald.ryan.util.CryptoHash;

/**
 * 
 * @author Gerald Ryan Block Class of blockchain app
 *
 *         Description: The block hash is the result of the timestamp, the
 *         last_hash, the data, the difficulty and the nonce
 *
 */
public class Block {
	long timestamp;
	String lastHash;
	String hash;
	String[] data;
	int difficulty;
	int nonce;

// Nanosecond basis
//	static long NANOSECONDS = 1;
//	static long MICROSECONDS = 1000 * NANOSECONDS;
//	static long MILLISECONDS = 1000 * MICROSECONDS;
//	static long SECONDS = 1000 * MILLISECONDS;
//	static long MINE_RATE = 4 * SECONDS;
//	static long NANOSECONDS = 1;

// Millisecond basis
	;
	static long MILLISECONDS = 1;
	static long SECONDS = 1000 * MILLISECONDS;
	static long MINE_RATE = 2 * SECONDS;

	/**
	 * A block is a unit of storage for a blockchain that supports a cryptocurrency.
	 * 
	 * @param timestamp
	 * @param lastHash
	 * @param hash
	 * @param data
	 * @param difficulty
	 * @param nonce
	 */
	public Block(long timestamp, String lastHash, String hash, String[] data, int difficulty, int nonce) {
		super();
		this.timestamp = timestamp;
		this.lastHash = lastHash;
		this.hash = hash;
		this.data = data;
		this.difficulty = difficulty;
		this.nonce = nonce;
	}

	public String toString() {
		return "\n-----------BLOCK--------\ntimestamp: " + this.timestamp + "\nlastHash: " + this.lastHash + "\nhash: "
				+ this.hash + "\ndifficulty: " + this.getDifficulty() + "\nNonce: " + this.nonce
				+ "\n-----------------------\n";
	}

	/**
	 * Mine a block based on given last block and data until a block hash is found
	 * that meets the leading 0's Proof of Work requirement.
	 * 
	 * @param last_block
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static Block mine_block(Block last_block, String[] data) throws NoSuchAlgorithmException {
		long timestamp = new Date().getTime();
		String last_hash = last_block.getHash();
		int difficulty = Block.adjust_difficulty(last_block, timestamp);
		int nonce = 0;
		String hash = CryptoHash.getSHA256(timestamp, last_block.getHash(), data, difficulty, nonce);

		String proof_of_work = CryptoHash.n_len_string('0', difficulty);
		String binary_hash = CryptoHash.hex_to_binary(hash);
		String binary_hash_work_end = binary_hash.substring(0, difficulty);
		System.out.println("Difficulty: " + difficulty);
		System.out.println("Working");
		while (!proof_of_work.equalsIgnoreCase(binary_hash_work_end)) {
			nonce += 1;
			timestamp = new Date().getTime();
			difficulty = Block.adjust_difficulty(last_block, timestamp);
			hash = CryptoHash.getSHA256(timestamp, last_block.getHash(), data, difficulty, nonce);
			proof_of_work = CryptoHash.n_len_string('0', difficulty);
			binary_hash = CryptoHash.hex_to_binary(hash);
			binary_hash_work_end = binary_hash.substring(0, difficulty);
		}
		System.out.println("Solved at Difficulty: " + difficulty);
		System.out.println("Proof of work requirement " + proof_of_work);
		System.out.println("binary_Hash_work_end " + binary_hash_work_end);
		System.out.println("binary hash " + binary_hash);
		System.out.println("BLOCK MINED");

		return new Block(timestamp, last_hash, hash, data, difficulty, nonce);
	}

	/**
	 * Generate Genesis block
	 * 
	 * @return
	 */
	public static Block genesis_block() {
		long timestamp = 1;
		String last_hash = "genesis_last_hash";
		String hash = "genesis_hash";
		String[] data = { "buy", "privcoin" };
		int difficulty = 5;
		int nonce = 0;
		return new Block(timestamp, last_hash, hash, data, difficulty, nonce);
	}

	/**
	 * Calculate the adjusted difficulty according to the MINE_RATE. Increase the
	 * difficulty for quickly mined blocks. Decrease the difficulty for slowly mined
	 * blocks.
	 * 
	 * @param last_block
	 * @param new_timestamp
	 */
	public static int adjust_difficulty(Block last_block, long new_timestamp) {
		long time_diff = new_timestamp - last_block.getTimestamp();

//		System.out.println(time_diff);
		if (time_diff < MINE_RATE) {
//			System.out.println("Increasing difficulty");
			return last_block.getDifficulty() + 1;
		} else if (last_block.getDifficulty() - 1 > 0) {
//			System.out.println("Decreasing difficulty");
			return last_block.getDifficulty() - 1;
		} else {
			return 1;
		}
	}

	/**
	 * Validate block by enforcing following rules: - Block must have the proper
	 * last_hash reference - Block must meet the proof of work requirements -
	 * difficulty must only adjust by one - block hash must be a valid combination
	 * of block fields
	 * 
	 * @param last_block
	 * @param block
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean is_valid_block(Block last_block, Block block) throws NoSuchAlgorithmException {
		String binary_hash = CryptoHash.hex_to_binary(block.getHash());
		char[] pow_array = CryptoHash.n_len_array('0', block.getDifficulty());
		char[] binary_char_array = CryptoHash.string_to_charray(binary_hash);
		if (!block.getLastHash().equalsIgnoreCase(last_block.getHash())) {
			System.out.println("The last hash must be correct");
			return false;
			// Throw exception the last hash must be correct
		}
		if (!Arrays.equals(pow_array, Arrays.copyOfRange(binary_char_array, 0, block.getDifficulty()))) {
			System.out.println("Proof of work requirement not met");
			return false;
			// throw exception - proof of work requirement not met
		}
		if (Math.abs(last_block.difficulty - block.difficulty) > 1) {
			System.out.println("Block difficulty must adjust by one");
			return false;
			// throw exception: The block difficulty must only adjust by 1
		}
		String reconstructed_hash = CryptoHash.getSHA256(block.getTimestamp(), block.getLastHash(), block.getData(),
				block.getDifficulty(), block.getNonce());
		if (!block.getHash().equalsIgnoreCase(reconstructed_hash)) {
			System.out.println("The block hash must be correct");
			System.out.println(block.getHash());

			System.out.println(reconstructed_hash);
			return false;
			// throw exception: the block hash must be correct
		}
		System.out.println("You have mined a valid block");
		return true;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getHash() {
		return hash;
	}

	public String getLastHash() {
		return lastHash;
	}

	public String[] getData() {
		return data;
	}

	public int getNonce() {
		return nonce;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
//		String md = CryptoHash.getSHA256("foobar");
		Block genesis = genesis_block();
		System.out.println(genesis.toString());
//		Block bad_block = Block.mine_block(genesis, new String[] { "watch", "AOT" });
//		bad_block.lastHash = "evil data";
//		System.out.println(bad_block.toString());
		Block good_block = mine_block(genesis, new String[] { "foo", "bar" });
		System.out.println(good_block.toString());
//		System.out.println(mine_block(new_block, new String[] { "crypto", "is", "fun" }).toString());
//		System.out.println(Block.is_valid_block(genesis, bad_block)); // returns false as expected
		System.out.println(Block.is_valid_block(genesis, good_block));
		System.out.println(CryptoHash.hex_to_binary(good_block.getHash()));
		Block good_block2 = mine_block(good_block, new String[] { "bar", "foo" });
		Block good_block3 = mine_block(good_block2, new String[] { "bar", "foo" });
		Block good_block4 = mine_block(good_block3, new String[] { "bar", "foo" });
//		Block good_block5 = mine_block(good_block4, new String[] {"bar", "foo"});
//		Block good_block6 = mine_block(good_block5, new String[] {"bar", "foo"});
	}

}
