package growthcraft.apples;

import growthcraft.apples.renderer.RenderApple;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void initRenders()
	{
		RenderingRegistry.registerBlockHandler(new RenderApple());
	}
}
