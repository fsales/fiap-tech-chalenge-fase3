package br.com.fsales.parktech.adapters.out.veiculo;

import br.com.fsales.parktech.adapters.out.repository.VeiculoRepository;
import br.com.fsales.parktech.application.ports.out.veiculo.DeleteVeiculoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class DeleteVeiculoAdapter implements DeleteVeiculoOutputPort {

    private final VeiculoRepository veiculoRepository;

    /**
     * @param id
     */
    @Override
    public void delete(String id) {

        veiculoRepository.deleteById(id);
    }

}
