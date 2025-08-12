package com.aurora.webapi.modules.usuarios.infra.entity.enums

enum class Profiles(val code: Int, val role: String) {
    FICHA(1, "ROLE_FICHA"),
    FICHA_UPDATE(2, "ROLE_FICHA_UPDATE"),
    FICHA_CREATE(3, "ROLE_FICHA_CREATE"),
    FICHA_DELETE(3, "ROLE_FICHA_DELETE"),
    //Fornecedor
    FORNECEDOR(1, "ROLE_FORNECEDOR"),
    FORNECEDOR_UPDATE(2, "ROLE_FORNECEDOR_UPDATE"),
    FORNECEDOR_CREATE(3, "ROLE_FORNECEDOR_CREATE"),
    FORNECEDOR_DELETE(3, "ROLE_FORNECEDOR_DELETE"),

    ARTIGO(1, "ROLE_ARTIGO"),
    ARTIGO_UPDATE(2, "ROLE_ARTIGO_UPDATE"),
    ARTIGO_CREATE(3, "ROLE_ARTIGO_CREATE"),
    ARTIGO_DELETE(3, "ROLE_ARTIGO_DELETE"),

    COR(1, "ROLE_COR"),
    COR_UPDATE(2, "ROLE_COR_UPDATE"),
    COR_CREATE(3, "ROLE_COR_CREATE"),
    COR_DELETE(3, "ROLE_COR_DELETE"),

    COLECAO(1, "ROLE_COLECAO"),
    COLECAO_UPDATE(2, "ROLE_COLECAO_UPDATE"),
    COLECAO_CREATE(3, "ROLE_COLECAO_CREATE"),
    COLECAO_DELETE(3, "ROLE_COLECAO_DELETE");



    companion object {
        fun fromCode(code: Int): Profiles? {
            return entries.find { it.code == code }
        }
    }
}