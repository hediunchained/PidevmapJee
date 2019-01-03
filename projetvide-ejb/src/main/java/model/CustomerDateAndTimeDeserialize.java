package model;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomerDateAndTimeDeserialize extends JsonDeserializer<Date> {
	private SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd");

    @Override
    public Date deserialize(JsonParser paramJsonParser,
            DeserializationContext paramDeserializationContext)
            throws IOException, JsonProcessingException {
    	
        String[] parts = paramJsonParser.getText().trim().split("\\(");
        String[] parts2 = parts[1].split("\\)");
        
        try {
        	
            return dateFormat.parse(parts2[0]);
        } catch (ParseException e) {
            // Handle exception here
        }
        return paramDeserializationContext.parseDate(parts2[0]);
    }

}
