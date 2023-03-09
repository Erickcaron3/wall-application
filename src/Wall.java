import DAO.CompositeBlock;
import model.Block;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {

    CompositeBlock compositeBlock;

    public Wall(CompositeBlock compositeBlock) {
        this.compositeBlock = compositeBlock;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (color == null || color.equals("") || !isColorExisting(color)) {
            throw new IllegalArgumentException("The color you are asking for " + color + " is not existing");
        }
        return findFirstBlockByColor(color);
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (material == null || material.equals("") || !isMaterialExisting(material)) {
            throw new IllegalArgumentException("The material you are asking for " + material + " is not existing");
        }
        final List<Block> blocksByMaterial = findAllBlocksByMaterial(material);
        return isBlocksListExportable(blocksByMaterial) ? blocksByMaterial : Collections.emptyList();
    }

    @Override
    public int count() {
        return 0;
    }

    private boolean isMaterialExisting(String material) {
        return compositeBlock.getBlocks()
                .stream().anyMatch(block -> block.getMaterial().equals(material));
    }

    private boolean isColorExisting(String color) {
        return compositeBlock.getBlocks()
                .stream().anyMatch(block -> block.getColor().equals(color));
    }


    private List<Block> findAllBlocksByMaterial(String material) {
        return compositeBlock.getBlocks().stream().filter(block -> block.getMaterial().equals(material)).collect(Collectors.toList());
    }

    private Optional<Block> findFirstBlockByColor(String color) {
        return compositeBlock.getBlocks().stream().filter(block -> block.getColor().equals(color)).findFirst();
    }

    private boolean isBlocksListExportable(List<Block> blocks) {
        return blocks.size() >= 1;
    }


}