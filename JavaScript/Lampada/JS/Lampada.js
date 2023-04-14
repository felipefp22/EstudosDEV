var estado = true;

function mudarLampada(tipo) {
    if(tipo == 1 && estado){
        document.getElementById("lampada").src="Imagens/lampada-acesa.jpg";
        
    }else if(tipo == 2 && estado){
        document.getElementById("lampada").src="Imagens/lampada-apagada.jpg";   

    }else if(tipo == 3 && estado){
        document.getElementById("lampada").src="Imagens/lampada-quebrada.jpg";
        estado = false;
        cursorLampada(1);
    }else if(tipo == 3 && estado == false){
        arrumarLampada();
    }
}

function cursorLampada(resposta){
    var classe = document.getElementById("lampada");
    if (resposta == 1){
        classe.setAttribute('class','') 
    }else if(resposta == 2){
        classe.setAttribute('class','imgCursor')
    }
}

function arrumarLampada() {
    document.getElementById("lampada").src="Imagens/lampada-apagada.jpg";
    estado = true;
    cursorLampada(2);
}