package psem.supermarket.service;

import psem.supermarket.exception.NotEnoughChangeException;
import psem.supermarket.model.Cash;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CashRegisterImpl implements CashRegister {

    private List<Cash> cashList;

    public CashRegisterImpl() {
        cashList = new ArrayList<>();
    }

    @Override
    public void addCash(Cash cash) {

        boolean found = false;

        for(Cash c : cashList) {
            if(Objects.equals(c.getValue(), cash.getValue())) {
                c.setQuantity(cash.getQuantity());
                found = true;
            }
        }

        if(!found) {
            cashList.add(cash);
        }

        sortCash();
    }

    @Override
    public List<Cash> getCashInventory() {
        return cashList;
    }

    // Comparator, kad surusiuoti values eiles tvarka.
    public void sortCash() {
        cashList.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
    }

    @Override
    public boolean hasEnoughChange(BigDecimal change) {
        try {
            BigDecimal cashLeft = BigDecimal.ZERO;
            for(Cash cash : cashList) {
                cashLeft = cashLeft.add(cash.getValue().multiply(new BigDecimal(cash.getQuantity())));
            }

            if(cashLeft.compareTo(change) > 0) {
                return true;
            } else {
                throw new NotEnoughChangeException("Sorry we don't have enough change");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean returnChange(BigDecimal change) {
        // reiketu is esmes dar tikrinti, jei po 1 ar du nera, reiketu daugint po 50ct, jei po 50 nera, daugint po 10 ir ziuret
        // ar galima grazint graza, bet cia toks supaprastintas variantas.

        try {

            int tenCentsReq = tenCentsRequired(change);
            int fiftyCentsReq = fiftyCentsRequired(change);

            if(cashList.get(0).getQuantity() >= tenCentsReq) {
                if(tenCentsReq > 0) {
                    cashList.get(0).setQuantity(cashList.get(0).getQuantity() - tenCentsReq);
                    System.out.println("Value: 0.1, quantity: " + tenCentsReq);
                }
            } else {
                throw new NotEnoughChangeException("Sorry we don't have enough change in 10 cents.");
            }

            if(cashList.get(1).getQuantity() > fiftyCentsReq) {
                if(fiftyCentsReq > 0) {
                    cashList.get(1).setQuantity(cashList.get(1).getQuantity() - fiftyCentsReq);
                    System.out.println("Value: 0.5, quantity: " + fiftyCentsReq);
                }
            } else {
                throw new NotEnoughChangeException("Sorry we don't have enough change in 50 cents.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        subtractOneAndTwoBills(change);

        return true;
    }

    private int tenCentsRequired(BigDecimal change) {
        // Skaiciuojam kiek is viso reikia 10ct monetu.
        // 4.7 % 0.5 = 0.2 (dauginam is 10 ir gaunam, kad reikia 2vnt. po 10ct)
        int tenCentsRequired = change.remainder(new BigDecimal(0.5)
                .round(new MathContext(2)))
                .multiply(BigDecimal.TEN).intValue();
        return tenCentsRequired;
    }

    private int fiftyCentsRequired(BigDecimal change) {

        // Jei change padalinus is 1 remainder gauname >= nei 0.5, tada reikia vienos monetos, jei maziau tada 0.
        if(change.remainder(BigDecimal.ONE).round(new MathContext(2)).compareTo(new BigDecimal(0.5)) >= 0) {
            return 1;
        }
        return 0;
    }

    private void subtractOneAndTwoBills(BigDecimal change) {
        // jei graza daugiau nei du, tada sukam while cikla, atimam 2 is change ir -1 is quantity,
        // kol change lieka <= nei 2.
        int countTwo = 0;
        int countOne = 0;
        while(change.compareTo(BigDecimal.TWO) >= 0) {
            cashList.get(3).setQuantity(cashList.get(3).getQuantity() - 1);
            change = change.subtract(BigDecimal.TWO);
            countTwo++;
        }

        // tas pats ir su vienu.
        while(change.compareTo(BigDecimal.ONE) >= 0) {
            cashList.get(2).setQuantity(cashList.get(2).getQuantity() - 1);
            change = change.subtract(BigDecimal.ONE);
            countOne++;
        }

        if(countTwo > 0) {
            System.out.println("Value: 2, quantity: " + countTwo);
        }
        if(countOne > 0) {
            System.out.println("Value: 1, quantity: " + countOne);
        }

    }

}
