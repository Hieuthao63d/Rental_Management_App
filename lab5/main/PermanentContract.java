/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

/**
 *
 * @author Phan Thao
 */
public class PermanentContract implements Contract{
    private String contractID;
    private String propertyID;
    private String tenantID;
    private double rentAmount;

    @Override
    public void buildContractID(String contractID) {
        this.contractID = contractID;
    }

    @Override
    public void buildPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    @Override
    public void buildTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    @Override
    public void buildRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    @Override
    public Contract signContract() {
        System.out.println("Permanent contract signed.");
        return this;
    }

    @Override
    public String toString() {
        return "PermanentContract{" +
                "contractID='" + contractID + '\'' +
                ", propertyID='" + propertyID + '\'' +
                ", tenantID='" + tenantID + '\'' +
                ", rentAmount=" + rentAmount +
                '}';
    }
}