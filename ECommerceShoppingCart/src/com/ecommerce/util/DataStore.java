package com.ecommerce.util;

import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.repository.OrderRepository;

public class DataStore {

    public static ProductRepository prod_repo = new ProductRepository();

    public static UserRepository user_repo = new UserRepository();

    public static OrderRepository order_repo = new OrderRepository();
}