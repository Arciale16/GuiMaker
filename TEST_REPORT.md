# Test report

Clean compilation: Java 21 `javac --release 8` against Spigot API 1.8.8. Produced classes are major version 52.

Automated suite: 24 JUnit tests passed. It covers legacy action migration/backup, deterministic YAML round-trip for all six click types, acceptance save/reload/ordered dispatch, direct runtime sequencing with delay and WAIT, stop-on-failure, disabled actions, OP restoration, placeholder expansion, cooldown keys, click mapping and double-click protection, action parsing, invalid chance/server-name rejection, malformed action isolation, duplicate identity, lore/material compatibility, pagination, and variables.

Final runtime startup smoke tests passed:
- PaperSpigot 1.8.8 build 445 on Temurin Java 8u502: plugin enabled and server reached `Done`.
- Paper 1.21.11 build 130 on Temurin Java 21.0.12: Paper remapped the legacy plugin, plugin enabled, and server reached `Done`.

Live PaperSpigot console verification also executed `zgui version`, `zartragui version`, `guimaker version`, `zgui create actionaccept`, and `zgui save` successfully. A connected Minecraft client is only required to physically operate the inventory GUI; all non-client action persistence and dispatch behavior is covered above.