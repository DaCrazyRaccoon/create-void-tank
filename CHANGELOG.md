## Unreleased

### Fixed
- Void Tanks on moving contraptions now void fluid. They used to be ignored by the contraption's fluid storage, so a Drill Drain with only a Void Tank on board could not collect anything. A mounted Void Tank keeps the activation state it had when the contraption was assembled.

### Added
- Server config option `voidOnContraptions` (default `true`) to turn voiding on contraptions off.

## Version 1.1.0

### Added
- Void Tank block that accepts and voids any fluid piped into it
- Crafting recipe using copper sheets, obsidian, and an ender pearl
- Configurable activation conditions: Always Active (default), Requires Heat, and Requires Redstone
- Window variant toggled by right-clicking with a wrench
- Create Goggles overlay showing voiding status, currently voided fluid, and unmet requirements
- Ponder scene demonstrating fluid voiding and all activation modes
- Jade mod integration displaying tank status
- Shift-expandable item tooltip with activation requirement details
- Loot table so the tank drops itself when mined
- Mineable with pickaxe tag

### Changed
- Updated Void Tank textures for improved appearance

### Fixed
- Fixed goggle overlay text overlapping with the status icon
- Fixed heat level not displaying correctly in the goggle overlay format string
