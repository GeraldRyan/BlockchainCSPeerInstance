package privblock.gerald.ryan.dao;

import java.util.List;

import privblock.gerald.ryan.dbConnection.DBConnection;
import privblock.gerald.ryan.entity.Block;

public class BlockDao extends DBConnection implements BlockDaoI {

	@Override
	public void addBlock(Block block) {
		// Where will the mining happen? It should happen elsewhere. Trust.
		this.connect();
		em.getTransaction().begin();
		em.persist(block);
		em.getTransaction().commit();
		this.disconnect();
	}

	@Override
	public Block getBlock(int id) {
		this.connect();
		Block b = em.find(Block.class, id);
		this.disconnect();
		return b;
	}

	@Override
	public List<Block> getAllBlocks() {
		this.connect();
		List<Block> list_of_blocks = em.createQuery("select b from Block b").getResultList();
		this.disconnect();
		return list_of_blocks;
	}

}
