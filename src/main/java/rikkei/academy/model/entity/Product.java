package rikkei.academy.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.NumberFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sku;

    private String name;

    private Integer stock;

    private BigDecimal price;

    private String description;

    public String getPriceFormat() {
        return NumberFormat.getCurrencyInstance().format(price);
    }
}
