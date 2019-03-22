package ciphers;

public class SimpleCiphers {

    public static String caesarEncrypt(String plainText, int key) {
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++)
            cipherText += (char) (plainText.charAt(i) + key);
        return cipherText;
    }

    public static String caesarDecrypt(String cipherText, int key) {
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++)
            plainText += (char) (cipherText.charAt(i) - key);
        return plainText;
    }

    // TODO implement
    public static String substitutionEncrypt(String plainText, String key) {
        String cipherText = "";
        return cipherText;
    }

    public static String substitutionDecrypt(String cipherText, String key) {
        String clearText = "";
        return clearText;
    }

    public static String vigenereEncrypt(String plainText, String key) {
        String cipherText = "";
        return cipherText;
    }

    public static String vigenereDecrypt(String cipherText, String key) {
        String clearText = "";
        return clearText;
    }

    public static String vernamEncrypt(String plainText, String key) {
        String cipherText = "";
        return cipherText;
    }

    public static String vernamDecrypt(String cipherText, String key) {
        String clearText = "";
        return clearText;
    }

    public static String otpEncrypt(String plainText, String key) {
        String cipherText = "";
        return cipherText;
    }

    public static String otpDecrypt(String cipherText, String key) {
        String clearText = "";
        return clearText;
    }

    public static String playfairEncrypt(String plainText, String key) {
        String cipherText = "";
        return cipherText;
    }

    public static String playfairDecrypt(String cipherText, String key) {
        String clearText = "";
        return clearText;
    }
}
