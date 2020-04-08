package censusanalyser;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface IcsvBuilder {
    public <T> Iterator<T> getCSVFileIterator(Reader reader, Class<T> csvClass) throws CSVBuilderException;
    public <T> List<T> getCSVFileList(Reader reader, Class<T> csvClass) throws CSVBuilderException;
}