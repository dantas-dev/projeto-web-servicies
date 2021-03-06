package com.dantas.projetowebservicies.model.order;

import com.dantas.projetowebservicies.model.product.ProductEntity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItemEntity implements Serializable {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;

    public OrderItemEntity() {
    }

    public OrderItemEntity(OrderEntity order, ProductEntity product, Integer quantity, Double price) {
        id.setOrderEntity(order);
        id.setProductEntity(product);
        this.quantity = quantity;
        this.price = price;
    }

    public OrderEntity getOrder() {
        return id.getOrderEntity();
    }

    public void setOrder(OrderEntity order) {
        id.setOrderEntity(order);
    }

    public ProductEntity getProduct() {
        return id.getProductEntity();
    }

    public void setProduct(ProductEntity product) {
        id.setProductEntity(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubTotal() {
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemEntity orderItemEntity = (OrderItemEntity) o;
        return Objects.equals(id, orderItemEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
