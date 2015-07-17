package br.com.android.material.core.modules;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Anotação para marcar campos, parâmetros e métodos para usar o contexto da aplicação
 *
 * @author andre.moreira
 */
@Qualifier
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RUNTIME)
public @interface Application {
}