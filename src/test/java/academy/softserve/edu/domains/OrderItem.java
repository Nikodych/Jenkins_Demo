package academy.softserve.edu.domains;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class OrderItem {

    private int id;
    private double cost;
    private double itemPrice;
    private int quantity;
    private int dimensionReference;
    private int orderReference;
    private int productReference;

    private OrderItem() {

    }

    public static FirstIdStep newBuilder() {
        return new Builder();
    }

    public interface FirstIdStep {
        CostStep setId(final int id);
    }

    public interface CostStep {
        ItemPriceStep setCost(final double cost);
    }

    public interface ItemPriceStep {
        QuantityStep setItemPrice(final double itemPrice);
    }

    public interface QuantityStep {
        DimensionReferenceStep setQuantity(final int quantity);
    }

    public interface DimensionReferenceStep {
        OrderReferenceStep setDimensionReference(final int dimensionReference);
    }

    public interface OrderReferenceStep {
        ProductReferenceStep setOrderReference(final int orderReference);
    }

    public interface ProductReferenceStep {
        BuildStep setProductReference(final int productReference);
    }

    public interface BuildStep {
        OrderItem build();
    }

    private static class Builder implements FirstIdStep, CostStep, ItemPriceStep, QuantityStep,
            DimensionReferenceStep, OrderReferenceStep, ProductReferenceStep, BuildStep {

        private int id;
        private double cost;
        private double itemPrice;
        private int quantity;
        private int dimensionReference;
        private int orderReference;
        private int productReference;


        @Override
        public final CostStep setId(final int id) {
            this.id = id;
            return this;
        }

        @Override
        public final ItemPriceStep setCost(final double cost) {
            this.cost = cost;
            return this;
        }

        @Override
        public final QuantityStep setItemPrice(final double itemPrice) {
            this.itemPrice = itemPrice;
            return this;
        }

        @Override
        public final DimensionReferenceStep setQuantity(final int quantity) {
            this.quantity = quantity;
            return this;
        }

        @Override
        public final OrderReferenceStep setDimensionReference(final int dimensionReference) {
            this.dimensionReference = dimensionReference;
            return this;
        }

        @Override
        public final ProductReferenceStep setOrderReference(final int orderReference) {
            this.orderReference = orderReference;
            return this;
        }

        @Override
        public final BuildStep setProductReference(final int productReference) {
            this.productReference = productReference;
            return this;
        }

        @Override
        public final OrderItem build() {

            final OrderItem orderItem = new OrderItem();

            orderItem.setId(id);
            orderItem.setCost(cost);
            orderItem.setItemPrice(itemPrice);
            orderItem.setQuantity(quantity);
            orderItem.setDimensionReference(dimensionReference);
            orderItem.setOrderReference(orderReference);
            orderItem.setProductReference(productReference);

            return orderItem;
        }
    }

    @Override
    public String toString() {

        return "OrderItem{" +
                "ID=" + id +
                ", Cost=" + cost +
                ", ItemPrice=" + itemPrice +
                ", Quantity=" + quantity +
                ", DimensionReference=" + dimensionReference +
                ", OrderReference=" + orderReference +
                ", ProductReference=" + productReference +
                "}";
    }

}
