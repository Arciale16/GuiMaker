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


### Confirmation, picker state and shift-transfer repair (2026-08-14)
- 115 automated tests passed, 0 failures; Java 8-target compilation passed. Regression coverage includes emerald/redstone confirmations, leather-picker close transition preservation, and deterministic virtual lower-to-top editor shift transfer.
- No authenticated player was available for physical GUI interaction; this remains externally unverified.


### Editor movement and leather control repair (2026-08-14)
- 117 automated tests passed, 0 failures; clean Java 8-target build passed. Physical client interaction was not available and remains externally unverified.


### Runtime-material and leather-render repair (2026-08-14)
- 120 automated tests passed, 0 failures; clean Java 8-target compilation passed. Coverage verifies authoritative serialized snapshots, no runtime shift-transfer legacy parser gate, and configured-item leather capability fallback. Physical client interaction remains externally unverified.


### Decisive appearance path replacement (2026-08-14)
- 120 tests passed, 0 failures; Java 8-target compilation passed. Packaged renderer contains fixed Item Appearance slot constants and unconditional Leather Color insertion. Authenticated physical click verification remains required.



## Runtime opaque editor transaction verification (2026-08-14)

- 121 deterministic tests passed, 0 failures after a clean Java 21 --release 8 compilation against the local Spigot 1.8.8 API.
- The physical regression branch was MenuItem.stack(): it deserialized stackSnapshot on each virtual-editor display/placement, allowing a failed legacy-era reconstruction to replace an accepted runtime stack. MenuItem.runtime now holds the event stack clone authoritatively until save; MenuStorage.writeItem serializes it only for persistence.
- /gui debug editor reports build ID, editor session, cursor material, last clicked material, branch, acceptance/rejection, refreshed slot, session material and visible material. Authenticated physical client confirmation on Paper 1.21.11 remains externally unverified in this workspace.

- Final artifact: 173470 bytes; SHA-256 43CA8E16A335B93282F829F567E80DA68C290CB08256AC2F07653306AC102869; target and dist are byte-identical; ZartraGUIPlugin is class major 52.
- Fresh isolated Paper 1.21.11 build 130 (c5a2736) on Java 21.0.12 reached complete startup, logged Build: 1.1.2-20260814, enabled ZartraGUI and reached Done without a ZartraGUI exception. The process was then stopped after the smoke observation.


## Physical editor click-capture verification (2026-08-14)

- Root cause of the reported lower_shift_rejected / null_or_air debug state: GuiService.shiftLowerToEditor read InventoryClickEvent.getCurrentItem() after the virtual handler cancelled the event. The result could already be AIR.
- EditorClickSnapshot now captures the physical event stack/cursor and coordinates before cancellation. Lower inventory actions use captured.current and captured.slot (the clicked bottom-inventory-relative slot), not raw view coordinates.
- 121 deterministic tests passed, 0 failures after clean Java 8-target compilation. Physical authenticated-client clicking remains externally unverified; Paper startup smoke is recorded separately.

- Final build 1.1.3-20260814: target/dist are byte-identical, 175166 bytes, SHA-256 C3988CEACB1489028DB9D8CD14E6794DDC14AF3B41CBDFAADFDEC1AAD784AA2C, class major version 52.
- PaperSpigot-445 / Minecraft 1.8.8 / Java 8u502: full startup and ZartraGUI 1.1.3 enable completed.
- Paper 1.21.11 build 130 (c5a2736) / Java 21.0.12: full startup, Build 1.1.3-20260814, ZartraGUI enable and Done completed with no ZartraGUI exception.


## Virtual lower-inventory transaction verification (2026-08-15)

- The confirmed Paper physical debug showed clicked inventory=BOTTOM, correct slot mapping, but ventCurrent=AIR. This is expected for the protected virtual editing view and cannot be an authoritative source.
- EditorSession now stores a deep-cloned irtualLower copy of the protected contents. Lower transactions use irtualLower(slot) first, the protected snapshot solely as preserved state, and non-AIR event current only as diagnostic fallback. Top-to-lower Shift transfer uses ddVirtualLower instead of PlayerInventory.addItem.
- 121 deterministic tests passed, 0 failures after clean Java 8-target compilation. Authenticated physical click confirmation remains externally unverified in this workspace.

- Final build 1.1.4-20260814: target/dist are byte-identical, 175989 bytes, SHA-256 6DDA55124839DEF22DDB10CF3C9DD42007FCF804B4A299424C1B1A2D95C10774, class major version 52.
- PaperSpigot-445 / Minecraft 1.8.8 / Java 8u502: full startup and ZartraGUI 1.1.4 enable completed.
- Paper 1.21.11 build 130 (c5a2736) / Java 21.0.12: full startup, build 1.1.4-20260814, ZartraGUI enable and Done completed without a ZartraGUI exception.


## Live PlayerInventory editor transactions (2026-08-15)

- Build 1.1.5-20260815 removes the independent virtual lower-inventory path. Editor opening deep-clones real storage, armor, held slot and cursor before the top canvas opens; lower operations read/write live Bukkit PlayerInventory and final exit restores that snapshot exactly once.
- Creative lower edits are cancelled and immediately synchronized into the live PlayerInventory. /gui debug editor identifies player game mode, resolved PlayerInventory slot, live/protected materials, independent virtual-lower=false, and restoration state.
- Deterministic suite: 123 tests passed, 0 failures. It verifies absence of virtualLower, deep snapshot creation, live lower reads/writes, Creative synchronization, and idempotent restoration. No authenticated client was available; physical GUI clicking and the requested server-side player/TUFF transaction harness remain externally unverified.
- PaperSpigot-445 / Minecraft 1.8.8 / Java 8u502: final JAR loaded, Build 1.1.5-20260815 enabled, Done reached, and clean plugin/server disable logged.
- Paper 1.21.11 build 130 (c5a2736) / Java 21.0.12: final JAR remapped/loaded, Build 1.1.5-20260815 enabled, Done reached, and clean plugin/server disable logged.
- Final artifact: target/ZartraGUI.jar and dist/ZartraGUI.jar byte-identical; 176217 bytes; SHA-256 6F2AB8C700DB2CEABCF1FA95AABA8E065B50A8AAF4360DDA4144659696E4F1B2; ZartraGUIPlugin class major version 52.

