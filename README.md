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


## Exact colored variants

On modern Paper, a successfully restored Bukkit item snapshot is authoritative and is not rewritten from legacy material/data fields; colored modern blocks retain their exact identity. Reset Content presents **LIME_TERRACOTTA** to confirm and **RED_TERRACOTTA** to cancel, with lime/red legacy stained-clay fallbacks on 1.8.8.


## Leather Color Picker

Right-click a leather armor template, then choose **Leather Color** in Item Settings. The picker provides paginated pale/light/standard/dark/deep presets across 16 families, exact RGB (R,G,B) and HEX (#RRGGBB) entry, Reset to Default, preview, Apply and Cancel. Selections stay preview-only until Apply and are retained through save/reload along with the item’s other configuration.


## Interactive Chat RGB Color Picker
Leather item settings > Leather Color Picker now includes **Chat Color Picker**. It opens a clickable 30-hue spectrum and 8x8 shade palette. Modern servers display exact RGB chat colours; legacy clients receive a nearest-colour preview while the applied leather RGB stays exact. Buttons carry opaque per-player, five-minute session tokens; Apply is the only operation that creates an undo checkpoint.


The chat palette has Full Spectrum, hue next/previous navigation, 8x8 shade/saturation selection, preview, Apply, Choose Another Color, Back to Inventory Picker, Default Leather Color, and Cancel. On 1.16+ it requests exact hex chat colours when available; on 1.8.8-1.15 clients it shows an explicitly approximate chat preview while preserving exact RGB leather metadata.


### RGB picker regression repair
Chat components are delivered only through the component-aware sender; unsupported transports return safely to the inventory picker and never print component debug data. Leather preset/RGB/HEX/chat transitions keep the same provisional selection until Apply or Cancel. All destructive confirmation controls use lime/red terracotta, with legacy stained-clay or wool data values.


### Editor reliability updates
All confirmation screens use EMERALD for confirmation, REDSTONE for destructive/no choices, and BARRIER for a third cancel/return choice. The inventory leather picker preserves one provisional selection through page changes and modal transitions. Shift-click transfers stacks through the virtual editor transaction, including special-inventory slots, without consuming the administrator's restored inventory.


### Leather appearance and movement repair
Item Appearance now reliably exposes Leather Color for all four leather armor pieces, using metadata-first capability detection with an exact legacy fallback. Virtual editor movement retains complete stack metadata and supports both shift-click directions without native special-container restrictions.


### Runtime material authority
Visual-editor transfers use the exact runtime ItemStack clone; successful Bukkit serialization/deserialization remains authoritative, so current-server materials are not passed through a legacy material allowlist. Item Appearance resolves leather color capability from the configured MenuItem as well as runtime metadata.


### Build identity and fixed appearance control
The plugin now reports build ID 1.1.3-20260814 at startup and through /gui version. Item Appearance always renders Leather Color in fixed slot 12 between Skull and Enchantments; click-time validation opens the picker only for leather-color-capable items.



Visual Editor transfers preserve the exact cloned runtime ItemStack during an active session. Modern Paper materials are accepted without legacy name conversion; their full Bukkit serialization is written only at Save. Administrators can inspect the last editor transaction with /gui debug editor.

Editor click transactions snapshot the physical event's stack, cursor, raw slot, clicked-inventory-relative slot, and source inventory before cancellation. This ensures Shift-clicks from player storage/hotbar use the actual runtime stack, not a later cleared slot. /gui debug editor exposes these immutable capture facts.