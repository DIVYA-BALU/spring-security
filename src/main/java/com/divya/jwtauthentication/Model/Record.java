package com.divya.jwtauthentication.Model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Record {
    @Id
    private String _id;
    private String product;
    private int quantity;
    private String supplierEmail;
}
