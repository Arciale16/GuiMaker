# ZartraGUI

ZartraGUI is a Java 8-bytecode Paper/Spigot menu-authoring plugin compiled against the Spigot 1.8.8 API. This release is runtime-verified on Paper 1.8.8 through Paper 1.21.11 with one JAR, without NMS or CraftBukkit version imports.

Use `/zgui` (aliases `/zartragui`, `/guimaker`) as a player to open the authoring dashboard. Menu Configuration includes title, a cross-version CHEST inventory type selector, 9/18/27/36/45/54 capacities with safe resize protection, opening permissions, command target modes, world access lists, aliases, integration status, save/reload and visual-editor continuation. Dynamic aliases are persisted, conflict-checked, registered through the Bukkit command map, and cleanly unregistered on disable.

Optional Vault, PlaceholderAPI, Multiverse-Core, HeadDatabase and PlayerPoints support is reflection-only and never bundled. Missing providers safely disable only their related action/condition behavior.

Final artifact: `target/ZartraGUI.jar` and `dist/ZartraGUI.jar`, byte-identical, 142191 bytes, SHA-256 `55360AE53D164C186A280C1B269C3A53BF0EFE6A1A66C7635AB128A553248139`, class major version 52. See `IMPLEMENTATION_STATUS.md` and `TEST_REPORT.md` for evidence and limitations.