package com.omnicuris.ecommercebasic.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.omnicuris.ecommercebasic.models.enums.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
@EqualsAndHashCode(of = "orderId", callSuper = false)
@JsonIgnoreProperties(value = {"orderDate", "status"}, allowGetters = true)
public class Order extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(nullable = false)
    private int quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date orderDate;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String customerAddress;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "itemId")
    private Item orderItem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private BigDecimal totalCost;
}
