window.addEventListener('load', start);

var globalRed = '0';
var globalGreen = '0';
var globalBlue = '0';

function start() {
  changeColor();
}

function changeColor() {
  function changeRangeEvent(event) {
    function pickRangeColor() {
      /* Isola o nome da cor do id do range para selecionar
    o display e a variável global correspondente.
    Dispensa a criação de uma função isolada para cada cor. */
      var idRangeColor = event.target.id;
      var idColor = idRangeColor.replace('range', '');
      return idColor;
    }
    var currentValue = event.target.value;

    var color = pickRangeColor();
    var displayColorID = '#display' + color;
    var currentDisplay = document.querySelector(displayColorID);
    currentDisplay.value = currentValue;
    switch (color) {
      case 'Red':
        globalRed = currentValue;
        break;
      case 'Green':
        globalGreen = currentValue;
        break;
      case 'Blue':
        globalBlue = currentValue;
        break;
    }
    square.style.backgroundColor =
      'rgb(' + globalRed + ',' + globalGreen + ',' + globalBlue + ')';
  }

  var rangeRed = document.querySelector('#rangeRed');
  var rangeGreen = document.querySelector('#rangeGreen');
  var rangeBlue = document.querySelector('#rangeBlue');

  var square = document.querySelector('#square');

  rangeRed.addEventListener('change', changeRangeEvent);
  rangeGreen.addEventListener('change', changeRangeEvent);
  rangeBlue.addEventListener('change', changeRangeEvent);
}
