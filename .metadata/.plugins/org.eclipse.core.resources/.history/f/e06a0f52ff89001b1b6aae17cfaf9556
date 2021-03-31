package privblock.gerald.ryan.dao;

import java.util.List;

import privblock.gerald.ryan.dbConnection.DBConnection;
import privblock.gerald.ryan.entity.Block;
import privblock.gerald.ryan.entity.Blockchain;

public class BlockchainDao extends DBConnection implements BlockchainDaoI {

	@Override
	public boolean newBlockchain(Blockchain blockchain) {
		this.connect();
		try {
			em.getTransaction().begin();
			em.persist(blockchain);
			em.getTransaction().commit();
			this.disconnect();
			System.out.println("New Blockchain added");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Blockchain getBlockchainById(int id) {
		try {
			this.connect();
			Blockchain b = em.find(Blockchain.class, id);
			this.disconnect();
			return b;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addBlock(Block block) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean replaceChain(Blockchain chain) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Blockchain> getAllBlockchains() {
		try {
			this.connect();
			List<Blockchain> list_of_chains = em.createQuery("select b from Blockchain b").getResultList();
			this.disconnect();
			return list_of_chains;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Block getBlockById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getBlockByHash(String hash) {
		// TODO Auto-generated method stub
		return null;
	}

}
