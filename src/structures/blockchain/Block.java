package structures.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @author Samir Ettali
 **/
public class Block {
    private Date date;
    private String message;
    private String hash;
    private String previousBlockHash;
    private Block nextBlock;

    public Block(String message, String previousBlockHash) throws NoSuchAlgorithmException {
        this.date = new Date();
        this.message = message;
        this.previousBlockHash = previousBlockHash;
        this.nextBlock = null;
        this.hash = computeHash();
    }

    private String computeHash() throws NoSuchAlgorithmException {
        String data = this.date.toString() + this.message + this.hash + this.previousBlockHash;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedhash);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public String getHash() {
        return this.hash;
    }

    public void setNextBlock(Block nextBlock) {
        this.nextBlock = nextBlock;

    }

    public Block getNextBlock() {
        return this.nextBlock;
    }

    @Override
    public String toString() {
        String s = "Date: " + date.toString() + "\n";
        s += "Message: " + message + "\n";
        s += "Hash: " + hash + "\n";
        s += "Previous hash: " + previousBlockHash;
        return s;
    }

}
