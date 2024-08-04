package de.mminee;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoNumberGenerator {

    private static final int TOTAL_NUMBERS = 6;
    private static final int NUMBER_RANGE = 49;

    public Set<Integer> generateLottoNumbers() {

        Random random = new Random();
        Set<Integer> newRandomLottoNumbers = new HashSet<>();

        while (newRandomLottoNumbers.size() < TOTAL_NUMBERS) {
            int number = random.nextInt(NUMBER_RANGE) + 1;
            if (!newRandomLottoNumbers.contains(number)) {
                newRandomLottoNumbers.add(number);
            }
        }
        return newRandomLottoNumbers;
    }

    public void generateUntilMatch(List<Set<Integer>> oldLottoNumberList) {

        boolean needsRestart = true;

        while (needsRestart) {
            needsRestart = false;

            // hand over all the list with readed numbers
            for (Set<Integer> oldLottoNumbers : oldLottoNumberList) {
                Set<Integer> generatedNumbers = generateLottoNumbers();
                int whiler = 0;
                // loop so long until old and generated lotto numbers are the same
                while (!oldLottoNumbers.equals(generatedNumbers)) {
                    generatedNumbers = generateLottoNumbers();
                    whiler++;
                }
                System.out.println(oldLottoNumbers + "---" + generatedNumbers + " || " + whiler);

                // restart whole method
                if (whiler != 0) {
                    needsRestart = true;
                    break;
                }
                System.out.println("WIN" + oldLottoNumbers + "---" + generatedNumbers + " || " + whiler);

                Set<Integer> predicteddNumbers = generateLottoNumbers();
                System.out.println("Will see " + predicteddNumbers);

            }
        }
    }
}
