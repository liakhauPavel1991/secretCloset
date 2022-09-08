package models;

import tools.constants.Splitters;
import tools.exeptions.ListSizeException;
import tools.utils.StringUtils;

import java.util.List;
import java.util.Objects;

public class Product {
    private String brand;
    private int finalPrice;
    private String finalPriceCurrency;
    private int originalPrice;
    private String originalPriceCurrency;
    private int discountPercentValue;
    private String discountPercentString;

    public String getBrand() {
        return brand;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public String getFinalPriceCurrency() {
        return finalPriceCurrency;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public String getOriginalPriceCurrency() {
        return originalPriceCurrency;
    }

    public int getDiscountPercentValue() {
        return discountPercentValue;
    }

    public String getDiscountPercentString() {
        return discountPercentString;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setFinalPrice(String finalPrice) {
        List<String> priceInfo = List.of(finalPrice.trim().split(Splitters.SPACE));
        if (priceInfo.size() != 2) {
            throw new ListSizeException("Price should contain price value and price currency");
        }
        this.finalPrice = Integer.parseInt(priceInfo.get(0));
        this.finalPriceCurrency = priceInfo.get(1);
    }

    public void setOriginalPrice(String originalPrice) {
        List<String> discountAmountInfo = List.of(originalPrice.trim().split(Splitters.SPACE));
        if (discountAmountInfo.size() != 2) {
            throw new ListSizeException("Discount amount should contain discount value and discount currency");
        }
        this.originalPrice = Integer.parseInt(discountAmountInfo.get(0));
        this.originalPriceCurrency = discountAmountInfo.get(1);
    }

    public void setDiscount(String discountPercent) {
        this.discountPercentString = discountPercent;
        this.discountPercentValue = StringUtils.getOnlyIntFromString(discountPercent);
    }

    public boolean hasDiscount() {
        return this.discountPercentValue != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return finalPrice == product.finalPrice && originalPrice == product.originalPrice && discountPercentValue == product.discountPercentValue && brand.equals(product.brand) && Objects.equals(finalPriceCurrency, product.finalPriceCurrency) && Objects.equals(originalPriceCurrency, product.originalPriceCurrency) && Objects.equals(discountPercentString, product.discountPercentString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, finalPrice, finalPriceCurrency, originalPrice, originalPriceCurrency, discountPercentValue, discountPercentString);
    }

    @Override
    public String toString() {
        return "Product{" +
                "brand='" + brand + '\'' +
                ", finalPrice=" + finalPrice +
                ", finalPriceCurrency='" + finalPriceCurrency + '\'' +
                ", originalPrice=" + originalPrice +
                ", originalPriceCurrency='" + originalPriceCurrency + '\'' +
                ", discountPercentValue=" + discountPercentValue +
                ", discountPercentString='" + discountPercentString + '\'' +
                ", hasDiscount='" + hasDiscount() + '\'' +
                '}';
    }
}
