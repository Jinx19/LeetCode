package common;

import java.util.Scanner;

public class BioNote {
    public String[] CSVParer(String record){
        String[] split = record.split(",");
        String[] parseRecode = new String[7];
        int colIndex = 0;
        for(int i = 0; i < split.length ; i++){
            String s = split[i];
            if(s == null || s.length() == 0){
                continue;
            }
            int begin = 0,end = s.length() - 1;
            while(s.charAt(begin) == ' '){
                begin++;
            }
            while (s.charAt(end) == ' '){
                end --;
            }
            if(s.charAt(begin) == '"' && s.charAt(end) == '"'){
                if(begin!=0){
                    continue;
                }
                s = s.substring(begin + 1,end);
                s = s.replaceAll("\"{2}","\"");
                parseRecode[colIndex++] = s;
            }else if(s.charAt(begin) == '"' && s.charAt(end) != '"'){
                StringBuffer sb = new StringBuffer();
                sb.append(s.substring(1) + ",");
                i++;
                while (i < split.length && split[i].charAt(split[i].length() - 1) != '"'){
                    sb.append(split[i] + ",");
                    i++;
                }
                sb.append(split[i].substring(0,split[i].length() - 1));
                parseRecode[colIndex++] = sb.toString();
            }else{
                parseRecode[colIndex++] = split[i];
            }
        }
        return parseRecode;
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        BioNote bioNote = new BioNote();
        while(scanner.hasNextLine()){
            String record = scanner.nextLine().toString();
            String[] parseRecord = bioNote.CSVParer(record);
            System.out.println(parseRecord[0] + "," + parseRecord[6] + "years old, is from" + parseRecord[5] + "and is interested in " + parseRecord[3]);
        }
    }
}