## Modern Paper legacy-material remapping repair (2026-08-15)

- Root cause confirmed: Build 1.1.5 had no `api-version`; Paper 1.21.11 logged `Legacy plugin ZartraGUI v1.1.5 does not specify an api-version` and initialized `CraftLegacy` before plugin enable.
- Build 1.1.6 packages `api-version: '1.13'` in source, target, and dist descriptors. Final Paper 1.21.11 build 130 / Java 21.0.12 logs no ZartraGUI legacy-plugin warning and no CraftLegacy initialization. It logs `Declared API version=1.13; Legacy material mode active=false; Runtime TUFF=TUFF/TUFF/TUFF/TUFF` from ZartraGUI's own classloader; the four values verify Material.valueOf, ItemStack type, clone type, and serialize/deserialize type.
- Direct bytecode audit: GuiService has no direct `org/bukkit/Material` Fieldref entries. Legacy-only GUI constants were replaced with CompatMaterial runtime-name resolution; the remaining production direct fields are cross-version AIR, BARRIER, PAPER, and STONE only.
- Exact final JAR startup: PaperSpigot-445 / Minecraft 1.8.8 / Java 8u502 loaded Build 1.1.6, reached Done, and cleanly disabled with no NoSuchFieldError/NoSuchMethodError. Its legacy API does not expose PluginDescriptionFile#getAPIVersion, so diagnostics report declared API `none` and TUFF unavailable while confirming plugin operation.
- 126 deterministic tests passed, including source/target/dist api-version package checks. Final artifacts are byte-identical: 177066 bytes; SHA-256 542396B8E9D13CE3EA9516C0D78D5AEFDD0E3598A32D1900D286AB32801CB1C6; class major version 52.
- No authenticated player was available in the isolated servers. The classloader-level TUFF probe is verified; physical player inventory → editor click → save/reload remains externally unverified.

## Paper 26.1.2 and 26.2 compatibility release (2026-08-15)

- **Build:** ZartraGUI 1.1.7, Build ID `1.1.7-20260815`; one JAR with `api-version: '1.13'`, class major version 52.
- **Deterministic suite:** 128 tests passed, 0 failures, including Paper 26 regression coverage for numeric multi-component server versions and the opt-in Bukkit main-thread command probe.
- **PaperSpigot 1.8.8 build 445 / Temurin 8u502-b07:** plugin discovered and enabled, server reached `Done`, `zgui version` and `zgui reload` worked, and plugin/server disabled cleanly.
- **Paper 1.21.11 build 130 (`c5a2736`) / Temurin 21.0.12+8:** plugin discovered and enabled, server reached `Done`, `zgui version` and `zgui reload` worked, modern material mode stayed disabled, and plugin/server disabled cleanly.
- **Paper 26.1.2 build 74 (`e4e17fc`) / Temurin 25.0.4+7 x64:** plugin discovered, descriptor parsed, enabled, reached `Done`, logged `Declared API version=1.13; Legacy material mode active=false; Runtime TUFF=TUFF/TUFF/TUFF/TUFF`; the Bukkit main-thread probe returned `zgui version=true; zgui reload=true`; reload completed and shutdown disabled ZartraGUI cleanly.
- **Paper 26.2 build 112 (`c9e894d`) / Temurin 25.0.4+7 x64:** the same lifecycle and main-thread probe passed. Direct dedicated-console commands without a slash (`zgui version`, `zgui reload`, `gui version`, `gui reload`, `stop`) also completed cleanly.
- **External console finding:** Paper 26.1.2's piped dedicated-console bridge threw `CommandSourceStack.getLevel() == null` for a no-slash command after `Done`; its trace contains no ZartraGUI frame. The equivalent Bukkit dispatcher invocation passed, so this is recorded as a Paper console-context limitation rather than a plugin failure.
- **Artifacts:** `target/ZartraGUI.jar` and `dist/ZartraGUI.jar` are byte-identical, 176723 bytes, SHA-256 `6BA26526F248F2D8B10699927EFF6E4C83CE502CD3B3958430F9E5753491C9DB`.
- **Physical-client scope:** no authenticated client was attached to the isolated 26.x runtimes. Startup, descriptor, command routing, reload and material probes are runtime-tested; physical GUI clicking on 26.x remains externally unverified.

## Public 1.0.0 release

ZartraGUI 1.0.0 (`1.0.0-20260816`) is the first public stable release. One Java-8-bytecode JAR targets Paper/Spigot 1.8.8–26.2; use the Java runtime required by your server. `build.ps1` is the authoritative build and embeds every `src/main/resources/**` file. On first startup it generates `config.yml` and `messages.yml` without overwriting existing user files.

Internal 1.1.7/1.1.8 candidates are withdrawn: their former custom packaging path omitted mandatory resources. The 1.0.0 artifact has 129 passing automated tests and verified root resources. Full final runtime/physical-client matrix verification was waived for this release; report reproducible issues with the [bug report template](.github/ISSUE_TEMPLATE/bug_report.yml), removing secrets and private information.
