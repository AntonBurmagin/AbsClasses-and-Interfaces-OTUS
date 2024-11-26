package org.example;

public class Animal {
    private String name;
    private Integer age;
    private Float weight;
    private String color;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Float getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    void say() {
        System.out.println("I'm talking!");
    }

    void go() {
        System.out.println("I'm moving!");
    }

    void drink() {
        System.out.println("I'm drinking!");
    }

    void eat() {
        System.out.println("I'm eating!");
    }

    @Override
    public String toString(){
        return ("Hello! My name is " + name + ", I'm " + age +
                " years old. My weight is about " + weight + "kg, and I'm " + color);
    }
}
