/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cines.json;

/**
 *
 * @author 2004p
 */
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
import javax.ws.rs.Produces;
import java.io.OutputStream;
import javax.json.stream.JsonGenerator;


@Provider
@Produces(MediaType.APPLICATION_JSON)

public class MovieWriter {


public boolean isWriteable(Class<?> type,
                             Type genericType,
                             Annotation[] annotations,
                             MediaType mediaType) {
    return Movie.class.isAssignableFrom(type);
}


public long getSize(Movie t,
                    Class<?> type,
                    Type genericType,
                    Annotation[] annotations,
                    MediaType mediaType) {
    return -1;
}
public void writeTo(Movie t, Class<?> type, Type genericType, Annotation[] annotations,
MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
throws IOException, WebApplicationException {
JsonGenerator gen = Json.createGenerator(entityStream);
gen.writeStartObject()
.write("id", t.getId())
.write("name", t.getName())
.write("actors", t.getActors())
.writeEnd();
gen.flush();
}

}
