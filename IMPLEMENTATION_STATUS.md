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