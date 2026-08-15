# Implementation status

## Release scope

This release supports Paper/Spigot **1.8.8 through 1.21.11**. It deliberately does not claim 26.x support. The Java-8-targeted compatibility adapters, reflection isolation and legacy-safe CHEST inventory strategy are retained for future releases.

## Completed implementation

- Menu Configuration: title, safe CHEST capacities, compatible inventory-type screen, permissions, aliases, command-target modes, world access, integrations, persistence/migration, and visual-editor continuation.
- Dynamic aliases: persisted registration, conflict detection, safe command-map unregistration, player execution, reload/startup refresh and disable cleanup.
- Runtime policy: normal opening enforces opening permission, ALL/WHITELIST/BLACKLIST world policy and conditions; preview is protected and non-executing.
- Optional integrations: reflection-only Vault, PlaceholderAPI, Multiverse-Core, HeadDatabase and PlayerPoints adapters; providers are optional and not packaged.
- Compatibility: no NMS/CraftBukkit imports; production classes compile against Spigot 1.8.8 API as Java class major 52.

## Final artifact

`target/ZartraGUI.jar` and `dist/ZartraGUI.jar` are byte-identical: 142191 bytes; SHA-256 `55360AE53D164C186A280C1B269C3A53BF0EFE6A1A66C7635AB128A553248139`.
## Latest improvements

Unified manager-to-configuration navigation preserves list context. Alias execution now supports immediate registration and target modes. InventoryCompat centrally classifies runtime InventoryType values, preserves unknown persisted IDs and enforces fixed capacities for special adapters.


## Special inventory and item safety fixes

Supported runtime layouts include special Bukkit containers via centralized InventoryCompat adapters. Visual editing uses the selected container topology and protection listener. Valid material IDs resolve through the running Material registry; unknown raw IDs are retained and do not overwrite data with STONE. /gui shares the root command executor/completer and is reserved from dynamic aliases.


## Editor click and special-slot authoring

InventoryClickEvent handling now deep-clones source stacks before editor transitions and never substitutes an editor control for the selected item. Every visible supported special-container slot is authorable through cancelled server-side placement; templates persist independently of vanilla input restrictions.


## Latest editor completion

Configured item templates retain the raw material ID, legacy data value and amount. The visual editor now uses left-click for item actions, right-click to remove with undo, and shift-left to move. Occupied destinations use Swap, Replace or Cancel confirmation. Menu Configuration provides Reset Content; it clears only item slots after a lime/red confirmation and is undoable. The artifact is Java-8 bytecode (major 52), 149248 bytes, SHA-256 41D95FBD8AFC8016D8617210613101972A59A07F011DF632F71B1D283EEEC354.


## Natural editing and lossless item snapshots

The editor now persists a lossless Bukkit stack snapshot in addition to portable legacy fields. On a running modern server this retains the exact material identity and serializable metadata, avoiding reconstruction of BLUE_WOOL as legacy WOOL. The editing surface uses a virtual cursor and transaction controller: left/right pickup/place, natural swaps, partial stacks and drags update only the unsaved template; real player inventory is not consumed. Middle-click opens item settings. Class bytecode remains Java 8 compatible (major 52).


## Live editor-session transfer and right-click editing

A Visual Editor session snapshots the administrator's inventory, armor and held slot. During the session, lower-inventory pickup/place updates the displayed session inventory and a virtual cursor atomically, while the configured template receives an exact cloned ItemStack. The snapshot is restored idempotently when the session ends. Right-click on a configured top slot now opens Item Settings without mutating the item; ordinary left-click and drag remain normal editing gestures.


## Colored variant reconstruction and terracotta reset controls

Bukkit serialized snapshots are authoritative when restoration succeeds: MenuItem no longer applies legacy material or durability over a deserialized modern item. This keeps modern materials such as BLUE_WOOL and LIME/RED_TERRACOTTA exact, while the portable legacy fallback still retains 1.8.8 variant data. Reset Content now renders LIME_TERRACOTTA and RED_TERRACOTTA, falling back to lime/red STAINED_CLAY data 5/14 only on legacy servers.


