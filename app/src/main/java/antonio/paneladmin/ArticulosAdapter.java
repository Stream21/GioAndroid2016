package antonio.paneladmin;

/** Handler para listado.
 * @author Antonio Arjones Bello.
 * Desarrollador Villa De Aguimes.
 */

public class ArticulosAdapter {




    private int idImagen;
    private String textoEncima;
    private String textoDebajo;
    private String textoDebajo2;


    public ArticulosAdapter (int idImagen, String textoEncima, String textoDebajo, String textoDebajo2) {
        this.idImagen = idImagen;
        this.textoEncima = textoEncima;
        this.textoDebajo = textoDebajo;
        this.textoDebajo2 = textoDebajo2;
    }

    public String get_textoEncima() {
        return textoEncima;
    }

    public String get_textoDebajo() {
        return textoDebajo;
    }

    public String getTextoDebajo2(){
        return textoDebajo2;
    }

    public int get_idImagen() {
        return idImagen;
    }


}