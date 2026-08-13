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

