package fr.epsi.gomi;

import retrofit2.Call;

public class Product {

    private  String id_product;
    private boolean status;
    private String marque;
    private  String url_image;
    private String cat_product;
    private String[] composants;

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMarque() {
        return marque;
    }

    public String getUrl_image() {
        return url_image;
    }

    public String getCat_product() {
        return cat_product;
    }

    public String[] getComposants() {
        return composants;
    }

}
