## 🛠 Built With

![Java](https://img.shields.io/badge/Java-17-orange)
![JavaFX](https://img.shields.io/badge/JavaFX-GUI-blue)
![OOP](https://img.shields.io/badge/Paradigm-OOP-green)
![Git](https://img.shields.io/badge/Version%20Control-Git-red)

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

# 🏗️ Technical Architecture

This project was designed with a strong focus on **object-oriented software engineering**, modular design, and maintainable game architecture.

The implementation separates **game logic**, **UI**, and **game state management** to ensure scalability and clean code organization.

---

## 💻 Technology Stack

| Technology | Purpose |
|---|---|
| **Java** | Core programming language |
| **JavaFX** | Graphical User Interface (GUI) framework |
| **Object-Oriented Programming (OOP)** | Core design paradigm |
| **Git & GitHub** | Version control and collaboration |
| **MVC-inspired architecture** | Separation between UI and game logic |

---

## 🧱 Software Design Principles

The system follows several **software engineering best practices**:

- **Encapsulation** → Game entities manage their own state
- **Inheritance** → Monster types share common behavior
- **Polymorphism** → Different monsters override abilities
- **Abstraction** → Game logic separated from UI rendering
- **Single Responsibility Principle** → Each class has one clear role

These principles make the codebase **extensible and easy to maintain**.

---

## 🧩 Core System Components

### 🎮 Game Engine

Responsible for controlling the entire game flow:

- Turn management
- Dice rolling
- Player movement
- Win condition validation
- Game state updates

---

### 🗺️ Board System

Represents the **100-cell zigzag board** and manages interactions between players and cells.

Handles:

- Cell indexing and movement
- Transport mechanics
- Door activation
- Cell effects

---

### 🧍 Monster System

Defines the **monster entities and their abilities**.

Each monster includes:

- Role (SCARER / LAUGHER)
- Monster type
- Energy level
- Special abilities
- Powerup logic

The monster system leverages **inheritance and polymorphism** to support different monster types.

---

### 🧱 Cell System

Cells represent the interactive components of the board.

Examples:

- Door Cells
- Card Cells
- Transport Cells
- Monster Cells
- Normal Cells

Each cell type implements its **own behavior when a player lands on it**.

---

### 🎴 Card Engine

Manages:

- Card deck
- Card drawing
- Card effects
- Deck reshuffling

Cards introduce **randomized gameplay mechanics** while maintaining rule consistency.

---

### 🖥️ User Interface (JavaFX)

The graphical interface was implemented using **JavaFX**.

Features include:

- Board visualization
- Player movement animations
- Energy tracking
- Turn indicators
- Interactive gameplay feedback

The UI layer interacts with the **game engine without embedding game logic**, maintaining clear architectural separation.

---


---

## ⚙️ Key Engineering Challenges

During development the project addressed several technical challenges:

- Designing a **flexible board system** with many dynamic cell effects
- Managing **complex game state transitions**
- Implementing **monster abilities with different rule interactions**
- Maintaining **clean separation between UI and game logic**
- Handling **randomized card mechanics** while preserving game balance

---

## 🚀 Skills Demonstrated

This project showcases practical experience with:

- Object-Oriented Programming in Java
- Software architecture design
- Game logic implementation
- JavaFX GUI development
- Git-based team collaboration
- Problem solving in complex rule system

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
