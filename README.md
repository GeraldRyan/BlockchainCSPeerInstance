# BlockchainCSPeerInstance

This is a companion repo to the [Blockchain App](https://github.com/GeraldRyan/blockchain-cs-app).

This is to serve as a (naively implemented) peer instance, that has much of the same code but differs enough in certain respects to warrant a separate repository. 

For instance, in the Home Controller file, it does not call the database used by the main blockchain app (Tomcat Server). It could very well do so but that would defeat the logic. 

It is assumed/presumed a peer instance would have its own databse and I could have made two, but that would be unnecessary for my use case of testing the peer. 

Instead in the home controller, where our blockchain ("beancoin") is initialized, we initialize a new one with simple a genesis block, and then we do a GET request to the http://localhost:8080/CaseStudy/blockchain endpoint, which is presumed to be live. It parses that and grabs the presumed current chain and replaces its singleton chain instance. Again it is presumd it would have its own database. Perhap the chain at port 8080 is 90 blocks long and the one on the peer instance is 75, that it pulls from its data source or database. It is replaced just the same as if it were one with only a genesis block. 

If the server at 8080 is not up and running, exceptions are handled and it simply renders the singleton blockchain as normal (which would be a chain of size 75 in the real world). This is to test, to learn and to understand and is sufficient for our purposes at this stage. Every contingency is handled, and if not, please submit feedback so we can integrate new cases into our model. 

Simply run the server and then you got the peer instance going, with most of the same features, pages, and methods, but reading from the web and mining to memory as opposed to a local data store. Still has (importantly) the capcaity to broadcast mined blocks, so the main node is still listening to reports that are routed through pubnumb (A pub-sub implementation) and the main node is still necessarily responsive to what its peer nodes are doing (importantly importantly importantly). This can still broadcast. It simply stores things in memory not in storage, so it is volatile- that is main difference. 
