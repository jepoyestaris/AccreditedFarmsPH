package com.jepoyestaris.csvtocrud.service.impl;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.jepoyestaris.csvtocrud.model.AccredBreederFarmCsvPojo;
import com.jepoyestaris.csvtocrud.service.AccreditedBreederFarmsService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class AccreditedBreederFarmsServiceImpl implements AccreditedBreederFarmsService {
    @Override
    public List<AccredBreederFarmCsvPojo> getFarms(File file) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper
            .typedSchemaFor(AccredBreederFarmCsvPojo.class)
            .withHeader();
        MappingIterator<AccredBreederFarmCsvPojo> mappingIterator = csvMapper
            .readerFor(AccredBreederFarmCsvPojo.class)
            .with(csvSchema)
            .readValues(file);
        return mappingIterator.readAll();
    }
}
