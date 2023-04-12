
package repositorio;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import modelo.Vertice;

/**
 *
 * @author luann
 */
public class VerticeTypeAdapter extends TypeAdapter<Vertice> {

  @Override
  public void write(JsonWriter out, Vertice value) throws IOException {
    // Implementar a lógica de serialização aqui
  }

  @Override
  public Vertice read(JsonReader in) throws IOException {
    // Implementar a lógica de desserialização aqui
    Vertice vertice = new Vertice();
    in.beginObject();
    while (in.hasNext()) {
      switch (in.nextName()) {
       case "nome":
          vertice.setNome(in.nextString());
          //System.out.println(vertice.getNome());  
          break;
       case "descricao":
            vertice.setDescricao(in.nextString());
            //System.out.println(vertice.getDescricao());  
            break;
       case "logPose":
            vertice.setLongPose(in.nextDouble());
            //System.out.println(vertice.getDescricao());  
            break;
       case "id":
           vertice.setId(in.nextInt());
           break;
       case "marinha":
    	   vertice.setMarinha(in.nextString().equals("sim"));
      }
    }
    in.endObject();
    return vertice;
  }
}

