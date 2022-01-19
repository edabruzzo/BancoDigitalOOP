package model;

import exception.OperacaoBloqueadaContaDestinoSituacaoIrregular;
import exception.OperacaoBloqueadaContaOrigemSituacaoIrregular;
import exception.SaldoInsuficienteException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Emmanuel Abruzzo
 * @date 18/01/2022
 */

public abstract class Conta implements IConta{


    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected UUID idConta;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected StatusConta statusConta;


    public Conta(double saldo, Cliente cliente, StatusConta statusConta) {

        this.idConta = UUID.randomUUID();
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = Conta.SEQUENCIAL;

        this.saldo = saldo;
        this.cliente = cliente;
        this.statusConta = statusConta;
    }


    public UUID getIdConta() {
        return idConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusConta getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(StatusConta statusConta) {
        this.statusConta = statusConta;
    }

    @Override
    public void sacar(double valor) {
        if(this.getStatusConta().equals(StatusConta.BLOQUEADA))
            throw new OperacaoBloqueadaContaOrigemSituacaoIrregular("Sua conta está bloqueada !");

        if(this.saldo - valor > 0)
            saldo -= valor;
        else
            try {
                throw new SaldoInsuficienteException("Saldo insuficiente para efetuar o saque");
            } catch (SaldoInsuficienteException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void depositar(double valor) {
        if(this.getStatusConta().equals(StatusConta.BLOQUEADA))
            throw new OperacaoBloqueadaContaOrigemSituacaoIrregular("Conta de origem em situação irregular");
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino)  {

        if(contaDestino.getStatusConta().equals(StatusConta.BLOQUEADA))
            throw new OperacaoBloqueadaContaDestinoSituacaoIrregular("Conta de destino em situação irregular");
        else if(this.getStatusConta().equals(StatusConta.BLOQUEADA))
                throw new OperacaoBloqueadaContaOrigemSituacaoIrregular("Conta de origem em situação irregular");
        else{
            this.sacar(valor);
            contaDestino.depositar(valor);
        }

    }


    @Override
    public void imprimirExtrato() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println("-----------------------------------");
        System.out.println(simpleDateFormat.format(date));
        System.out.println("\n");
        System.out.printf("Saldo %.2f", this.saldo);
        System.out.println("\n");
        System.out.println("-----------------------------------");


    }



    @Override
    public String toString() {
        return String.format("Conta{" +
                "idConta=" + idConta +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                "\nCLIENTE -> [ %s ]\n" + cliente.toString() +
                ", statusConta=" + statusConta +
                '}');
    }

    protected void imprimirInfosComuns() {
        System.out.println(this.toString());
    }




}
