package com.jepoyestaris.csvtocrud.controller;

import com.jepoyestaris.csvtocrud.model.AccredBreederFarmCsvPojo;
import com.jepoyestaris.csvtocrud.service.AccreditedBreederFarmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.List;

@Controller
public class AccreditedBreederFarmsController {
    @Autowired
    private AccreditedBreederFarmsService accreditedBreederFarmsService;

    @GetMapping()
    public ResponseEntity<?> getAccreditedFarms() {
        ResponseEntity<?> responseEntity;
        try {
            File file = ResourceUtils.getFile("classpath:Bureau_of_Animal_Industry_Accredited_Breeder_Farms.csv");
            List<AccredBreederFarmCsvPojo> accreditedFarms = accreditedBreederFarmsService.getFarms(file);
            responseEntity = new ResponseEntity<>(
                accreditedFarms,
                HttpStatus.OK
            );
        } catch (final Exception exception) {
            exception.printStackTrace();
            responseEntity = new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        return responseEntity;
    }
}
