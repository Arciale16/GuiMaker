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

