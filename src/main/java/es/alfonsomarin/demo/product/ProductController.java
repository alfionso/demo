package es.alfonsomarin.demo.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@Api(value = "/product", description = "Product Resource API")
public class ProductController {

    private ProductService productService;


    @ApiOperation(value = "Create a new product", response = ProductEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "The product has been created"),
    })
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ProductEntity create(@RequestBody @Valid ProductEntity product) {
        return productService.save(product);
    }

    @ApiOperation(value = "Find all products", response = ProductEntity.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "Find all products")
    })
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<ProductEntity> getAll() {
        return productService.findAll();
    }

    @ApiOperation(value = "Update an existing product", response = ProductEntity.class)
    @RequestMapping(
            path = "/{productId}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ProductEntity update(@PathVariable Long productId, @RequestBody @Valid ProductEntity product){
        return productService.save(product);
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
