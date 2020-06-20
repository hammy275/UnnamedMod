package net.blf02.unnamedmod;

import net.blf02.unnamedmod.init.ModEntities;
import net.blf02.unnamedmod.init.ModRecipes;
import net.blf02.unnamedmod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = UnnamedMod.MODID, name = UnnamedMod.NAME, version = UnnamedMod.VERSION)
public class UnnamedMod
{
	
	@Instance
	public static UnnamedMod instance;
	
    public static final String MODID = "unnamedmod";
    public static final String NAME = "Unnamed Mod";
    public static final String VERSION = "1.0.0";
    public static final String CLIENT_PROXY_CLASS = "net.blf02.unnamedmod.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "net.blf02.unnamedmod.proxy.CommonProxy";

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Hello World from Unnamed Mod!");
        ModEntities.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	System.out.println("Hello everybody! It's Unnamed Mod again; how's it going?");
    	ModRecipes.init();
    }
    
    @EventHandler
    public void init(FMLPostInitializationEvent event) {
    	System.out.println("One last hello from Unnamed Mod, just about set up here!");
    }
}
