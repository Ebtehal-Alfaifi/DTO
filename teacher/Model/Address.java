package com.example.teacher.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private Integer addressId;

    @Column(columnDefinition = "varchar(10) not null")
    private String area;

    @Column(columnDefinition = "varchar(10) not null")
    private String Street;

    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;


    @OneToOne
    @MapsId
    @JsonIgnore  // بمنع من خلالها التكرار
    private Teacher teacher;
}
