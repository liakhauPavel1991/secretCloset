package models;

import java.util.Objects;

import static tools.utils.StringUtils.getOnlyIntFromString;

public class Seller {
    private String name;
    private int id;
    private int rate;
    private String time;
    private int rating;
    private int likes;
    private int sells;
    private String city;
    private String member;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getRate() {
        return rate;
    }

    public String getTime() {
        return time;
    }

    public int getRating() {
        return rating;
    }

    public String getCity() {
        return city;
    }

    public int getLikes() {
        return likes;
    }

    public int getSells() {
        return sells;
    }

    public String getMember() {
        return member;
    }

    public Seller setName(String name) {
        this.name = name;
        return this;
    }

    public Seller setId(String id) {
        this.id = getOnlyIntFromString(id);
        return this;
    }

    public Seller setRate(String rate) {
        this.rate = getOnlyIntFromString(rate);
        return this;
    }

    public Seller setTime(String time) {
        this.time = time;
        return this;
    }

    public Seller setRating(String rating) {
        this.rating = getOnlyIntFromString(rating);
        return this;
    }

    public Seller setCity(String city) {
        this.city = city;
        return this;
    }

    public Seller setLikes(String likes) {
        this.likes = getOnlyIntFromString(likes);
        return this;
    }

    public Seller setSells(String sells) {
        this.sells = getOnlyIntFromString(sells);
        return this;
    }

    public Seller setMember(String member) {
        this.member = member;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return name.equals(seller.name) && city.equals(seller.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", rate=" + rate +
                ", time='" + time + '\'' +
                ", rating=" + rating +
                ", likes=" + likes +
                ", sells=" + sells +
                ", city='" + city + '\'' +
                ", member='" + member + '\'' +
                '}';
    }

    public String comparableInfo() {
        return "Seller{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
