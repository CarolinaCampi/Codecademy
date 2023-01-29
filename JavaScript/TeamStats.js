const team = {
    _players: [player1 = {
      firstName: 'John',
      lastName: 'Smith',
      age: 20
    },
    player2 = {
      firstName: 'Adam',
      lastName: 'Baker',
      age: 21
    },
    player3 = {
      firstName: 'Jack',
      lastName: 'Green',
      age: 20
    }],
    _games: [game1 = {
      opponent: 'Sea Hawks',
      teamPoints: 1,
      opponentPoints: 2
    },
    game2 = {
      opponent: 'Black Panthers',
      teamPoints: 1,
      opponentPoints: 1
    },
    game3 = {
      opponent: 'Blue Fish',
      teamPoints: 3,
      opponentPoints: 2
    }],
    get players(){
      return this._players;
    },
    get games(){
      return this._games;
    },
    addPlayer(newFirstName, newLastName, newAge) {
      player4 = {
        firstName: newFirstName, 
        lastName: newLastName, 
        age: newAge}
      team._players.push(player4);
    },
    addGame(newOpponent, newTeamPoints, newOpponentPoints) {
      game4 = {
        opponent: newOpponent,
        teamPoints: newTeamPoints,
        opponentPoints: newOpponentPoints}
      team._games.push(game4);
    }
  }
  
  team.addPlayer('Tim', 'Frost', 24);
  team.addGame('Red Bulls', 5,4);
  console.log(team);