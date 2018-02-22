package edu.upc.talent.tddkata;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestProductCatalog implements ProductCatalog{

    private Map<String,Integer> prices = new HashMap<String, Integer>();


    public void registerPrice(String eanCode, int price){
        prices.put(eanCode, price);
    }

    @Override
    public int getProductPrice(String eanCode) {
        return prices.get(eanCode);
    }
}

public class POSShould {


    @Test
    void returnNoActiveSaleInitially(){
        POS pos = new POS(null);
        assertEquals(false, pos.isSaleActive());
    }

    @Test
    void returnActiveSaleAfterAddingProducts(){
        String eanCode = "1";
        TestProductCatalog catalog = new TestProductCatalog();
        catalog.registerPrice(eanCode, 3);
        POS pos = new POS(catalog);
        pos.addProduct(eanCode);
        assertEquals(true, pos.isSaleActive());
    }

    @Test
    void returnSaleTotalOneProduct(){
        String eanCode = "1";
        int price = 3;
        TestProductCatalog catalog = new TestProductCatalog();
        catalog.registerPrice(eanCode, price);
        POS pos = new POS(catalog);
        pos.addProduct(eanCode);
        int saleTotal = pos.getSaleTotal();
        assertEquals(price, saleTotal);
    }


    @Test
    void returnSaleTotalDifferentProduct(){
        String eanCode = "2";
        int price = 5;
        TestProductCatalog catalog = new TestProductCatalog();
        catalog.registerPrice(eanCode, price);
        POS pos = new POS(catalog);
        pos.addProduct(eanCode);
        int saleTotal = pos.getSaleTotal();
        assertEquals(price, saleTotal);
    }



}
