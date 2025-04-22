package ufrn.br.aulamvcintroducao.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa {
    String nome;
    Integer idade;
    String sexo;
    Float altura;
    Float peso;

    public void crescer(){
        altura+=1;
    }
}