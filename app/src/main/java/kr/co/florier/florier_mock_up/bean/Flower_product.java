package kr.co.florier.florier_mock_up.bean;

public class Flower_product {
    private String flower_img;
    private String flower_name;
    private String flower_price;

    public Flower_product(String flower_img, String flower_name, String flower_price) {
        this.flower_img = flower_img;
        this.flower_name = flower_name;
        this.flower_price = flower_price;
    }

    public String getFlower_img() {
        return flower_img;
    }

    public void setFlower_img(String flower_img) {
        this.flower_img = flower_img;
    }

    public String getFlower_name() {
        return flower_name;
    }

    public void setFlower_name(String flower_name) {
        this.flower_name = flower_name;
    }

    public String getFlower_price() {
        return flower_price;
    }

    public void setFlower_price(String flower_price) {
        this.flower_price = flower_price;
    }
}
