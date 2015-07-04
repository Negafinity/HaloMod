package halocraft;

import org.lwjgl.input.Keyboard;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBindings {

    public static KeyBinding scope;
    public static KeyBinding fire;
    public static void init() {
        scope = new KeyBinding("Bring up Scope for Battle Rifle", Keyboard.KEY_Z, "key.categories.HaloCraft 2.0");
        fire = new KeyBinding("Fires Guns on Halo Vehicles", Keyboard.KEY_F, "key.categories.HaloCraft 2.0");
        ClientRegistry.registerKeyBinding(scope);
        ClientRegistry.registerKeyBinding(fire);
    }

}