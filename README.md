# ZartraGUI

ZartraGUI is a Java 8 bytecode Paper/Spigot menu-authoring plugin built against the Spigot 1.8.8 API. It supports Paper 1.8.8 through modern Paper without NMS or CraftBukkit-version imports.

Use `/zgui` (aliases: `/zartragui`, `/guimaker`) as a player to open the authoring dashboard. The editor includes menu list pagination, visual item editing, material/name/lore/enchantment/flag controls, click-type action pipelines, nested success/failure actions, action and opening conditions, lifecycle open/close actions, pagination/filler controls, preview, confirmations, clipboard, and bounded undo/redo. Console administration supports `version`, `create`, `save`, and `reload`, along with the remaining documented `/zgui` subcommands.

Build verification uses `javac --release 8` against the 1.8.8 API. The final JAR is available at `target/ZartraGUI.jar` and `dist/ZartraGUI.jar`; both are identical Java major-version-52 artifacts. Optional Vault and PlaceholderAPI integrations are reflection-based and are not bundled.

See `IMPLEMENTATION_STATUS.md` for completed behavior and `TEST_REPORT.md` for the 52-test and cross-version runtime evidence.

/zgui open <menu-id> (and the zartragui/guimaker aliases) opens a normal runtime menu for a player. /zgui preview <menu-id> opens a protected, non-executing rendering for inspection. Text and numeric editor fields use modal chat input: the GUI closes before the prompt and returns to the originating editor after completion or cancellation.


For %server%, set optional server-name in config.yml; otherwise ZartraGUI safely resolves a compatible server name and falls back to server. PLAYER_COMMAND action values are stored without leading slashes; both legacy /command and canonical command values are accepted at runtime.
