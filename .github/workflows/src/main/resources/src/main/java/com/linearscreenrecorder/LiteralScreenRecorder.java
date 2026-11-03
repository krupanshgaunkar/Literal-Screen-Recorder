package com.linearscreenrecorder;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class LiteralScreenRecorder implements ClientModInitializer {
    public static KeyBinding openGuiKey;

    @Override
    public void onInitializeClient() {
        // Register the 'N' key to open our mod features
        openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.literalscreenrecorder.open_gui",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_N,
            "category.literalscreenrecorder.main"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openGuiKey.wasPressed()) {
                // Future code to open GUI goes here!
            }
        });
    }
}
