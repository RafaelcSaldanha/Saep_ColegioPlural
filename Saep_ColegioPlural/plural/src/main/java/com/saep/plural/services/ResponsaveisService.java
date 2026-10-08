package com.saep.plural.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saep.plural.models.Responsaveis;
import com.saep.plural.repositories.ResponsaveisRepository;

@Service 
public class ResponsaveisService {
    private final ResponsaveisRepository responsaveisRepository;

    public ResponsaveisService(ResponsaveisRepository responsaveisRepository) {
        this.responsaveisRepository = responsaveisRepository;
    }

    public Long countResponsaveis() {
        return responsaveisRepository.count();
    }

    public Responsaveis buscarResponsavelPorId(Integer id) {
        return responsaveisRepository.findById(id).orElse(null);
    }

    public List<Responsaveis> buscarTodosResponsaveis() {
        return responsaveisRepository.findAll();
    }

    public boolean deletarResponsavel(Integer id) {
        if (responsaveisRepository.existsById(id)) {
            responsaveisRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Responsaveis cadastrarResponsavel(Responsaveis responsavel) {
        return responsaveisRepository.save(responsavel);
    }

    public Responsaveis atualizarResponsavel(Integer id, Responsaveis responsaveis) {
        Responsaveis responsavelRecuperado = buscarResponsavelPorId(id);
        if(responsavelRecuperado != null) {
            responsavelRecuperado.setResponsavelId(id);
        
            if (responsaveis.getResponsavelNome() != null) {
                responsavelRecuperado.setResponsavelNome(responsaveis.getResponsavelNome());
            }
            if (responsaveis.getResponsavelCpf() != null) {
                responsavelRecuperado.setResponsavelCpf(responsaveis.getResponsavelCpf());
            }
            return responsaveisRepository.save(responsavelRecuperado);
        }
        return null;
    }
}
