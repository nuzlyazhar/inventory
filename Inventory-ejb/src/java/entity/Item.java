/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents an item
 * @author nuzly
 */
@Entity
@Table(name = "ITEM")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id"),
    @NamedQuery(name = "Item.findByItemName", query = "SELECT i FROM Item i WHERE i.itemName = :itemName"),
    @NamedQuery(name = "Item.findByItemDescription", query = "SELECT i FROM Item i WHERE i.itemDescription = :itemDescription"),
    @NamedQuery(name = "Item.findByUnitPrice", query = "SELECT i FROM Item i WHERE i.unitPrice = :unitPrice"),
    @NamedQuery(name = "Item.findByQuanityPerUnit", query = "SELECT i FROM Item i WHERE i.quanityPerUnit = :quanityPerUnit"),
    
    @NamedQuery(name = "Item.findByUnitsInStock", query = "SELECT i FROM Item i WHERE i.unitsInStock = :unitsInStock"),
    @NamedQuery(name = "Item.findBelowReorderThreshold", query = "SELECT i FROM Item i WHERE i.unitsInStock <= i.reorderThreshold"),
    @NamedQuery(name = "Item.findByUnitsInOrder", query = "SELECT i FROM Item i WHERE i.unitsInOrder = :unitsInOrder"),
    @NamedQuery(name = "Item.findByReorderThreshold", query = "SELECT i FROM Item i WHERE i.reorderThreshold = :reorderThreshold")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "item_name")
    private String itemName;
    @Size(max = 400)
    @Column(name = "item_description")
    private String itemDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quanity_per_unit")
    private int quanityPerUnit;
    @Size(max = 3)
    @Column(name = "size")
    private String itemSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "units_in_stock")
    private int unitsInStock;
    @Column(name = "units_in_order")
    private Integer unitsInOrder;
    @Basic(optional = false)
    @NotNull
   
    @Column(name = "reorder_threshold")
    private int reorderThreshold;
    @JoinColumn(name = "cat_id", referencedColumnName = "id")
    @ManyToOne
    private Category catId;
    @JoinColumn(name = "sup_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Supplier supId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private Collection<OrderDetail> orderDetailCollection;

    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Item(Integer id, String itemName, BigDecimal unitPrice, int quanityPerUnit, int unitsInStock, int reorderThreshold) {
        this.id = id;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.quanityPerUnit = quanityPerUnit;
        this.unitsInStock = unitsInStock;
        this.reorderThreshold = reorderThreshold;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuanityPerUnit() {
        return quanityPerUnit;
    }

    public void setQuanityPerUnit(int quanityPerUnit) {
        this.quanityPerUnit = quanityPerUnit;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

  

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Integer getUnitsInOrder() {
        return unitsInOrder;
    }

    public void setUnitsInOrder(Integer unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public int getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(int reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    public Category getCatId() {
        return catId;
    }

    public void setCatId(Category catId) {
        this.catId = catId;
    }

    public Supplier getSupId() {
        return supId;
    }

    public void setSupId(Supplier supId) {
        this.supId = supId;
    }

    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Item[ id=" + id + " ]";
    }

}
