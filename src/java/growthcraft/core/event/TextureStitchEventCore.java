package growthcraft.core.event;

import growthcraft.core.GrowthCraftCore;
import net.minecraftforge.client.event.TextureStitchEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TextureStitchEventCore 
{
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onTextureStitchPre(TextureStitchEvent.Pre event)
	{
		if (event.map.getTextureType() == 0) 
		{
			GrowthCraftCore.liquidSmoothTexture = event.map.registerIcon("grccore:liquidsmooth");
			GrowthCraftCore.liquidBlobsTexture = event.map.registerIcon("grccore:liquidblob");
		}

	}
}
