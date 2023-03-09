import DAO.CompositeBlock;
import model.Block;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        CompositeBlock compositeBlock = createCompositeBlockWithBlocks();
        Wall wall = new Wall(compositeBlock);

        String material = "leaf";

        System.out.println("--- List of all blocks by material " + material + " --- \n");
        List<Block> blocksByMaterial = wall.findBlocksByMaterial(material);
        System.out.println(prepareAllMaterialsByMaterial(blocksByMaterial));
        System.out.println("--- End of all blocks by material " + material + " --- \n");


    }

    public static CompositeBlock createCompositeBlockWithBlocks() {
        CompositeBlock compositeBlock = new CompositeBlock();
        compositeBlock.feedBlockList();
        return compositeBlock;
    }

    public static String prepareAllMaterialsByMaterial(List<Block> blocks) {
        return blocks.stream()
                .map(Block::toString)
                .collect(Collectors.joining(" "));
    }

}
