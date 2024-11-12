/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab5;

/**
 *
 * @author Phan Thao
 */
public interface Contract {
    void buildContractID(String contractID);
    void buildPropertyID(String propertyID);
    void buildTenantID(String tenantID);
    void buildRentAmount(double rentAmount);
    Contract signContract();
}
