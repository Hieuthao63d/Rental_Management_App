/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cse483_lab5.Factory;

/**
 *
 * @author Phan Thao
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MidPriorityRequest implements MaintenanceRequest{
    private String priority;
    private String status;
    private LocalDate expireDate;

    @Override
    public void setPriority() {
        this.priority = "Medium";
    }

    @Override
    public void setStatus() {
        this.status = "Accepted";
    }

    @Override
    public void setExpire() {
        this.expireDate = LocalDate.now().plusMonths(1);
    }

    @Override
    public void processRequest() {
        System.out.println("Request accept, estimated completion date is " + expireDate);
    }

    @Override
    public String toString() {
        return "MidPriorityRequest{" +
               "priority='" + priority + '\'' +
               ", status='" + status + '\'' +
               ", expireDate=" + expireDate +
               '}';
    }
}
