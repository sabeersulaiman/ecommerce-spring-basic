package com.omnicuris.ecommercebasic.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of = "itemId", callSuper = false)
@Entity
@JsonIgnoreProperties(value = {"dateAdded", "dateModified", "deleted"},
        allowGetters = true)
public class Item extends AuditModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer itemId;

    @NotBlank
    private String title;

    private String description;

    private String tags;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private BigDecimal cost;
}
