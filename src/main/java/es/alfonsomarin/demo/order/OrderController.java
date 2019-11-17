package es.alfonsomarin.demo.order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@Api(value = "/order", description = "Order Resource API")
public class OrderController {

    private OrderService orderService;


    @ApiOperation(value = "Create a new order", response = OrderEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "The product has been created"),
    })
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderEntity create(@RequestBody @Valid OrderEntity product) {
        return orderService.save(product);
    }

    @ApiOperation(value = "Find all products by dates", response = OrderEntity.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "Find all products")
    })
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
//    public List<OrderEntity> getAllByDates(@RequestParam("from") LocalDate from,
//                                    @RequestParam("to") LocalDate to) {
    public List<OrderEntity> getAllByDates() {
//        return orderService.findAll(from, to);
        return orderService.findAll();
    }


    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
