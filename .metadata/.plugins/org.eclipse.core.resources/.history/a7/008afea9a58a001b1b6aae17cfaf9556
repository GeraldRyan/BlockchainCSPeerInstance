package privblock.gerald.ryan.service;

import java.util.List;

import privblock.gerald.ryan.dao.BlockchainDao;
import privblock.gerald.ryan.entity.Blockchain;

public class BlockchainService {
	private BlockchainDao blockchainD = new BlockchainDao();

	public boolean newBlockchainService(Blockchain blockchain) {
		return blockchainD.newBlockchain(blockchain);
	}

	public Blockchain getBlockchainService(int id) {
		return blockchainD.getBlockchainById(id);
	}

	public List<Blockchain> getAllBlockchainsService(){
		return blockchainD.getAllBlockchains();
	}

}
