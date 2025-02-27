package project.src.animals;

import project.src.data.ColorType;

public abstract class AbsAnimal {
    private String name;
    private Integer age;
    private Float weight;
    private ColorType color;

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
        return color.toString();
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
        this.color = ColorType.valueOf(color.toUpperCase());
    }

    public void say() {
        System.out.println("I'm talking!");
    }

    public void go() {
        System.out.println("I'm moving!");
    }

    public void drink() {
        System.out.println("I'm drinking!");
    }

    public void eat() {
        System.out.println("I'm eating!");
    }

    //    {"id", "name", "age", "weight", "color", "type"}
    public String getAll() {
        return String.format("'%s', %s, %s, '%s'", name, age, weight, color);
    }

    @Override
    public String toString(){
        String yearFormat;
        if (age % 10 == 0 || age % 10 >= 5 || age / 10 == 1) {
            yearFormat = "лет";
        } else if (age % 10 == 1) {
            yearFormat = "год";
        } else {
            yearFormat = "года";
        }
        return String.format("Привет! Меня зовут %s, мне %d %s, " +
                "я вешу %s кг, мой цвет - %s", name, age, yearFormat, weight, color.getName());
    }

}
