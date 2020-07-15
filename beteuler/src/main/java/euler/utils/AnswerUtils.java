package euler.utils;

import java.math.BigDecimal;

public class AnswerUtils {


  public static BigDecimal formatAnswer(BigDecimal answer) {
    String answerAsString = answer.toString();
    String answerTruncated = answerAsString.substring(0, answerAsString.length() - 2);
    BigDecimal result = new BigDecimal(answerTruncated);
    return result;
  }
}
