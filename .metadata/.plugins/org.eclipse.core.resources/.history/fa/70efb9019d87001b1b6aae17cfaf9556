package privblock.gerald.ryan.dao;

import java.util.List;

import privblock.gerald.ryan.entity.Block;

public interface BlockDaoI {

	public void addBlock(Block block);
	// may need to be here or elsewhere addBlock(data, previous block). Not 100 percent yet how this will look. I think this end can just be this.

	public Block getBlock(int id);

//	public boolean updateBlock(Block block); // I'm not sure this this one is permitted--- perhaps the metadata of the block but not block itself 
	public void removeBlock(int id); // id or hash? Id of database? Longest chain can be replaced.

	public List<Block> getAllBlocks();

}
