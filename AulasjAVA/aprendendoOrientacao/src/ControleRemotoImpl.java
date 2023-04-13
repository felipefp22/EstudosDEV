public class ControleRemotoImpl extends ControleRemoto {
    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        System.out.println("Esta ligado? " + this.isLigado());
        System.out.println("Esta tocando? " + this.isTocando());
        int j=0;
        for (int i=0; i<=this.getVolume(); i+=10){
            j = i;
        }

        System.out.print("[" + j +"] ");
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando Menu");

    }

    @Override
    public void maisVolume() {
        if (this.isLigado()){
            this.setVolume(this.getVolume()+10);
        }
    }

    @Override
    public void menosVolume() {
        if (this.isLigado()){
            this.setVolume(this.getVolume() - 10);
        }
    }

    @Override
    public void ligarMudo() {
        if (this.isLigado() && this.getVolume()>0){
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
        if (this.isLigado() && this.getVolume() == 0){
            this.setVolume(30);
        }
    }

    @Override
    public void play() {
        if (this.isLigado() && !this.isTocando()){
            this.setTocando(true);
        }
    }

    @Override
    public void pause() {
        if (this.isLigado() && this.isTocando()){
            this.setTocando(false);
        }
    }
}
