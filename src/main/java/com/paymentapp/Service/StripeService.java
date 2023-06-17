package com.paymentapp.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    // Set your Stripe secret key
    private static final String STRIPE_SECRET_KEY = "sk_test_51NGPGWSIGV3GKrpMZQiE4Z5Ao5RH6fKS6qcGIUe2Q7j4796QBJChLu9r3CkTIM5QDNDA3G6VeYggaLW5hRMrzmjr00AaUk7FcX";

    public String createCustomer(String description) throws StripeException {
        // Set the Stripe API key
        Stripe.apiKey = STRIPE_SECRET_KEY;

        // Create a map to hold the customer parameters
        Map<String, Object> params = new HashMap<>();
        params.put("description", description);
        // Add more parameters as needed

        // Create the customer using Stripe API
        Customer customer = Customer.create(params);

        // Return the customer ID or any other relevant information
        return customer.getId();
    }
}

