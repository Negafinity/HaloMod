package halocraft;

import org.lwjgl.input.Keyboard;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBindings {

    // Declare two KeyBindings, ping and pong
    public static KeyBinding scope;
    public static void init() {
        // Define the "ping" binding, with (unlocalized) name "key.ping" and
        // the category with (unlocalized) name "key.categories.mymod" and
        // key code 24 ("O", LWJGL constant: Keyboard.KEY_O)
        scope = new KeyBinding("key.zoom", Keyboard.KEY_Z, "key.categories.gameplay");
        
        ClientRegistry.registerKeyBinding(scope);
    }

}