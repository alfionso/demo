/*
 * Copyright 2016-2007 Alfonso Marin Lopez.
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

import es.alfonsomarin.demo.product.ProductEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alfonso.marin.lopez
 */
public class OrderStubFactory {

    public static OrderEntity generateOrderEntity(){


        return new OrderEntity()
                .id(1L)
                .buyerMail("alfonso@marin")
                .orderDate(LocalDate.now());
    }


    public static OrderLineEntity generateOrderLine() {
        return new OrderLineEntity()
                .id(1L)
                .price(BigDecimal.valueOf(33L));
    }

}
