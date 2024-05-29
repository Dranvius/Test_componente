package org.example.componente.Services;

import org.example.componente.Dto.DtoProvedor;
import org.example.componente.Entities.Provedor;
import org.example.componente.Repositories.RepositoryProvedor;

import org.example.componente.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServiceProvedor implements Serializable {

    @Autowired
    public ModelMapper modelMapper; // Agrega @Autowired aquí
    @Autowired
    private RepositoryProvedor repoProvedor;

    //Guardar usuario
    public DtoProvedor registrar(DtoProvedor Dtoprovedor)
    {
        Provedor laProvedor = repoProvedor.save(modelMapper.map(Dtoprovedor, Provedor.class));
        return modelMapper.map(laProvedor, DtoProvedor.class);
    }

    //Mostrar lista de usuario

    public List<DtoProvedor> obtenerProvedores() {
        TypeToken<List<DtoProvedor>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoProvedor.findAll(), typeToken.getType());
    }

    //Obtener Provedor unica

    public DtoProvedor obtenerProvedor(long serial)
    {
        Provedor provedor = repoProvedor.findById(serial).orElseThrow(ResourceNotFoundException::new);
        return modelMapper.map(provedor,DtoProvedor.class);
    }

    //Actualizar un registro

    public DtoProvedor actualizar(DtoProvedor DtoProvedor)
    {
        repoProvedor.save(modelMapper.map(DtoProvedor, Provedor.class));
        return DtoProvedor;
    }

    //Eliminar registro
    public void eliminar(long serial) {
        repoProvedor.deleteById(serial);
    }

    //Alarma provedor



}
