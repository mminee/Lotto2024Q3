package de.mminee;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberLoader {

    private final String filepath;

    public LottoNumberLoader (String filepath) {

        this.filepath = filepath;
    }

    public List<Set<Integer>> loadLottoNumbers() throws IOException{
        List<Set<Integer>> allLottoNumbers = new ArrayList<>();
        try(FileInputStream fis = new FileInputStream(filepath);
            Workbook workbook = createWorkbook(fis, filepath)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet){
                if (row.getRowNum() == 0) {
                    continue;
                }
                Set<Integer> lottoNumbers = new HashSet<>();
                for (int i = 2; i <= 7; i++){
                    Cell cell = row.getCell(i);
                    if (cell != null && !(cell.getStringCellValue().isEmpty() || cell.getStringCellValue().equals(" "))) {
                        lottoNumbers.add(Integer.parseInt(cell.getStringCellValue().replace(" ", "")));
                    }
                }
                if(lottoNumbers.size() == 6) {
                    allLottoNumbers.add(lottoNumbers);
                }
            }
            return allLottoNumbers;
        }
    }

    private Workbook createWorkbook (FileInputStream fis, String filepath) throws IOException {
        if (filepath.toLowerCase().endsWith("xlsx")){
            return new XSSFWorkbook(fis);
        } else if (filepath.toLowerCase().endsWith("xls")) {
            return new HSSFWorkbook(fis);
        } else {
            throw new IllegalArgumentException("No excel file.");
        }
    }

}
