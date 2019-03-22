package structures.blockchain;

import java.security.NoSuchAlgorithmException;

/**
 * @author Samir Ettali
 **/
public class BlockChain {
    private Block genesis;
    private Block lastBlock;

    public BlockChain() throws NoSuchAlgorithmException {
        this.genesis = new Block("This is the genesis block", "0000000000000000000000000000000000000000000000000000000000000000");
        this.lastBlock = genesis;
    }

    public void addMessage(String message) throws NoSuchAlgorithmException {
        Block block = new Block(message, lastBlock.getHash());
        this.lastBlock.setNextBlock(block);
        lastBlock = lastBlock.getNextBlock();
    }

    @Override
    public String toString() {
        String s = "";
        Block block = genesis;
        while (block != null) {
            s += block + "\n\n";
            block = block.getNextBlock();
        }
        return s;
    }
}
