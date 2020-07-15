package net.blf02.unnamedmod;

import net.blf02.unnamedmod.init.ModEntities;
import net.blf02.unnamedmod.init.ModRecipes;
import net.blf02.unnamedmod.proxy.CommonProxy;
import net.blf02.unnamedmod.util.TickHandlers;
import net.minecraftforge.common.MinecraftForge;
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
    public static final String NAME = "Elements";
    public static final String VERSION = "0.1.0";
    public static final String CLIENT_PROXY_CLASS = "net.blf02.unnamedmod.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "net.blf02.unnamedmod.proxy.CommonProxy";

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Performing Elements pre-init!");
        ModEntities.init();
        MinecraftForge.EVENT_BUS.register(new TickHandlers());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	System.out.println("Performing Elements init!");
    	ModRecipes.init();
    }
    
    @EventHandler
    public void init(FMLPostInitializationEvent event) {
    	System.out.println("Elements post-init, away we go!");
    }
}
