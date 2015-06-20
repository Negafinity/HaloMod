package halocraft;

import org.lwjgl.input.Keyboard;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBindings {

    // Declare two KeyBindings, ping and pong
    public static KeyBinding scope;
    public static KeyBinding fire;
    public static void init() {
        // Define the "ping" binding, with (unlocalized) name "key.ping" and
        // the category with (unlocalized) name "key.categories.mymod" and
        // key code 24 ("O", LWJGL constant: Keyboard.KEY_O)
        scope = new KeyBinding("Bring up Scope for Battle Rifle", Keyboard.KEY_Z, "key.categories.HaloCraft 2.0");
        fire = new KeyBinding("Fire Rocket on Scorpion", Keyboard.KEY_F, "key.categories.HaloCraft 2.0");
        ClientRegistry.registerKeyBinding(scope);
        ClientRegistry.registerKeyBinding(fire);
    }

}