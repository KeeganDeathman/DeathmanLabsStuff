package keegan.labstuff.world;

import keegan.labstuff.LabStuffMain;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class LabStuffOreGen implements IWorldGenerator
{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case -1:
                this.generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0:
                this.generateSurface(world, random, chunkX * 16, chunkZ * 16);

        }

    }

    private void generateSurface(World world, Random rand, int baseX, int baseZ)
    {
        // rarity -smaller number = rarer
        for (int x = 0; x < 50; x++)
        {
            int Xcoord = baseX + rand.nextInt(16);
            int Zcoord = baseZ + rand.nextInt(16);
            int Ycoord = rand.nextInt(30);
            // Max Vein Size
            new WorldGenMinable(LabStuffMain.blockCopperOre, 4).generate(world, rand, Xcoord, Ycoord, Zcoord);
        }

        // rarity -smaller number = rarer
        for (int x = 0; x < 50; x++)
        {
            int Xcoord = baseX + rand.nextInt(16);
            int Zcoord = baseZ + rand.nextInt(16);
            int Ycoord = rand.nextInt(20) + 30;
            // Max Vein Size
            new WorldGenMinable(LabStuffMain.blockPlasticOre, 5).generate(world, rand, Xcoord, Ycoord, Zcoord);
        }
        for (int x = 0; x < 50; x++)
        {
            int Xcoord = baseX + rand.nextInt(16);
            int Zcoord = baseZ + rand.nextInt(16);
            int Ycoord = rand.nextInt(20) + 30;
            // Max Vein Size
            new WorldGenMinable(LabStuffMain.blockZincOre, 5).generate(world, rand, Xcoord, Ycoord, Zcoord);
        }
        for (int x = 0; x < 50; x++)
        {
            int Xcoord = baseX + rand.nextInt(16);
            int Zcoord = baseZ + rand.nextInt(16);
            int Ycoord = rand.nextInt(20) + 30;
            // Max Vein Size
            new WorldGenMinable(LabStuffMain.blockMangOre, 5).generate(world, rand, Xcoord, Ycoord, Zcoord);
        }
        for (int x = 0; x < 50; x++)
        {
            int Xcoord = baseX + rand.nextInt(16);
            int Zcoord = baseZ + rand.nextInt(16);
            int Ycoord = rand.nextInt(20) + 30;
            // Max Vein Size
            new WorldGenMinable(LabStuffMain.blockSiliconOre, 5).generate(world, rand, Xcoord, Ycoord, Zcoord);
        }
        
    }

    private void generateNether(World world, Random random, int i, int j)
    {

    }

}