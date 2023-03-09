import DAO.CompositeBlock;
import model.Block;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        CompositeBlock compositeBlock = createCompositeBlockWithBlocks();
        Wall wall = new Wall(compositeBlock);

        String material = "leaf";
        System.out.println("--- List of all blocks by material " + material + " --- \n");
        List<Block> blocksByMaterial = wall.findBlocksByMaterial(material);
        System.out.println(preparePrintingOfAllMaterialsByMaterial(blocksByMaterial));

        String existingColor = "red";
        System.out.println("--- First block of color " + existingColor + " is: --- \n");
        System.out.println(preparePrintingOfFirstBlockByColor(wall.findBlockByColor(existingColor)));

        System.out.println("--- " + preparePrintingOfCount(wall.count()) + " --- \n");


    }

    public static CompositeBlock createCompositeBlockWithBlocks() {
        CompositeBlock compositeBlock = new CompositeBlock();
        compositeBlock.feedBlockList();
        return compositeBlock;
    }

    public static String preparePrintingOfAllMaterialsByMaterial(List<Block> blocksToPrint) {
        return blocksToPrint.stream()
                .map(Block::toString)
                .collect(Collectors.joining(" "));
    }

    public static String preparePrintingOfFirstBlockByColor(Optional<Block> optionalBlockToPrint) {
        return optionalBlockToPrint.isPresent() ? optionalBlockToPrint.get().toString() : "Sadly there is no block with the color you're asking for!";
    }

    public static String preparePrintingOfCount(int count) {
        return count != 0 ?
                "Our current list of blocks is composed of " + count + " blocks "
                : "Our current list of blocks is empty!";
    }


}
