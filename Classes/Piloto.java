package Classes;

public class Piloto extends Pessoa {
    
    private String breve;
    private Aeronave aeronave;

     
    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public String getBreve() {
        return breve;
    }

    public void setBreve(String breve) {
        this.breve = breve;
    }
    

    @Override
    public String toString() {
        String texto = " ";
        texto += " Nome: " + getNome();
        texto += " - CPF: " + getCpf();
        texto += " - Breve " + getBreve();
        if( aeronave != null ){
            texto += " PILOTO DA AERONAVE" + getAeronave();
        }
        return texto;
    }
  
}
