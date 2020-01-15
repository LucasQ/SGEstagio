package com.edu.sgestagio.sgestagio.domain.enums;

public enum Status {
    DISPONIVEL(1, "Disponivel"),
    OCUPADO(2, "Ocupado"),
    PENDENTE(3, "Pendente"),
    BLOQUEADO(4, "Bloqueado");

    private int cod;
    private String descricao;

    private Status(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public Status toEnum(Integer cod) {
        if (cod == null)
            return null;

        for (Status x : Status.values()) {
            if (cod.equals(x.getCod()))
                return x;
        }
        throw new IllegalArgumentException("Id invalido: " + cod);
    }

}
