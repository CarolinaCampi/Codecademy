// The variable kelvin will save the value of today's forecast.

const kelvin = 293;

// The value of the temperature in Celsius is equal to the value of kelvin minus 273.
const celsius = kelvin - 273;

// The equation to calculate the temperature's value in Fahrenheit is as follows: Fahrenheit = Celsius * (9/5) + 32.
let fahrenheit = celsius * (9/5) + 32;

// With the function floor, the value calculated with the formula above is rounded down and the largest integer less than or equal to the given number is returned.
fahrenheit = Math.floor(fahrenheit);

console.log(`The temperature is ${fahrenheit} degrees Fahrenheit.`);