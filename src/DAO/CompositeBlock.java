package DAO;

import model.Block;

import java.util.ArrayList;
import java.util.List;

public class CompositeBlock {

    private List<Block> blocks = new ArrayList<>();

    public CompositeBlock() {
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void addBlock(Block block) {
        if (block != null) {
            blocks.add(block);
        }
    }

    public void feedBlockList() {
        this.blocks.addAll(createBlockList());
    }

    private List<Block> createBlockList() {
        return List.of(
                new Block("blue", "wood"),
                new Block("green", "wood"),
                new Block("red", "wood"),
                new Block("yellow", "wood"),
                new Block("black", "wood"),
                new Block("white", "wood"),
                new Block("blue", "leaf"),
                new Block("green", "leaf"),
                new Block("red", "leaf"),
                new Block("yellow", "leaf"),
                new Block("black", "leaf"),
                new Block("white", "leaf"),
                new Block("blue", "plastic"),
                new Block("green", "plastic"),
                new Block("red", "plastic"),
                new Block("yellow", "plastic"),
                new Block("black", "plastic"),
                new Block("white", "plastic")
        );
    }
}