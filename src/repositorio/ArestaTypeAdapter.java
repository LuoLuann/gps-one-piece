package repositorio;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/**
 *
 * @author luann
 */
public class ArestaTypeAdapter extends TypeAdapter<ArestaJson> {

    @Override
    public void write(JsonWriter out, ArestaJson value) throws IOException {
        // Implementação do método write omitida
    }

    @Override
    public ArestaJson read(JsonReader in) throws IOException {
        ArestaJson aresta = new ArestaJson();
        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "origem":
                    aresta.setIdOrigem(in.nextInt());
                    break;
                case "destino":
                    aresta.setIdDestino(in.nextInt());
                    break;
                case "distancia":
                    aresta.setDistancia(in.nextDouble());
                    break;
                default:
                    in.skipValue();
                    break;
            }
        }
        in.endObject();
        return aresta;
    }

}
