package de.mminee;

import java.util.Set;

public class ErrorRateCalculator {

    public double calculateErrorRate(Set<Integer> lastLottoNumbers, Set<Integer> newLottoNumbers) {
        int matches = 0;

        for (int number : newLottoNumbers) {
            if (lastLottoNumbers.contains(number)) {
                matches++;
            }
        }
        return (double) matches / newLottoNumbers.size();
    }
}
