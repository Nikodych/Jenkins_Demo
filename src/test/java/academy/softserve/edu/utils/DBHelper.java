package academy.softserve.edu.utils;

import static academy.softserve.edu.repos.OrderItemRepo.getValidOrderItem;
import static academy.softserve.edu.repos.OrderRepo.getValidOrder;
import static academy.softserve.edu.repos.ProductRepo.getValidProduct;
import static academy.softserve.edu.repos.UserRepo.getValidUser;

public final class DBHelper {

    private DBHelper() {

    }

    public static final int createValidUserInDB() {

        return DBHandler.createUser(getValidUser());
    }

    public static final int createActiveProductInDB() {

        return DBHandler.createProduct(getValidProduct());
    }

    //  Quantity of Orders must be "<=6"
    public static final int createValidOrderInDB() {

        return DBHandler.createOrder(getValidOrder());
    }

    public static final int createOrderItemInDB() {

        return DBHandler.createOrderItem(getValidOrderItem());
    }
}
