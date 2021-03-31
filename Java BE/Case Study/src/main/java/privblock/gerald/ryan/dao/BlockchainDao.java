package privblock.gerald.ryan.dao;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.Query;

import privblock.gerald.ryan.dbConnection.DBConnection;
import privblock.gerald.ryan.entity.Block;
import privblock.gerald.ryan.entity.Blockchain;

public class BlockchainDao extends DBConnection implements BlockchainDaoI {

	@Override
	public Blockchain newBlockchain(String name) {
		this.connect();
		try {
			Blockchain new_blockchain = new Blockchain(name);
			em.getTransaction().begin();
			em.persist(new_blockchain);
			em.getTransaction().commit();
			this.disconnect();
			System.out.println("New Blockchain added");
			return new_blockchain;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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
	public Blockchain getBlockchainByName(String name) {
		try {
			this.connect();
			Query query = em.createQuery("select b from Blockchain b where b.instance_name = :name");
			query.setParameter("name", name);
			Blockchain blockchain = (Blockchain) query.getSingleResult();
			this.disconnect();
			return blockchain;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addBlock(String name, String[] data) {
		this.connect();
		Query query = em.createQuery("select b from Blockchain b where b.instance_name = :name");
		query.setParameter("name", name);
		Blockchain blockchain = (Blockchain) query.getSingleResult();
		try {
			em.getTransaction().begin();
			Block new_block = blockchain.add_block(data);
			em.persist(new_block);
			em.getTransaction().commit();
			this.disconnect();
			System.out.println("Returning true");
			return true;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Blockchain getTopBlockchain() {
		this.connect();
		Query query = em.createQuery("select b from Blockchain b");
		Blockchain blockchain = (Blockchain) query.setMaxResults(1).getSingleResult();
		return blockchain;
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
		} catch (Exception e) {
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
