const toggle = document.querySelector(".menu-toggle");
const menu = document.querySelector(".menu");

function toggleMenu() {
    if (menu.classList.contains("expanded")) {
        menu.classList.remove("expanded");
        toggle.querySelector('a').innerHTML = '<i id="toggle-icon" class="far fa-plus-square"></i>';
    } else {
        menu.classList.add("expanded");
        toggle.querySelector('a').innerHTML = '<i id="toggle-icon" class="far fa-minus-square"></i>';
    }
}

toggle.addEventListener("click", toggleMenu, false);
document.querySelector('.search-icon').addEventListener('click', function (e) {
    const container = this.closest('.search-container');
    const input = container.querySelector('.input-bar');

    // Ustawienia komunikatu błędu, jeśli pole jest puste
    input.addEventListener('invalid', function () {
        input.setCustomValidity('Proszę wprowadzić tytuł filmu');
    });

    // Usuwamy komunikat błędu, kiedy użytkownik zacznie pisać
    input.addEventListener('input', function () {
        input.setCustomValidity(''); // Kasowanie komunikatu błędu
    });

    container.classList.toggle('expanded'); // Przełączenie kontenera na rozwinięty/zwiniety
    if (container.classList.contains('expanded')) {
        input.focus(); // Skupienie na polu tekstowym
    }
});
