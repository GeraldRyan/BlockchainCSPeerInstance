package privblock.gerald.ryan.mains;

import privblock.gerald.ryan.service.BlockchainService;
// drop table blocksbychain; drop table block; drop table blockchain;
public class initializerMain {

	public static void main(String[] args) {
		BlockchainService blockchainApp = new BlockchainService();
		blockchainApp.newBlockchainService("beancoin");
		blockchainApp.addBlockService("beancoin", new String[] { "Dance", "The", "Quickstep" });
		blockchainApp.addBlockService("beancoin", new String[] { "Dance", "The", "Waltz" });
		blockchainApp.addBlockService("beancoin", new String[] { "Dance", "The", "Tango" });
		blockchainApp.addBlockService("beancoin", new String[] { "Dance", "The", "Samba	" });
	}
}
