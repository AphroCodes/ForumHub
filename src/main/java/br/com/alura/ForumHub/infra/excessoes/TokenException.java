package br.com.alura.ForumHub.infra.excessoes;

public class TokenException extends RuntimeException {
    public TokenException(String mensagem) {
        super(mensagem);
    }
}
