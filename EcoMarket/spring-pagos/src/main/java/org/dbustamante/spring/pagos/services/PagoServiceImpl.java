package org.dbustamante.spring.pagos.services;


import org.dbustamante.spring.pagos.models.Pago;
import org.dbustamante.spring.pagos.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Pago> listar() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pago> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Pago guardar(Pago pago) {
        return repository.save(pago);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }


}
