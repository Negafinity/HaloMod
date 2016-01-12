package com.arisux.xlib;

import com.arisux.xlib.api.wavefrontapi.WavefrontAPI;
import net.minecraft.client.Minecraft;

public class XLib
{
	public static XLibLogger logger()
	{
		return XLibLogger.instance();
	}
	
    public static Minecraft game()
    {
        return Minecraft.getMinecraft();
    }
    
    public static WavefrontAPI wavefrontAPI()
    {
    	return WavefrontAPI.instance();
    }

    /**
     * Returns if the current Minecraft installation is running
     * in a development environment or normal environment.
     *
     * @return Returns true if in a dev environment. Returns false if other.
     */
    public static boolean isDevEnvironment()
    {
        return (Boolean) net.minecraft.launchwrapper.Launch.blackboard.get("fml.deobfuscatedEnvironment");
    }
}
