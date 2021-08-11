package algorithms.strings;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 7/11/21
 * Time: 2:16 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
 */

public class DesignerPDFViewer {

    public static int designerPdfViewer(List<Integer> h, String word) {
        int maxLetterValue = 0;

        for(char c : word.toCharArray()) {
            if(h.get((int)c - 97) > maxLetterValue) {
                maxLetterValue = h.get((int)c - 97);
            }
        }
        return maxLetterValue * word.length();
    }

    @Test
    public void DesignerPDFViewerTest() {
        List<Integer> h = List.of(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        String word = "abc";
        Assert.assertThat(designerPdfViewer(h, word), Is.is(IsEqual.equalTo(9)));
    }
}
