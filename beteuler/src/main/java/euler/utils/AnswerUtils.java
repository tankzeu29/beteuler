package euler.utils;

import java.math.BigDecimal;

/**
 * Formatter of the Euler result
 * 
 * @author Tankz
 *
 */
public class AnswerUtils {

  /**
   * Removes the last 2 digits of the euler result
   * 
   * @param answer - euler number
   * @return euler result without the last 2 digits
   */
  public static BigDecimal formatAnswer(BigDecimal answer) {
    String answerAsString = answer.toString();
    String answerTruncated = answerAsString.substring(0, answerAsString.length() - 2);
    BigDecimal result = new BigDecimal(answerTruncated);
    return result;
  }
}
