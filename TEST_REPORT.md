# Test report

## Automated verification

Clean compilation: `javac --release 8` against Spigot API 1.8.8 completed successfully. JUnit 4: **69 tests, 0 failures**. The packaged `ZartraGUIPlugin` class is **major version 52**.

## Runtime matrix

The same 142191-byte JAR was placed in separate isolated Paper directories. Every row reached completed server startup, loaded/enabled ZartraGUI, accepted `zgui version` and `zgui reload`, and cleanly disabled/stopped without a plugin exception.

| Minecraft / Paper build | Java executable | Status | Notes |
|---|---|---|---|
| 1.8.8 / PaperSpigot-445 | `C:\Program Files (x86)\Common Files\Oracle\Java\java8path\java.exe` | SUPPORTED_AND_TESTED | Startup, enable, commands, reload, shutdown. |
| 1.12.2 / Paper-1620 | `C:\Users\ender\Documents\ZartraGUI\target\runtimes\temurin11\jdk-11.0.32+9-jre\bin\java.exe` | SUPPORTED_AND_TESTED | Startup, enable, commands, reload, shutdown. |
| 1.13.2 / Paper-657 | `C:\Users\ender\Documents\ZartraGUI\target\runtimes\temurin11\jdk-11.0.32+9-jre\bin\java.exe` | SUPPORTED_AND_TESTED | Startup, enable, commands, reload, shutdown. |
| 1.16.5 / Paper-794 | `C:\Users\ender\Documents\ZartraGUI\target\runtimes\temurin16-valid\jdk-16.0.2+7\bin\java.exe` | SUPPORTED_AND_TESTED | Startup, enable, commands, reload, shutdown. |
| 1.18.2 / Paper-388 | `C:\Users\ender\Documents\ZartraGUI\target\runtimes\temurin17-valid\jdk-17.0.20+8-jre\bin\java.exe` | SUPPORTED_AND_TESTED | Startup, enable, commands, reload, shutdown. |
| 1.20.4 / Paper-499 | `C:\Program Files\Eclipse Adoptium\jdk-21.0.12.8-hotspot\bin\java.exe` | SUPPORTED_AND_TESTED | Startup, enable, commands, reload, shutdown. |
| 1.21.4 / Paper-232 | `C:\Program Files\Eclipse Adoptium\jdk-21.0.12.8-hotspot\bin\java.exe` | SUPPORTED_AND_TESTED | Startup, enable, commands, reload, shutdown. |
| 1.21.11 / Paper-130 | `C:\Program Files\Eclipse Adoptium\jdk-21.0.12.8-hotspot\bin\java.exe` | SUPPORTED_AND_TESTED | Startup, enable, commands, reload, shutdown. |

## Functional evidence and safe fallbacks

The 69 deterministic tests cover persistence/migration, alias normalization, command target states, world ALL/WHITELIST/BLACKLIST evaluation, menu conditions/variables/placeholders, pagination, protected preview, inventory safety, Java-8 compatibility, PLAYER_COMMAND dispatch and optional-provider absence. Server smoke confirms descriptor parsing, registration, enable/reload/disable paths on every matrix version. A connected authenticated client was not available, so physical GUI click-by-click interaction is externally unverified; no version claim relies on a missing client or optional provider. Missing Vault, PlaceholderAPI, Multiverse-Core, HeadDatabase or PlayerPoints providers degrade safely.

## Artifact verification

- `target/ZartraGUI.jar` and `dist/ZartraGUI.jar`: byte-identical.
- Size: 142191 bytes.
- SHA-256: `55360AE53D164C186A280C1B269C3A53BF0EFE6A1A66C7635AB128A553248139`.
- Java class major version: 52.
## Latest improvement verification

73 deterministic tests pass. The final updated JAR passed a fresh PaperSpigot 1.8.8 / Java 8u431 enable, zgui version, zgui reload, and clean-disable smoke test. Inventory capability discovery is deterministic against the compiled legacy API; physical special-container interaction remains externally unverified without an authenticated client.


## Reproduced issue fixes

77 tests pass. Final JAR passed Paper 1.21.11 build 130 / Java 21 startup plus gui version, gui reload, and clean disable. The server-side harness verifies descriptor registration and container adapter classification; a connected authenticated client was unavailable, so physical special-container clicks remain externally unverified.


