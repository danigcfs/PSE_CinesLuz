package com.mycompany.cines.json;

import com.mycompany.cines.entities.Movie;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class MovieReader implements MessageBodyReader<Movie> {

   
    public boolean isReadable(Class<?> type,
                                Type genericType,
                                Annotation[] annotations,
                                MediaType mediaType) {
        return Movie.class.isAssignableFrom(type);
    }

    
    public Movie readFrom(Class<Movie> type,
                          Type genericType,
                          Annotation[] annotations,
                          MediaType mediaType,
                          MultivaluedMap<String, String> httpHeaders,
                          InputStream entityStream)
            throws IOException, WebApplicationException {
        Movie movie = new Movie();
        JsonParser parser = Json.createParser(entityStream);
        
        while (parser.hasNext()) {
            Event event = parser.next();
            if (event == Event.KEY_NAME) {
                String key = parser.getString();
                // Avanza al siguiente evento que debe ser el valor
                event = parser.next();
                switch (key) {
                    case "id":
                        movie.setId(parser.getInt());
                        break;
                    case "name":
                        movie.setName(parser.getString());
                        break;
                    case "actors":
                        movie.setActors(parser.getString());
                        break;
                    default:
                        // Puedes ignorar claves desconocidas o manejarlas según convenga
                        break;
                }
            }
        }
        
        return movie;
    }
}
