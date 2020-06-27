package com.jepoyestaris.csvtocrud.accredbreederfarms.service;

import com.jepoyestaris.csvtocrud.service.AccreditedBreederFarmsService;
import com.jepoyestaris.csvtocrud.service.impl.AccreditedBreederFarmsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.ResourceUtils;

@ExtendWith(SpringExtension.class)
public class GetAccreditedFarmsImplTest {
    @TestConfiguration
    static class ServiceBeanCreationConfiguration {
        @Bean
        public AccreditedBreederFarmsService generateService() {
            return new AccreditedBreederFarmsServiceImpl();
        }
    }

    @Autowired
    private AccreditedBreederFarmsService accreditedBreederFarmsService;

    @Test
    public void csvToPojosReturnsValid() throws Exception {
        Assertions.assertEquals(
            "Gamefowl Breeder",
            accreditedBreederFarmsService
                .getFarms(ResourceUtils.getFile("classpath:Bureau_of_Animal_Industry_Accredited_Breeder_Farms.csv"))
                .get(0).getAccreditation());
    }
}
