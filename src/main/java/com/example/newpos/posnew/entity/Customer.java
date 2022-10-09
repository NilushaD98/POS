package com.example.newpos.posnew.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "customer")
@TypeDefs({@TypeDef(name = "json", typeClass = JsonType.class)})
public class Customer {

    @Id
    @Column(name = "custmoer_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerID;
    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    @Column(name = "customer_address", length = 200)
    private String customerAddress;

    @Column(name = "customer_salary", length = 25)
    private double customerSalary;

    @Type(type = "json")
    @Column(name = "contact_number", columnDefinition = "json")
    private ArrayList contacts;

    @Column(name = "nic", length = 12, unique = true)
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default '1'")
    private boolean activeState;

    @OneToMany(mappedBy ="customer")
    private Set<Orders> ordersSet;
    public Customer(String customerName, String customerAddress, double customerSalary, ArrayList contacts, String nic) {
    }

    public Customer(int customerID, String customerName, String customerAddress, double customerSalary, ArrayList contacts, String nic, boolean activeState) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contacts = contacts;
        this.nic = nic;
        this.activeState = activeState;
    }

    public Customer(String customerName, String customerAddress, double customerSalary, ArrayList contacts, String nic, boolean activeState) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contacts = contacts;
        this.nic = nic;
        this.activeState = activeState;
    }

    public Customer() {

    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public ArrayList getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList contacts) {
        this.contacts = contacts;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", customerName='" + customerName + '\'' + ", customerAddress='" + customerAddress + '\'' + ", customerSalary=" + customerSalary + ", contacts=" + contacts + ", nic='" + nic + '\'' + ", activeState=" + activeState + '}';
    }
}
