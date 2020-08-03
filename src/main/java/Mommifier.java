import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  Mommifier {


    public String mommify(String inputString) {
        List<Character> vowelList = new ArrayList<>();
        vowelList.add('a');
        vowelList.add('e');
        vowelList.add('i');
        vowelList.add('o');
        vowelList.add('u');
        int vowelCount = 0;
        for (int index = 0; index < inputString.length(); ++index) {
            switch (inputString.charAt(index)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    ++vowelCount;
                default:
                    break;
            }
        }
        boolean isLastCharVowel = false;
        List<Integer> continuousVowelIndexArray = new ArrayList<>();
        if ((vowelCount / (float)inputString.length()) > 0.3) {
            for (int charIndex = 0; charIndex < inputString.length(); ++charIndex) {
                if (vowelList.contains(inputString.charAt(charIndex)) && isLastCharVowel) {
                    continuousVowelIndexArray.add(charIndex);
                } else if (vowelList.contains(inputString.charAt(charIndex)) && !isLastCharVowel) {
                    isLastCharVowel = true;
                } else {
                    isLastCharVowel = false;
                }
            }
        }
        StringBuffer inputStringBuffer = new StringBuffer(inputString);
        for (int insertArrayIndex = 0; insertArrayIndex < continuousVowelIndexArray.size(); ++insertArrayIndex) {
            if (insertArrayIndex != 0) {
                inputStringBuffer.insert(continuousVowelIndexArray.get(insertArrayIndex) + (5 * insertArrayIndex),"mommy");
            } else {
                inputStringBuffer.insert(continuousVowelIndexArray.get(insertArrayIndex),"mommy");
            }
        }
        return inputStringBuffer.toString();
    }
}
