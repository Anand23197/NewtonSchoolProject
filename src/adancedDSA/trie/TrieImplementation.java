package adancedDSA.trie;

public class TrieImplementation {
    static final int ALPHABET_SIZE = 26;
    static class TrieNode{
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        //isEnd of word is true if the node present in end of workd
        boolean isEndofWord;

        TrieNode(){
            isEndofWord = false;
            for(int i = 0; i<ALPHABET_SIZE; i++){
                children[i] = null;
            }
        }
    }
    static TrieNode root;
    static void insert(String key){
        int lavel;
        int length = key.length();
        int index;

        TrieNode temp = root;
        for(lavel = 0; lavel<length; lavel++){
            index = key.charAt(lavel) - 'a';

            if(temp.children[index] == null){
                temp.children[index] = new TrieNode();

             temp = temp.children[index];
            }
        }
        temp.isEndofWord = true;
    }
    public static void main(String[] args) {
           String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
           String output[] = {"Not present", "present"};
    }
}
