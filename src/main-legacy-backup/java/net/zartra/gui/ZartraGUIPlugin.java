package net.zartra.gui;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public final class ZartraGUIPlugin extends JavaPlugin {
    private MenuManager menus; private ChatInputManager inputs;
    public void onEnable() {
        saveDefaultConfig(); saveResource("messages.yml", false);
        inputs = new ChatInputManager(getConfig().getLong("chat-input-timeout-seconds", 60));
        menus = new MenuManager(new MenuStorage(new File(getDataFolder(), "menus"), getLogger()));
        GuiEditor editor = new GuiEditor(this, menus);
        ZGuiCommand command = new ZGuiCommand(this, menus, editor);
        PluginCommand zgui = getCommand("zgui"); zgui.setExecutor(command); zgui.setTabCompleter(command);
        getServer().getPluginManager().registerEvents(new GuiListener(this, menus, editor), this);
    }
    public void onDisable() { if (inputs != null) inputs.clear(); try { if (menus != null) menus.saveAll(); } catch (Exception e) { getLogger().warning("Could not save menus: " + e.getMessage()); } }
    public ChatInputManager inputs() { return inputs; }
}
