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

public class HighPriorityRequest  implements MaintenanceRequest{
    private String priority;
    private String status;
    private LocalDate expireDate;

    @Override
    public void setPriority() {
        this.priority = "Emergency";
    }

    @Override
    public void setStatus() {
        this.status = "Accepted";
    }

    @Override
    public void setExpire() {
        this.expireDate = LocalDate.now();
    }

    @Override
    public void processRequest() {
        System.out.println("Emergency request, our Administer will contact you immediately!");
    }

    @Override
    public String toString() {
        return "HighPriorityRequest{" +
               "priority='" + priority + '\'' +
               ", status='" + status + '\'' +
               ", expireDate=" + expireDate +
               '}';
    }
}
