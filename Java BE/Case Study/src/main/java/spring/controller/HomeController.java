package spring.controller;

//select instance_name,b.id,hash,data from blockchain c inner join blocksbychain bc on c.id=bc.blockchain_id inner join block b on bc.chain_id=b.id;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pubnub.api.PubNubException;

import exceptions.BlocksInChainInvalidException;
import exceptions.ChainTooShortException;
import exceptions.GenesisBlockInvalidException;
import privblock.gerald.ryan.entity.Block;
import privblock.gerald.ryan.entity.BlockData;
import privblock.gerald.ryan.entity.Blockchain;
import privblock.gerald.ryan.entity.Message;
//import org.springframework.web.bind.annotation.RequestMapping;
import privblock.gerald.ryan.entity.User;
import privblock.gerald.ryan.initializors.SyncToNetwork;
import privblock.gerald.ryan.service.BlockService;
import privblock.gerald.ryan.service.BlockchainService;
import privblock.gerald.ryan.utilities.StringUtils;
import pubsub.PubNubApp;

//@RequestMapping("/admin")
@Controller
@SessionAttributes("blockchain")
public class HomeController {

	BlockService blockApp = new BlockService();
	BlockchainService blockchainApp = new BlockchainService();
	PubNubApp pnapp;

	/*
	 * This constructor runs when Spring launches this controller? It seems to
	 * becuse pnapp doesn't return null anymore.
	 */
	public HomeController() throws InterruptedException {
		pnapp = new PubNubApp(); // moved to @modelAttribute new blockchain
	}
//	@RequestMapping("/")
//	public ModelAndView welcome() {
//		ModelAndView mav = new ModelAndView("index");
//		return mav;
//	}

//	@RequestMapping(value="/process", method=RequestMethod.POST)
//	public ModelAndView processSomething() {
//		return new ModelAndView("index");
//	}

	@ModelAttribute("afb")
	public String addFooBar() {
		return "FooAndBar";
	}

	/*
	 * Similar to method in other class but this peer instance will not pull from
	 * the database. It is presumed to not have access. It would have its own but
	 * that implies a separate db not a common shared db. Therefore it gets a report
	 * of current blockchain from peer node (GET request). In practice, it would
	 * also pull from its own database but we won't make two databases. Instead we
	 * will initialize a single genesis block based coin and then run a GET request
	 * to http://localhost:8080/CaseStudy/blockchain and replace our singleton chain
	 * with their chain as proof of concept Database will not be touched so we don't
	 * use services here.
	 */
	@ModelAttribute("blockchain")
	public Blockchain addBlockchain() throws NoSuchAlgorithmException, InterruptedException {
		/*
		 * This is not going through service. No database will be accessed on peer
		 * instance. In reality it would have its own
		 */
		Blockchain blockchain = Blockchain.createBlockchainInstance("beancoin");
		
		// This is where the magic happens
		try {
			ArrayList<Block> chain = SyncToNetwork.getNetworkChain("http://localhost:8080/CaseStudy/blockchain");
			// This should work and replace chain according to our setup

			System.out.println(chain.get(0).toJSONtheBlock());
			System.out.println(blockchain.getChain().get(0).toJSONtheBlock());
			blockchain.replace_chain(chain);
			System.out.println("WE ARE REPLACING CHAIN AND UPDATING OUR PEER INSTANCE OF BLOCKCHAIN");
			return blockchain;
		} catch (IllegalStateException e) {
			return blockchain;
		} catch (NullPointerException e) {
			System.err.println("NULL POINTER EXCEPTION THROWN.");
			System.err.println(
					"But no worries. That just means our central node is not up and serving (incommunicado) (or less likely it or our processing of its data just failed for some reason) so our GET request didn't return anything");
			System.err.println(
					"We'll just keep using our own local version of the chain knowing its probably too short. We'll also keep broadcasting blocks to the network");
			return blockchain;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return blockchain;
		} catch (ChainTooShortException e) {
			System.err.println("Chain too short exception");
			return blockchain;
		} catch (GenesisBlockInvalidException e) {
			System.err.println("Genesis Block invalid exception");
			return blockchain;
		} catch (BlocksInChainInvalidException e) {
			System.err.println("Blocks In Chain Invalid Exception");
			return blockchain;
		}

	}

//	@ModelAttribute("pubnubapp")
//	public PubNubApp addPubNub() throws InterruptedException {
//		return new PubNubApp();
//	}

	@GetMapping("/")
	public String showIndex() {
		return "index";
	}

	@GetMapping("/blockchain")
	public String serveBlockchain(Model model) {
		return "blockchain";
	}

	@GetMapping("/blockchaindesc")
	public String serveBlockchaindesc(Model model) throws NoSuchAlgorithmException {
		model.addAttribute("blockdata", new BlockData());
		return "blockchaindesc";
	}

	@PostMapping("/blockchaindesc")
	public String save(@ModelAttribute("blockdata") BlockData blockData) {
		System.out.println(blockData.getBlockdata());
		return "redirect:/blockchain/mine";
	}

	@GetMapping("/blockchain/mine")
	public String getMine(@ModelAttribute("blockchain") Blockchain blockchain, Model model)
			throws NoSuchAlgorithmException, PubNubException {
		String stubbedData = "PEER INSTANCE DATA!!";
		Block new_block = blockchain.add_block(stubbedData);
		model.addAttribute("foo", "Bar");

		// Even though this is an "in memory, synced" peer instance with no dev
		// database, it still mines and broadcasts blocks
		// and can still influence and change other nodes.
		pnapp.broadcastBlock(new_block);
		return "mine";
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String processInput(@RequestParam("name") String name, @RequestParam("email") String email) {

		System.out.println(name);
		System.out.println(email);
		return "index";
	}

	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user) {
		System.out.println(user.toString());
		return "index";
	}

	@GetMapping("/data")
	public String getData(Model model) {
		model.addAttribute("blockdata", new BlockData());
		return "data";
	}

	@PostMapping("/data")
	public String processData(@ModelAttribute("blockdata") BlockData blockdata) {
		System.out.println(blockdata.getBlockdata());
		return "data";
	}

	@GetMapping("/publish")
	public String getPublish(Model model) {
		model.addAttribute("message", new Message());
		return "publish";
	}

//	String messages;

	@PostMapping("/publish")
	public String getPublish(@ModelAttribute("message") Message message, Model model)
			throws InterruptedException, PubNubException {

		System.out.println("Publish post mapping ran");
//		messages += message.getMessage() + "\n";
		pnapp.publish(message.getChannel(), message.getMessage());
		model.addAttribute("display", message.getMessage());
//		model.addAttribute("display", messages);
		return "publish";
	}

	@GetMapping("/subscribe")
	public String getSubscribe() {
		return "subscribe";
	}

	@PostMapping("/subscribe")
	public String subToChannel(@RequestParam("channel") String channel) throws InterruptedException, PubNubException {
		pnapp.subscribe(channel);
		System.out.println("Publish post mapping ran");
//		messages += message.getMessage() + "\n";

//		model.addAttribute("display", messages);
		return "subscribe";
	}

}