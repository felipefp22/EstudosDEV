var horario = new Date();
var horarioAgora = horario.getHours();
var horarioDigitado = 'Agora são ' + horarioAgora + " horas";
var img = document.getElementById("imagem");
var hrs = document.getElementById("horas");
var body = document.body;

if (horarioAgora >= 6 && horarioAgora < 12){
    hrs.innerHTML = horarioDigitado;
    img.src = "imagens/dia1.jpeg";
    body.style.background = "rgb(228, 208, 98)";

} else if (horarioAgora >= 12 && horarioAgora < 18){
    hrs.innerHTML = horarioDigitado;
    img.src = "imagens/tarde1.jpeg";
    body.style.background = "rgba(75, 146, 238, 0.850)";

}else if (horarioAgora >= 18 && horarioAgora <24 || horarioAgora >= 0 && horarioAgora <6 ){
    hrs.innerHTML = horarioDigitado;
    img.src = "imagens/noite1.jpg";
    body.style.background = "rgba(26, 25, 23, 0.733)";
}        