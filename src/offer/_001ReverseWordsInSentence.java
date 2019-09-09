package offer;
/**
 * 001_ReverseWordsInSentence
 */
public class _001ReverseWordsInSentence {
  public String ReverseSentence(String str) {
    if (str == null || str.length() == 0) {
      return "";
    }
    String[] words = str.split(" ");
    if (words.length == 0) {
      return " ";
    }
    StringBuilder sb = new StringBuilder();
    int i;
    for (i = words.length - 1; i > 0; i--) {
      sb.append(words[i] + " ");
    }
    sb.append(words[0]);
    return sb.toString();
  }
  public static void main(String[] args) {
    String str = "student. a am I";
    _001ReverseWordsInSentence solution = new _001ReverseWordsInSentence();
    String strret = solution.ReverseSentence(str);
    System.out.println(strret);
  }
}