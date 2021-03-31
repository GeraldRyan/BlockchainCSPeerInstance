package privblock.gerald.ryan.dao;

import java.util.List;

import privblock.gerald.ryan.entity.Block;

public interface BlockDaoI {

	public void addBlock(Block block);

	public Block getBlock(int id); // should really get by hash via query or by timestamp - get block by unique identifier

//	public boolean updateBlock(Block block); // Blocks are immutable. They are not altered. Chains may be altered but not blocks. 
	
//	public void removeBlock(int id); // Valid Blocks are not removed. They may be removed from a chain but not from existence.

	public List<Block> getAllBlocks(); // could be impractical if have 100k blocks but for now good

}
