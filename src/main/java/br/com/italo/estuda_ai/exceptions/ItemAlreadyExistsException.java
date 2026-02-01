package br.com.italo.estuda_ai.exceptions;

public class ItemAlreadyExistsException extends RuntimeException {

    public ItemAlreadyExistsException(String menssage) {
        super(menssage);
    }

    public ItemAlreadyExistsException(String item, String violation) {
        super("Esse " + item +" com "+ violation+ " já existe");
    }
}
