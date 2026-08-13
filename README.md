# ZartraGUI

ZartraGUI is a Java 8-bytecode Paper/Spigot menu-authoring plugin compiled against the Spigot 1.8.8 API. This release is runtime-verified on Paper 1.8.8 through Paper 1.21.11 with one JAR, without NMS or CraftBukkit version imports.

Use `/zgui` (aliases `/zartragui`, `/guimaker`) as a player to open the authoring dashboard. Menu Configuration includes title, a cross-version CHEST inventory type selector, 9/18/27/36/45/54 capacities with safe resize protection, opening permissions, command target modes, world access lists, aliases, integration status, save/reload and visual-editor continuation. Dynamic aliases are persisted, conflict-checked, registered through the Bukkit command map, and cleanly unregistered on disable.

Optional Vault, PlaceholderAPI, Multiverse-Core, HeadDatabase and PlayerPoints support is reflection-only and never bundled. Missing providers safely disable only their related action/condition behavior.

Final artifact: `target/ZartraGUI.jar` and `dist/ZartraGUI.jar`, byte-identical, 142191 bytes, SHA-256 `55360AE53D164C186A280C1B269C3A53BF0EFE6A1A66C7635AB128A553248139`, class major version 52. See `IMPLEMENTATION_STATUS.md` and `TEST_REPORT.md` for evidence and limitations.
## Latest improvements

The GUI manager, command editor and creation flow now use one Menu Configuration route. Dynamic aliases refresh immediately after add/remove and support OPTIONAL/REQUIRED/DISABLED targets. Inventory type selection is runtime-discovered and classified; safe custom/special adapters are selectable and server-managed types are shown disabled.


## Special inventory and item safety fixes

/gui is a full alias of /zgui and cannot be claimed by a menu. The runtime inventory registry now routes supported special layouts through real Bukkit inventory containers. Item editor transitions use deep MenuItem copies and registry-aware material resolution, so a valid item is never silently replaced by STONE.


## Editor click and special-slot authoring

The editor captures cloned current/cursor stacks before changing screens. Special container placement is cancelled and written into ZartraGUI's template model, so native acceptance rules cannot consume or reject administrator template items. The selector uses version-aware representative block icons.


## Editor controls

In the Visual Editor, left-click a configured item to edit it, right-click to remove it (undo with Ctrl+drop), and shift-left it before left-clicking a destination to move it. An occupied destination presents Swap, Replace and Cancel. Menu Configuration includes **Reset Content**, which clears only configured slots after a lime/red confirmation while preserving title, inventory settings, permissions, aliases and other menu configuration.

Current artifact: 149248 bytes; SHA-256 41D95FBD8AFC8016D8617210613101972A59A07F011DF632F71B1D283EEEC354; Java class major version 52.


## Natural virtual editor

The Visual Editor now follows normal inventory gestures safely: left/right pickup and placement, swaps, partial stacks and drag distribution operate on a virtual template cursor, never consuming the administrator's inventory. Middle-click opens Item Settings. Each item also stores the server's Bukkit serialization snapshot alongside the portable fields, preserving modern variants and metadata such as BLUE_WOOL across save/reload where the running API supports serialization.


## Editor session safety

Opening the Visual Editor snapshots your inventory for the session. Moving an item from the lower inventory into the menu removes it visibly from the session source slot and keeps its exact Bukkit stack identity; closing, saving or cancelling restores your original inventory. Right-click a configured menu item to open Item Settings; left-click and drag are reserved for natural movement.

