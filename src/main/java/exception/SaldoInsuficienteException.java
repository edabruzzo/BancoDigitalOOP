package exception;

/**
 * @author Emmanuel Abruzzo
 * @date 18/01/2022
 */
public class SaldoInsuficienteException extends Throwable {
    public SaldoInsuficienteException(String mensagemErro) {
        super(mensagemErro);
    }
}
