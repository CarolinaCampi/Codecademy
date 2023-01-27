function getSleepHours (day) {
    switch (day) {
      case 'Monday':
        return 8;
      case 'Tuesday':
        return 7;
      case 'Wednesday':
        return 6;
      case 'Thursday':
        return 5;
      case 'Friday':
        return 9;
      case 'Saturday':
        return 10;
      case 'Sunday':
        return 9;
    }
  }
  
  const getActualSleepHours = () => getSleepHours('Monday')+ getSleepHours('Tuesday') + getSleepHours('Wednesday') + getSleepHours('Thursday') + getSleepHours('Friday') + getSleepHours('Saturday') + getSleepHours('Sunday');
  
  function getIdealSleepHours(){
    const idealHours = 8;
    return idealHours * 7;
  }
  
  function calculateSleepDebt(){
    let actualSleepHours = getActualSleepHours();
    let idealSleepHours = getIdealSleepHours();
    let sleepDebt = idealSleepHours - actualSleepHours;
  
    if (actualSleepHours === idealSleepHours) {
      console.log('You got the perfect amount of sleep this week.');
    } else if (actualSleepHours > idealSleepHours) {
      console.log('You got more sleep than needed this week.');
      console.log('Extra hours of sleep: ' + Math.abs(sleepDebt));
    } else {
      console.log('You should get some rest.');
      console.log('Missing hours of sleep: ' + sleepDebt);
    }
  }
  
  calculateSleepDebt();