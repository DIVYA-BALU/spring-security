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
public class Orders {
    @Id
    private String _id;
    private String product;
    private float price;
    private String customerEmail;
}
