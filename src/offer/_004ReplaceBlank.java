package offer;

public class _004ReplaceBlank {
    public char[] replaceBlank(char[] string, int length) {
        int spaceCount = 0;
        for(char c : string){
            if(c == ' '){
                spaceCount++;
            }
        }
        char[] temp = new char[length + spaceCount * 2];
        int last = temp.length - 1,before = length - 1;
        while (before >= 0){
            if(string[before] == ' '){
                temp[last--] = '0';
                temp[last--] = '2';
                temp[last--] = '%';
            }else{
                temp[last--] = string[before];
            }
            before--;
        }
        string = temp;
        return string;
    }
}
