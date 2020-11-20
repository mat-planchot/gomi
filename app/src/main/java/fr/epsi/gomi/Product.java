package fr.epsi.gomi;

import retrofit2.Call;

public class Product {

    private String id_product;
    private String product_name_fr;
    private String manufacturing_places;
    private String origins;
    private String brands;
    private String image_front_url;
    private String[] packaging_tags;

    public String getId_product() {
        return id_product;
    }
    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getProductNameFr() { return product_name_fr; }

    public String getManufacturingPlaces() { return manufacturing_places; }

    public String getOrigins() { return origins; }

    public String getBrands() {
        return brands;
    }

    public String getImageFrontUrl() {
        return image_front_url;
    }

    public String[] getPackagingTags() {
        return packaging_tags;
    }

}
