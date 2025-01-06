package project.src.data;

public enum ColorType {
    PINK ("розовый"),
    BLACK ("черный"),
    WHITE ("белый"),
    EBONY ("эбонитовый"),
    GREEN ("зеленый"),
    WET_ASPHALT ("мокрый асфальт"),
    GINGER ("имбирный"),
    RAINBOW ("радужный");

    private String name;

    ColorType(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
