package webshop.order;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import webshop.CustomResponseStatus;
import webshop.Response;

@RestController
public class OrderController {
    private OrderService orderService;
    private OrderValidator orderValidator = new OrderValidator();

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/myorders")
    @ResponseBody
    public CustomResponseStatus getOrderDataForActualUser(Authentication authentication,
                                                          @RequestBody Order orderWithShippingAddressOnly) {
        if (authentication != null) {
            String shippingAddress;
            if (orderWithShippingAddressOnly == null) {
                shippingAddress = "";
            }
            else {
                shippingAddress = orderWithShippingAddressOnly.getShippingAddress();
            }
            if (orderValidator.isEmpty(shippingAddress)) {
                return new CustomResponseStatus(Response.FAILED, "Shipping address cannot be empty.");
            }
            String loggedInUsername = authentication.getName();
            if (orderService.isShippingAddressAlreadyStored(loggedInUsername, shippingAddress)) {
                return new CustomResponseStatus(Response.FAILED, "Shipping address already stored. " +
                        "Please choose from the list below.");
            }
            return orderService.placeOrder(loggedInUsername, shippingAddress);
        }
        else {
            return new CustomResponseStatus(Response.FAILED, "Please log in to order.");
        }
    }

    @PostMapping("/myorders/storedaddresses")
    @ResponseBody
    public CustomResponseStatus sendOrderWithStoredAddress(Authentication authentication,
                                                           @RequestBody Order orderWithShippingAddressOnly) {
        if (authentication != null) {
            String shippingAddress;
            if (orderWithShippingAddressOnly == null) {
                shippingAddress = "";
            }
            else {
                shippingAddress = orderWithShippingAddressOnly.getShippingAddress();
            }
            if (orderValidator.isEmpty(shippingAddress)) {
                return new CustomResponseStatus(Response.FAILED, "Shipping address can not be empty.");
            }
            String loggedInUsername = authentication.getName();
            return orderService.placeOrder(loggedInUsername, shippingAddress);
        }
        else {
            return new CustomResponseStatus(Response.FAILED, "Please log in to order.");
        }
    }
}
