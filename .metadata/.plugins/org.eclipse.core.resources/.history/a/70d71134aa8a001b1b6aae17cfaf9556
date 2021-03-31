package privblock.gerald.ryan.dao;

import java.util.List;

import privblock.gerald.ryan.entity.Block;
import privblock.gerald.ryan.entity.Blockchain;

public interface BlockchainDaoI {
	public boolean newBlockchain(String name);
	public boolean addBlock(Block block);
	public boolean replaceChain(Blockchain chain);
	public List<Blockchain> getAllBlockchains();
	public Blockchain getBlockchainById(int id);
	public Block getBlockById(int id); 
	public Block getBlockByHash(String hash); // is it a long? TODO Implement // could just overload same method or regard as hex # but nbd
	public Blockchain getBlockchainByName(String name);
	
}
