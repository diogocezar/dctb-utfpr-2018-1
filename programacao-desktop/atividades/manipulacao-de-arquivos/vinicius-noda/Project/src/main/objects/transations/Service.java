/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.objects.transations;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author gabriel
 */
public class Service extends Transation{
    private LocalDate startDate;
    private LocalDate estimatedDate;
    private LocalDate finishDate;
    private String status;
    private int codServ;
    private String assignedEmployee;
    private String name;

    public Service(String name, float price) {
        this.name = name;
        super.setPrice(price);
    }
    
    public Service(LocalDate startDate, LocalDate estimatedDate, LocalDate finishDate, String status, int codServ, String assignedEmployee, String name, int id) {
        super(id);
        this.startDate = startDate;
        this.estimatedDate = estimatedDate;
        this.finishDate = finishDate;
        this.status = status;
        this.codServ = codServ;
        this.assignedEmployee = assignedEmployee;
        this.name = name;
    }

    public Service(LocalDate startDate, LocalDate estimatedDate, int codServ) {
        this.startDate = startDate;
        this.estimatedDate = estimatedDate;
        this.codServ = codServ;
    }

    public Service(int codServ) {
        this.codServ = codServ;
    }

    
    
       
    
    
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(LocalDate estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCodServ() {
        return codServ;
    }

    public void setCodServ(int codServ) {
        this.codServ = codServ;
    }

    public String getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(String assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString()+"Service{" + "startDate=" + startDate + ", estimatedDate=" + estimatedDate + ", finishDate=" + finishDate + ", status=" + status + ", codServ=" + codServ + ", assignedEmployee=" + assignedEmployee + ", name=" + name + '}';
    }
    
    
}
