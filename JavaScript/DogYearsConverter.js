//The variable myAge stores the age of the user.
let myAge = 28;

//The variable earlyYears will store 2 years for now.
let earlyYears = 2;

//We will start to convert the human years to dog years.
//First let's take into account the early years conversion.
earlyYears *= 10.5;

//The 2 years already taken into account have to be substracted from myAge. The resulting vlaue will be stored in a new variable.
let laterYears = myAge - 2;

//Now we will convert the later years to dog years using the conversion value for them.
laterYears *= 4;

//We add the two parts of the age in dog years.
let myAgeInDogYears = earlyYears + laterYears;

//The name inputed will be converted to lowercase.
let myName = 'Carolina'.toLowerCase();

//Print to console along with the values calculted.
console.log(`My name is ${myName}. I am ${myAge} years old in human years which is ${myAgeInDogYears} years old in dog years.`);