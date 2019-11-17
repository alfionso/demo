/*
 * Copyright 20119 Alfonso Marin Lopez.
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


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * @author alfonso.marin.lopez
 */
@RunWith(SpringRunner.class)
public class DefaultProductServiceTest {

    @TestConfiguration
    static class DefaultProductServiceTestContextConfiguration {

        @Bean
        public ProductService productService() {
            return new DefaultProductService();
        }
    }
    @MockBean
    private ProductRepository mockProductRepository;

    /* private */
    private ProductEntity productEntity = ProductStubFactory.generateProductEntity();

    @Autowired
    private ProductService productService;

    /**
     * Create product and return a product.
     */
    @Test
    public void createProductReturnProduct() {
        when(mockProductRepository.save(ArgumentMatchers.any())).thenReturn(productEntity);
        ProductEntity newProduct = ProductStubFactory.generateProductEntity();
        newProduct.setId(null);
        ProductEntity returnTransaction = productService.save(newProduct);
        Assert.assertNotNull(returnTransaction.getId());
        Assert.assertEquals(productEntity.getName(), returnTransaction.getName());
    }


    
    /**
     * Get All products.
     */
    @Test
    public void getAllProductsOK(){
        List<ProductEntity> productEntityArrayList = new ArrayList<>();

        when(mockProductRepository.findAll()).thenReturn(productEntityArrayList);
        List<ProductEntity> expectedTransactionList = productService.findAll();
        Assert.assertEquals(expectedTransactionList.size(), productEntityArrayList.size());
    }
}
