package com.jepoyestaris.csvtocrud.service;

import com.jepoyestaris.csvtocrud.model.AccredBreederFarmCsvPojo;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface AccreditedBreederFarmsService {
    List<AccredBreederFarmCsvPojo> getFarms(File file) throws IOException;
}
