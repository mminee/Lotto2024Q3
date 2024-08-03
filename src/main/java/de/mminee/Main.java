package de.mminee;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        String excelFilePath = "lotto.xls";

        LottoNumberLoader loader = new LottoNumberLoader(excelFilePath);
        LottoNumberGenerator generator = new LottoNumberGenerator();
        ErrorRateCalculator calculator = new ErrorRateCalculator();

        try {
            List<Set<Integer>> lastLottoNumbers = loader.loadLottoNumbers();
            System.out.println("Started");
                        //System.out.println("Last Lotto Numbers " + lastLottoNumbers);

            generator.generateUntilMatch(lastLottoNumbers);

            System.out.println("Finished");

            //Set<Integer> newLottoNumbers = generator.generateLottoNumbers();
            //System.out.println("Generated Lotto Numbers: " + newLottoNumbers);

           // double errorRate = calculator.calculateErrorRate(lastLottoNumbers, newLottoNumbers);
           // System.out.println("Error rate" + (errorRate * 100) + "%");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}