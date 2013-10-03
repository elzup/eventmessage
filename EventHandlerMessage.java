package elzzup.mods.eventmessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

public class EventHandlerMessage {
	//SleepInBed Event
	@ForgeSubscribe
	public void MessagePlayerSleepInBed(PlayerSleepInBedEvent event) {
		String tx = "";
		switch ((int) (Math.random() * 4)) {
		case 0:
			tx = "( ˘ω˘ )ｽﾔｧ";
			break;
		case 1:
			tx = "(:3[    ]";
			break;
		case 2:
			tx = "-_- zzz";
			break;
		case 3:
			tx = "『ていうか もう寝よう』";
			break;
		}
		event.entityPlayer.addChatMessage(event.entityPlayer.getEntityName() + EnumChatFormatting.AQUA + " [inBed] "
				+ EnumChatFormatting.WHITE + tx);
	}

	//PlayerKillingMob Event
	@ForgeSubscribe
	public void MessageLivingDeathEvent(LivingDeathEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) (event.source.getEntity());
			String tn = event.entityLiving.getEntityName();
			String aw = event.source.getSourceOfDamage().getEntityName();
			player.addChatMessage(player.getEntityName() + EnumChatFormatting.GOLD + "[Kill]-> "
					+ EnumChatFormatting.WHITE + tn);
		}
	}

	//PlayerDamagedAnd atleastLife Event
	@ForgeSubscribe
	public void MessageLivingHurtEvent(LivingHurtEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) (event.entityLiving);
			float life = player.getHealth() - event.ammount;
			if (0 < life && life < 5.0)
				player.addChatMessage(player.getEntityName() + EnumChatFormatting.DARK_RED + "[Pinchi] " + EnumChatFormatting.RED + "<LIFE: " + (int) life + ">");
		}
	}

	//PlayerFall Event
	@ForgeSubscribe
	public void MessageLivingFallEvent(LivingFallEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) (event.entityLiving);
			float dist = event.distance;
			if (dist > 4.0) {
				player.addChatMessage(player.getEntityName() + EnumChatFormatting.GREEN + "[Diving] " + String.format("%.2f", dist) + "m");
			}
		}
	}
}
