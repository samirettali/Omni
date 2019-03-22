package ciphers;

import java.util.HashMap;

/**
 * Created by Sam on 27/02/2017.
 */
public class Flinch {

	private char[][] map;
	private String message;

	public Flinch() {
		map = new char[][]{{'a', 'b', 'c', 'd', 'e'}, {'f', 'g', 'h', 'i', 'j'}, {'l', 'm', 'n', 'o', 'p'}, {'q', 'r', 's', 't', 'u'}, {'v', 'w', 'x', 'y', 'z'}};
	}

	private String getIndex(char x) {

		String index = "";

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == x)
					index = (i + 1) + "" + (j + 1);
			}
		}

		return index;
	}

	public String crypt() {

		assert message != null;

		String cryptedMessage = "";
		int size = message.length();
		for (int i = 0; i < size; i++)
			cryptedMessage += getIndex(message.charAt(i));

		return cryptedMessage;
	}

	public String decrypt(String cryptedMessage) {

		String clearMessage = "";

		if (cryptedMessage.length() % 2 == 1)
			clearMessage = "Error: the length of the crypted message should be a multiple of 2";
		else {
			for (int k = 0; k < cryptedMessage.length(); k += 2) {
				int i = Integer.parseInt(Character.toString(cryptedMessage.charAt(k))) - 1;
				int j = Integer.parseInt(Character.toString(cryptedMessage.charAt(k + 1))) - 1;
				clearMessage += map[i][j];
			}
		}

		return clearMessage;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void printMap() {
		System.out.println("\t1\t2\t3\t4\t5");
		System.out.println("1\ta\tb\tc\td\te");
		System.out.println("2\tf\tg\th\ti\tj");
		System.out.println("3\tl\tm\tn\to\tp");
		System.out.println("4\tq\tr\ts\tt\tu");
		System.out.println("5\tv\tw\tx\ty\tz");

	}
}
