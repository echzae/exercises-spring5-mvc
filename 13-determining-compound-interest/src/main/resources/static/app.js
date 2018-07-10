const principal = document.getElementById("principal");
const interest = document.getElementById("interest");
const years = document.getElementById("years");
const yearlyCompounds = document.getElementById("yearlyCompounds");

const button = document.getElementById("button");
const answer = document.getElementById("answer");

const getPayload = () => ({
    principal: Number.parseInt(principal.value),
    interest: Number.parseFloat(interest.value),
    years: Number.parseInt(years.value),
    yearlyCompounds: Number.parseInt(yearlyCompounds.value)
});

const fetchAnswer = payload =>
    fetch(
        '/compound-interest',
        {
            headers: {
                    "Content-Type": "application/json; charset=utf-8",
            },
            method: 'post',
            body: JSON.stringify(payload),
        }
    ).then(response => response.json())
    .then(json => json.answer);

button.addEventListener("click", (evt) => {
    evt.preventDefault();

    fetchAnswer(getPayload()).then(answ => answer.innerHTML = answ);
});

