var sexoUser = document.getElementsByName("radsex");

var data = new Date();
var anoAtual = data.getFullYear();
var anoUser = document.getElementById("txtano");

var img = document.getElementById("img")
var res = document.getElementById("resp");
var backG = document.body

function verificar() {
    var idade = anoAtual - Number(anoUser.value);

    if (anoUser.value.length == 0 || Number(anoUser.value) > anoAtual || Number(anoUser.value) < 1880) {
        alert("Verifique o Ano Digitado!")
    } else {

        if (sexoUser[0].checked) {
            if (idade <= 5) {
                img.src = "imagens/bebe.jpeg"
                res.innerHTML = "Nenê " + idade + " anos.";
                backG.style.background = "rgba(44, 211, 94, 0.8)"
            }else if (idade > 5 && idade <= 17) {
                img.src = "imagens/criancaMenino.jpeg"
                res.innerHTML = "Homem de " + idade + " anos.";
                backG.style.background = "rgb(40, 99, 177)"
            }else if (idade > 17 && idade <= 50) {
                img.src = "imagens/meiaIdadeHomem.jpeg"
                res.innerHTML = "Homem de " + idade + " anos.";
                backG.style.background = "rgb(40, 99, 177)"
            }else if (idade > 50) {
                img.src = "imagens/idosoHomem.jpeg"
                res.innerHTML = "Homem de " + idade + " anos.";
                backG.style.background = "rgb(40, 99, 177)"
            }
            
        } else if (sexoUser[1].checked) {
            if (idade < 5) {
                img.src = "imagens/bebe.jpeg"
                res.innerHTML = "Nenê " + idade + " anos.";
                backG.style.background = "rgba(44, 211, 94, 0.8)"
            }else if (idade > 5 && idade <= 17) {
                img.src = "imagens/criancaMenina.jpeg"
                res.innerHTML = "Mulher de " + idade + " anos.";
                backG.style.background = "rgba(176, 78, 196, 0.8)"
            }else if (idade > 17 && idade <= 50) {
                img.src = "imagens/meiaIdadeMulher.jpeg"
                res.innerHTML = "Mulher de " + idade + " anos.";
                backG.style.background = "rgba(176, 78, 196, 0.8)"
            }else if (idade > 50) {
                img.src = "imagens/idosaMulher.jpeg"
                res.innerHTML = "Mulher de " + idade + " anos.";
                backG.style.background = "rgba(176, 78, 196, 0.8)"
            }
        }
    }
}