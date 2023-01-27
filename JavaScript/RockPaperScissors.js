console.log('Hi! This is a rock, paper, scissors game against the computer.');
console.log();

// Verify the validity of the value inputed by the user.
const getUserChoice = function (userInput) {
  userInput = userInput.toLowerCase();
  if (userInput === 'rock' || userInput === 'paper' || userInput === 'scissors' || userInput === 'bomb') {
    return userInput;
  } else {
    console.log('That is not a viable option. Please, choose between rock, paper or scissors.');
  }
}

// Generate the computer value.
const getComputerChoice = function () {
  const randomNumber = Math.floor(Math.random() * 3);
  let computerChoice;
  if (randomNumber === 0) {
    computerChoice = 'rock';
  } else if (randomNumber === 1) {
    computerChoice = 'paper';
  } else {
    computerChoice = 'scissors';
  }
  return computerChoice;
}

// Compare the results to determine the winner.
function determineWinner (userChoice, computerChoice) {
  if (userChoice === 'bomb'){
    return 'You\'ve won!!!';
  }
  
  if (userChoice === computerChoice) {
    return ('It\'s a tie!');
  }

  if(userChoice === 'rock'){
    if (computerChoice === 'paper'){
      return 'You\'ve lost :(';
    } else {
      return 'You\'ve won!!!';
    }  
  }

  if(userChoice === 'paper'){
    if (computerChoice === 'scissors'){
      return 'You\'ve lost :(';
    } else {
      return 'You\'ve won!!!';
    }  
  }

  if(userChoice === 'scissors'){
    if (computerChoice === 'rock'){
      return 'You\'ve lost :(';
    } else {
      return 'You\'ve won!!!';
    }  
  }

}

// Assembly of the game by calling the functions generated above.
function playGame() {
  let userChoice = getUserChoice('rock');
  let computerChoice = getComputerChoice();
  console.log('You chose ' + userChoice + ' and the computer chose ' + computerChoice + '.');
  console.log('The final result is the following:');
  console.log(determineWinner(userChoice, computerChoice));
}

// Play the game.
playGame();