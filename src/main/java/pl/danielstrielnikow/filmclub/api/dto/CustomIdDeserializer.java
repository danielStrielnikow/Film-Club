package pl.danielstrielnikow.filmclub.api.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public  class CustomIdDeserializer extends JsonDeserializer<Long> {
    @Override
    public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String id = p.getText();
        // Logic to convert the string to Long or handle it differently
        return id.startsWith("tt") ? null : Long.valueOf(id);
    }
}
