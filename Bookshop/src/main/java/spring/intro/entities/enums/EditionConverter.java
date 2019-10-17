package spring.intro.entities.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter
public class EditionConverter implements AttributeConverter<Edition, String> {
    @Override
    public String convertToDatabaseColumn(Edition edition) {
        if (edition == null){
            return null;
        }

        return edition.getCode();
    }

    @Override
    public Edition convertToEntityAttribute(String code) {
        if (code == null){
            return null;
        }

        return Stream.of(Edition.values())
                .filter(e -> e.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