## Leather armor color picker

Item Settings now exposes Leather Color only when the item's metadata supports color. The in-game paginated picker has 80 dyed-leather preset swatches, arbitrary RGB and HEX entry, default reset, selected preview, Apply/Cancel and undo-compatible application. It stores explicit color/default state, preserves the serialized item snapshot and leaves actions, conditions and other metadata intact.


- Interactive Chat RGB Color Picker: implemented with reflection-only component compatibility, secure per-player sessions, palette navigation, provisional selection, Apply/Cancel/back routes and legacy display fallback.


Chat picker controls are served only through the hidden _zgui_picker <opaque-token> <bounded-action> descriptor. The token is random, expires after five minutes, is scoped to the initiating UUID, and contains no menu/slot/RGB data. Apply delegates to the existing lossless leather capture path and creates one checkpoint; navigation/cancel does not.


- Regression repair: removed the unsafe chat component 	oString() fallback; sender validates Player.Spigot#sendMessage(BaseComponent[]) reflectively and fails back to the inventory picker. RGB/HEX modal transitions now preserve provisional leather state. Confirmation factory covers delete and save/finish UI with LIME/RED_TERRACOTTA plus STAINED_CLAY/WOOL data fallbacks.


- Confirmation controls standardized to EMERALD/REDSTONE/BARRIER without legacy data values. Leather picker inventory replacements now carry a transition guard so provisional state survives page/modal navigation. Virtual lower-inventory shift-click now merges/fills editor slots deterministically and reverse transfer uses the virtual player inventory.


- Restored Item Appearance leather-color control: stable LeatherArmorMeta detection plus exact legacy leather-piece fallback. Added coverage for top/bottom virtual movement routes and complete leather capability.


- Item Appearance now has a configured-item leather fallback in addition to runtime metadata detection. MenuItem runtime copies preserve leatherDefault; complete ItemStack snapshots stay authoritative for modern materials.


- Replaced conditional Leather Color layout gate with unconditional fixed slot 12 renderer and shared click mapping. Added build.properties identity, startup build logging, and expanded /gui version runtime diagnostics.



## Runtime-opaque editor item transactions

The Visual Editor creates MenuItem.runtime session entries from cloned event stacks. It retains a transient runtime clone for display/movement and serializes the complete stack only when MenuStorage saves. This prevents current Paper materials from being routed through legacy resolver fallback while preserving the existing cross-version persistence fallback.

## Immutable physical editor click capture

Visual Editor click handling now captures the event stack and cursor clones, raw slot, clicked-inventory-relative slot and clicked-inventory identity before cancellation. Lower Shift-click transfer exclusively uses that capture and updates the player inventory with the relative bottom slot; raw view slots are never passed to PlayerInventory.

## Live lower inventory authority

EditorSession snapshots protected original contents, armor, held slot and cursor before opening the editor. Live PlayerInventory is the sole lower editing state; lower-to-top, normal cursor actions and top-to-lower Shift transfers mutate it directly while the snapshot remains immutable for exactly-once restoration.
## Modern Paper material-mode repair (Build 1.1.6-20260815)

ZartraGUI declares `api-version: '1.13'` in its packaged `plugin.yml`. This prevents Paper 1.21.11 from classifying it as a legacy plugin and avoids pre-handler legacy material translation. The same JAR was verified to load on PaperSpigot 1.8.8, which ignores the descriptor field.

Safe deployment: fully stop the server, replace `plugins/ZartraGUI.jar`, remove only Paper's cached/remapped ZartraGUI copy if that Paper build creates one, then restart. Do not use `/reload`; never delete worlds, plugin configuration, or unrelated plugin cache entries. Confirm the startup Build ID and `Declared API version=1.13; Legacy material mode active=false` before testing modern items.