## Editor regression verification

80 tests pass. Final JAR passed Paper 1.21.11 build 130 / Java 21 enable, gui version, and clean disable. The event-path test asserts current/cursor cloning precedes GUI transition. Physical client special-slot clicks remain externally unverified because no authenticated client was available.


## Move/reset and variant-preservation verification (2026-08-13)

- 83 deterministic tests passed after Java 21 --release 8 compilation against spigot-api-1.8.8.jar (test runtime also used local SnakeYAML, Guava and Commons Lang dependencies).
- Final artifact: 149248 bytes; SHA-256 41D95FBD8AFC8016D8617210613101972A59A07F011DF632F71B1D283EEEC354; class major version 52; 	arget/ZartraGUI.jar and dist/ZartraGUI.jar are byte-identical.
- PaperSpigot-445 / Minecraft 1.8.8 / Java 8u431: fresh startup, ZartraGUI enable, complete startup and plugin disable passed.
- Paper 1.21.11 build 130 / Java 21.0.12: fresh startup and ZartraGUI enable passed. The supplied console stop command triggered a Paper 1.21.11 command-context NullPointerException after startup; this is server-console shutdown infrastructure, not a ZartraGUI exception. The isolated process was then terminated. No authenticated player was attached, so physical GUI clicking remains externally unverified.
- Editor coverage: colored/legacy variant material, amount and data copy; right-click removal; shift-left move; occupied-slot Swap/Replace/Cancel; reset-content lime/red confirmation; and undo checkpoints.


## Lossless variants and natural editor regression verification (2026-08-13)

- 86 deterministic tests passed after Java 21 --release 8 compilation against the Spigot 1.8.8 API.
- Item templates now persist Bukkit ItemStack.serialize() output as stack-snapshot, retain the existing structured legacy fields, and reconstruct with ItemStack.deserialize() before applying explicit edits. This preserves modern material identities and serializable metadata when running on Paper 1.21.11; legacy fallback retains type, amount and durability.
- The Visual Editor uses cancelled, virtual click/drag transactions with a virtual cursor. Normal left/right clicks, stack swaps, partial pickup/placement, external-template removal, drag updates and middle-click item settings are routed without consuming player inventory.
- PaperSpigot-445 / Minecraft 1.8.8 / Java 8u431: startup, ZartraGUI enable, complete startup and plugin disable passed.
- Paper 1.21.11 / build 130 / Java 21.0.12: the isolated process remapped and initialized ZartraGUI but exited before the server's complete-startup line and without a ZartraGUI stack trace. This smoke attempt is UNVERIFIED; an authenticated client was not available for physical BLUE_WOOL interaction.
- Artifact: 151061 bytes, SHA-256 3E5C11EC2AB589E6047542728F673CA4F17563E17CFC4A773DA36276A0F4BE73, class major version 52; target and dist artifacts are byte-identical.


## Live transfer and right-click editor regression verification (2026-08-13)

- 89 deterministic tests passed after Java 21 --release 8 compilation against Spigot API 1.8.8.
- Visual Editor sessions now snapshot the player inventory/armor/held slot, transfer live lower-inventory stacks visually into the session, and restore the snapshot idempotently on save, cancel and disconnect. Top configured-stack right-click opens Item Settings; left click/drag remains transactional inventory editing.
- PaperSpigot-445 / Minecraft 1.8.8 / Java 8u431: complete startup, ZartraGUI enable and clean disable passed.
- Paper 1.21.11 build 130 / Java 21.0.12: two isolated runs completed plugin remapping and normal server initialization through legacy-material initialization but did not reach plugin enable before their 45s/55s observation limits; no ZartraGUI error occurred. Status: UNVERIFIED. No authenticated client was available, so physical blue-wool transfer/right-click verification is explicitly unverified.
- Artifact: 152543 bytes, SHA-256 F0C1FCD97B3C0D21A1EC18DBEAC1EF3D7DED5D5BA6DD46C17189B377BB17EB9A, Java class major version 52; target and dist are byte-identical.


## Colored snapshot and terracotta-control verification (2026-08-13)

