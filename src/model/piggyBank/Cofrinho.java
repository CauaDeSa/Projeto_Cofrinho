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
        return moedas.size;
    }

    @Override
    public double totalCofrinho(){
        double value = 0;

        for(Moeda obj : moedas){
            value += obj.getvalue;
        }

        return value;
    }

    @Override
    public Montinhos quebrarCofrinho(){

        Montinhos montinhos = new Montinhos();

        montinhos.add(new Montinho(new Um(), moedas.quantasMoedas(new Um)));
        montinhos.add(new Montinho(new Cinco(), moedas.quantasMoedas(new Cinco)));
        montinhos.add(new Montinho(new Dez(), moedas.quantasMoedas(new Dez)));
        montinhos.add(new Montinho(new VinteCinco(), moedas.quantasMoedas(new VinteCinco)));
        montinhos.add(new Montinho(new Cinquenta(), moedas.quantasMoedas(new Cinquenta)));
        montinhos.add(new Montinho(new UmReal(), moedas.quantasMoedas(new UmReal)));

        return montinhos;
    }
}
