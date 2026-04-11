package psem.supermarket.service;

import psem.supermarket.model.Cash;

import java.math.BigDecimal;
import java.util.List;

public interface CashRegister {
    void addCash(Cash cash);
    List<Cash> getCashInventory();
    boolean hasEnoughChange(BigDecimal change);
    boolean returnChange(BigDecimal change);
}
