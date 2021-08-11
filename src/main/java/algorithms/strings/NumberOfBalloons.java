package algorithms.strings;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:09 PM
 * Algorithm URL: https://leetcode.com/problems/maximum-number-of-balloons/
 */

public class NumberOfBalloons {
    public static int maxNumberOfBalloons(String text) {
        int[] charCounts = new int[26];

        for(int i = 0; i < text.length(); i++) {
            charCounts[text.charAt(i) - 'a']++;
        }

        int min = Math.min(charCounts[1], charCounts[0]); // b, a
        min = Math.min(min, charCounts[11] / 2); //l
        min = Math.min(min, charCounts[14] / 2); //o
        min = Math.min(min, charCounts[13]); // n

        return min;
    }


    public static void main(String[] args) {
        String word = "krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw";
        System.out.println(maxNumberOfBalloons(word));
    }
}
