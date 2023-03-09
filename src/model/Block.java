package model;

public class Block {

    private String color;
    private String material;

    public Block(String color, String material) {
        this.color = color;
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Block on " + material + " with color " + color + ". \n";
    }
}