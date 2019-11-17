package es.alfonsomarin.demo.order;
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

import es.alfonsomarin.demo.product.ProductEntity;
import es.alfonsomarin.demo.product.ProductRepository;
import es.alfonsomarin.demo.product.ProductStubFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author alfonso.marin.lopez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class OrderControllerIT {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    private ProductEntity product = ProductStubFactory.generateProductEntity();

    @Before
    public void init(){
        productRepository.save(product);
    }

    @After
    public void resetDB(){
        orderRepository.deleteAll();
    }

    @Test
    public void createOrder_thenOk() throws Exception {
        OrderEntity order = OrderStubFactory.generateOrderEntity();
        OrderLineEntity line = OrderStubFactory.generateOrderLine();
        line.setProduct(product);
        order.getLines().add(line);
        orderRepository.save(order);
        mockMvc
                .perform( get("/api/order").contentType(APPLICATION_JSON))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(APPLICATION_JSON));

    }
}
