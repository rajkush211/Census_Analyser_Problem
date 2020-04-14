package censusanalyser;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_TYPE = "./src/test/resources/CensusDataTypeWrong.txt";
    private static final String WRONG_CSV_FILE_DELIMITER = "./src/test/resources/CensusDataDelimiterWrong.csv";
    private static final String WRONG_CSV_FILE_HEADER = "./src/test/resources/CensusDataHeaderWrong.csv";

    private static final String INDIA_STATE_CODE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.csv";
    private static final String CODE_WRONG_CSV_FILE_DELIMITER = "./src/test/resources/IndiaStateCodeDelimiterWrong.csv";


    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndianCensusData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.type);
        }
    }

    @Test
    public void givenIndianCensusData_WithWrongFileDelimiter_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_DELIMITER);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_DELIMITER, e.type);
        }
    }

    @Test
    public void givenIndianCensusData_WithWrongFileHeader_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_HEADER);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_HEADER, e.type);
        }
    }

    @Test
    public void givenIndiaStateCodeCSVFile_ShouldReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaStateData(INDIA_STATE_CODE_CSV_FILE_PATH);
            Assert.assertEquals(37, numOfRecords);
        } catch (CensusAnalyserException e) {}
    }

    @Test
    public void givenIndiaStateCodeCSV_WhenWrongPath_ShouldReturnException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaStateData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndianStateCodeCSV_WhenWrongType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaStateData(WRONG_CSV_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.type);
        }
    }

    @Test
    public void givenIndiaStateCodeCSV_WhenWrongDelimiter_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaStateData(CODE_WRONG_CSV_FILE_DELIMITER);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_DELIMITER, e.type);
        }
    }

    @Test
    public void givenIndiaStateCodeCSV_WhenWrongHeader_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaStateData(WRONG_CSV_FILE_HEADER);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_HEADER, e.type);
        }
    }

    @Test
    public void givenIndianCensusData_withRandomStateNames_ShouldReturnInPopulationSortedOrder() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            String populationWiseSortedCensusData = censusAnalyser.getPopulationWiseSortedCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            System.out.println(populationWiseSortedCensusData);
            IndiaCensusCSV[] censusCSV = new Gson().fromJson(populationWiseSortedCensusData, IndiaCensusCSV[].class);
            Assert.assertEquals(199812341, censusCSV[0].population);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndianCensusData_withRandomStateNames_ShouldReturnInDensitySortedOrder() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            String densityWiseSortedCensusData = censusAnalyser.getDensityWiseSortedCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            System.out.println(densityWiseSortedCensusData);
            IndiaCensusCSV[] censusCSV = new Gson().fromJson(densityWiseSortedCensusData, IndiaCensusCSV[].class);
            Assert.assertEquals(1102, censusCSV[0].densityPerSqKm);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }
}