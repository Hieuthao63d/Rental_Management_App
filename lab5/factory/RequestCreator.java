/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cse483_lab5.Factory;

/**
 *
 * @author Phan Thao
 */
public abstract class RequestCreator {
    public abstract MaintenanceRequest createRequest();

    public void processRequest() {
        MaintenanceRequest request = createRequest();
        request.setPriority();
        request.setStatus();
        request.setExpire();
        request.processRequest();
    }
}
