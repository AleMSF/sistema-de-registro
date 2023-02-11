package application.registro.springbootapplication.controller;

import application.registro.springbootapplication.domain.*;
import application.registro.springbootapplication.requests.CidadePostRequestBody;
import application.registro.springbootapplication.requests.EstadoPostRequestBody;
import application.registro.springbootapplication.requests.ProfissaoPostRequestBody;
import application.registro.springbootapplication.requests.UsuarioPostRequestBody;
import application.registro.springbootapplication.services.RegistroService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registros")
@Log4j2
@RequiredArgsConstructor
public class RegistroController {
    private final RegistroService registroService;

    @PostMapping(path = "/usuario")
     ResponseEntity<Usuario> saveUsuario(@RequestBody UsuarioPostRequestBody usuarioPostRequestBody) {
        return new ResponseEntity<>(registroService.saveUsuario(usuarioPostRequestBody), HttpStatus.CREATED);
    }

    @PostMapping(path = "/cidade")
    ResponseEntity<Cidade> saveCidade(@RequestBody CidadePostRequestBody cidadePostRequestBody) {
        return new ResponseEntity<>(registroService.saveCidade(cidadePostRequestBody), HttpStatus.CREATED);
    }

    @PostMapping(path = "/profissao")
    ResponseEntity<Profissao> saveProfissao(@RequestBody ProfissaoPostRequestBody profissaoPostRequestBody) {
        return new ResponseEntity<>(registroService.saveProfissao(profissaoPostRequestBody), HttpStatus.CREATED);
    }

    @PostMapping(path = "/estado")
    ResponseEntity<Estado> saveEstado(@RequestBody EstadoPostRequestBody estadoPostRequestBody) {
        return new ResponseEntity<>(registroService.saveEstado(estadoPostRequestBody), HttpStatus.CREATED);
    }

    @GetMapping(path = "/listTodosUsuarios")
    public ResponseEntity<List<UsuarioDTO>> listTodosUsuarios() {
        return ResponseEntity.ok(registroService.listAllUsuarios());
    }

    @GetMapping(path = "/listTodosUsuariosDaCidade/{idCidade}")
    public ResponseEntity<List<UsuarioPorCidadeDTO>> listTodosUsuariosPorCidade(@PathVariable @NotNull Long idCidade){
        return new ResponseEntity<>(registroService.listTodosDaCidade(idCidade),HttpStatus.OK);
    }

    @GetMapping(path = "/listTodosUsuariosDaEstado/{idEstado}")
    public ResponseEntity<List<UsuarioDTO2>> listTodosUsuariosPorEstado(@PathVariable @NotNull Long idEstado){
        return new ResponseEntity<>(registroService.listTodosDoEstado(idEstado),HttpStatus.OK);
    }


}

