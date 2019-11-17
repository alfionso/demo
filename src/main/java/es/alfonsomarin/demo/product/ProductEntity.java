/*
 * Copyright 2019 Alfonso Marin Lopez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 	  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.alfonsomarin.demo.product;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


/**
 * The type Product entity.
 */
@Entity
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private BigDecimal currentPrice;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets current price.
     *
     * @return the current price
     */
    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    /**
     * Sets current price.
     *
     * @param currentPrice the current price
     */
    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * Id product entity.
     *
     * @param id the id
     * @return the product entity
     */
    public ProductEntity id(Long id){
        this.id = id;
        return this;
    }

    /**
     * Name product entity.
     *
     * @param name the name
     * @return the product entity
     */
    public ProductEntity name(String name){
        this.name = name;
        return this;
    }

    /**
     * Current price product entity.
     *
     * @param currentPrice the current price
     * @return the product entity
     */
    public ProductEntity currentPrice(BigDecimal currentPrice){
        this.currentPrice = currentPrice;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(currentPrice, that.currentPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, currentPrice);
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
