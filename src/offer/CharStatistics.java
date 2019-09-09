package offer;

public class CharStatistics {
    private int[] occurrence;
    private int index;
    public CharStatistics() {
        index = 0;
        occurrence = new int[256];
        for (int i = 0; i < 256; i++) {
            occurrence[i] = -1;
        }
    }

    public void insert(char c){
        if(occurrence[c] == -1){
            occurrence[c] = index;
        }else if(occurrence[c] >= 0){
            occurrence[c] = -2;
        }
        index++;
    }

    public char firstApperingOnce(){
        char c = '\0';
        int minIndex = Integer.MAX_VALUE;
        for(int i = 0; i < 256; i++){
            if(occurrence[i] >= 0){
                c = (char)i;
                minIndex = Math.min(minIndex,occurrence[i]);
            }
        }
        return c;
    }

    public static void main(String[] args) {
        CharStatistics charStatistics = new CharStatistics();
        charStatistics.insert('a');
        System.out.println(charStatistics.firstApperingOnce());
        charStatistics.insert('s');
        System.out.println(charStatistics.firstApperingOnce());
    }
}
