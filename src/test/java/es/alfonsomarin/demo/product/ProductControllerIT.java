package es.alfonsomarin.demo.product;
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

import es.alfonsomarin.demo.JsonUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author alfonso.marin.lopez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ProductControllerIT {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @After
    public void resetDB(){
        productRepository.deleteAll();
    }

    @Test
    public void createProduct_thenOk() throws Exception {
        ProductEntity product = ProductStubFactory.generateProductEntity();
        mockMvc
                .perform(
                        post("/api/product")
                                .contentType(APPLICATION_JSON)
                                .content(JsonUtils.toJson(product)));
        List<ProductEntity> found = productRepository.findAll();
        assertThat(found).extracting(ProductEntity::getName).containsOnly(product.getName());
    }

}
