Low-Level Design

Design Tic Tac Toe

Clarifying Questions
You: "How do players interact with the game?
You: "What are all the ways a game can end?
You: "What should happen if someone tries to mark column/ row that's already marked?
Should I return an error, throw an exception, or just ignore it?"

Requirements:
1. Two players alternate placing X and O on a 3x3 grid.
2. A player wins by completing a row, column, or diagonal.
3. The game ends in a draw if all nine cells are filled with no winner.
4. Invalid moves should be rejected (placing on an occupied cell, acting after the game is over).
5. The system should provide a way to query current game state and reset the game.

Out of Scope:
- UI/rendering layer
- AI opponent or move suggestions
- Networked multiplayer
- Variable board sizes (NxN grids)
- Undo/redo functionality

Game – State:
- board: Board
- playerX: Player
- playerO: Player
- currentPlayer: Player
- state: GameState (IN_PROGRESS, WON, DRAW)
- winner: Player? (null if no winner)

Board
- rows: int
- cols: int
- grid: Marker[rows][cols]

+ canPlace(row, col, mark)
+ markBoard(row, col, mark)
+ checkWin(row, col, mark
+ isBoardFull()

Player
```agsl
makeMove(player, row, col)
    if state != IN_PROGRESS
    return false
    if player != currentPlayer
    return false
    if !board.canPlace(row, col)
    return false

    board.placeMark(row, col, player.mark)

    if board.checkWin(row, col, player.mark)
        state = WON
        winner = player
    else if board.isFull()
        state = DRAW
    else
        currentPlayer = (player == playerX) ? playerO : playerX

    return true
```