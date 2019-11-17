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


import java.util.List;

/**
 * The interface Product service.
 */
public interface ProductService {

    /**
     * Get product entity.
     *
     * @param id the id
     * @return the product entity
     */
    ProductEntity get(Long id);

    /**
     * Save product entity.
     *
     * @param product the product
     * @return the product entity
     */
    ProductEntity save(ProductEntity product);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<ProductEntity> findAll();

}
