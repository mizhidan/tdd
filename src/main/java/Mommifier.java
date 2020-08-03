import java.util.ArrayList;
import java.util.List;

public class  Mommifier {
    List<Character> vowelList = new ArrayList<>();

    public String mommify(String inputString) throws invalidInputException {
        if (inputString == null) {
            throw new invalidInputException();
        }
        initList(vowelList);
        int vowelCount = 0;
        vowelCount = setVowelCount(inputString, vowelCount);
        List<Integer> continuousVowelIndexArray = new ArrayList<>();
        if ((vowelCount / (float)inputString.length()) > 0.3) {
            recordInsertPos(continuousVowelIndexArray, inputString, false);
        }
        StringBuffer inputStringBuffer = new StringBuffer(inputString);
        insertMommy(inputStringBuffer, continuousVowelIndexArray);
        return inputStringBuffer.toString();
    }

    private void insertMommy(StringBuffer inputStringBuffer, List<Integer> continuousVowelIndexArray) {
        for (int insertArrayIndex = 0; insertArrayIndex < continuousVowelIndexArray.size(); ++insertArrayIndex) {
            if (insertArrayIndex != 0) {
                inputStringBuffer.insert(continuousVowelIndexArray.get(insertArrayIndex)
                        + (5 * insertArrayIndex),"mommy");
            } else {
                inputStringBuffer.insert(continuousVowelIndexArray.get(insertArrayIndex),"mommy");
            }
        }
    }

    private void recordInsertPos(List<Integer> continuousVowelIndexArray, String inputString, boolean isLastCharVowel) {
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

    private int setVowelCount(String inputString, int vowelCount) {
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
        return vowelCount;
    }

    private void initList(List<Character> vowelList) {
        vowelList.add('a');
        vowelList.add('e');
        vowelList.add('i');
        vowelList.add('o');
        vowelList.add('u');
    }
}
