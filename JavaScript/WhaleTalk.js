let input = 'My name is Dory and I speak Whale talk, dude';

const vowels = ['a', 'e', 'i', 'o', 'u'];

let resultArray = [];

for (let i = 0; i < input.length; i++){
  // console.log(i);
  for (let j = 0; j < vowels.length; j++){
    // console.log(j);
    if (input[i] === vowels[j]){
      // console.log(input[i]);
      resultArray.push(input[i]);
    }
  }
  if (input[i] === 'e' || input[i] === 'u'){
    resultArray.push(input[i]);
  }
}

let resultString = resultArray.join('').toUpperCase();
console.log(resultString);
