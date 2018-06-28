/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const control = document.getElementById("control");
const output = document.getElementById("output");
const word = document.getElementById("word");

word.addEventListener("keyup", () => {
    control.textContent = `${word.value} has ${word.value.length} characters.`;
    getText(word.value).then((text) => output.textContent = text);
});

const getText = (word) => {
    return fetch('/word', {
        method: 'POST',
        body: `word=${word}`,
        headers: {
            "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
        },
    })      .then((response) => response.text())
            .catch((error) => error)
}

control.textContent = 'Wolf was here';
