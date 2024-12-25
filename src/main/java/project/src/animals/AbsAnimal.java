package project.src.animals;

public abstract class AbsAnimal {
    private String name;
    private Integer age;
    private Double weight;
    private String color;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getWeight() {
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

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
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

    @Override
    public String toString(){
        String yearFormat = (age > 1 ? "years" : "year");
        return String.format("Hello! My name is %s, I'm %d %s old. " +
                "My weight is about %s kg, and I'm %s", name, age, yearFormat, weight, color);
    }

}
