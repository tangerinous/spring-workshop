package com.example.demo.les4_inheritance;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("TOY")
public class Toy extends ProductItem {

    private int minAge;

    public Toy() {}

    public Toy(String name, int minAge) {
        super(name);
        this.minAge = minAge;
    }

    public int getMinAge() { return minAge; }
    public void setMinAge(int minAge) { this.minAge = minAge; }
}
