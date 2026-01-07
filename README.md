# 🎮 Tetris

Ein Tetris-Spiel entwickelt mit libGDX als Java-Desktop-Anwendung.

---

## 📋 Inhaltsverzeichnis

- [Über das Projekt](#über-das-projekt)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Verwendung](#verwendung)
- [Steuerung](#steuerung)
- [Testing](#testing)
- [Projektstruktur](#projektstruktur)
- [Lizenz](#lizenz)
- [Kontakt](#kontakt)

---

## 🎯 Über das Projekt

Dieses Tetris-Projekt ist eine Java-Implementierung des klassischen Puzzle-Spiels, entwickelt mit dem libGDX-Framework. Das Projekt befindet sich aktuell in der Entwicklungsphase mit einer grundlegenden Spielmatrix und Rendering-System.

### Zielgruppe
- **Casual Gamer**: Für klassisches Tetris-Gameplay
- **Java-Lernende**: Als Beispiel für libGDX-Entwicklung

### Projektziele
- ✅ Saubere Projektstruktur mit libGDX
- ✅ Matrix-basiertes Spielfeld (10×20)
- ✅ Desktop-Anwendung mit LWJGL3
- ✅ Unit-Tests mit JUnit 5
- 🔄 Tetromino-Implementierung (in Arbeit)
- 🔄 Kollisionserkennung (in Arbeit)

---

## ✨ Features

### Implementierte Features
- 🎮 **Grundlegendes Rendering**: Bewegliche rote Box als Test-Element
- 📊 **GameMatrix**: 10×20 Spielfeld-Matrix
- ⌨️ **Tastatursteuerung**: Pfeiltasten zur Bewegung
- 🖥️ **Desktop-Platform**:  LWJGL3-Backend für Windows, macOS und Linux
- 🧪 **Unit-Tests**: JUnit 5 Tests für Matrix-Operationen

### In Entwicklung
- 🔲 Tetromino-Formen (I, O, T, S, Z, J, L)
- 🔲 Rotation und Kollisionserkennung
- 🔲 Zeilenentfernung und Scoring
- 🔲 Spiellogik (Game Over, Level-System)

---

## 🛠️ Tech Stack

### Sprachen & Frameworks
- **Java 17** - Hauptprogrammiersprache
- **libGDX** - Game Development Framework
- **LWJGL3** - Desktop-Backend
- **JUnit 5** - Testing-Framework

### Build-Tools
- **Gradle 8.x** - Build-Management & Dependency-Management
- **Gradle Wrapper** - Inkludiert für plattformunabhängige Builds

### Libraries
- **libGDX Core** - Grundlegende Game-Engine-Funktionen
- **libGDX Box2D** - Physik-Engine
- **LWJGL3** - OpenGL-Bindings für Desktop

---

## 📦 Installation

### Voraussetzungen

```bash
- Java 17 oder höher (JDK)
- Git
```

**Hinweis**:  Gradle Wrapper ist inkludiert, keine separate Gradle-Installation nötig!

### Schritt-für-Schritt Installation

1. **Repository klonen**
   ```bash
   git clone https://github.com/lorenzheld/tetris.git
   cd tetris
   ```

2. **Anwendung starten**

   **Windows:**
   ```bash
   gradlew.bat lwjgl3:run
   ```

   **macOS/Linux:**
   ```bash
   ./gradlew lwjgl3:run
   ```

3. **JAR-Datei erstellen**

   **Windows:**
   ```bash
   gradlew. bat lwjgl3:jar
   ```

   **macOS/Linux:**
   ```bash
   ./gradlew lwjgl3:jar
   ```

   Die JAR-Datei befindet sich dann in:  `lwjgl3/build/libs/Tetris-{version}.jar`

4. **JAR ausführen**
   ```bash
   java -jar lwjgl3/build/libs/Tetris-{version}.jar
   ```

---

## 🎮 Verwendung

### Anwendung starten

```bash
# Direkt ausführen
./gradlew lwjgl3:run

# Oder JAR erstellen und ausführen
./gradlew lwjgl3:jar
java -jar lwjgl3/build/libs/Tetris-*. jar
```

### Entwicklungsmodus

```bash
# Projekt in IntelliJ IDEA öffnen
# File → Open → tetris/build. gradle auswählen

# Oder Eclipse-Projektdateien generieren
./gradlew eclipse
```

---

## ⌨️ Steuerung

| Aktion | Taste |
|--------|-------|
| Nach links | ← |
| Nach rechts | → |
| Nach oben | ↑ |
| Nach unten | ↓ |

**Hinweis**: Aktuell steuern die Pfeiltasten eine Test-Box (rotes Rechteck).

---

## 🧪 Testing

### Tests ausführen

**Alle Tests:**
```bash
./gradlew test
```

**Nur Core-Tests:**
```bash
./gradlew core:test
```

**Mit detailliertem Output:**
```bash
./gradlew test --info
```

### Implementierte Tests

**MatrixTest.java** - Tests für GameMatrix-Klasse:
- ✅ `testgetMatrixByK()` - Testet das Abrufen und Setzen von Matrix-Werten

### Test-Struktur

```
core/src/main/test/java/
└── MatrixTest.java          # Unit-Tests für GameMatrix
```

### Beispiel-Testfall

```java
@Test
public void testgetMatrixByK(){
    // Given:  Matrix-Wert wird gesetzt in @BeforeEach
    GameMatrix.setMatrixByK(4, 5, 1);
    
    // When & Then: Wert wird korrekt abgerufen
    assertEquals(1, GameMatrix.getMatrixByK(4, 5));
}
```

---

## 📁 Projektstruktur

```
tetris/
│
├── assets/                     # Spiel-Assets (Bilder, Sounds)
│   └── assets. txt             # Automatisch generierte Asset-Liste
│
├── core/                      # Hauptmodul mit Spiellogik
│   ├── build.gradle
│   └── src/
│       └── main/
│           ├── java/ch/bbw/lorenzheld/
│           │   ├── Main.java           # Hauptklasse (ApplicationAdapter)
│           │   └── GameMatrix.java     # Spielfeld-Matrix (10×20)
│           └── test/java/
│               └── MatrixTest.java     # Unit-Tests für Matrix
│
├── lwjgl3/                    # Desktop-Platform (LWJGL3)
│   ├── build.gradle
│   ├── icons/                 # App-Icons
│   └── src/main/java/ch/bbw/lorenzheld/lwjgl3/
│       ├── Lwjgl3Launcher.java    # Desktop-Launcher
│       └── StartupHelper.java     # macOS/Windows-Kompatibilität
│
├── gradle/                    # Gradle Wrapper
├── build. gradle               # Haupt-Build-Datei
├── settings.gradle            # Gradle-Settings
├── gradlew                    # Gradle Wrapper (Unix)
├── gradlew.bat               # Gradle Wrapper (Windows)
└── README.md
```

### Klassenübersicht

#### Core Module

**Main.java** (`ch.bbw.lorenzheld.Main`)
- Extends `ApplicationAdapter`
- Methoden:  `create()`, `render()`, `resize()`, `dispose()`
- Rendert eine bewegliche rote Box als Test
- Initialisiert `Stage` mit `FitViewport` (800×600)
- Tastatureingabe-Verarbeitung

**GameMatrix.java** (`ch.bbw.lorenzheld.GameMatrix`)
- 2D-Array:  `int[10][20]` (10 Spalten, 20 Reihen)
- `getMatrix()` - Gibt gesamte Matrix zurück
- `getMatrixByK(int x, int y)` - Gibt Wert an Position zurück
- `setMatrixByK(int x, int y, int value)` - Setzt Wert an Position

#### LWJGL3 Module

**Lwjgl3Launcher. java** (`ch.bbw.lorenzheld.lwjgl3.Lwjgl3Launcher`)
- Entry Point für Desktop-Anwendung
- Konfiguration:  640×480 Fenster, VSync aktiviert, Titel "Tetris"

---

## 🎯 Verwendete Gradle-Tasks

| Task | Beschreibung |
|------|--------------|
| `./gradlew lwjgl3:run` | Startet die Desktop-Anwendung |
| `./gradlew lwjgl3:jar` | Erstellt runnable JAR |
| `./gradlew test` | Führt alle Unit-Tests aus |
| `./gradlew build` | Kompiliert das gesamte Projekt |
| `./gradlew clean` | Löscht Build-Ordner |
| `./gradlew idea` | Generiert IntelliJ-Projektdateien |
| `./gradlew eclipse` | Generiert Eclipse-Projektdateien |

---

## 🗺️ Nächste Schritte

### Geplante Features
- [ ] Tetromino-Klasse (7 verschiedene Formen)
- [ ] Rotation-System
- [ ] Kollisionserkennung
- [ ] Gravity-System (fallende Steine)
- [ ] Zeilenentfernung
- [ ] Score-System
- [ ] Game Over Logik
- [ ] UI/Menü-System

---

## 📄 Lizenz

Dieses Projekt wurde als Lernprojekt erstellt.

**libGDX** ist lizenziert unter der Apache 2.0 License.

---

## 👤 Kontakt

**Lorenz Held**

- GitHub: [@lorenzheld](https://github.com/lorenzheld)
- Projekt-Link: [https://github.com/lorenzheld/tetris](https://github.com/lorenzheld/tetris)

---

## 🙏 Danksagungen

- **libGDX Team** - Für das ausgezeichnete Game-Framework
- **gdx-liftoff** - Projekt-Generator für libGDX
- **LWJGL** - Lightweight Java Game Library

### Ressourcen
- [libGDX Documentation](https://libgdx.com/wiki/)
- [libGDX GitHub](https://github.com/libgdx/libgdx)
- [Gradle User Guide](https://docs.gradle.org/)

---

<div align="center">

Entwickelt mit ☕ von [lorenzheld](https://github.com/lorenzheld)

</div>
