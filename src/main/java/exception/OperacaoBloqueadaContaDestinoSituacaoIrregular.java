package exception;

/**
 * @author Emmanuel Abruzzo
 * @date 18/01/2022
 */
public class OperacaoBloqueadaContaDestinoSituacaoIrregular extends RuntimeException {
    public OperacaoBloqueadaContaDestinoSituacaoIrregular(String mensagemErro) {
        super(mensagemErro);
    }
}
