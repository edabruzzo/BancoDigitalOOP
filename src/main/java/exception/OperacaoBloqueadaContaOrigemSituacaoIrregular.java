package exception;

/**
 * @author Emmanuel Abruzzo
 * @date 18/01/2022
 */
public class OperacaoBloqueadaContaOrigemSituacaoIrregular extends RuntimeException {
    public OperacaoBloqueadaContaOrigemSituacaoIrregular(String mensagemErro) {
        super(mensagemErro);
    }
}
