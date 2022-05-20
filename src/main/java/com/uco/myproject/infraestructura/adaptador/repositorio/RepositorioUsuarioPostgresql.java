package com.uco.myproject.infraestructura.adaptador.repositorio;

import com.uco.myproject.dominio.dto.DtoUsuarioResumen;
import com.uco.myproject.dominio.modelo.RolUsuario;
import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadRolUsuario;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadUsuario;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RepositorioUsuarioPostgresql implements RepositorioUsuario {

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;

    public RepositorioUsuarioPostgresql(RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }

   @Override
    public List<DtoUsuarioResumen> listar() {
        List<EntidadUsuario> entidades = this.repositorioUsuarioJpa.findAll();
        return entidades.stream().map(entidad -> new DtoUsuarioResumen(entidad.getNombre(), entidad.getApellido(),
                entidad.getCorreo())).collect(Collectors.toList());
    }

    @Override
    public Long guardar(Usuario usuario) {
        List<EntidadRolUsuario> roles = usuario.getRoles().stream().map(rol -> new EntidadRolUsuario(rol.getRol())).toList();


        EntidadUsuario entidadUsuario = new EntidadUsuario(usuario.getNombre(), usuario.getApellido(),
                usuario.getCorreo(), usuario.getPassword(), roles);


        return this.repositorioUsuarioJpa.save(entidadUsuario).getId();
    }

    @Override
    public boolean existe(Usuario usuario) {
        return this.repositorioUsuarioJpa.findByNombreAndApellido(usuario.getNombre(), usuario.getApellido()) != null;
    }

    @Override
    public Boolean eliminar(Long id) {
        this.repositorioUsuarioJpa.deleteById(id);
        return true;
    }

    @Override
    public Boolean actualizar(Long id, Usuario usuario) {
        repositorioUsuarioJpa.findById(id);
        EntidadUsuario entidadUsuario = new EntidadUsuario();
        entidadUsuario.setId(id);
        entidadUsuario.setNombre(usuario.getNombre());
        entidadUsuario.setApellido(usuario.getApellido());
        entidadUsuario.setCorreo(usuario.getCorreo());
        entidadUsuario.setPassword(usuario.getPassword());
        repositorioUsuarioJpa.save(entidadUsuario);
        return true;
    }

    @Override
    public Usuario consultar(String nombre, String password) {
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndPassword(nombre, password);

        if(entidadUsuario == null) {
            return null;
        }


        List<RolUsuario> roles = entidadUsuario.getRoles().stream().map(rol -> RolUsuario.of(rol.getRol())).collect(Collectors.toList());
        return Usuario.of(entidadUsuario.getNombre(), entidadUsuario.getApellido(),
                entidadUsuario.getCorreo(),entidadUsuario.getPassword(), roles);
    }

    @Override
    public DtoUsuarioResumen consultarPorId(Long id) {

        return this.repositorioUsuarioJpa
                .findById(id)
                .map(entidad -> new DtoUsuarioResumen(entidad.getNombre(), entidad.getApellido(),
                        entidad.getCorreo()))
                .orElse(null);
    }
}
