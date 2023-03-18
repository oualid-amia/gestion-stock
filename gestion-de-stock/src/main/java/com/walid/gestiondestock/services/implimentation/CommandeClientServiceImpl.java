package com.walid.gestiondestock.services.implimentation;

import com.walid.gestiondestock.dto.CommandeClientDto;
import com.walid.gestiondestock.exception.EntityNotFoundException;
import com.walid.gestiondestock.exception.ErrorCodes;
import com.walid.gestiondestock.exception.InvalidEntityException;
import com.walid.gestiondestock.model.Client;
import com.walid.gestiondestock.repository.ArticleRepository;
import com.walid.gestiondestock.repository.ClientRepository;
import com.walid.gestiondestock.repository.CommandeClientRepository;
import com.walid.gestiondestock.services.CommandeClientService;
import com.walid.gestiondestock.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {


    private CommandeClientRepository commandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;


    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository, ArticleRepository articleRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {


        List<String > errors = CommandeClientValidator.Validate(dto);

        if (!errors.isEmpty()){

            log.error("Commande Client n'est pas valide ", dto);
            throw new InvalidEntityException("Commande Client n'est pas valide ", ErrorCodes.COMMANDE_CLIENT_NOT_VALIDE,errors);
        }
        Optional<Client> client = clientRepository.findById(dto.getClient().getId());
        if (client.isEmpty()){

            log.warn("Client with ID {} was not found in the DB",dto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec L'ID " + dto.getClient().getId() + "n'a ete trouve dans la BDD",
                    ErrorCodes.CLIENT_NOT_FOUND);
        }

        return null;
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        return null;
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        return null;
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
