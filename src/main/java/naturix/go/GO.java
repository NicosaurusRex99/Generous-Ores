package naturix.go;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.Logger;

import naturix.go.proxy.CommonProxy;

@Mod(modid = GO.MODID, name = GO.NAME, version = GO.VERSION, updateJSON = GO.UPDATE_URL, dependencies = "required-after:forge@[14.23.2.2611,);"
        + "after:thermalfoundation);"
        + "after:mekanism;")
public class GO
{
    public static final String MODID = "generousores";
    public static final String NAME = "Generous Ores";
    public static final String VERSION = "1.12.2.1";
    public static final String UPDATE_URL = "https://raw.githubusercontent.com/NicosaurusRex99/Generous-Ores/master/go_update.json";
    
    public static Logger logger;

    @SidedProxy(clientSide = "naturix.go.proxy.ClientProxy", serverSide = "naturix.go.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);

        GameRegistry.registerWorldGenerator(new ModWorldGeneration(), 3);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

}
