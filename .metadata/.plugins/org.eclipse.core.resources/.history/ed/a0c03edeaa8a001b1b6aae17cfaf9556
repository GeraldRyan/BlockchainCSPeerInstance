package privblock.gerald.ryan.service;

import java.util.List;

import privblock.gerald.ryan.dao.BlockchainDao;
import privblock.gerald.ryan.entity.Blockchain;

public class BlockchainService {
	private BlockchainDao blockchainD = new BlockchainDao();

	public boolean newBlockchainService(String name) {
		return blockchainD.newBlockchain(name);
	}

	public Blockchain getBlockchainService(String name) {
		return blockchainD.getBlockchainByName(name);
	}

	public List<Blockchain> getAllBlockchainsService(){
		return blockchainD.getAllBlockchains();
	}

}
