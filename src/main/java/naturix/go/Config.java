package naturix.go;


import org.apache.logging.log4j.Level;

import naturix.go.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config {

	private static final String CATEGORY_MAX = "Max ore height";
	private static final String CATEGORY_MIN = "Min ore height";
	private static final String CATEGORY_TRIES = "Spawn tries";
	private static final String CATEGORY_VEIN = "Vein size";
    
    
    public static int ironMax;
    public static int ironMin;
    public static int ironSpawnTries;
    public static int ironVein;
    public static int goldMax;
    public static int goldMin;
    public static int goldSpawnTries;
    public static int goldVein;
    public static int coalMax;
    public static int coalMin;
    public static int coalSpawnTries;
    public static int coalVein;
    public static int lapisMax;
    public static int lapisMin;
    public static int lapisSpawnTries;
    public static int lapisVein;
    public static int redstoneMax;
    public static int redstoneMin;
    public static int redstoneSpawnTries;
    public static int redstoneVein;
    public static int diamondMax;
    public static int diamondMin;
    public static int diamondSpawnTries;
    public static int diamondVein;
    public static int emeraldMax;
    public static int emeraldMin;
    public static int emeraldSpawnTries;
    public static int emeraldVein;
    
    public static int copperMax;
    public static int copperMin;
    public static int copperSpawnTries;
    public static int copperVein;
    public static int tinMax;
    public static int tinMin;
    public static int tinSpawnTries;
    public static int tinVein;
    public static int silverMax;
    public static int silverMin;
    public static int silverSpawnTries;
    public static int silverVein;
    public static int leadMax;
    public static int leadMin;
    public static int leadSpawnTries;
    public static int leadVein;
    public static int aluminumMax;
    public static int aluminumMin;
    public static int aluminumSpawnTries;
    public static int aluminumVein;
    public static int nickelMax;
    public static int nickelMin;
    public static int nickelSpawnTries;
    public static int nickelVein;
    public static int osmiumMax;
    public static int osmiumMin;
    public static int osmiumSpawnTries;
    public static int osmiumVein;
    public static int iridiumMax;
    public static int iridiumMin;
    public static int iridiumSpawnTries;
    public static int iridiumVein;
    public static int mithrilMax;
    public static int mithrilMin;
    public static int mithrilSpawnTries;
    public static int mithrilVein;
    public static int platinumMax;
    public static int platinumMin;
    public static int platinumSpawnTries;
    public static int platinumVein;
       
    
  
    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
        } catch (Exception e1) {
            GO.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
    	cfg.addCustomCategoryComment(CATEGORY_MAX, "How would you like to manipulate oregen");
    	cfg.addCustomCategoryComment(CATEGORY_MIN, "How would you like to manipulate oregen");
    	cfg.addCustomCategoryComment(CATEGORY_TRIES, "How would you like to manipulate oregen");
    	cfg.addCustomCategoryComment(CATEGORY_VEIN, "How would you like to manipulate oregen");
        
        ironMax = cfg.getInt("ironMax", CATEGORY_MAX, 67, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        ironMin = cfg.getInt("ironMin", CATEGORY_MIN, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        ironSpawnTries = cfg.getInt("ironTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        ironVein = cfg.getInt("ironVein ", CATEGORY_VEIN, 25, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        goldMax = cfg.getInt("goldMax", CATEGORY_MAX, 33, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        goldMin = cfg.getInt("goldMin", CATEGORY_MIN, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        goldSpawnTries = cfg.getInt("goldTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        goldVein = cfg.getInt("goldVein", CATEGORY_VEIN, 30, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        coalMax = cfg.getInt("coalMax", CATEGORY_MAX, 131, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        coalMin = cfg.getInt("coalMin", CATEGORY_MIN, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        coalSpawnTries = cfg.getInt("coalTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        coalVein = cfg.getInt("coalVein", CATEGORY_VEIN, 25, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        lapisMax = cfg.getInt("lapisMax", CATEGORY_MAX, 33, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        lapisMin = cfg.getInt("lapisMin", CATEGORY_MIN, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        lapisSpawnTries = cfg.getInt("lapisTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        lapisVein = cfg.getInt("lapisVein", CATEGORY_VEIN, 43, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        redstoneMax = cfg.getInt("redstoneMax", CATEGORY_MAX, 15, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        redstoneMin = cfg.getInt("redstoneMin", CATEGORY_MIN, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        redstoneSpawnTries = cfg.getInt("redstoneTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        redstoneVein = cfg.getInt("redstoneVein", CATEGORY_VEIN, 20, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        diamondMax = cfg.getInt("diamondMax", CATEGORY_MAX, 15, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        diamondMin = cfg.getInt("diamondMin", CATEGORY_MIN, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        diamondSpawnTries = cfg.getInt("diamondTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        diamondVein = cfg.getInt("diamondVein", CATEGORY_VEIN, 10, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        emeraldMax = cfg.getInt("emeraldMax", CATEGORY_MAX, 32, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        emeraldMin = cfg.getInt("emeraldMin", CATEGORY_MIN, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        emeraldSpawnTries = cfg.getInt("emeraldTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        emeraldVein = cfg.getInt("emeraldVein", CATEGORY_VEIN, 8, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        
        copperMax = cfg.getInt("copperMax", CATEGORY_MAX, 94, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        copperMin = cfg.getInt("copperMin", CATEGORY_MIN, 17, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        copperSpawnTries = cfg.getInt("copperTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        copperVein = cfg.getInt("copperVein", CATEGORY_VEIN, 20, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        tinMax = cfg.getInt("tinMax", CATEGORY_MAX, 54, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        tinMin = cfg.getInt("tinMin", CATEGORY_MIN, 17, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        tinSpawnTries = cfg.getInt("tinTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        tinVein = cfg.getInt("tinVein", CATEGORY_VEIN, 30, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        silverMax = cfg.getInt("silverMax", CATEGORY_MAX, 34, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        silverMin = cfg.getInt("silverMin", CATEGORY_MIN, 2, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        silverSpawnTries = cfg.getInt("silverTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        silverVein = cfg.getInt("silverVein", CATEGORY_VEIN, 15, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        leadMax = cfg.getInt("leadMax", CATEGORY_MAX, 34, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        leadMin = cfg.getInt("leadMin", CATEGORY_MIN, 2, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        leadSpawnTries = cfg.getInt("leadTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        leadVein = cfg.getInt("leadVein", CATEGORY_VEIN, 30, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        aluminumMax = cfg.getInt("aluminumMax", CATEGORY_MAX, 44, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        aluminumMin = cfg.getInt("aluminumMin", CATEGORY_MIN, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        aluminumSpawnTries = cfg.getInt("aluminumTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        aluminumVein = cfg.getInt("aluminumVein", CATEGORY_VEIN, 30, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        nickelMax = cfg.getInt("nickelMax", CATEGORY_MAX, 19, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        nickelMin = cfg.getInt("nickelMin", CATEGORY_MIN, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        nickelSpawnTries = cfg.getInt("nickelTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        nickelVein = cfg.getInt("nickelVein", CATEGORY_VEIN, 30, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        osmiumMax = cfg.getInt("osmiumMax", CATEGORY_MAX, 59, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        osmiumMin = cfg.getInt("osmiumMin", CATEGORY_MIN, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        osmiumSpawnTries = cfg.getInt("osmiumTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        osmiumVein = cfg.getInt("osmiumVein", CATEGORY_VEIN, 20, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        iridiumMax = cfg.getInt("iridiumMax", CATEGORY_MAX, 15, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        iridiumMin = cfg.getInt("iridiumMin", CATEGORY_MIN, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        iridiumSpawnTries = cfg.getInt("iridiumTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        iridiumVein = cfg.getInt("iridiumVein", CATEGORY_VEIN, 5, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        mithrilMax = cfg.getInt("mithrilMax", CATEGORY_MAX, 15, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        mithrilMin = cfg.getInt("mithrilMin", CATEGORY_MIN, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        mithrilSpawnTries = cfg.getInt("mithrilTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        mithrilVein = cfg.getInt("mithrilVein", CATEGORY_VEIN, 5, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        platinumMax = cfg.getInt("platinumMax", CATEGORY_MAX, 8, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        platinumMin = cfg.getInt("platinumMin", CATEGORY_MIN, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        platinumSpawnTries = cfg.getInt("platinumTries", CATEGORY_TRIES, 1, 1, 255, "Choose a number between 1 and 255 to set how many attempts the game has to spawn this ore");
        platinumVein = cfg.getInt("platinumVein", CATEGORY_VEIN, 8, 1, 255, "Choose a number between 1 and 255 to set the vein size");
        
        }

}