package model.piggyBank;

import java.util.List;
import model.coin.*;
import java.util.ArrayList;

public class Cofrinho implements ICofrinho {
    
    private List<Moeda> moedas;
    
    public Cofrinho(){
        moedas = new ArrayList<>(50);
    }

    @Override
    public void insereMoeda(Moeda coin){
        moedas.add(coin);
    }

    @Override
    public int quantasMoedas(Moeda coin){
        int quantity = 0;

        for(Moeda obj : moedas){
            if(obj.equals(coin)){
                quantity++;
            }
        }

        return quantity;
    }

    @Override
    public int quantidadeMoedas(){
        return moedas.size();
    }

    @Override
    public double totalCofrinho(){
        double value = 0;

        for(Moeda obj : moedas){
            value += obj.getValue();
        }

        return value;
    }

    @Override
    public Montinhos quebrarCofrinho(){

        Montinhos montinhos = new Montinhos();
        int coinQuantity[] = new int[6];
        double tester;

        for(Moeda obj : moedas){
            tester = obj.getValue();

            if (tester == 0.01) {
                coinQuantity[0]++;
            } else if (tester == 0.05) {
                coinQuantity[1]++;
            } else if (tester == 0.10) {
                coinQuantity[2]++;
            } else if (tester == 0.25) {
                coinQuantity[3]++;
            } else if (tester == 0.50) {
                coinQuantity[4]++;
            } else if (tester == 1.00) {
                coinQuantity[5]++;
            }
        }

        montinhos.add(new Montinho(new Um(), coinQuantity[0]));
        montinhos.add(new Montinho(new Cinco(), coinQuantity[1]));
        montinhos.add(new Montinho(new Dez(), coinQuantity[2]));
        montinhos.add(new Montinho(new VinteCinco(), coinQuantity[3]));
        montinhos.add(new Montinho(new Cinquenta(), coinQuantity[4]));
        montinhos.add(new Montinho(new UmReal(), coinQuantity[5]));

        return montinhos;
    }
}
