# ZartraGUI

ZartraGUI is a Java 8 bytecode Paper/Spigot menu authoring plugin built against the Spigot 1.8.8 API. Its `zgui`, `zartragui`, and `guimaker` commands manage persistent inventory menus with ordered click actions, scoped variables, conditions, pagination, refresh, optional Vault and PlaceholderAPI integration, and legacy/modern material adapters.

Build verification uses `javac --release 8` against the bundled 1.8.8 API. Optional integrations are reflection-based and are not bundled in the plugin JAR.

The current implementation checkpoint is tracked in `IMPLEMENTATION_STATUS.md`; reproducible verification and the requirement matrix are tracked in `TEST_REPORT.md`.