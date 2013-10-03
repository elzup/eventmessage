package elzzup.mods.eventmessage;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "elzzupEventMessage", name = "EventMessage", version = "v1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class EventHandlerMessageCore {
	public EventHandlerMessageCore () {
		MinecraftForge.EVENT_BUS.register(new EventHandlerMessage());
	}
}