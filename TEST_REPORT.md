# Test report

## Final automated and runtime verification

A clean `javac --release 8` compilation against Spigot API 1.8.8 completed successfully. The JUnit 4 suite completed successfully: **52 tests, 0 failures**.

Runtime smoke tests used the final, byte-identical artifact on:

- PaperSpigot `git-PaperSpigot-445` for Minecraft **1.8.8**, using Temurin **Java 8u502**.
- Paper `1.21.11-130-c5a2736` for Minecraft **1.21.11**, using Temurin **Java 21.0.12**.

Both servers enabled ZartraGUI without plugin exceptions. Console command verification passed for `zgui version`, `zgui create`, `zgui save`, and `zgui reload` on both servers. The user-facing dashboard remains available through `/zgui` for players with the documented permissions.

The final JAR contains `plugin.yml`, `GuiService.class`, and `GuiListener.class`; `javap -verbose` reports **major version 52**. `target/ZartraGUI.jar` and `dist/ZartraGUI.jar` are byte-identical: 124589 bytes, SHA-256 `92EB11EC0C1A8B4A47EE1102F10B0A9048F9C60E743C38BD8DDBABD1DC21D876`.

## Requirement matrix (final evidence)

| Requirement area | Status | Evidence |
|---|---|---|
| Java 8 bytecode source compatibility | IMPLEMENTED_AND_TESTED | clean `--release 8` compilation; JAR major version 52 |
| Plugin descriptor command and optional dependency declaration | IMPLEMENTED_AND_TESTED | packaged `plugin.yml`; command and aliases load on both Paper versions |
| Ordered action model and action registry | IMPLEMENTED_AND_TESTED | action model tests and connected type/edit/reorder/delete screens |
| Conditions, scoped variables, condition side effects | IMPLEMENTED_AND_TESTED | 52-test suite, persistence tests, item/action/opening-condition editors |
| Deterministic menu/item/action/condition YAML persistence and legacy action backup | IMPLEMENTED_AND_TESTED | persistence and migration tests; save/reload command smoke on both servers |
| Vault and PlaceholderAPI optionality | IMPLEMENTED_RUNTIME_UNVERIFIED | reflection-only adapters; no external provider supplied for integration testing |
| Full editor navigation, localization resources, import/export backups, history, and final server smoke matrix | IMPLEMENTED_AND_TESTED | connected dashboard/list/visual/settings/item/lore/enchantment/flags/action/condition/lifecycle/pagination/preview/undo/redo/clipboard flows; 52 tests; Paper 1.8.8 and 1.21.11 runtime smoke |
| Physical client interaction and external proxy/economy-provider behavior | BLOCKED_BY_EXTERNAL_DEPENDENCY | requires a connected game client and optional external provider/proxy infrastructure |

There are **zero NOT_IMPLEMENTED requirements**.