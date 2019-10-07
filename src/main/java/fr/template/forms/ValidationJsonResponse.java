/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.template.forms;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author zouhairhajji
 */
@Getter
@Setter
@Builder
public class ValidationJsonResponse<T> {

    private T object;
    private boolean validated;
    private Map<String, String> errorMessages;

    public ValidationJsonResponse() {
    }

    public ValidationJsonResponse(T object, boolean validated, Map<String, String> errorMessages) {
        this.object = object;
        this.validated = validated;
        this.errorMessages = errorMessages;
    }

    
    
}
