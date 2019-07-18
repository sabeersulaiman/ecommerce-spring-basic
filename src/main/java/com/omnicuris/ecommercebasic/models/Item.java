package com.omnicuris.ecommercebasic.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@EqualsAndHashCode(of = "itemId")
@Entity
@JsonIgnoreProperties(value = {"dateAdded", "dateModified", "deleted"},
        allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class Item {
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
    private boolean deleted = false;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateAdded;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date dateModified;
}
