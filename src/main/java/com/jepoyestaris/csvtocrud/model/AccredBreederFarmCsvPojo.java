package com.jepoyestaris.csvtocrud.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonPropertyOrder({"Accreditation", "FarmName", "Barangay", "Municipality","Province","ContactPerson","DateEvaluated","ExpiryDate"})
public class AccredBreederFarmCsvPojo {
    @JsonProperty("Accreditation")
    private String accreditation;

    @JsonProperty("FarmName")
    private String farmName;

    @JsonProperty("Barangay")
    private String barangay;

    @JsonProperty("Municipality")
    private String municipality;

    @JsonProperty("Province")
    private String province;

    @JsonProperty("ContactPerson")
    private String contactPerson;

    @JsonProperty("DateEvaluated")
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "MM/dd/yyyy"
    )
    private Date dateEvaluated;

    @JsonProperty("ExpiryDate")
    private String expiryDate;
}
