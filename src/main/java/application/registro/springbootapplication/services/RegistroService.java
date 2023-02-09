package application.registro.springbootapplication.services;

import application.registro.springbootapplication.domain.*;
import application.registro.springbootapplication.repository.CidadeRepository;
import application.registro.springbootapplication.repository.EstadoRepository;
import application.registro.springbootapplication.repository.ProfissaoRepository;
import application.registro.springbootapplication.repository.UsuarioRepository;
import application.registro.springbootapplication.requests.CidadePostRequestBody;
import application.registro.springbootapplication.requests.EstadoPostRequestBody;
import application.registro.springbootapplication.requests.ProfissaoPostRequestBody;
import application.registro.springbootapplication.requests.UsuarioPostRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroService {
    private final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;
    private final ProfissaoRepository profissaoRepository;
    private final UsuarioRepository usuarioRepository;

    public Usuario saveUsuario(UsuarioPostRequestBody usuarioPostRequestBody) {
        return usuarioRepository.save(Usuario.builder()
                .idUsuario(usuarioPostRequestBody.getIdUsuario())
                .usuarioNome(usuarioPostRequestBody.getUsuarioNome())
                .idCidade(usuarioPostRequestBody.getIdCidade())
                .idProfissao(usuarioPostRequestBody.getIdProfissao())
                .build());
    }

    public Cidade saveCidade(CidadePostRequestBody cidadePostRequestBody) {
        return cidadeRepository.save(Cidade.builder()
                .idCidade(cidadePostRequestBody.getIdCidade())
                .cidadeNome(cidadePostRequestBody.getCidadeNome())
                .idEstado(cidadePostRequestBody.getIdEstado())
                .build());
    }

    public Profissao saveProfissao(ProfissaoPostRequestBody profissaoPostRequestBody) {
        return profissaoRepository.save(Profissao.builder()
                .idProfissao(profissaoPostRequestBody.getIdProfissao())
                .profissaoNome(profissaoPostRequestBody.getProfissaoNome())
                .salario(profissaoPostRequestBody.getSalario())
                .build());
    }

    public Estado saveEstado(EstadoPostRequestBody estadoPostRequestBody) {
        return estadoRepository.save(Estado.builder()
                .idEstado(estadoPostRequestBody.getIdEstado())
                .estadoNome(estadoPostRequestBody.getEstadoNome())
                .build());
    }

    public List<UsuarioDTO> listAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();



//        Estado estado = estadoRepository.
//                .orElseThrow(() -> new ResponseStatusException((HttpStatus.BAD_REQUEST), "estado not found"));
//
//        Profissao profissao = profissaoRepository.
//                .orElseThrow(() -> new ResponseStatusException((HttpStatus.BAD_REQUEST), "profissao not found"));

        for (Usuario usuario : usuarios) {

            Cidade cidade = cidadeRepository.findById(usuario.getIdCidade())
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.BAD_REQUEST), "cidade not found"));

            UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                    .idUsuario(usuario.getIdUsuario())
                    .nomeCidade(cidade.getCidadeNome())
                    .nomeEsatdo(estado.getEstadoNome())
                    .nomeProfissao(profissao.getProfissaoNome())
                    .salario(profissao.getSalario())
                    .build();
            usuarioDTOS.add(usuarioDTO);
        }
        return usuarioDTOS;
    }
}
