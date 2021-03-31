package privblock.gerald.ryan.dao;

import java.util.List;

import privblock.gerald.ryan.entity.Block;
import privblock.gerald.ryan.entity.Blockchain;

public interface BlockchainDaoI {
	public Blockchain newBlockchain(String name);
	public boolean addBlock(String name, String[] data);
	public boolean replaceChain(Blockchain chain);
	public List<Blockchain> getAllBlockchains();
	public Blockchain getBlockchainById(int id);
	public Blockchain getTopBlockchain();
	public Block getBlockById(int id); 
	public Block getBlockByHash(String hash); // is it a long? TODO Implement // could overload method if types differ
	public Blockchain getBlockchainByName(String name);
	
}
