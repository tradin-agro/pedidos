package br.com.tradin.pedidos.amqp;

import br.com.tradin.pedidos.dto.PagamentoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {

    @RabbitListener(queues = "pagamentos.detalhes-pedido")
    public void recebeMensagem(@Payload PagamentoDto pagamentoDto){
        String message = """
                \nDados do pagamento: %s
                Número do pedido: %s
                Valor R$: %s
                Status: %s
                """.formatted(pagamentoDto.getId(),
                pagamentoDto.getPedidoId(),
                pagamentoDto.getValor(),
                pagamentoDto.getStatus());
        System.out.println("Recebi a mensagem "+ message);
    }
}
