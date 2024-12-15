package com.example.teacher.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDto {

    private Integer teacher_Id;


    @NotEmpty(message = "street name can not be null")
    @Size(min = 3, max = 10, message = "street nme should be between 3 and 10 ")
    private String Street;


    @NotEmpty(message = "area can not be null")
    @Size(min = 3, max = 10, message = " area should be between 3 and 10")
    private String area;


@NotNull(message = "building number can not be null ")
@Min(value = 1,message = "building number at least should has 1")
    private Integer buildingNumber;


    public AddressDto() {

    }
}
