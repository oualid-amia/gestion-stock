package com.walid.gestion.de.stock.handlers;

import com.walid.gestion.de.stock.exception.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {


//    l'objet envoyer lorsqu'une exception se leve

    private Integer httpCodes;

    private ErrorCodes code;

    private String message;

    private List<String> errors = new ArrayList<>();

}
