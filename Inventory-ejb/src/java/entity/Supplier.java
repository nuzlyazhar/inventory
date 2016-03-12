/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents a supplier
 * @author nuzly
 */
@Entity
@Table(name = "SUPPLIER")
@NamedQueries({
    @NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s"),
    @NamedQuery(name = "Supplier.findById", query = "SELECT s FROM Supplier s WHERE s.id = :id"),
    @NamedQuery(name = "Supplier.findByCompName", query = "SELECT s FROM Supplier s WHERE s.compName = :compName"),
    @NamedQuery(name = "Supplier.findByContactFname", query = "SELECT s FROM Supplier s WHERE s.contactFname = :contactFname"),
    @NamedQuery(name = "Supplier.findByContactLname", query = "SELECT s FROM Supplier s WHERE s.contactLname = :contactLname"),
    @NamedQuery(name = "Supplier.findByCompAddress", query = "SELECT s FROM Supplier s WHERE s.compAddress = :compAddress"),
    @NamedQuery(name = "Supplier.findByCompPhone", query = "SELECT s FROM Supplier s WHERE s.compPhone = :compPhone"),
    @NamedQuery(name = "Supplier.findByCompFax", query = "SELECT s FROM Supplier s WHERE s.compFax = :compFax"),
    @NamedQuery(name = "Supplier.findByCompEmail", query = "SELECT s FROM Supplier s WHERE s.compEmail = :compEmail"),
    @NamedQuery(name = "Supplier.findByPaymentMethod", query = "SELECT s FROM Supplier s WHERE s.paymentMethod = :paymentMethod")})
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comp_name")
    private String compName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contact_fname")
    private String contactFname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contact_lname")
    private String contactLname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comp_address")
    private String compAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comp_phone")
    private String compPhone;
    @Size(max = 45)
    @Column(name = "comp_fax")
    private String compFax;
    @Size(max = 45)
    @Column(name = "comp_email")
    private String compEmail;
    @Size(max = 45)
    @Column(name = "payment_method")
    private String paymentMethod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supId")
    private Collection<Item> itemCollection;

    public Supplier() {
    }

    public Supplier(Integer id) {
        this.id = id;
    }

    public Supplier(Integer id, String compName, String contactFname, String contactLname, String compAddress, String compPhone) {
        this.id = id;
        this.compName = compName;
        this.contactFname = contactFname;
        this.contactLname = contactLname;
        this.compAddress = compAddress;
        this.compPhone = compPhone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getContactFname() {
        return contactFname;
    }

    public void setContactFname(String contactFname) {
        this.contactFname = contactFname;
    }

    public String getContactLname() {
        return contactLname;
    }

    public void setContactLname(String contactLname) {
        this.contactLname = contactLname;
    }

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public String getCompPhone() {
        return compPhone;
    }

    public void setCompPhone(String compPhone) {
        this.compPhone = compPhone;
    }

    public String getCompFax() {
        return compFax;
    }

    public void setCompFax(String compFax) {
        this.compFax = compFax;
    }

    public String getCompEmail() {
        return compEmail;
    }

    public void setCompEmail(String compEmail) {
        this.compEmail = compEmail;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
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
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SupplierTable[ id=" + id + " ]";
    }
    
}
