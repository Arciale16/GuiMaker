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

