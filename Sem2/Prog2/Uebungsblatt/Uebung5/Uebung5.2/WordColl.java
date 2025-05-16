
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;
public class WordColl {

        private int wordCounts;
        private Vector<Word> words = new Vector<Word>();

        class Word {
            String s;
            int count;

            Word(String s) {
                this.s = s;
                this.count = 1;
            }
        }

        public WordColl(String[] sentences) {
            words = new Vector<Word>(sentences.length);

            append(sentences);

        }

        public int size() {
            return wordCounts;
        }
        public int count(String s) {
            Word w = included(s);

            if(w != null) {
                return w.count;
            }
            else {
                return 0;
            }
        }
        public void append(String[] sentences) {

            for(String s : sentences) {
                StringTokenizer str = new StringTokenizer(s);
                while(str.hasMoreTokens()) {
                    insert(str.nextToken());
                }
            }

        }
        private void insert(String s) {
            Word w = included(s);
            if(w != null) {
                w.count++;
            }
            else {
                w = new Word(s);
                words.add(w);
            }
            wordCounts++;
        }
        private Word included(String s) {
            for(Word w : words) {
                if(w.s.equals(s)) return w;

            }
            return null;
        }
        public String top() {

            Word topWord = words.elementAt(0);

            if(topWord != null) {
                for(Word w : words) {
                    if(topWord.count < w.count) {
                        topWord = w;
                    }
                }
                return topWord.s;
            }
            return null;

        }
        public String toString() {

            String result = "";
            result += String.format("%-20s | %2s\n", "Word", "count");
            result += "-----------------------------------------\n";
            for(Word w : words) {
                result += String.format("%-20s | %2d\n", w.s, w.count);
            }
            result += "-----------------------------------------\nTotal: " + wordCounts;

            return result;

        }
    }