- 92 deterministic tests passed after a clean Java 21 --release 8 compile against Spigot API 1.8.8.
- Root cause fixed: after successful Bukkit ItemStack.deserialize(), MenuItem.stack() was applying stored legacy setType and setDurability, allowing modern color identity to be overwritten by legacy/default data. The deserialized snapshot is now authoritative; legacy material/data is only used if snapshot restoration fails.
- Reset Content uses LIME_TERRACOTTA/RED_TERRACOTTA where available and STAINED_CLAY with data 5/14 on legacy servers. Routing continues to use protected slot identity, not icon material.
- PaperSpigot-445 / Minecraft 1.8.8 / Java 8u431: complete startup, ZartraGUI enable and clean disable passed.
- Paper 1.21.11 build 130 / Java 21.0.12: isolated startup remapped ZartraGUI and reached normal Paper bootstrap/legacy-material initialization, but not plugin enable within a 58-second observation window; no plugin error was logged. Status: UNVERIFIED. No authenticated client was available, so physical BLUE_WOOL and terracotta display verification remains unverified.
- Artifact: 152484 bytes, SHA-256 57435D356C8E5E1CE206A804EC9792727FC7D69012633CDA943E007F51948AD0, class major version 52; target and dist artifacts are byte-identical.


## Leather armor color picker verification (2026-08-13)

- 98 deterministic tests passed after clean Java 21 --release 8 compilation against the Spigot 1.8.8 API.
- Leather capability is checked through metadata setColor/getColor reflection, not a material-name heuristic. The picker provides 16 named families with pale/light/standard/dark/deep variants (80 presets), paginated dyed-leather previews, RGB and HEX input, default reset, preview-only selection, Apply/Cancel and one history checkpoint at Apply.
- Persisted fields: leather-color and leather-default; color changes update the Bukkit item snapshot while retaining item configuration/actions/conditions.
- PaperSpigot-445 / Minecraft 1.8.8 / Java 8u431: complete startup, ZartraGUI enable and clean disable passed.
- Paper 1.21.11 build 130 / Java 21.0.12: isolated server remapped ZartraGUI and completed normal Paper bootstrap through legacy-material initialization, but did not reach plugin enable within 58 seconds; no ZartraGUI error was logged. Status: UNVERIFIED. No authenticated client was available, so physical picker interaction remains unverified.
- Artifact: 158377 bytes, SHA-256 988EE0A918BD5E6248C4155DEFE2B79D134F166B2841C1E680FC3547C9FEDF07, class major version 52; target and dist are byte-identical.


- Interactive chat RGB picker: deterministic palette/session/source coverage added; physical chat-component clicking remains externally unverified without an authenticated client.


### Interactive chat RGB picker verification (2026-08-14)
- Automated: 105 tests passed, 0 failures; Java 21 compiler with --release 8 and the Spigot 1.8.8 API.
- Paper 1.21.11 build 130 (c5a2736), Java 21.0.12: final JAR remapped, enabled with the internal _zgui_picker command registered, and disabled cleanly with no ZartraGUI exception.
- PaperSpigot 1.8.8 build 445, Java 8: final JAR loaded; this isolated server did not finish world preparation before the controlled stop, so plugin enable and physical chat clicking are UNVERIFIED for this run.
- No authenticated Minecraft client was attached; physical inventory/chat component clicking is externally unverified. Palette, token/session validation, apply/cancel state routing and persistence source paths are covered deterministically.


### RGB picker regressions (2026-08-14)
- 112 automated tests passed, 0 failures. Coverage includes component-only delivery/no debug string fallback, hover/click component construction, safe unavailable-sender return, legacy color approximation, terracotta/stained-clay/wool confirmation source paths, and provisional RGB/HEX/chat state routing.
- Paper 1.21.11 build 130 (c5a2736) on Java 21.0.12: final artifact enabled and disabled cleanly.
- PaperSpigot 1.8.8 build 445 on Java 8: this run loaded the final JAR but did not reach complete startup before the controlled stop; enablement remains UNVERIFIED in this isolated runtime.
- No authenticated player was available; physical spectrum rendering, hover/click behavior and confirmation icons remain externally unverified.

