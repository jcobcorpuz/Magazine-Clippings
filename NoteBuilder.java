import java.util.HashMap;

public class NoteBuilder {
    public static boolean canCreateNote(String note, String[] articles){
        HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();

        for(int i = 0; i < articles.length; i++){
            String article = articles[i];
            for(int j = 0; j < article.length(); j++){
                char currentChar = article.charAt(j);
                char letter = Character.toLowerCase(currentChar);
                if (letter >= 'a' && letter <= 'z') {
                    if (letterCount.containsKey(letter)) {
                        letterCount.put(letter, letterCount.get(letter) + 1);
                    }
                    else{
                        letterCount.put(letter, 1);
                    }
                }
            }
        }

        HashMap<Character, Integer> noteLetterCount = new HashMap<Character, Integer>();
        for (int i = 0; i <  note.length(); i++){
            char currentChar = note.charAt(i);
            char letter = Character.toLowerCase(currentChar);
            if (letter >= 'a' && letter <= 'z') {
                if (noteLetterCount.containsKey(letter)) {
                    noteLetterCount.put(letter, noteLetterCount.get(letter) + 1);
                }
                else{
                    noteLetterCount.put(letter, 1);
                }
            }
        }

        Object[] noteKeys = noteLetterCount.keySet().toArray();
        for (int i = 0; i < noteKeys.length; i++){
            char letterKey = (Character) noteKeys[i];
            int requiredCount = noteLetterCount.get(letterKey);
            int availableCount = 0;
            if (letterCount.containsKey(letterKey)) {
                availableCount = letterCount.get(letterKey);
            }
            if (availableCount < requiredCount) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String note1 = "a";
        String[] articles1 = {"a"};
        System.out.println(canCreateNote(note1, articles1));

        String note2 = "a";
        String[] articles2 = {"ab"};
        System.out.println(canCreateNote(note2, articles2));

        String note3 = "a";
        String[] articles3 = {"a","b"};
        System.out.println(canCreateNote(note3, articles3));

        String note4 = "abc";
        String[] articles4 = {"a", "b", "c"};
        System.out.println(canCreateNote(note4, articles4));

        String note5 = "The bird is red!";
        String[] articles5 = {"I write a lot.", "To and fro.", "Here be deadly dragons!"};
        System.out.println(canCreateNote(note5, articles5));

        String note6 = "a";
        String[] articles6 = {"b"};
        System.out.println(canCreateNote(note6, articles6));

        String note7 = "a";
        String[] articles7 = {"bc"};
        System.out.println(canCreateNote(note7, articles7));

        String note8 = "a";
        String[] articles8 = {"b","c"};
        System.out.println(canCreateNote(note8, articles8));

        String note9 = "abc";
        String[] articles9 = {"a", "b", "d"};
        System.out.println(canCreateNote(note9, articles9));

        String note10 = "The bird is red";
        String[] articles10 = {"I write a lot.", "To and fro."};
        System.out.println(canCreateNote(note10, articles10));
    }
}
