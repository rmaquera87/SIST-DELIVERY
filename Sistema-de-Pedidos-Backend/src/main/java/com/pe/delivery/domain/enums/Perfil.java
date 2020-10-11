package com.pe.delivery.domain.enums;
public enum Perfil {

	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");

	private int cod;
	private String descripcion;

	private Perfil(int cod, String descripcion) {
		this.cod = cod;
		this.descripcion = descripcion;
	}

	public int getCod() {
		return cod;
	}

	public String getDescripcion () {
		return descripcion;
	}

	public static Perfil toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}