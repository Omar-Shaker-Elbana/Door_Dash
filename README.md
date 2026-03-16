# 🎮 DooR DasH – Scare vs Laugh Touchdown

> *“We scare because we care.”* — Scarers  
> *“We laugh, that’s our path.”* — Laughers  

DooR DasH is a **competitive strategy board game inspired by the world of Monsters Inc.** where monsters compete to collect energy from children's doors while navigating the chaotic factory floor of **Monstropolis**.

Players race across a **100-cell zigzag board**, managing energy, using special abilities, and interacting with different types of cells. The first monster to reach **Boo’s Door** with **at least 1000 energy** wins the game.

This project implements the game mechanics and rules in software using **object-oriented design and game logic systems**.

---

# 🧠 Game Concept

For years, Monstropolis relied on **scream energy** collected by Scarers.

Then **Mike Wazowski discovered something revolutionary**:

💡 **Laughter generates 10× more energy than screams.**

Now two ideologies compete on the same floor:

| Role | Strategy |
|-----|-----|
| 👹 **Scarers** | Traditional scream energy |
| 😂 **Laughers** | Modern laughter energy |

Which one will dominate the factory floor?

---

# 🗺️ Game Overview

The game board is a **10 × 10 zigzag grid (100 cells)** similar to **Snakes & Ladders**, filled with different interactive elements.

Players must balance:

- ⚡ **Energy collection**
- 🎲 **Movement strategy**
- 🧠 **Monster abilities**
- 🎴 **Random cards**
- ⚠️ **Hazards**

Victory requires **position + energy management**.

---

# 🧩 Board Elements

## 🚪 Door Cells (50)

Energy collection points.

- Doors alternate between **SCARER** and **LAUGHER** types.
- Landing on a door affects **all teammates** with the same role.

| Situation | Effect |
|---|---|
| Role Match | Team gains the door's energy |
| Role Mismatch | Team loses the door's energy |
| Shield Active | Loss is prevented |

Doors activate **only once** when first used.

---

## 👾 Monster Cells (6)

Special cells containing monsters not chosen by players.

| Condition | Result |
|---|---|
| Same Role | Landing player activates their powerup for **free** |
| Different Role | Energy swap may occur |

---

## 🚚 Transport Cells (10)

These behave like **Snakes & Ladders**.

### Conveyor Belts (5)

Move the player **forward quickly**.

### Contamination Socks (5)

Move the player **backwards** and cause:

- **−100 energy**
- Shield can block the energy loss.

---

## 🎴 Card Cells (10)

Landing here draws a **random card** from the deck.

Cards create unpredictable game events.

Examples:

| Card | Effect |
|---|---|
| Swapper | Swap position with opponent |
| Energy Steal | Steal energy |
| Start Over | Send player back to start |
| Shield | Block next negative energy effect |
| Confusion | Swap roles temporarily |

Total cards: **25**

---

# 👹 Monster Types

Each monster belongs to a **type** that changes gameplay mechanics.

## ⚡ Dasher

Fast movement specialist.

**Passive**
- Dice movement **×2**

**Powerup — Momentum Rush**
- Movement **×3 for 3 turns**

---

## 🔋 Dynamo

Energy-focused monster.

**Passive**
- Energy gains **×2**
- Energy losses **×2**

**Powerup — Energy Freeze**
- Freezes opponent for **1 turn**

---

## 🧠 Multitasker

Balanced but slower monster.

**Passive**
- Movement **halved**
- All energy changes **+200 bonus**

**Powerup — Focus Mode**
- Removes movement penalty for **2 turns**

---

## 🕶️ Schemer

Strategic energy manipulator.

**Passive**
- All energy changes **+10**

**Powerup — Chain Attack**
- Steals **10 energy from every monster** on the board

---

# 🎲 Game Flow

Each turn follows this sequence:

1. **Powerup Phase (Optional)**  
   Activate powerup for **500 energy**.

2. **Dice Roll**  
   Roll a **6-sided dice**.

3. **Movement Attempt**
   - Move forward according to dice.
   - If landing cell is occupied → move is invalid → roll again.

4. **Cell Action**
   The landed cell activates its effect:
   - Door
   - Card
   - Monster
   - Transport
   - Normal

5. **Board Update**
   All position and energy updates occur.

6. **Turn Switch**
   Turn passes to the opponent.

---

# 🏆 Win Condition

A player wins when **both conditions are satisfied**:

✔ Position is **exactly cell 99 (Boo’s Door)**  
✔ Player has **≥ 1000 energy**

If one condition fails → the game continues.

---

# ⚙️ Game Initialization

At the start:

1. Player chooses role
   - **SCARER**
   - **LAUGHER**

2. The system randomly selects:
   - Player monster
   - Opponent monster

3. The board is initialized:
   - 100 cells
   - 50 doors
   - 10 card cells
   - 10 transport cells
   - 6 monster cells

4. Both players start at:

📍 **Cell 0**

---

# 💻 Project Goals

This project demonstrates:

- Object-Oriented Design
- Game state management
- Event-driven gameplay
- Strategy mechanics
- Randomized game systems

---

# 🚀 Possible Future Improvements

- GUI interface for the board
- Multiplayer support
- AI opponent strategies
- Animation for movements
- Online gameplay

---

# 👥 Team

Developed as part of a **software engineering project**.

Contributors:

- Omar Shaker
- Mark Fahim
- Ahmed Roshdy
- Karl Hany

---

# 📜 License

This project is created for **educational purposes**.

Inspired by the universe of Monsters Inc.
