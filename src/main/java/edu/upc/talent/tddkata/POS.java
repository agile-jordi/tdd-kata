package edu.upc.talent.tddkata;

public class POS {

    private final ProductCatalog productCatalog;
    private boolean saleStatus = false;
    private int saleTotal;

    public POS(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    void addProduct(String eanCode) {
        saleStatus = true;
        this.saleTotal += this.productCatalog.getProductPrice(eanCode);
    }

    boolean isSaleActive() {
        return saleStatus;
    }

    public int getSaleTotal() {
        return saleTotal;
    }
}
