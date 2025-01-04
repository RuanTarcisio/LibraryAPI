package io.github.ruantarcisio.libraryapi.repositories;

import io.github.ruantarcisio.libraryapi.services.TransacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransacoesTest {

    @Autowired
    TransacaoService transacaoService;

    /**
     * Commit -> confirmar as alterações
     * Rollback -> desfazer as alterações
     */
    @Test
    void transacaoSimples(){
       transacaoService.executar();
    }

    @Test
    void transacaoEstadoManaged(){

        transacaoService.atualizacaoSemAtualizar();
    }
}
