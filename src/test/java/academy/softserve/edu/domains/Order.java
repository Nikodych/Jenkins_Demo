package academy.softserve.edu.domains;

import academy.softserve.edu.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private int id;
    private String deliveryDate;
    private int gift;
    private int maxDiscount;
    private String orderDate;
    private String orderName;
    private int orderNumber;
    private String preferableDeliveryDate;
    private double totalPrice;
    private int assignee;
    private int customer;
    private int orderStatusReference;

    private Order() {

    }

    public static FirstIdStep newBuilder() {
        return new Builder();
    }

    public interface FirstIdStep {
        DeliveryDateStep setId(final int id);
    }

    public interface DeliveryDateStep {
        GiftStep setDeliveryDate(final String deliveryDate);
    }

    public interface GiftStep {
        MaxDiscountStep setGift(final int gift);
    }

    public interface MaxDiscountStep {
        OrderDateStep setMaxDiscount(final int maxDiscount);
    }

    public interface OrderDateStep {
        OrderNameStep setOrderDate(final String orderDate);
    }

    public interface OrderNameStep {
        OrderNumberStep setOrderName(final String orderName);
    }

    public interface OrderNumberStep {
        PreferableDeliveryDateStep setOrderNumber(final int orderNumber);
    }

    public interface PreferableDeliveryDateStep {
        TotalPriceStep setPreferableDeliveryDate(final String preferableDeliveryDate);
    }

    public interface TotalPriceStep {
        AssigneeStep setTotalPrice(final double totalPrice);
    }

    public interface AssigneeStep {
        CustomerStep setAssignee(final int assignee);
    }

    public interface CustomerStep {
        OrderStatusReferenceStep setCustomer(final int customer);
    }

    public interface OrderStatusReferenceStep {
        BuildStep setOrderStatusReference(final int orderStatusReference);
    }

    public interface BuildStep {
        Order build();
    }

    private static class Builder implements FirstIdStep, DeliveryDateStep, GiftStep, MaxDiscountStep,
            OrderDateStep, OrderNameStep, OrderNumberStep, PreferableDeliveryDateStep, TotalPriceStep,
            AssigneeStep, CustomerStep, OrderStatusReferenceStep, BuildStep {

        private int id;
        private String deliveryDate;
        private int gift;
        private int maxDiscount;
        private String orderDate;
        private String orderName;
        private int orderNumber;
        private String preferableDeliveryDate;
        private double totalPrice;
        private int assignee;
        private int customer;
        private int orderStatusReference;

        @Override
        public final DeliveryDateStep setId(final int id) {
            this.id = id;
            return this;
        }

        @Override
        public final GiftStep setDeliveryDate(final String deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        @Override
        public final MaxDiscountStep setGift(final int gift) {
            this.gift = gift;
            return this;
        }

        @Override
        public final OrderDateStep setMaxDiscount(final int maxDiscount) {
            this.maxDiscount = maxDiscount;
            return this;
        }

        @Override
        public final OrderNameStep setOrderDate(final String orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        @Override
        public final OrderNumberStep setOrderName(final String orderName) {
            this.orderName = orderName;
            return this;
        }

        @Override
        public final PreferableDeliveryDateStep setOrderNumber(final int orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        @Override
        public final TotalPriceStep setPreferableDeliveryDate(final String preferableDeliveryDate) {
            this.preferableDeliveryDate = preferableDeliveryDate;
            return this;
        }

        @Override
        public final AssigneeStep setTotalPrice(final double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        @Override
        public final CustomerStep setAssignee(final int assignee) {
            this.assignee = assignee;
            return this;
        }

        @Override
        public final OrderStatusReferenceStep setCustomer(final int customer) {
            this.customer = customer;
            return this;
        }

        @Override
        public final BuildStep setOrderStatusReference(final int orderStatusReference) {
            this.orderStatusReference = orderStatusReference;
            return this;
        }

        @Override
        public final Order build() {

            final Order order = new Order();

            order.setId(id);
            order.setDeliveryDate(deliveryDate);
            order.setGift(gift);
            order.setMaxDiscount(maxDiscount);
            order.setOrderDate(orderDate);
            order.setOrderName(orderName);
            order.setOrderNumber(orderNumber);
            order.setPreferableDeliveryDate(preferableDeliveryDate);
            order.setTotalPrice(totalPrice);
            order.setAssignee(assignee);
            order.setCustomer(customer);
            order.setOrderStatusReference(orderStatusReference);

            return order;
        }
    }

    public final String getOrderStatusName() {
        return OrderStatus.getOrderStatusNameByReference(orderStatusReference);
    }

    @Override
    public String toString() {

        return "Order{" +
                "ID=" + id +
                ", DeliveryDate='" + deliveryDate +
                ", Gift=" + gift +
                ", MaxDiscount=" + maxDiscount +
                ", OrderDate='" + orderDate +
                ", OrderName='" + orderName +
                ", OrderNumber=" + orderNumber +
                ", PreferableDeliveryDate='" + preferableDeliveryDate +
                ", TotalPrice=" + totalPrice +
                ", Assignee=" + assignee +
                ", Customer=" + customer +
                ", OrderStatusReference=" + orderStatusReference +
                "}";
    }

}
