package project.day8_ObjectService.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private int ordNo;

//    private int custId;
    private int customerId;
    private int code;

    private double amount;

    private LocalDate ordDate;

    public Order() {
    }

    public Order(int ordNo, int custId, int code, double amount, LocalDate ordDate) {
        this.ordNo = ordNo;
        this.customerId = custId;
        this.code = code;
        this.amount = amount;
        this.ordDate = ordDate;
    }

    public int getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(int ordNo) {
        this.ordNo = ordNo;
    }

    public int getCustId() {
        return customerId;
    }

    public void setCustId(int custId) {
        this.customerId = custId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(LocalDate ordDate) {
        this.ordDate = ordDate;
    }
}