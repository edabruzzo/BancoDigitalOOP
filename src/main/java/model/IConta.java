package model;

import exception.OperacaoBloqueadaContaDestinoSituacaoIrregular;
import exception.OperacaoBloqueadaContaOrigemSituacaoIrregular;
import exception.SaldoInsuficienteException;

/**
 * @author Emmanuel Abruzzo
 * @date 18/01/2022
 */
public interface IConta {

    void sacar(double valor) throws SaldoInsuficienteException;

    void depositar(double valor);

    void transferir(double valor, Conta contaDestino) throws OperacaoBloqueadaContaDestinoSituacaoIrregular, OperacaoBloqueadaContaOrigemSituacaoIrregular;

    void imprimirExtrato();

}
