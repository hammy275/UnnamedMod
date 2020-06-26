package net.blf02.unnamedmod.util;

import net.blf02.unnamedmod.items.powers.FissureItem;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TickHandlers {
	
	private static int tickCount = 0;
	
	@SubscribeEvent
	public void onTickClient(TickEvent.ClientTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			doGlobalTick(event);
		}
	}
	
	@SubscribeEvent
	public void onTickServer(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			doGlobalTick(event);
		}
	}
	
	private void doGlobalTick(TickEvent event) {
		tickCount++;
		if (tickCount % 2 == 0) {
			FissureItem.attemptFissure();
		}
		
	}

}
