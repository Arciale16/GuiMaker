package net.zartra.gui;
final class ConditionEntry { enum Type { HAS_PERMISSION, NOT_HAS_PERMISSION, HAS_LEVEL, MIN_LEVEL, MAX_LEVEL, IS_OP, IS_NOT_OP, GAMEMODE, WORLD, PLAYER_NAME, PLACEHOLDER_EQUALS, PLACEHOLDER_CONTAINS, IS_SNEAKING, IS_FLYING, CHANCE } Type type; String value=""; boolean inverted; ConditionEntry(Type type,String value){this.type=type;this.value=value==null?"":value;} }
