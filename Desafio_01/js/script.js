//variáveis de estado:
let tabUserResults = null;
let tabStats = null;

let inputField = null;
let searchInput = null;
let searchButton = null;

let allUsers = [];
let userResults = [];

window.addEventListener('load', () => {
  inputField = document.querySelector('#searchInput');
  searchButton = document.querySelector('#searchButton');
  tabUserResults = document.querySelector('#tabUserResults');
  tabStats = document.querySelector('#tabStats');

  fetchUsers();
  inputField.addEventListener('keyup', inputFieldEvent);
  searchButton.addEventListener('click', () => searchUsers(searchInput));
});

//async
function fetchUsers() {
  /* const res = await fetch(
    'https://randomuser.me/api/?seed=javascript&results=100&nat=BR&noinfo'
  ); */
  const json = /* await */ data.results;
  allUsers = json.map((user) => {
    const { name, picture, dob, gender } = user;
    return {
      name,
      picture,
      age: dob.age,
      gender,
    };
  });
  //console.log(allUsers);
}

function inputFieldEvent(event) {
  searchInput = inputField.value;
  searchButton.disabled = !(searchInput !== '');
  if (event.key === 'Enter') searchUsers(searchInput);
}

function searchUsers(input) {
  input = input.toLowerCase();
  userResults = allUsers.filter((user) => {
    let firstname = user.name.first;
    let lastname = user.name.last;
    firstname = firstname.toLowerCase();
    lastname = lastname.toLowerCase();
    return firstname.includes(input) || lastname.includes(input);
  });
  //console.log(userResults);
  let resultsTitle = document.querySelector('#resultsTitle');
  let statsTitle = document.querySelector('#statsTitle');
  if (userResults.length > 0) {
    resultsTitle.innerHTML = '';
    statsTitle.innerHTML = '';
  } else {
    resultsTitle.innerHTML = 'Nenhum usuário filtrado';
    statsTitle.innerHTML = 'Nada a ser exibido';
  }
  render();
}

function render() {
  renderUserResults();
  renderStats();
}

function renderUserResults() {
  let resultsHTML = '<ul>';
  userResults.forEach((user) => {
    const firstname = user.name.first;
    const lastname = user.name.last;
    const age = user.age;
    const userHTML =
      '<li>' + firstname + ' ' + lastname + ' - ' + age + '</li>';
    resultsHTML += userHTML;
  });
  resultsHTML += '</ul>';
  tabUserResults.innerHTML = resultsHTML;
}

function renderStats() {
  let statsHTML = '<ul>';
  let ageSum = 0;
  let ageRate = 0;
  let maleCount = 0;
  let femaleCount = 0;
  userResults.forEach((user) => {
    if (user.gender === 'male') maleCount++;
    else if (user.gender === 'female') femaleCount++;
    ageSum += user.age;
  });
  ageRate = ageSum / userResults.length;
  statsHTML += '<li> Homens: ' + maleCount + '</li>';
  statsHTML += '<li> Mulheres: ' + femaleCount + '</li>';
  statsHTML += '<li> Soma das idades: ' + ageSum + '</li>';
  statsHTML += '<li> Média das idades: ' + ageRate + '</li>';
  statsHTML += '</ul>';
  tabStats.innerHTML = statsHTML;
}
