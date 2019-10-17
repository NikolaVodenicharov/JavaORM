package spring.intro.entities.enums;

import javax.persistence.AttributeConverter;
import java.util.stream.Stream;

public class AgeRestrictionConverter implements AttributeConverter<AgeRestriction, String> {
    @Override
    public String convertToDatabaseColumn(AgeRestriction ageRestriction) {
        if (ageRestriction == null){
            return null;
        }

        return ageRestriction.getCode();
    }

    @Override
    public AgeRestriction convertToEntityAttribute(String code) {
        if (code == null){
            return null;
        }

        return Stream.of(AgeRestriction.values())
                .filter(a -> a.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
