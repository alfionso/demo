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

package es.alfonsomarin.demo.order;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * The type Order entity.
 */
@Entity
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    @NotNull
    private String buyerMail;

    @Column
    @NotNull
    private LocalDate orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLineEntity> lines = new ArrayList<>();

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
     * Gets buyer mail.
     *
     * @return the buyer mail
     */
    public String getBuyerMail() {
        return buyerMail;
    }

    /**
     * Sets buyer mail.
     *
     * @param buyerMail the buyer mail
     */
    public void setBuyerMail(String buyerMail) {
        this.buyerMail = buyerMail;
    }

    /**
     * Gets order date.
     *
     * @return the order date
     */
    public LocalDate getOrderDate() {
        return orderDate;
    }

    /**
     * Sets order date.
     *
     * @param orderDate the order date
     */
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderLineEntity> getLines() {
        return lines;
    }

    public void setLines(List<OrderLineEntity> lines) {
        this.lines = lines;
    }

    /**
     * Id order entity.
     *
     * @param id the id
     * @return the order entity
     */
    public OrderEntity id(Long id){
        this.id = id;
        return this;
    }

    /**
     * Buyer mail order entity.
     *
     * @param buyerMail the buyer mail
     * @return the order entity
     */
    public OrderEntity buyerMail(String buyerMail){
        this.buyerMail = buyerMail;
        return this;
    }

    /**
     * Order date order entity.
     *
     * @param orderDate the order date
     * @return the order entity
     */
    public OrderEntity orderDate(LocalDate orderDate){
        this.orderDate = orderDate;
        return this;
    }

    public OrderEntity lines(List<OrderLineEntity> lines){
        this.lines = lines;
        return this;
    }

    public BigDecimal getTotalPrice(){
        return lines.stream().map(OrderLineEntity::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderEntity)) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(buyerMail, that.buyerMail) &&
                Objects.equals(orderDate, that.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buyerMail, orderDate);
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", buyerMail='" + buyerMail + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}
