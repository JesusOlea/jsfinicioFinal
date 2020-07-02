package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AlunoModel;
import br.com.jsfinicio.model.CidadeModel;
import br.com.jsfinicio.model.DisciplinaModel;
import br.com.jsfinicio.model.EstadoModel;
import br.com.jsfinicio.repository.AlunoRepository;
import br.com.jsfinicio.repository.CidadeRepository;
import br.com.jsfinicio.repository.DisciplinaRepository;
import br.com.jsfinicio.repository.EstadoRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class AlunoController {

    private AlunoModel alunoModel;
    private EstadoModel estadoModel;
    private EstadoRepository estadoRepository;
    private AlunoRepository alunoRepository;
    private DisciplinaModel disciplinaModel;
    private DisciplinaRepository disciplinaRepository;
    private List<AlunoModel> listaDeAlunos;
    private CidadeModel cidadeModel;
    private CidadeRepository cidadeRepository;


    public AlunoController() {
        this.estadoRepository = new EstadoRepository();
        this.alunoModel = new AlunoModel();
        this.estadoModel = new EstadoModel();
        this.alunoRepository = new AlunoRepository();
        this.disciplinaModel = new DisciplinaModel();
        this.disciplinaRepository = new DisciplinaRepository();
        this.listaDeAlunos = new ArrayList<>();
        this.cidadeModel = new CidadeModel();
        this.cidadeRepository = new CidadeRepository();
    }

    public void salvar() {
        this.cidadeModel = this.cidadeRepository.buscarPorId(this.cidadeModel.getIdCidade());
        this.alunoModel.setCidade(cidadeModel);
        this.estadoModel = this.cidadeModel.getEstado();
        this.alunoModel.setEstadoOrigem(this.estadoModel);
        this.alunoRepository.salvar(this.alunoModel);
        this.alunoModel = new AlunoModel();
    }

    public void buscarTodos() {
        this.listaDeAlunos = this.alunoRepository.buscarTodos();
    }

    public void buscarPorNome() {
        this.listaDeAlunos = this.alunoRepository.buscarPorNome(this.alunoModel.getNome());
    }

    public void excluirPorId(long idpessoa) {
        this.alunoRepository.excluirPorId(idpessoa);
    }

    public String editarPorId(long idpessoa) throws IOException {
        this.alunoModel = this.alunoRepository.buscarPorId(idpessoa);

        return "editarAluno.xhtml?faces-redirect=true";
    }

    public AlunoModel getAlunoModel() {
        return alunoModel;
    }

    public void setAlunoModel(AlunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    public EstadoModel getEstadoModel() {
        return estadoModel;
    }

    public void setEstadoModel(EstadoModel estadoModel) {
        this.estadoModel = estadoModel;
    }

    public EstadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public void setEstadoRepository(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public AlunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public DisciplinaModel getDisciplinaModel() {
        return disciplinaModel;
    }

    public void setDisciplinaModel(DisciplinaModel disciplinaModel) {
        this.disciplinaModel = disciplinaModel;
    }

    public DisciplinaRepository getDisciplinaRepository() {
        return disciplinaRepository;
    }

    public void setDisciplinaRepository(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<AlunoModel> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<AlunoModel> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

    public CidadeModel getCidadeModel() {
        return cidadeModel;
    }

    public void setCidadeModel(CidadeModel cidadeModel) {
        this.cidadeModel = cidadeModel;
    }

    public CidadeRepository getCidadeRepository() {
        return cidadeRepository;
    }

    public void setCidadeRepository(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }
    
    

}
