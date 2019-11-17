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

package es.alfonsomarin.demo.core;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * To know if swagger is working, access to http://localhost/swagger-ui.html
 *
 * @author alfonso.marin.lopez
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigurer {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("es.alfonsomarin.demo"))
                .build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/api/*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Demo REST API")
                .description("Demo API reference for developers")
                .termsOfServiceUrl("http://alfonsomarin.es")
                .contact("info@alfonsomarin.es").license("Demo License")
                .licenseUrl("info@alfonsomarin.es").version("1.0").build();
    }
}
