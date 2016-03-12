/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Represents an Order Detail entry.
 * @author nuzly
 */
@Entity
@Table(name = "ORDER_DETAIL")
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o"),
    @NamedQuery(name = "OrderDetail.findById", query = "SELECT o FROM OrderDetail o WHERE o.id = :id"),
    @NamedQuery(name = "OrderDetail.findByBillId", query = "SELECT o FROM OrderDetail o WHERE o.billId = :billId"),
    @NamedQuery(name = "OrderDetail.findByUnitPrice", query = "SELECT o FROM OrderDetail o WHERE o.unitPrice = :unitPrice"),
    @NamedQuery(name = "OrderDetail.findByOrderQantity", query = "SELECT o FROM OrderDetail o WHERE o.orderQantity = :orderQantity"),
    @NamedQuery(name = "OrderDetail.findByTotal", query = "SELECT o FROM OrderDetail o WHERE o.total = :total"),
    @NamedQuery(name = "OrderDetail.findByDeliveryDate", query = "SELECT o FROM OrderDetail o WHERE o.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "OrderDetail.findByOrderDate", query = "SELECT o FROM OrderDetail o WHERE o.orderDate = :orderDate")})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bill_id")
    private int billId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "order_qantity")
    private Integer orderQantity;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "delivery_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Item itemId;
    @JoinColumn(name = "order_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Order orderId;

    public OrderDetail() {
    }

    public OrderDetail(Integer id) {
        this.id = id;
    }

    public OrderDetail(Integer id, int billId, BigDecimal unitPrice) {
        this.id = id;
        this.billId = billId;
        this.unitPrice = unitPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getOrderQantity() {
        return orderQantity;
    }

    public void setOrderQantity(Integer orderQantity) {
        this.orderQantity = orderQantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderDetail[ id=" + id + " ]";
    }
    
}
