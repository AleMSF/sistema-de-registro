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

        for (Usuario usuarioDeTodosUsuarios : usuarios) {

            Cidade cidade = cidadeRepository.findById(usuarioDeTodosUsuarios.getIdCidade())
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.BAD_REQUEST), "cidade not found"));

            Estado estado = estadoRepository.findById(cidade.getIdEstado())
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.BAD_REQUEST), "estado not found"));

            Profissao profissao = profissaoRepository.findById(usuarioDeTodosUsuarios.getIdProfissao())
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.BAD_REQUEST), "profissao not found"));

            UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                    .idUsuario(usuarioDeTodosUsuarios.getIdUsuario())
                    .nomeCidade(cidade.getCidadeNome())
                    .nomeEstado(estado.getEstadoNome())
                    .nomeProfissao(profissao.getProfissaoNome())
                    .salario(profissao.getSalario())
                    .build();
            usuarioDTOS.add(usuarioDTO);
        }
        return usuarioDTOS;
    }

    public List<UsuarioPorCidadeDTO> listTodosDaCidade(Long idCidade) {
        List<Usuario> usuarios = usuarioRepository.findAll();

        List<UsuarioPorCidadeDTO> usuarioPorCidadeDTOS = new ArrayList<>();

        for (Usuario usuariosDaCidade : usuarios) {

            Usuario usuario  = usuarioRepository.findById(idCidade)
                    .orElseThrow();

            Cidade cidade  = cidadeRepository.findById(idCidade)
                    .orElseThrow();

            if (usuario.getIdCidade().equals(idCidade)){
                UsuarioPorCidadeDTO usuarioPorCidadeDTO = UsuarioPorCidadeDTO.builder()
                        .idUsuario(usuariosDaCidade.getIdUsuario())
                        .nomeUsuario(usuariosDaCidade.getUsuarioNome())
                        .nomeCidade(cidade.getCidadeNome())
                        .build();
                usuarioPorCidadeDTOS.add(usuarioPorCidadeDTO);
            }
        }
        return usuarioPorCidadeDTOS;
    }

    public List<UsuarioDTO2> listTodosDoEstado(Long idEstado) {

        List<UsuarioDTO2> usuarioList = new ArrayList<>();
        List<Cidade> cidades = cidadeRepository.findAll();
        List<Cidade> cidadesDoEstado = new ArrayList<>();

        for (Cidade cidade1 : cidades) {
            estadoRepository.findById(idEstado)
                    .orElseThrow();

            cidadesDoEstado.add(cidade1);
        }

        for (Cidade cidade2 : cidadesDoEstado) {

            Estado estado = estadoRepository.findById(cidade2.getIdEstado())
                    .orElseThrow();

                        UsuarioDTO2 usuario1 = UsuarioDTO2.builder()
                        .idUsuario(usuario1.getIdUsuario())
                        .nomeUsuario(usuario1.getNomeUsuario())
                        .nomeCidade(cidade2.getCidadeNome())
                        .nomeEstado(estado.getEstadoNome())
                        .build();

                usuarioList.add(usuario1);
            }
        return usuarioList;
    }
}
