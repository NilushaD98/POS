package com.example.newpos.posnew.dto;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;

public class CustomerDTO {

    private int customerID;

    private String customerName;

    private String customerAddress;

    private double customerSalary;

    private ArrayList contacts;

    private String nic;

    private boolean activeState;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerID, String customerName, String customerAddress, double customerSalary, ArrayList contacts, String nic, boolean activeState) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contacts = contacts;
        this.nic = nic;
        this.activeState = activeState;
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
        return "CustomerDTO{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                ", contacts=" + contacts +
                ", nic='" + nic + '\'' +
                ", activeState=" + activeState +
                '}';
    }
}
