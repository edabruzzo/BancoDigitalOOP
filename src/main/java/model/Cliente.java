package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emmanuel Abruzzo
 * @date 18/01/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {


    private String nome;
    private List<Conta> contasCliente = new ArrayList<>();




}
