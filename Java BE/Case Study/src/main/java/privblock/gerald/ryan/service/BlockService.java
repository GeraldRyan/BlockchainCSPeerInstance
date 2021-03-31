package privblock.gerald.ryan.service;

import java.util.List;

import privblock.gerald.ryan.dao.BlockDao;
import privblock.gerald.ryan.entity.Block;

public class BlockService {
	private BlockDao blockD = new BlockDao();

	public void addBlockService(Block block) {
		blockD.addBlock(block);
	}

	public Block getBlockService(int id) {
		return blockD.getBlock(id);
	}

	public List<Block> getAllBlocksService() {
		return blockD.getAllBlocks();
	}
}
