package com.john.cacapalindromo.entrypoint.mapper;

import com.john.cacapalindromo.core.domain.Palindromo;
import com.john.cacapalindromo.dataprovider.repository.entity.PalindromeEntity;
import com.john.cacapalindromo.entrypoint.response.PalindromeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
/**
 * @author john
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IPalindromeMapper {

    Palindromo toDomain(PalindromeEntity palindromeEntity);

    PalindromeEntity toEntity(Palindromo palindrome);

    PalindromeResponse toResponse(Palindromo palindrome);

}
