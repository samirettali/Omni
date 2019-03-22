import java.util.ArrayList;

public class Trie {

    private ArrayList<Trie> childs;
    private Character c;
    private boolean isWord;

    public Trie(Character c) {
        this.c = c;
    }

    public void addChild(Character c) {
        childs.add(new Trie(c));
    }

    public void addWord(String word) {

    }


}

