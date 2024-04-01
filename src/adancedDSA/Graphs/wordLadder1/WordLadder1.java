package adancedDSA.Graphs.wordLadder1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    String first;
    int times;

    Pair(String first, int times){
        this.first = first;
        this.times = times;
    }
}
public class WordLadder1 {
    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };


        int ans = wordLadderLength(startWord, targetWord, wordList);

        System.out.print(ans);

        System.out.println();
    }

    public static int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        //created hashset so that unique words will store
        HashSet<String> words = new HashSet<>();
        for(int i = 0 ;i<wordList.length;i++){
            words.add(wordList[i]);
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startWord, 1));

        //remove word so that it should not visit again
        words.remove(startWord);

        while(!queue.isEmpty()){
            String word = queue.peek().first;
            int steps = queue.peek().times;
            queue.remove();

            //if first occurence of target word got remove this
            if(word.equals(targetWord)) return steps;

            for(int i = 0;i<word.length();i++){
                for(char ch = 'a';ch <= 'z';ch++){
                    //replace each character in word and chaeck whether it exist in hash set
                    char[] replacedChar = word.toCharArray();
                    replacedChar[i] = ch;

                    String st = new String(replacedChar);
                    //if exist in hash set then remove so that it will not visit again
                    if(words.contains(st)){
                        words.remove(st);
                        queue.add(new Pair(st, steps+1));
                    }
                }
            }

        }

        return 0;
    }
}
