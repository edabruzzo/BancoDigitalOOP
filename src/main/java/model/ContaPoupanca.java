package model;

/**
 * @author Emmanuel Abruzzo
 * @date 18/01/2022
 */
public class ContaPoupanca extends Conta {

    boolean podeTransferirValorSuperiorA10Mil = false;

    public ContaPoupanca(double saldo, Cliente cliente, StatusConta statusConta) {
        super(saldo,cliente,statusConta);
    }

}
