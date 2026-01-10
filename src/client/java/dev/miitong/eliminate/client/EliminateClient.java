package dev.miitong.eliminate.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EliminateClient implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("Eliminate");
    public static boolean DEBUG = false;
    public static int CULLED_COUNT = 0;
    public static int TOTAL_CHECKED = 0;
    private int tickCounter = 0;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (DEBUG && client.player != null) {
                tickCounter++;
                if (tickCounter >= 20) {
                    String message = "Eliminate Debug: Checked " + TOTAL_CHECKED + ", Culled " + CULLED_COUNT + " objects/sec";
                    
                    client.player.sendMessage(Text.literal(message).formatted(Formatting.YELLOW), true);
                    
                    LOGGER.info(message);
                    
                    tickCounter = 0;
                    CULLED_COUNT = 0;
                    TOTAL_CHECKED = 0;
                }
            } else {
                CULLED_COUNT = 0;
                TOTAL_CHECKED = 0;
            }
        });
    }
}
