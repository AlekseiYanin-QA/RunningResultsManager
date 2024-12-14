package org.example;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultsReader {

    private final ResultParser resultParser;

    @Autowired
    public ResultsReader(ResultParser resultParser) {
        this.resultParser = resultParser;
    }

    public List<Result> readFromFile(Path filePath) {
        try {
            return Files.lines(filePath)
                    .map(resultParser::parseResult)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
