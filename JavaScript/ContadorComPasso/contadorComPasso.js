//Variaveis Globais
var state = false

//Aqui são as variaveis de caoptar os numeros imputados
var ini
var fim
var pass

//Apresentação Resultado
var result = document.getElementById("resultado")

//Background Body
var bodyBackColor = document.body

function verificacao() {
    ini = document.getElementById("inicio")
    fim = document.getElementById("final")

    pass = document.getElementById("passo")

    if ((!state) && (ini.value.length == 0 || fim.value.length == 0 || pass.value.length == 0)) {
        result.innerHTML = "Estao Faltando Dados"
    } else if ((state) && (ini.value.length == 0 && fim.value.length == 0 && pass.value.length == 0)) {
        resetar()
    } else if ((state) && (ini.value.length == 0 || fim.value.length == 0 || pass.value.length == 0)) {
        result.innerHTML = "Estao Faltando Dados"
    } else {
        ini = Number(ini.value)
        fim = Number(fim.value)
        pass = Number(pass.value)

        if (pass == 0) {
            pass++
        }
        calcular();
    }
}
function calcular() {
    var print = "🏳️ " + ini
    if (ini < fim) {
        ini += pass
        for (ini; ini <= fim; ini += pass) {
            print += " 🥊 " + ini
        }
    } else if (ini > fim) {
        ini -= pass
        for (ini; ini >= fim; ini -= pass) {
            print += "🥊" + ini
        }
    }
    print += " 🏴"
    bodyBackColor.style.background = "rgb(13, 75, 129)"
    result.innerHTML = print

    state = true
}
function resetar() {
    bodyBackColor.style.background = "blueviolet"
    state = false
    result.innerHTML = ""
}