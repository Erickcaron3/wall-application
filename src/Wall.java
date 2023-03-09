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
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (material == null || !isMaterialExisting(material)) {
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

    private List<Block> findAllBlocksByMaterial(String material) {
        return compositeBlock.getBlocks().stream().filter(block -> block.getMaterial().equals(material)).collect(Collectors.toList());
    }

    private boolean isBlocksListExportable(List<Block> blocks) {
        return blocks.size() >= 1;
    }


}