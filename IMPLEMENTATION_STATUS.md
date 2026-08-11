# ZartraGUI action-pipeline verification

Implemented and verified in source/tests: persisted ordered `ActionEntry` lists for LEFT, RIGHT, SHIFT_LEFT, SHIFT_RIGHT, MIDDLE and NUMBER_KEY; v1 single-action migration with a `.pre-action-migration.bak` copy; registry-backed action dispatch; main-thread chaining with per-action delay and WAIT; chance, enabled, stop-on-failure, cooldown, disconnect, recursion and double-click safeguards; and the in-game list/detail action editor.

The obsolete `MenuItem.action` value is a load-only migration bridge. It is cleared before runtime dispatch and v2 saving.

The automated acceptance test creates two ordered actions, saves the menu, reloads it, and executes the reloaded list in order through `ActionExecutor`. Physical inventory interaction remains the only verification requiring a connected Minecraft client.